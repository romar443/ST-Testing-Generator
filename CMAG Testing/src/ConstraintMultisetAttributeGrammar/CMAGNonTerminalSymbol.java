package ConstraintMultisetAttributeGrammar;

import ContextFreeGrammar.CFGNonTerminalSymbol;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The Non-Terminal instance of a {@linkplain CMAGSymbol}
 */
public class CMAGNonTerminalSymbol extends CMAGSymbol {

    public CMAGNonTerminalSymbol(Object object, List<Attribute> attributes) {
        super(object, attributes);
    }
    public CMAGNonTerminalSymbol(Object object, List<Attribute> attributes, UUID id) {
        super(object, attributes, id);
    }
    public CMAGNonTerminalSymbol(Object object, Attribute attribute) {
        super(object, attribute);
    }

    /**
     * Method for cloning symbols and their attributes
     * @return A new instance of the same {@linkplain CMAGSymbol}
     */
    @Override
    public CMAGSymbol clone() {
        List<Attribute> clonedAttributes = new ArrayList<>();
        this.getAttributes().forEach(attribute -> clonedAttributes.add(attribute.clone()));
        return new CMAGNonTerminalSymbol(this.getObject(), clonedAttributes, this.getId());
    }
}
