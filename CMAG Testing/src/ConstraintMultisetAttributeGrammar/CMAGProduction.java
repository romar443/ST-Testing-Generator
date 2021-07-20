package ConstraintMultisetAttributeGrammar;

import ContextFreeGrammar.CFGNonTerminalSymbol;
import ContextFreeGrammar.CFGProduction;
import ContextFreeGrammar.CFGTerminalSymbol;
import GeneralComponents.AbstractSymbol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Implementation of a grammar production for CMAG's. The ruleHead must be a non-terminal symbol, as defined by CMAG's. Replaces the ruleHead with the ruleBody
 */
public class CMAGProduction extends CFGProduction {

    private final List<Constraint> listOfConstraints;
    private final List<AttributeRule> listOfAttributeRules;


    /**
     * Constructor
     * @param ruleHead A {@linkplain CMAGNonTerminalSymbol} as defined for CMAG's
     * @param ruleBody A list of {@linkplain CMAGNonTerminalSymbol}s and {@linkplain CMAGTerminalSymbol}s, returned when the production is applied
     * @param constraints A list of constraints which must be fulfilled in order to apply the production
     * @param attributeRules A list of attributeRules to be executed when the production is applied
     */
    public CMAGProduction(AbstractSymbol ruleHead, List<AbstractSymbol> ruleBody,
                          List<Constraint> constraints, List<AttributeRule> attributeRules) {

        super(ruleHead, ruleBody);
        this.listOfConstraints = constraints;
        this.listOfAttributeRules = attributeRules;
    }

    /**
     * Constructor with single attribute rule
     * @param ruleHead A {@linkplain CMAGNonTerminalSymbol} as defined for CMAG's
     * @param ruleBody A list of {@linkplain CMAGNonTerminalSymbol}s and {@linkplain CMAGTerminalSymbol}s, returned when the production is applied
     * @param constraints A list of constraints which must be fulfilled in order to apply the production
     * @param attributeRule A single attributeRule to be executed when the production is applied
     */
    public CMAGProduction(AbstractSymbol ruleHead, List<AbstractSymbol> ruleBody,
                          List<Constraint> constraints, AttributeRule attributeRule) {

        super(ruleHead, ruleBody);
        this.listOfConstraints = constraints;
        this.listOfAttributeRules = Arrays.asList(attributeRule);
    }

    /**
     * Constructor with single constraint
     * @param ruleHead A {@linkplain CMAGNonTerminalSymbol} as defined for CMAG's
     * @param ruleBody A list of {@linkplain CMAGNonTerminalSymbol}s and {@linkplain CMAGTerminalSymbol}s, returned when the production is applied
     * @param constraint A single constraint which must be fulfilled in order to apply the production
     * @param attributeRules A list of attributeRules to be executed when the production is applied
     */
    public CMAGProduction(AbstractSymbol ruleHead, List<AbstractSymbol> ruleBody,
                          Constraint constraint, List<AttributeRule> attributeRules) {

        super(ruleHead, ruleBody);
        this.listOfConstraints = Arrays.asList(constraint);
        this.listOfAttributeRules = attributeRules;
    }

    /**
     * Constructor with single constraint and single attribute rule
     * @param ruleHead A {@linkplain CMAGNonTerminalSymbol} as defined for CMAG's
     * @param ruleBody A list of {@linkplain CMAGNonTerminalSymbol}s and {@linkplain CMAGTerminalSymbol}s, returned when the production is applied
     * @param constraint A single constraint which must be fulfilled in order to apply the production
     * @param attributeRule A single attributeRule to be executed when the production is applied
     */
    public CMAGProduction(AbstractSymbol ruleHead, List<AbstractSymbol> ruleBody,
                          Constraint constraint, AttributeRule attributeRule) {

        super(ruleHead, ruleBody);
        this.listOfConstraints = Arrays.asList(constraint);
        this.listOfAttributeRules = Arrays.asList(attributeRule);
    }

    /**
     * Constructor with no constraints and attribute rules
     * @param ruleHead A {@linkplain CMAGNonTerminalSymbol} as defined for CMAG's
     * @param ruleBody A list of {@linkplain CMAGNonTerminalSymbol}s and {@linkplain CMAGTerminalSymbol}s, returned when the production is applied
     */
    public CMAGProduction(AbstractSymbol ruleHead, List<AbstractSymbol> ruleBody) {

        super(ruleHead, ruleBody);
        this.listOfConstraints = new ArrayList<>();
        this.listOfAttributeRules = new ArrayList<>();
    }

