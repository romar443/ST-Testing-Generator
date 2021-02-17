package ConstraintMultisetAttributeGrammar;

import GeneralComponents.BinaryOperation;

import java.util.function.BiFunction;

public class BooleanBinaryOperation<T extends Attribute, U extends Attribute> extends BinaryOperation<T, U , BooleanAttribute> {

    public BooleanBinaryOperation(BiFunction operation) {
        super(operation);
    }
}
