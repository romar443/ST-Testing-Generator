package GeneralComponents.Operators.BooleanOperators;

import ConstraintMultisetAttributeGrammar.Attribute;
import GeneralComponents.Operators.AbstractBooleanOperator;

public class NotEqualTo extends AbstractBooleanOperator {

    @Override
    public Boolean getResult(Attribute a1, Attribute a2) {
        try {
            var i1 =  a1.getValue();
            var i2 =  a2.getValue();
            return !(i1.equals(i2));
        } catch (Exception e) {
            throw new ClassCastException("\n Attribute Values weren't of type Boolean \n");
        }
    }

}

