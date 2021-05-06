package ContextFreeGrammar;

import GeneralComponents.AbstractSymbol;

import java.util.UUID;

/**
 * Abstract CFG symbol
 */
public abstract class CFGSymbol extends AbstractSymbol {
    public CFGSymbol(Object object) {
        super(object);
    }

    /**
     * Constructor used in {@linkplain CFGProduction}, to replicate the symbol
     * @param object Object contained within the symbol
     * @param id The UUID of the symbol, used to replicate it
     */
    public CFGSymbol(Object object, UUID id) {
        super(object, id);
    }
}
