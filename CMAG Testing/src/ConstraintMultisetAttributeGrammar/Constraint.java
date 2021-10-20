package ConstraintMultisetAttributeGrammar;

import GeneralComponents.AbstractSymbol;
import GeneralComponents.Operators.AbstractBooleanOperator;

import java.util.Objects;
import java.util.UUID;

/**
 * Constaints are a defining aspect of CMAG's, alongside the concept of {@linkplain Attribute}s, which differentiate CMAG's from CFG's.
 * Constraints prevent {@linkplain CMAGProduction}s from being applied, if not all constraints are fulfilled.
 * Constraints can be modelled in two ways. Either the constraint checks the value of an {@linkplain Attribute} against some constant, or against the value of
 * some other {@linkplain Attribute}.
 */
public class Constraint {

    private AbstractBooleanOperator operator;
    private UUID leftSymbolId;
    private UUID rightSymbolId;
    private String leftsideAttributeName;
    private String rightsideAttributeName;
    private Object constant;
    /**
     * Used to indicate whether to perform the operation on two {@linkplain Attribute}s, or on some {@linkplain Attribute} and a {@linkplain #constant} value
     */
    private Boolean constantFlag = false;


    /**
     * Constructor for operating on the value of the {@linkplain Attribute}s of two differing {@linkplain CMAGSymbol}s
     *
     * @param leftSymbol The {@linkplain UUID} of the {@linkplain CMAGSymbol} on the left hand side of the operation
     * @param leftSymbolAttributeName The name of the {@linkplain Attribute} belonging to the {@linkplain CMAGSymbol} on the left
     * @param booleanOperator The concrete instance of a {@linkplain AbstractBooleanOperator} e.g. {@linkplain GeneralComponents.Operators.BooleanOperators.GreaterThan}
     * @param rightSymbol The {@linkplain UUID} of the {@linkplain CMAGSymbol} on the right hand side of the operation
     * @param rightSymbolAttributeName The name of the {@linkplain Attribute} belonging to the {@linkplain CMAGSymbol} on the right
     */
    public Constraint (AbstractSymbol leftSymbol, String leftSymbolAttributeName, AbstractBooleanOperator booleanOperator, AbstractSymbol rightSymbol, String rightSymbolAttributeName){
        this.operator = booleanOperator;
        this.leftSymbolId = leftSymbol.getId();
        this.rightSymbolId = rightSymbol.getId();
        this.leftsideAttributeName = leftSymbolAttributeName;
        this.rightsideAttributeName = rightSymbolAttributeName;
    }

    /**
     * Constructor for operating on the value of the {@linkplain Attribute} of a {@linkplain CMAGSymbol}, and a {@linkplain #constant}
     * @param leftSymbol The {@linkplain UUID} of the {@linkplain CMAGSymbol} on the left hand side of the operation
     * @param leftSymbolAttributeName The name of the {@linkplain Attribute} belonging to the {@linkplain CMAGSymbol} on the left
     * @param booleanOperator The concrete instance of a {@linkplain AbstractBooleanOperator} e.g. {@linkplain GeneralComponents.Operators.BooleanOperators.GreaterThan}
     * @param constant The value of the predefined constant {@linkplain Attribute}
     */
    public Constraint (AbstractSymbol leftSymbol, String leftSymbolAttributeName, AbstractBooleanOperator booleanOperator, Object constant){
        this.operator = booleanOperator;
        this.leftSymbolId = leftSymbol.getId();
        this.leftsideAttributeName = leftSymbolAttributeName;
        this.constant = constant;
        this.constantFlag = true;
    }

    /**
     * Returns whether the constraint is fulfilled
     * @return {@linkplain Boolean} indicating the status of the constraint
     */
    public Boolean getSatisfied(CMAGSymbol leftSymbol, CMAGSymbol rightSymbol) throws ClassNotFoundException {

        //Get leftSide attribute
        Attribute leftsideAttribute = leftSymbol.getAttributeWithName(leftsideAttributeName);

        //If the constraint is evaluated upon the value of two attributes:
        if(Objects.equals(constantFlag, false)){

            Attribute rightsideAttribute = rightSymbol.getAttributeWithName(rightsideAttributeName);

            return operator.getResult(leftsideAttribute, rightsideAttribute);
        }

        Attribute attributePlaceholder = new Attribute(constant, "constant");
        return operator.getResult(leftsideAttribute, attributePlaceholder);
    }


    public Boolean getConstantFlag(){
        return this.constantFlag;
    }

    public UUID getLeftSymbolId() {
        return leftSymbolId;
    }

    public UUID getRightSymbolId() {
        return rightSymbolId;
    }
}
