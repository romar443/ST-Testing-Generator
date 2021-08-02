package GeneralComponents.Operators.ArithmeticIntegerOperators;

import ConstraintMultisetAttributeGrammar.Attribute;
import GeneralComponents.Operators.AbstractArithmeticIntegerOperator;

public class Division extends AbstractArithmeticIntegerOperator {

    @Override
    public Integer getResult(Attribute a1, Attribute a2) {

        try {
            var i1 = (Integer) a1.getValue();
            var i2 = (Integer) a2.getValue();
            return (i1 / i2);
        } catch (Exception e) {
            throw new ClassCastException("\n Attribute Values weren't of type Integer \n");
        }
    }
}