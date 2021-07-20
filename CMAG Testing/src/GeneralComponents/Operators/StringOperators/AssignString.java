package GeneralComponents.Operators.StringOperators;

import ConstraintMultisetAttributeGrammar.Attribute;
import GeneralComponents.Operators.AbstractArithmeticOperator;
import GeneralComponents.Operators.AbstractStringOperator;

/**
 * Arithmetic Operation
 * Return the result of the addition of the two values
 * Values of Attributes must be of type Integer
 */
public class AssignString extends AbstractStringOperator {

    @Override
    public String getResult(Attribute a1, Attribute a2) {

        try {
            var i1 = (String) a1.getValue();
            return i1;
        } catch (Exception e) {
            throw new ClassCastException("\n Attribute Values weren't of type String \n");
        }
    }
}
