package GeneralComponents;

import ConstraintMultisetAttributeGrammar.Attribute;

/**
 * An abstract implementation of an operator
 * @param <T> Generic type T
 */
public abstract class AbstractOperator<T> {

    public abstract T getResult(Attribute a1, Attribute a2);
}
