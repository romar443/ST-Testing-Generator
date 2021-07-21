package ConstraintMultisetAttributeGrammar;

import java.util.List;

public class CMAG_Gen {

    private List<CMAGProduction> cmagProductions;
    private CMAGNonTerminalSymbol startSymbol;

    public CMAG_Gen(CMAGNonTerminalSymbol startSymbol, List<CMAGProduction> productions){
        this.startSymbol = startSymbol;
        this.cmagProductions = productions;
    }

    public CMAGNonTerminalSymbol getStartSymbol() {
        return startSymbol;
    }

    public List<CMAGProduction> getCmagProductions() {
        return cmagProductions;
    }
}
