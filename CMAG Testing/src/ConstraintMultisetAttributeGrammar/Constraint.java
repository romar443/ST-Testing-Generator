package ConstraintMultisetAttributeGrammar;

import GeneralComponents.BinaryOperation;
import GeneralComponents.Operators.AbstractBooleanOperator;

import java.util.Objects;

public class Constraint {

    private AbstractBooleanOperator operator;
    private Attribute leftsideAttribute;
    private Attribute rightsideAttribute;
    private Attribute constant;
    private Boolean constantFlag = false;


    public Constraint (CMAGSymbol leftSymbol, String leftSymbolAttributeName, AbstractBooleanOperator booleanOperator, CMAGSymbol rightSymbol, String rightSymbolAttributeName){
        this.operator = booleanOperator;
        this.leftsideAttribute = leftSymbol.getAttributeWithName(leftSymbolAttributeName);
        this.rightsideAttribute = rightSymbol.getAttributeWithName(rightSymbolAttributeName);
    }

    public Constraint (CMAGSymbol leftSymbol, String leftSymbolAttributeName, AbstractBooleanOperator booleanOperator, Attribute constant){
        this.operator = booleanOperator;
        this.leftsideAttribute = leftSymbol.getAttributeWithName(leftSymbolAttributeName);
        this.constant = constant;
        this.constantFlag = true;
    }

    //Method which returns a boolean indicating whether the constraint is satisfied or not
    public Boolean getSatisfied(){
        if(Objects.equals(constantFlag, false)){
            return operator.getResult(leftsideAttribute, rightsideAttribute);
        }
        return operator.getResult(leftsideAttribute, constant);
    }
}
