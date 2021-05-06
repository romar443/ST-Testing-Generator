package ConstraintMultisetAttributeGrammar;

import GeneralComponents.AbstractOperator;
import GeneralComponents.AbstractSymbol;

import java.util.List;
import java.util.Objects;

/**
 * An {@linkplain AttributeRule} represents the operation that will occur on a specified attribute, when a production is applied. These operations allow attributes
 * to be Inherited, a key concept of CMAG's. As currently modelled, an {@linkplain AttributeRule} allows either the assigning of an attribute, or an operation to be
 * executed upon an attribute with some constant. By chaining the rules, one can execute any type of function.
 */
public class AttributeRule {

    /**
     * The operation itself, which must be a concrete instance of an operator e.g. {@linkplain GeneralComponents.Operators.ArithmeticOperators.Addition} for integers.
     */
    private AbstractOperator operation;
    /**
     * The String denoting the name of the{@linkplain Attribute}, which will be used to assign FROM
     */
    private String assignFromAttributeName;
    /**
     * The String denoting the name of the {@linkplain Attribute}, to which a value will be ASSIGNED
     */
    private String assigneeAttributeName;
    /**
     * The {@linkplain Attribute} which will be used to assign FROM
     */
    private CMAGSymbol assignFrom;
    /**
     * The {@linkplain Attribute} to which a value will be ASSIGNED
     */
    private CMAGSymbol assignee;
    /**
     * Some {@linkplain Attribute}, which has some constant stored at its {@linkplain Attribute#getValue()}
     */
    private Object constant;
    /**
     * Flag used to indicate whether an assignment or operation is to take place.
     */
    private Boolean assignmentFlag = false;


    /**
     * Constructor for allowing assignement of the value from one {@linkplain Attribute} to another, indicating the symbol, as well as
     * the name of the  {@linkplain Attribute}
     *
     * @param assignFrom The {@linkplain CMAGSymbol} from which the {@linkplain Attribute} and its corresponding value is taken
     * @param assignFromAttributeName The name of the {@linkplain Attribute} FROM which the value is assigned
     * @param assigneeAttributeName The {@linkplain CMAGSymbol} to which the {@linkplain Attribute} and its corresponding value is assigned to
     * @param assignee The name of the {@linkplain Attribute} TO which the value is assigned
     */
    public AttributeRule (CMAGSymbol assignFrom, String assignFromAttributeName, String assigneeAttributeName, CMAGSymbol assignee){
        this.assignmentFlag = true;
        this.assignFrom = assignFrom;
        this.assignFromAttributeName = assignFromAttributeName;
        this.assigneeAttributeName = assigneeAttributeName;
        this.assignee = assignee;
    }


    /**
     * Constructor serving to allow operations to be executed upon some {@linkplain Attribute}s value, using predefined {@linkplain Attribute}s with constant values
     * to perform the operation
     *
     * @param constant Some {@linkplain Attribute} with a constant value
     * @param operation A concrete instance of an {@linkplain AbstractOperator}
     * @param assigneeAttributeName The {@linkplain CMAGSymbol} to which the {@linkplain Attribute} and its corresponding value is assigned to
     * @param assignee The name of the {@linkplain Attribute} TO which the value is assigned
     */
    public AttributeRule (Object constant, AbstractOperator operation, String assigneeAttributeName, CMAGSymbol assignee){
        this.operation = operation;
        this.constant = constant;
        this.assignee = assignee;
        this.assigneeAttributeName = assigneeAttributeName;
    }




    /**
     * Either assigns the value from some {@linkplain CMAGSymbol}s {@linkplain Attribute} to another {@linkplain CMAGSymbol}s {@linkplain Attribute}, or performs
     * an {@linkplain #operation} upon some {@linkplain CMAGSymbol}s {@linkplain Attribute}s value. The functionality is based upon the constructor used, which sets
     * the assignment flag
     * @return
     */
    public AbstractSymbol applyRule(){

        //If assignmentFlag is true, then the rule is an assignment. The assignee's attribute is set with the value of the assignFrom attribute
        if (Objects.equals(this.assignmentFlag, true)){
            assignee.getAttributeWithName(assigneeAttributeName).setValue(assignFrom.getAttributeWithName(assignFromAttributeName).getValue());
            return assignee;
        }

        //In the case that an operation is set, return the assignee symbol, with a new value in the given attribute
        Attribute attributePlaceholder = new Attribute(constant, "constant");
        assignee.getAttributeWithName(assigneeAttributeName).setValue(operation.getResult(attributePlaceholder, assignee.getAttributeWithName(assigneeAttributeName)));
        return assignee;
    }

}
