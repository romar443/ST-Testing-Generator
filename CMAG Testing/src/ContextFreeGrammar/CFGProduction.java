package ContextFreeGrammar;

import ConstraintMultisetAttributeGrammar.CMAGNonTerminalSymbol;
import ConstraintMultisetAttributeGrammar.CMAGProduction;
import GeneralComponents.AbstractProduction;
import GeneralComponents.AbstractSymbol;

import java.util.ArrayList;
import java.util.List;

public class CFGProduction extends AbstractProduction {

    public CFGProduction(AbstractSymbol ruleHead, List<AbstractSymbol> ruleBody){

        super(ruleHead, ruleBody);

        //Rule head must be a NonTerminalSymbol in context-free grammars
//        if(!(ruleHead instanceof CFGNonTerminalSymbol)){
//            throw new IllegalStateException();
//        }
    }

    @Override
    public List<AbstractSymbol> applyProduction(AbstractSymbol nonTerminal) throws Exception {
        if(applicable(nonTerminal)){

            //Introduce a copy of the objects in the rule body, so that attribute values are not changed in further productions
            List<AbstractSymbol> copyOfRuleBody = new ArrayList<>();

            for (AbstractSymbol ar : getRuleBody()){
                if (ar instanceof CFGTerminalSymbol){
                    copyOfRuleBody.add(new CFGTerminalSymbol(ar.getObject()));
                }
                else {
                    copyOfRuleBody.add(new CFGNonTerminalSymbol(ar.getObject()));
                }
            }

            return copyOfRuleBody;
        }
        else{
            throw new Exception("Production is not applicable");
        }
    }

    /**
     * The core of the class. Returns wether the production is applicable.
     * @param nonTerminal The {@linkplain CMAGNonTerminalSymbol} symbol to be replaced by the production
     * @return Boolean, answers wether the {@linkplain CMAGProduction} can be applied
     */
    @Override
    public Boolean applicable(AbstractSymbol nonTerminal) {
        return (nonTerminal.equals(getRuleHead()));
    }

}
