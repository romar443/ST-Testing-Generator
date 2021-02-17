package ContextFreeGrammar;

import GeneralComponents.AbstractProduction;
import GeneralComponents.AbstractSymbol;

import java.util.List;

public class CFGProduction extends AbstractProduction {

    public CFGProduction(NonTerminalSymbol ruleHead, List<AbstractSymbol> ruleBody){
        super(ruleHead, ruleBody);
    }

}