    /**
     * The core of the class. Returns whether the production is applicable. I.e. are all {@linkplain Constraint}'s fulfilled
     * @param nonTerminal The {@linkplain CMAGNonTerminalSymbol} symbol to be replaced by the production
     * @return Boolean, can the {@linkplain CMAGProduction} be applied
     */
    @Override
    public Boolean applicable (AbstractSymbol nonTerminal) throws ClassNotFoundException {

        //Rulehead must be a Non terminal symbol as defined for all CFG Grammars and their derivations
        if(!(getRuleHead() instanceof CMAGNonTerminalSymbol)){
            throw new IllegalStateException("Head of rule is NOT a CMAGNonTerminalSymbol, as required by all subclasses of CFG Grammars");
        }

        //Checks the id of the symbols to see if they have the same 'signature'. Symbols are duplicated in the production, so the id is used to identify symbols
        //that are "the same"
        if (!(getRuleHead().getId() == nonTerminal.getId())) {

            //If the rulehead is not a nonterminal symbol, the rule is not applicable and false is returned
            return false;

        } else {

            //Iterate through all constraints, if any are not fulfilled, then the rule is not applicable and false is return
            for(Constraint c : listOfConstraints){

                //Get the leftSymbol from the ruleBody
                CMAGSymbol leftSymbol = getSymbolWithId(c.getLeftSymbolId());

                //Flag is true when operating with a constant, no rightside attribute is needed.
                if (Boolean.TRUE.equals(c.getConstantFlag())){

                    //Check if the constraint is satisfied, otherwise return false
                    if (c.getSatisfied(leftSymbol, null).equals(Boolean.FALSE)){
                        return false;
                    }
                }
                else{

                    //Get the rightSymbol from the ruleBody
                    CMAGSymbol rightSymbol = getSymbolWithId(c.getRightSymbolId());

                    //Check if the constraint is satisfied, otherwise return false
                    if (c.getSatisfied(leftSymbol, rightSymbol).equals(Boolean.FALSE)){
                        return false;
                    }
                }
            }

            //All constraints are fulfilled, return true
            return true;
        }
    }


    /**
     * <p>Applies the production to the supplied {@linkplain CFGNonTerminalSymbol}, executing all
     * {@linkplain AttributeRule}s and checking all {@linkplain Constraint}s</p>
     *
     * <p><h3>Important to note:</h3>
     * All symbols in the rule body and their corresponding attributes are cloned, after all attribute rules have been applied.
     * The id of the symbol is used to track that it is still the correct symbol, but it must be a new object such that
     * the values of attributes in symbols are able to be changed later without changing the values of attributes in the
     * instance used in the current rule. This allows a generator to be able to print a tree with all attribute values at
     * a given point in the tree.</p>
     *
     * @param nonTerminal The {@linkplain CFGNonTerminalSymbol} passed as the ruleHead argument
     * @return The {@linkplain #getRuleBody()}
     * @throws Exception Thrown when not all constraints are fulfilled, meaning the production is not applicable
     */
    @Override
    public List<AbstractSymbol> applyProduction(AbstractSymbol nonTerminal) throws Exception {

        //If the all constraints are met
        if(applicable(nonTerminal)){

            //Apply AttributeRules
            for(AttributeRule ar : listOfAttributeRules){

                //Retrieve the CMAGSymbol from the ruleBody for which the attribute rule will be evaluated
                CMAGSymbol assignee = getSymbolWithId(ar.getAssigneeId());

                //If the AttributeRule is an assignment, then a Symbol from which the value of some Attribute will be assigned
                //is also needed
                if (ar.assignmentRule()){
                    CMAGSymbol assignFrom = getSymbolWithId(ar.getAssignFromId());
                    ar.applyRule(assignee, assignFrom);
                }

                //Otherwise the rule is some operation with a constant, an no Symbol is needed from which an attribute must
                //be taken
                else{
                    ar.applyRule(assignee, null);
                }
            }

            //Introduce a copy of the objects in the rule body, so new attributes may be assigned without altering the attributes from symbols in previous productions
            List<AbstractSymbol> copyOfRuleBody = new ArrayList<>();


            for (AbstractSymbol ar : getRuleBody()){


                //List which will contain new attributes
                List listOfDuplicateAttributes = new ArrayList();

                if (ar instanceof CMAGTerminalSymbol){
                    CMAGTerminalSymbol terminalSymbol = (CMAGTerminalSymbol) ar;
                    for (Attribute oldAttribute : (terminalSymbol.getAttributes())){
                        listOfDuplicateAttributes.add(oldAttribute.clone());

                        //print the nonterminal
                        System.out.println(terminalSymbol.toString());

                    }
                    copyOfRuleBody.add(ar.clone());
                }
                else {
                    for (Attribute oldAttribute : ((CMAGNonTerminalSymbol) ar).getAttributes()){
                        listOfDuplicateAttributes.add(oldAttribute.clone());

                    }
                    copyOfRuleBody.add(ar.clone());
                }
            }



            return copyOfRuleBody;
        }
        else{
            throw new Exception("Production is not applicable");
        }
    }

    /**
     * @return A List of all {@linkplain Constraint}s of the {@linkplain CMAGProduction}
     */
    public List<Constraint> getConstraints() {
        return listOfConstraints;
    }

    /** Used to find the correct instance of a {@linkplain CMAGSymbol} so that an {@linkplain AttributeRule} can
     * be applied.
     *
     * @param id {@linkplain UUID}
     * @return {@linkplain CMAGSymbol}
     */
    public CMAGSymbol getSymbolWithId(UUID id) throws ClassNotFoundException {
        for (AbstractSymbol symbol : this.getRuleBody()){
            if (symbol.getId() == id){
                return (CMAGSymbol) symbol;
            }
        }
        if(this.getRuleHead().getId() == id){
            return (CMAGSymbol) this.getRuleHead();
        }
        throw new ClassNotFoundException("The symbol with id: " + id + "\n was not found!");
    }
}
