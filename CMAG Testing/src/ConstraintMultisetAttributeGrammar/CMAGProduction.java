package ConstraintMultisetAttributeGrammar;

import ContextFreeGrammar.CFGProduction;
import GeneralComponents.AbstractSymbol;

import java.util.List;

public class CMAGProduction extends CFGProduction {

    private final List<Constraint> listOfConstraints;

    public CMAGProduction(CMAGNonTerminal ruleHead, List<AbstractSymbol> ruleBody,
                          List<Constraint> constraints) {

        super(ruleHead, ruleBody);
        this.listOfConstraints = constraints;
    }

//    /**
//     * The core of the class. Returns wether the production is applicable. I.e. are all {@linkplain Constraint}'s fullfilled
//     * @param nonTerminal The {@linkplain CMAGNonTerminal} symbol to be replaced by the production
//     * @return Boolean, can the {@linkplain CMAGProduction} be applied
//     */
//    public Boolean applicable (CMAGNonTerminal nonTerminal){
//        if(nonTerminal.equals(getRuleHead()))
//        for(Constraint c : listOfConstraints){
//            if (c.getSatisfied().equals(Boolean.FALSE)){
//                return false;
//            }
//        }
//        return true;
//    }

    public List<Constraint> getConstraints() {
        return listOfConstraints;
    }
}
