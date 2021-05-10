package GeneralComponents.Operators;

import ConstraintMultisetAttributeGrammar.Attribute;
import GeneralComponents.AbstractOperator;

public abstract class AbstractStringOperator extends AbstractOperator {


    @Override
    public abstract String getResult(Attribute a1, Attribute a2);
}
