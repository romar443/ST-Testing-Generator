package ContextFreeGrammar;

import ConstraintMultisetAttributeGrammar.CMAGProduction;
import GeneralComponents.AbstractProduction;
import GeneralComponents.AbstractSymbol;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of a grammar production for CFG's. The ruleHead must be a non-terminal symbol, as defined by CFG's.
 */
public class CFGProduction extends AbstractProduction {

    public CFGProduction(AbstractSymbol ruleHead, List<AbstractSymbol> ruleBody){
        super(ruleHead, ruleBody);
    }

    /**
     * <p>Core functionality of the class. Applies the production to the {@linkplain CFGNonTerminalSymbol} passed as an argument </p>
     * @param nonTerminal The {@linkplain CFGNonTerminalSymbol} passed as the ruleHead argument
     * @return The ruleBody
     * @throws Exception If the production is not {@linkplain #applicable(AbstractSymbol)}
     */
    @Override
    public List<AbstractSymbol> applyProduction(AbstractSymbol nonTerminal) throws Exception {
        if(applicable(nonTerminal)){

            //Introduce a copy of the objects in the rule body, so that attribute values are not changed in further productions
            List<AbstractSymbol> copyOfRuleBody = new ArrayList<>();

            for (AbstractSymbol ar : getRuleBody()){
                if (ar instanceof CFGTerminalSymbol){
                    copyOfRuleBody.add(new CFGTerminalSymbol(ar.getObject(), ar.getId()));
                }
                else {
                    copyOfRuleBody.add(new CFGNonTerminalSymbol(ar.getObject(), ar.getId()));
                }
            }

            return copyOfRuleBody;
        }
        else{
            throw new Exception("Production is not applicable");
        }
    }

    /**
     * Returns whether the production is applicable.
     * @param nonTerminal The {@linkplain CFGNonTerminalSymbol} symbol to be replaced by the production
     * @return Boolean, declaring whether the {@linkplain CMAGProduction} can be applied
     */
    @Override
    public Boolean applicable(AbstractSymbol nonTerminal) {

        //Rule head must be a NonTerminalSymbol in context-free grammars
        if(!(getRuleHead() instanceof CFGNonTerminalSymbol)){
            throw new IllegalStateException("Head of rule is NOT a CFGNonTerminalSymbol, as required by CFG Grammars");
        }

        return (nonTerminal.equals(getRuleHead()));
    }

}
