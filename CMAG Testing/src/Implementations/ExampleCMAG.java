package Implementations;

import ConstraintMultisetAttributeGrammar.*;
import GeneralComponents.AbstractSymbol;
import GeneralComponents.Operators.ArithmeticOperators.Multiplication;
import GeneralComponents.Operators.BooleanOperators.EqualTo;
import GeneralComponents.Operators.BooleanOperators.GreaterThan;
import GeneralComponents.Operators.BooleanOperators.NotEqualTo;
import GeneralComponents.Operators.BooleanOperators.SmallerThan;
import GeneralComponents.Operators.StringOperators.AssignString;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unchecked")
public class ExampleCMAG {

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws Exception {


        //Step 1: Define Attributes
        Attribute attribute_x = new Attribute(1, "x");


        //Step 2: Non-Terminal and Terminal Symbols
        CMAGNonTerminalSymbol nonTerminalSymbol_S = new CMAGNonTerminalSymbol("S", attribute_x);
        CMAGNonTerminalSymbol nonTerminalSymbol_A = new CMAGNonTerminalSymbol("A", attribute_x);

        CMAGTerminalSymbol terminalSymbol_a = new CMAGTerminalSymbol("a", attribute_x);
        CMAGTerminalSymbol terminalSymbol_b = new CMAGTerminalSymbol("b", attribute_x);


        //Step 3: Define a Constraint
        Constraint c1 = new Constraint(nonTerminalSymbol_A, "x", new GreaterThan(), 0);


        //Step 4: Define an Attribute Rule
        AttributeRule x_times_2 = new AttributeRule(2, new Multiplication(), "x", nonTerminalSymbol_A);


        //Step 5: Define a Production
        CMAGProduction p1 = new CMAGProduction(nonTerminalSymbol_S, Collections.singletonList(nonTerminalSymbol_A), c1, x_times_2);




        //Run the production rule
        List<AbstractSymbol> r1 = p1.applyProduction(nonTerminalSymbol_S);

        CMAGNonTerminalSymbol A = (CMAGNonTerminalSymbol) r1.get(0);
        A.getAttributes().forEach(attribute -> System.out.println(attribute.getValue()));




    }


}
