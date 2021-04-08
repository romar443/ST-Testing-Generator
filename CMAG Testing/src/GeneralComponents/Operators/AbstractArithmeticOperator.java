package GeneralComponents.Operators;

import ConstraintMultisetAttributeGrammar.Attribute;
import GeneralComponents.AbstractOperator;

public abstract class AbstractArithmeticOperator extends AbstractOperator {


    @Override
    public abstract Integer getResult(Attribute a1, Attribute a2);

}
