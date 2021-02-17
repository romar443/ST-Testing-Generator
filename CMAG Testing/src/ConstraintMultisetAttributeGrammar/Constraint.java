package ConstraintMultisetAttributeGrammar;

import GeneralComponents.BinaryOperation;

public class Constraint {

    private BooleanBinaryOperation operation;
    private Attribute leftsideAttribute;
    private Attribute rightsideAttribute;


    public Constraint (CMAGSymbol leftSymbol, String leftSymbolAttributeName, BooleanBinaryOperation booleanBinaryOperation, CMAGSymbol rightSymbol, String rightSymbolAttributeName){
        this.operation = booleanBinaryOperation;
        this.leftsideAttribute = leftSymbol.getAttributeWithName(leftSymbolAttributeName);
        this.rightsideAttribute = rightSymbol.getAttributeWithName(rightSymbolAttributeName);;
    }

    public Boolean getSatisfied(){
        return operation.getResult(leftsideAttribute, rightsideAttribute).getValue();
    }
}
