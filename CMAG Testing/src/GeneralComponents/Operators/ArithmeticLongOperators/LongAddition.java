package GeneralComponents.Operators.ArithmeticLongOperators;

import ConstraintMultisetAttributeGrammar.Attribute;
import GeneralComponents.Operators.AbstractArithmeticIntegerOperator;
import GeneralComponents.Operators.AbstractArithmeticLongOperator;

/**
 * Arithmetic Operation
 * Return the result of the addition of the two values
 * Values of Attributes must be of type Integer
 */
public class LongAddition extends AbstractArithmeticLongOperator {

    @Override
    public Long getResult(Attribute a1, Attribute a2) {

        try {
            var i1 = (Long) a1.getValue();
            var i2 = (Long) a2.getValue();
            return (i1 + i2);
        } catch (Exception e) {
            throw new ClassCastException("\n Attribute Values weren't of type Integer \n");
        }
    }
}
