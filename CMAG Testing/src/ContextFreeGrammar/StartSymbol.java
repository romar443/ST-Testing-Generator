package ContextFreeGrammar;

/**
 * The symbol set as the starting point from which productions can be applied.
 */
public class StartSymbol{

    private CFGNonTerminalSymbol startSymbol;

    /** Constructor
     * @param startObject An instance of a {@linkplain CFGNonTerminalSymbol}
     */
    public StartSymbol(CFGNonTerminalSymbol startObject){
        this.startSymbol = startObject;
    }

    public CFGNonTerminalSymbol getStartSymbol(){
        return this.startSymbol;
    }
}