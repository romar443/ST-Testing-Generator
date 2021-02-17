package GeneralComponents;

import ConstraintMultisetAttributeGrammar.Attribute;

import java.util.function.BiFunction;

public class BinaryOperation<T extends Attribute,U extends Attribute,R extends Attribute> {

    BiFunction<T,U,R> operation;

    public BinaryOperation(BiFunction<T,U,R> operation){
        this.operation = operation;
    }

     /**
     * Abstract BinaryOperation. Result cast to Boolean, so lambda function must be of a boolean form
     * @param a1 Left hand side of the function. Of type {@linkplain Attribute}
     * @param a2 Right hand side of the function. Of type {@linkplain Attribute}
     * @return Boolean
     */
    public R getResult(T a1, U a2) {
        return operation.apply(a1, a2);
    }


}

