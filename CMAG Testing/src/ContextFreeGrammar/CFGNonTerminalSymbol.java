package ContextFreeGrammar;

import GeneralComponents.AbstractSymbol;

import java.util.UUID;

/**
 * An implementation of a {@linkplain CFGSymbol}. Non-terminal symbol
 */
public class CFGNonTerminalSymbol extends CFGSymbol {

    public CFGNonTerminalSymbol(Object object) {
        super(object);
    }
    public CFGNonTerminalSymbol(Object object, UUID id) {
        super(object, id);
    }
}

