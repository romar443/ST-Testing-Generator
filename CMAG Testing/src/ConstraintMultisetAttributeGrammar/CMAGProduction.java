package ConstraintMultisetAttributeGrammar;

import ContextFreeGrammar.CFGNonTerminalSymbol;
import ContextFreeGrammar.CFGProduction;
import ContextFreeGrammar.CFGTerminalSymbol;
import GeneralComponents.AbstractSymbol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
     * Constructor with single constraint
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
     * The core of the class. Returns whether the production is applicable. I.e. are all {@linkplain Constraint}'s fulfilled
     * @param nonTerminal The {@linkplain CMAGNonTerminalSymbol} symbol to be replaced by the production
     * @return Boolean, can the {@linkplain CMAGProduction} be applied
     */
    @Override
    public Boolean applicable (AbstractSymbol nonTerminal){

        //Rulehead must be a Non terminal symbol as defined for all CFG Grammars and their derivations
        if(!(getRuleHead() instanceof CMAGNonTerminalSymbol)){
            throw new IllegalStateException("Head of rule is NOT a CMAGNonTerminalSymbol, as required by all subclasses of CFG Grammars");
        }

        //Checks the id of the symbols to see if they have the same 'signature'. Symbols are duplicated in the production, so the id is used to identify symbols
        //that are "the same"
        if (!(getRuleHead().getId() == nonTerminal.getId())) {
            return false;
        } else {
            for(Constraint c : listOfConstraints){
                if (c.getSatisfied().equals(Boolean.FALSE)){
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Applies the production to the supplied {@linkplain CFGNonTerminalSymbol}, executing all {@linkplain AttributeRule}s and checking all {@linkplain Constraint}s
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
                ar.applyRule();
            }


            //Introduce a copy of the objects in the rule body, so new attributes may be assigned without altering the attributes from symbols in previous productions
            List<AbstractSymbol> copyOfRuleBody = new ArrayList<>();


            for (AbstractSymbol ar : getRuleBody()){


                //List which will contain new attributes
                List listOfDuplicateAttributes = new ArrayList();

                if (ar instanceof CMAGTerminalSymbol){
                    for (Attribute oldAttribute : ((CMAGTerminalSymbol) ar).getAttributes()){
                        listOfDuplicateAttributes.add(new Attribute(oldAttribute.getValue(), oldAttribute.getName()));
                    }
                    copyOfRuleBody.add( new CMAGTerminalSymbol ( ar.getObject(), listOfDuplicateAttributes, ar.getId()));
                }
                else {
                    for (Attribute oldAttribute : ((CMAGNonTerminalSymbol) ar).getAttributes()){
                        listOfDuplicateAttributes.add(new Attribute(oldAttribute.getValue(), oldAttribute.getName()));
                    }
                    copyOfRuleBody.add(new CMAGNonTerminalSymbol(ar.getObject(), listOfDuplicateAttributes, ar.getId()));
                }
            }



            return copyOfRuleBody;
        }
        else{
            throw new Exception("Production is not applicable");
        }
    }

    public List<Constraint> getConstraints() {
        return listOfConstraints;
    }

}
