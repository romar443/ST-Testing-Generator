package ConstraintMultisetAttributeGrammar;

import ContextFreeGrammar.*;
import GeneralComponents.AbstractProduction;

import java.util.List;

/**
 * The grammar as a whole, adhering to all definitions of CMAG's except for the exclusion of synthesised attributes.
 * Extensible in the future to provide for generation.
 */
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
