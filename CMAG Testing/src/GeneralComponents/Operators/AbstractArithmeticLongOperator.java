package GeneralComponents.Operators;

import ConstraintMultisetAttributeGrammar.Attribute;
import GeneralComponents.AbstractOperator;

public abstract class AbstractArithmeticLongOperator extends AbstractOperator {


    @Override
    public abstract Long getResult(Attribute a1, Attribute a2);

}
