package ConstraintMultisetAttributeGrammar;

import ContextFreeGrammar.CFGNonTerminalSymbol;
import java.util.List;

/**
 * The Non-Terminal instance of a {@linkplain CMAGSymbol}
 */
public class CMAGNonTerminalSymbol extends CMAGSymbol {

    public CMAGNonTerminalSymbol(Object object, List<Attribute> attributes) {
        super(object, attributes);
    }

    public CMAGNonTerminalSymbol(Object object, Attribute attribute) {
        super(object, attribute);
    }
}
