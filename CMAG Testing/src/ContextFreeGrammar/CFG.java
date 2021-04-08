package ContextFreeGrammar;

import GeneralComponents.AbstractProduction;

import java.util.List;

public class CFG {

    private List<CFGTerminalSymbol> terminalSymbols;
    private List<CFGNonTerminalSymbol> nonTerminalSymbols;
    private StartSymbol startSymbol;
    private List<AbstractProduction> productions;


    public CFG(List<CFGTerminalSymbol> terminalSymbols, List<CFGNonTerminalSymbol> nonTerminalSymbols,
               StartSymbol startSymbol, List<AbstractProduction> productions){

        this.terminalSymbols = terminalSymbols;
        this.nonTerminalSymbols = nonTerminalSymbols;
        this.startSymbol = startSymbol;
        this.productions = productions;
    }
}
