package ContextFreeGrammar;

import GeneralComponents.AbstractSymbol;

import java.util.UUID;

/**
 * An implementation of a {@linkplain CFGSymbol}. Terminal symbol
 */
public class CFGTerminalSymbol extends CFGSymbol {

    public CFGTerminalSymbol(Object object) {
        super(object);
    }
    public CFGTerminalSymbol(Object object, UUID id) {
        super(object, id);
    }

    @Override
    public CFGTerminalSymbol clone() {
        return new CFGTerminalSymbol(this.getObject(), this.getId());
    }

}
