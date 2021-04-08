package GeneralComponents;

import ConstraintMultisetAttributeGrammar.Attribute;
import GeneralComponents.Operators.AbstractBooleanOperator;

public class BinaryOperation<T extends Attribute,U extends Attribute,R extends Attribute> {

    private Attribute a1;
    private Attribute a2;

    public BinaryOperation(Attribute a1, Attribute a2){
        this.a1 = a1;
        this.a2 = a2;
    }

    public Boolean BooleanResult(AbstractBooleanOperator operator){
        return operator.getResult(a1, a2);
    }

    

}

