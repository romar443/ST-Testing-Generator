package ContextFreeGrammar;

import GeneralComponents.AbstractProduction;
import GeneralComponents.AbstractSymbol;

import java.util.List;

/**
 * The grammar as a whole, adhering to all definitions of a CFG. Extensible in the future to provide for generation.
 */
public class CFG {

    private List<CFGTerminalSymbol> terminalSymbols;
    private List<CFGNonTerminalSymbol> nonTerminalSymbols;
    private AbstractSymbol startSymbol;
    private List<AbstractProduction> productions;


    /**
     * Constructor
     * @param terminalSymbols List of all {@linkplain CFGTerminalSymbol}'s contained in the grammar
     * @param nonTerminalSymbols List of all {@linkplain CFGNonTerminalSymbol}'s contained in the grammar
     * @param startSymbol A {@linkplain CFGNonTerminalSymbol}
     * @param productions List of all {@linkplain CFGProduction}'s contained in the grammar
     */
    public CFG(List<CFGTerminalSymbol> terminalSymbols, List<CFGNonTerminalSymbol> nonTerminalSymbols,
               AbstractSymbol startSymbol, List<AbstractProduction> productions){
        if(startSymbol instanceof CFGNonTerminalSymbol){
            this.startSymbol = startSymbol;
        }
        else{
            throw new IllegalArgumentException("Start Symbol is not CFGNonTerminalSymbol");
        }
        this.terminalSymbols = terminalSymbols;
        this.nonTerminalSymbols = nonTerminalSymbols;
        this.startSymbol = startSymbol;
        this.productions = productions;
    }
}
