package GeneralComponents.Operators.BooleanOperators;

import ConstraintMultisetAttributeGrammar.Attribute;
import GeneralComponents.Operators.AbstractBooleanOperator;

public class EqualTo extends AbstractBooleanOperator {

    @Override
    public Boolean getResult(Attribute a1, Attribute a2) {
        try {
            var i1 = (Integer) a1.getValue();
            var i2 = (Integer) a2.getValue();
            return (i1.equals(i2));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

