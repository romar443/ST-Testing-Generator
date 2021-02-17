package ContextFreeGrammar;

import ConstraintMultisetAttributeGrammar.CMAGNonTerminal;
import ConstraintMultisetAttributeGrammar.CMAGProduction;
import ConstraintMultisetAttributeGrammar.Constraint;
import GeneralComponents.AbstractProduction;
import GeneralComponents.AbstractSymbol;

import java.util.List;

public class CFGProduction extends AbstractProduction {

    public CFGProduction(AbstractSymbol ruleHead, List<AbstractSymbol> ruleBody){
        super(ruleHead, ruleBody);
    }

    /**
     * The core of the class. Returns wether the production is applicable.
     * @param nonTerminalSymbol The {@linkplain CMAGNonTerminal} symbol to be replaced by the production
     * @return Boolean, answers wether the {@linkplain CMAGProduction} can be applied
     */
    public Boolean applicable (CFGNonTerminalSymbol nonTerminalSymbol){
        return (nonTerminalSymbol.equals(getRuleHead()));
    }

    public List<AbstractSymbol> applyProduction(CFGNonTerminalSymbol nonTerminalSymbol){
        if(applicable(nonTerminalSymbol)){
            return getRuleBody();
        }
        else{
            return null;
        }
    }

}
