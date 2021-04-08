package ConstraintMultisetAttributeGrammar;

import ContextFreeGrammar.CFGNonTerminalSymbol;
import java.util.List;


public class CMAGNonTerminalSymbol extends CMAGSymbol {

    public CMAGNonTerminalSymbol(Object object, List<Attribute> attributes) {
        super(object, attributes);
    }

    public CMAGNonTerminalSymbol(Object object, Attribute attribute) {
        super(object, attribute);
    }
}
