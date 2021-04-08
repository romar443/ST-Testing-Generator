package ConstraintMultisetAttributeGrammar;

import GeneralComponents.AbstractOperator;
import GeneralComponents.AbstractSymbol;

import java.util.List;
import java.util.Objects;

public class AttributeRule {

    private AbstractOperator operation;
    private String assignFromAttributeName;
    private String assigneeAttributeName;
    private CMAGSymbol assignFrom;
    private CMAGSymbol assignee;
    private Attribute constant;
    private Boolean assignmentFlag = false;


    public AttributeRule (CMAGSymbol assignFrom, String assignFromAttributeName, String assigneeAttributeName, CMAGSymbol assignee){
        this.assignmentFlag = true;
        this.assignFrom = assignFrom;
        this.assignFromAttributeName = assignFromAttributeName;
        this.assigneeAttributeName = assigneeAttributeName;
        this.assignee = assignee;
    }

    public AttributeRule (Attribute constant, AbstractOperator operation, String assigneeAttributeName, CMAGSymbol assignee){
        this.operation = operation;
        this.constant = constant;
        this.assignee = assignee;
        this.assigneeAttributeName = assigneeAttributeName;
    }

    //Create constructor for unary functions
    //think about constants


    public AbstractSymbol applyRule(){

        //If assignmentFlag is true, then the rule is an assignment. The assignee's attribute is set with the value of the assignFrom attribute
        if (Objects.equals(this.assignmentFlag, true)){
            assignee.getAttributeWithName(assigneeAttributeName).setValue(assignFrom.getAttributeWithName(assignFromAttributeName).getValue());
            return assignee;
        }

        //In the case that an operation is set, return the assignee symbol, with a new value in the given attribute
        assignee.getAttributeWithName(assigneeAttributeName).setValue(operation.getResult(constant, assignee.getAttributeWithName(assigneeAttributeName)));

        return assignee;
    }

}
