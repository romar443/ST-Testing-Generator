package ConstraintMultisetAttributeGrammar;

import ContextFreeGrammar.*;
import GeneralComponents.AbstractProduction;

import java.util.List;

public class CMAG extends CFG {

    private List<Attribute> attributes;
    private List<AttributeRule> attributeRules;
    private List<Constraint> constraints;


    public CMAG(List<CFGTerminalSymbol> terminalSymbols, List<CFGNonTerminalSymbol> nonTerminalSymbols, StartSymbol startSymbol, List<AbstractProduction> productions,
                List<Attribute> attributes, List<AttributeRule> attributeRules, List<Constraint> constraints) {

        super(terminalSymbols, nonTerminalSymbols, startSymbol, productions);
        this.attributes = attributes;
        this.attributeRules = attributeRules;
        this.constraints = constraints;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public List<AttributeRule> getAttributeRules() {
        return attributeRules;
    }

    public List<Constraint> getConstraints() {
        return constraints;
    }
}
