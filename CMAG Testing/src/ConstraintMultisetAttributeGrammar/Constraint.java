package ConstraintMultisetAttributeGrammar;

import GeneralComponents.Operators.AbstractBooleanOperator;

import java.util.Objects;

/**
 * Constaints are a defining aspect of CMAG's, alongside the concept of {@linkplain Attribute}s, which differentiate CMAG's from CFG's.
 * Constraints prevent {@linkplain CMAGProduction}s from being applied, if not all constraints are fulfilled.
 * Constraints can be modelled in two ways. Either the constraint checks the value of an {@linkplain Attribute} against some constant, or against the value of
 * some other {@linkplain Attribute}.
 */
public class Constraint {

    /**
     * The {@linkplain #operator} must be a boolean operation, as a constraint is either fulfilled or not.
     */
    private AbstractBooleanOperator operator;
    private Attribute leftsideAttribute;
    private Attribute rightsideAttribute;
    private Object constant;
    /**
     * Used to indicate whether to perform the operation on two {@linkplain Attribute}s, or on some {@linkplain Attribute} and a {@linkplain #constant} value
     */
    private Boolean constantFlag = false;


    /**
     * Constructor for operating on the value of the {@linkplain Attribute}s of two differing {@linkplain CMAGSymbol}s
     *
     * @param leftSymbol The {@linkplain CMAGSymbol} on the left hand side of the operation
     * @param leftSymbolAttributeName The name of the {@linkplain Attribute} belonging to the {@linkplain CMAGSymbol} on the left
     * @param booleanOperator The concrete instance of a {@linkplain AbstractBooleanOperator} e.g. {@linkplain GeneralComponents.Operators.BooleanOperators.GreaterThan}
     * @param rightSymbol The {@linkplain CMAGSymbol} on the right hand side of the operation
     * @param rightSymbolAttributeName The name of the {@linkplain Attribute} belonging to the {@linkplain CMAGSymbol} on the right
     */
    public Constraint (CMAGSymbol leftSymbol, String leftSymbolAttributeName, AbstractBooleanOperator booleanOperator, CMAGSymbol rightSymbol, String rightSymbolAttributeName){
        this.operator = booleanOperator;
        this.leftsideAttribute = leftSymbol.getAttributeWithName(leftSymbolAttributeName);
        this.rightsideAttribute = rightSymbol.getAttributeWithName(rightSymbolAttributeName);
    }

    /**
     * Constructor for operating on the value of the {@linkplain Attribute} of a {@linkplain CMAGSymbol}, and a {@linkplain #constant}
     * @param leftSymbol The {@linkplain CMAGSymbol} on the left hand side of the operation
     * @param leftSymbolAttributeName The name of the {@linkplain Attribute} belonging to the {@linkplain CMAGSymbol} on the left
     * @param booleanOperator The concrete instance of a {@linkplain AbstractBooleanOperator} e.g. {@linkplain GeneralComponents.Operators.BooleanOperators.GreaterThan}
     * @param constant The value of the predefined constant {@linkplain Attribute}
     */
    public Constraint (CMAGSymbol leftSymbol, String leftSymbolAttributeName, AbstractBooleanOperator booleanOperator, Object constant){
        this.operator = booleanOperator;
        this.leftsideAttribute = leftSymbol.getAttributeWithName(leftSymbolAttributeName);
        this.constant = constant;
        this.constantFlag = true;
    }

    /**
     * Returns whether the constraint is fulfilled
     * @return {@linkplain Boolean} indicating the status of the constraint
     */
    public Boolean getSatisfied(){
        if(Objects.equals(constantFlag, false)){
            return operator.getResult(leftsideAttribute, rightsideAttribute);
        }
        Attribute attributePlaceholder = new Attribute(constant, "constant");
        return operator.getResult(leftsideAttribute, attributePlaceholder);
    }
}
