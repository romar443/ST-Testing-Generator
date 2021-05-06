package ConstraintMultisetAttributeGrammar;

import ContextFreeGrammar.CFGNonTerminalSymbol;
import ContextFreeGrammar.CFGProduction;
import ContextFreeGrammar.CFGTerminalSymbol;
import GeneralComponents.AbstractSymbol;

import java.util.ArrayList;
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
     * The core of the class. Returns whether the production is applicable. I.e. are all {@linkplain Constraint}'s fulfilled
     * @param nonTerminal The {@linkplain CMAGNonTerminalSymbol} symbol to be replaced by the production
     * @return Boolean, can the {@linkplain CMAGProduction} be applied
     */
    @Override
    public Boolean applicable (AbstractSymbol nonTerminal){

        if(!(getRuleHead() instanceof CMAGNonTerminalSymbol)){
            throw new IllegalStateException("Head of rule is NOT a CMAGNonTerminalSymbol, as required by all subclasses of CFG Grammars");
        }

        if (!nonTerminal.equals(getRuleHead())) {
            //Add typing to symbols so production can be applied to symbols that are the same
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

            //Introduce a copy of the objects in the rule body, so new attributes may be assigned without altering the attributes from symbols in previous productions
            List<AbstractSymbol> copyOfRuleBody = new ArrayList<>();

            for (AbstractSymbol ar : getRuleBody()){


                //List which will contain new attributes
                List listOfDuplicateAttributes = new ArrayList();

                for (Attribute oldAttribute : ((CMAGTerminalSymbol) ar).getAttributes()){
                    listOfDuplicateAttributes.add(new Attribute(oldAttribute.getValue(), oldAttribute.getName()));
                }

                if (ar instanceof CMAGTerminalSymbol){
                    copyOfRuleBody.add( new CMAGTerminalSymbol ( ar.getObject(), listOfDuplicateAttributes, ar.getId()));
                }
                else {
                    copyOfRuleBody.add(new CMAGNonTerminalSymbol(ar.getObject(), listOfDuplicateAttributes, ar.getId()));
                }
            }

            for(AttributeRule ar : listOfAttributeRules){
                ar.applyRule();
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
