package ConstraintMultisetAttributeGrammar;

import ContextFreeGrammar.TerminalSymbol;

import java.util.List;

public class CMAGTerminal extends TerminalSymbol {

    private final List<Attribute> attributes;

    public CMAGTerminal(Object object, List<Attribute> attributes) {
        super(object);
        this.attributes = attributes;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

}
