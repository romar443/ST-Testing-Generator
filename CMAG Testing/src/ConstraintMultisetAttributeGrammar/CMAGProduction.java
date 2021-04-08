package ConstraintMultisetAttributeGrammar;

import ContextFreeGrammar.CFGNonTerminalSymbol;
import ContextFreeGrammar.CFGProduction;
import ContextFreeGrammar.CFGTerminalSymbol;
import GeneralComponents.AbstractSymbol;

import java.util.ArrayList;
import java.util.List;

public class CMAGProduction extends CFGProduction {

    private final List<Constraint> listOfConstraints;
    private final List<AttributeRule> listOfAttributeRules;


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

    @Override
    public List<AbstractSymbol> applyProduction(AbstractSymbol nonTerminal) throws Exception {

        //If the all constraints are met
        if(applicable(nonTerminal)){

            for(AttributeRule ar : listOfAttributeRules){
                ar.applyRule();
            }

            //Introduce a copy of the objects in the rule body, so that attribute values are not changed in further productions
            List<AbstractSymbol> copyOfRuleBody = new ArrayList<>();

            for (AbstractSymbol ar : getRuleBody()){
                if (ar instanceof CMAGTerminalSymbol){
                    copyOfRuleBody.add(new CMAGTerminalSymbol(ar.getObject(), ((CMAGTerminalSymbol) ar).getAttributes()));
                }
                else {
                    copyOfRuleBody.add(new CMAGNonTerminalSymbol(ar.getObject(), ((CMAGNonTerminalSymbol) ar).getAttributes()));
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
