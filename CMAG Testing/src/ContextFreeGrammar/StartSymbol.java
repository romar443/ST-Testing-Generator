package ContextFreeGrammar;

public class StartSymbol{

    private NonTerminalSymbol startSymbol;

    public StartSymbol(NonTerminalSymbol startObject){
        this.startSymbol = startObject;
    }

    public NonTerminalSymbol getStartSymbol(){
        return this.startSymbol;
    }
}