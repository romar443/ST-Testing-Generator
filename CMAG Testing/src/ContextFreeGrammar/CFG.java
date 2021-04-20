package ContextFreeGrammar;

import GeneralComponents.AbstractProduction;

import java.util.List;

/**
 * The grammar as a whole, adhering to all definitions of a CFG. Extensible in the future to provide for generation.
 */
public class CFG {

    private List<CFGTerminalSymbol> terminalSymbols;
    private List<CFGNonTerminalSymbol> nonTerminalSymbols;
    private StartSymbol startSymbol;
    private List<AbstractProduction> productions;


    /**
     * Constructor
     * @param terminalSymbols List of all {@linkplain CFGTerminalSymbol}'s contained in the grammar
     * @param nonTerminalSymbols List of all {@linkplain CFGNonTerminalSymbol}'s contained in the grammar
     * @param startSymbol The {@linkplain StartSymbol}
     * @param productions List of all {@linkplain CFGProduction}'s contained in the grammar
     */
    public CFG(List<CFGTerminalSymbol> terminalSymbols, List<CFGNonTerminalSymbol> nonTerminalSymbols,
               StartSymbol startSymbol, List<AbstractProduction> productions){

        this.terminalSymbols = terminalSymbols;
        this.nonTerminalSymbols = nonTerminalSymbols;
        this.startSymbol = startSymbol;
        this.productions = productions;
    }
}
