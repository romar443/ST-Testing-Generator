package GeneralComponents;

import ConstraintMultisetAttributeGrammar.Attribute;

public abstract class AbstractOperator<T> {

    public abstract T getResult(Attribute a1, Attribute a2);
}
