package GeneralComponents.Operators.BooleanOperators;

import ConstraintMultisetAttributeGrammar.Attribute;
import GeneralComponents.Operators.AbstractBooleanOperator;

/**
 * Boolean Operation
 * Given 2 arguments, perform operation: argument1 > argument2
 * It is assumed that the values of the attributes are Integers
 */
public class GreaterThan extends AbstractBooleanOperator {

    @Override
    public Boolean getResult(Attribute a1, Attribute a2) {
        try {
            var i1 = (Integer) a1.getValue();
            var i2 = (Integer) a2.getValue();
            return (i1 > i2);
        } catch (Exception e) {
            throw new ClassCastException("\n Attribute Values weren't of type Boolean \n");
        }
    }

}
