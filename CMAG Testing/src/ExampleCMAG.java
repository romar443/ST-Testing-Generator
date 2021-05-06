import ConstraintMultisetAttributeGrammar.*;
import GeneralComponents.AbstractOperator;
import GeneralComponents.AbstractSymbol;
import GeneralComponents.Operators.AbstractBooleanOperator;
import GeneralComponents.Operators.ArithmeticOperators.Addition;
import GeneralComponents.Operators.ArithmeticOperators.Multiplication;
import GeneralComponents.Operators.BooleanOperators.EqualTo;
import GeneralComponents.Operators.BooleanOperators.GreaterThan;
import GeneralComponents.Operators.BooleanOperators.SmallerThan;

import java.util.Arrays;
import java.util.List;

public class ExampleCMAG {

    public ExampleCMAG() {
    }

    public static void main(String[] args) throws Exception {

        //Initial Attribute Values
        Integer startvalue = 1;
        Integer two = 2;
        Integer one = 1;
        Integer oneHundred = 100;

        //Attributes
        Attribute sum = new Attribute(startvalue, "sum");



        // Terminal and Non-Terminal Symbols
        //NT1 - Non-terminal symbol, with attribute "sum", initialised as 1
        CMAGNonTerminalSymbol NT1 = new CMAGNonTerminalSymbol("NT1", sum);
        //T1 - Terminal symbol, with attribute "sum", initialised as 1
        CMAGTerminalSymbol T1 = new CMAGTerminalSymbol("T1", sum);

        //Start Symbol
        //NT1
        CMAGStartSymbol startSymbol = new CMAGStartSymbol(NT1);


        //Constraints
        // (NT1.sum < 100)
        Constraint c1 = new Constraint(NT1, "sum", new SmallerThan(), oneHundred);

        //Attribute Rules
        // (2 x NT1.sum)
        AttributeRule mutliply = new AttributeRule(two, new Multiplication(), "sum", NT1);
        // (NT1.sum + 1)
        AttributeRule add = new AttributeRule(one, new Addition(), "sum", NT1);
        // (NT1.sum -> T1.sum)
        AttributeRule assign = new AttributeRule(NT1, "sum", "sum", T1);

        //Rule 1 (NT1 -> NT1,T1)
        List<AbstractSymbol> ruleBody1 = Arrays.asList(NT1, T1);
        List<AttributeRule> attributeRules1 = Arrays.asList(mutliply, add, assign);
        List<Constraint> constraints1 = Arrays.asList(c1);
        CMAGProduction p1 = new CMAGProduction(NT1, ruleBody1, constraints1, attributeRules1);

        //Rule 2 (NT1 -> T1)
        List<AbstractSymbol> ruleBody2 = Arrays.asList(T1);
        List<AttributeRule> attributeRules2 = Arrays.asList(mutliply, add, assign);
        List<Constraint> constraints2 = Arrays.asList(c1);
        CMAGProduction p2 = new CMAGProduction(NT1, ruleBody2, constraints2, attributeRules2);




        //Apply the production
        List list1 = p1.applyProduction(NT1);

        for(Object a : list1){
            System.out.println(a);
            System.out.println("First prod: " + ((CMAGSymbol) a).getAttributeWithName("sum").getValue());
        }

        List list2 = p2.applyProduction((CMAGNonTerminalSymbol) list1.get(0));

        for(Object a : list2){
            System.out.println("Second prod" + ((CMAGSymbol) a).getAttributeWithName("sum").getValue());
        }


    }
}
