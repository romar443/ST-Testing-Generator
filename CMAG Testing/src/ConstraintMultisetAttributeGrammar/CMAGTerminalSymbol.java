package ConstraintMultisetAttributeGrammar;

import ContextFreeGrammar.CFGTerminalSymbol;
import GeneralComponents.AbstractSymbol;

import java.util.List;
import java.util.UUID;

/**
 * The Terminal instance of a {@linkplain CMAGSymbol}
 */
public class CMAGTerminalSymbol extends CMAGSymbol {
    public CMAGTerminalSymbol(Object object, List<Attribute> attributes) {
        super(object, attributes);
    }
    public CMAGTerminalSymbol(Object object, List<Attribute> attributes, UUID id) {
        super(object, attributes, id);
    }
    public CMAGTerminalSymbol(Object object, Attribute attribute) {
        super(object, attribute);
    }

    @Override
    public CMAGTerminalSymbol clone() {
        return new CMAGTerminalSymbol(this.getObject(), this.getAttributes(), this.getId());
    }
}
