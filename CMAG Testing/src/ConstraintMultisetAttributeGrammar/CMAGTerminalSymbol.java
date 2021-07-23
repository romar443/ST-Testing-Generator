package ConstraintMultisetAttributeGrammar;

import ContextFreeGrammar.CFGTerminalSymbol;
import GeneralComponents.AbstractSymbol;

import java.util.ArrayList;
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
    public String toString() {
        return super.toString();
    }

    /**
     * Method for cloning symbols and their attributes
     * @return A new instance of the same {@linkplain CMAGSymbol}
     */
    @Override
    public CMAGSymbol clone() {
        List<Attribute> clonedAttributes = new ArrayList<>();
        this.getAttributes().forEach(attribute -> clonedAttributes.add(attribute.clone()));
        return new CMAGTerminalSymbol(this.getObject(), clonedAttributes, this.getId());
    }
}
