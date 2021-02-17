package ContextFreeGrammar;

public class StartSymbol{

    private CFGNonTerminalSymbol startSymbol;

    public StartSymbol(CFGNonTerminalSymbol startObject){
        this.startSymbol = startObject;
    }

    public CFGNonTerminalSymbol getStartSymbol(){
        return this.startSymbol;
    }
}