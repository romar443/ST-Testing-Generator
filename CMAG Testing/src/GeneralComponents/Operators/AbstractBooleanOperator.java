package GeneralComponents.Operators;

import ConstraintMultisetAttributeGrammar.Attribute;
import GeneralComponents.AbstractOperator;

public abstract class AbstractBooleanOperator extends AbstractOperator {


    @Override
    public abstract Boolean getResult(Attribute a1, Attribute a2);
}
