package ConstraintMultisetAttributeGrammar;

import ContextFreeGrammar.NonTerminalSymbol;
import java.util.List;


public class CMAGNonTerminal extends NonTerminalSymbol {

    private final List<Attribute> attributes;

    public CMAGNonTerminal(Object object, List<Attribute> attributes) {
        super(object);
        this.attributes = attributes;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public Attribute getAttributeAtPosition(int position){
        return attributes.get(position);
    }

}
