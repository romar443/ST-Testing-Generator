package ConstraintMultisetAttributeGrammar;

import GeneralComponents.BinaryOperation;

public class Constraint {

    private BooleanBinaryOperation operation;

    public Constraint (BooleanBinaryOperation booleanBinaryOperation){
        this.operation = booleanBinaryOperation;
    }

    public Boolean getSatisfied(Attribute leftside, Attribute rightside){
        return operation.getResult(leftside, rightside).getValue();
    }
}
