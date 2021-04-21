package ConstraintMultisetAttributeGrammar;

/**
 * The StartSymbol of a CMAG
 */
public class CMAGStartSymbol {

    private CMAGNonTerminalSymbol startSymbol;

    public CMAGStartSymbol(CMAGNonTerminalSymbol startObject) {
        this.startSymbol = startObject;
    }

    public CMAGNonTerminalSymbol getStartSymbol() {
        return this.startSymbol;
    }
}
