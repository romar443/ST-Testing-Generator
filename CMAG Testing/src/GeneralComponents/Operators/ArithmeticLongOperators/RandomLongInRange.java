package GeneralComponents.Operators.ArithmeticLongOperators;

import ConstraintMultisetAttributeGrammar.Attribute;
import GeneralComponents.Operators.AbstractArithmeticLongOperator;

/**
 * Arithmetic Operation
 * Return a random Long in a range, given a starting value
 */
public class RandomLongInRange extends AbstractArithmeticLongOperator {

    /**
     * Returns a random Long within a range, where a1 denotes the range and a2 is the starting value
     * @param a1 The given range from which to vary
     * @param a2 The base value from which to vary from
     * @return
     */
    @Override
    public Long getResult(Attribute a1, Attribute a2) {

        //Try catch loop in case of failed casting
        try {
            //Cast the value of the attributes to Long
            var i1 = (Long) a1.getValue();
            var i2 = (Long) a2.getValue();

            //Find maximum bound
            var max = i2 + i1/2;
            max = Math.round(max);

            //Find minimum bound
            var min = i2 - i1/2;
            min = Math.round(min);

            //Return random Long result
            Double result = ((Math.random() * (max - min)) + min);
            return (result).longValue();

        }
        catch (Exception e) {
            throw new ClassCastException("\n Attribute Values weren't of type Long \n");
        }
    }

}