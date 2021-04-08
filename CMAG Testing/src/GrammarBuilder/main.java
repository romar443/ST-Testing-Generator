package GrammarBuilder;

import ConstraintMultisetAttributeGrammar.Attribute;
import GeneralComponents.Operators.ArithmeticOperators.Addition;

import java.util.Arrays;
import java.util.function.BiFunction;

public class main {

    public static void main(String[] args) {
        Attribute atr = new Attribute("atr", "atr");

        Attribute a1 = new Attribute(2, "1");
        Attribute a2 = new Attribute(2, "2");

        System.out.println(new Addition().getResult(a1, a2));

    }

}
