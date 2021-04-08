package ConstraintMultisetAttributeGrammar;

import ContextFreeGrammar.CFGTerminalSymbol;

import java.util.List;

public class CMAGTerminalSymbol extends CMAGSymbol {
    public CMAGTerminalSymbol(Object object, List<Attribute> attributes) {
        super(object, attributes);
    }

    public CMAGTerminalSymbol(Object object, Attribute attribute) {
        super(object, attribute);
    }
}
