package GeneralComponents.Operators.ArithmeticOperators;

import ConstraintMultisetAttributeGrammar.Attribute;
import GeneralComponents.Operators.AbstractArithmeticOperator;

public class Division extends AbstractArithmeticOperator {

    @Override
    public Integer getResult(Attribute a1, Attribute a2) {

        try {
            var i1 = (Integer) a1.getValue();
            var i2 = (Integer) a2.getValue();
            return (i1 / i2);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n Attribute Values weren't of type Integer \n");
            return null;
        }
    }
}