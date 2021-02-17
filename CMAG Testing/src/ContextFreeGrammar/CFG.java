package ContextFreeGrammar;

import GeneralComponents.AbstractProduction;

import java.util.List;

public class CFG {

    private List<TerminalSymbol> terminalSymbols;
    private List<NonTerminalSymbol> nonTerminalSymbols;
    private StartSymbol startSymbol;
    private List<AbstractProduction> productions;


    public CFG(List<TerminalSymbol> terminalSymbols, List<NonTerminalSymbol> nonTerminalSymbols,
               StartSymbol startSymbol, List<AbstractProduction> productions){

        this.terminalSymbols = terminalSymbols;
        this.nonTerminalSymbols = nonTerminalSymbols;
        this.startSymbol = startSymbol;
        this.productions = productions;
    }

}
