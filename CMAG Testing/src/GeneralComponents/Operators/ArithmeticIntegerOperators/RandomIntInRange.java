package GeneralComponents.Operators.ArithmeticIntegerOperators;

import ConstraintMultisetAttributeGrammar.Attribute;
import GeneralComponents.Operators.AbstractArithmeticIntegerOperator;

/**
 * Arithmetic Operation
 * Return a random integer in a range, given a starting value
 */
public class RandomIntInRange extends AbstractArithmeticIntegerOperator {

    /**
     * Returns a random integer within a range, where a1 denotes the range and a2 is the starting value
     * @param a1 The given range from which to vary
     * @param a2 The base value from which to vary from
     * @return Random int in range
     */
    @Override
    public Integer getResult(Attribute a1, Attribute a2) {

        //Try catch loop in case of failed casting
        try {
            //Cast the value of the attributes to Integer
            var i1 = (Integer) a1.getValue();
            var i2 = (Integer) a2.getValue();

            //Find maximum bound
            var max = i2 + i1/2;
            max = Math.round(max);

            //Find minimum bound
            var min = i2 - i1/2;
            min = Math.round(min);

            //Return radom int result
            return (int) ((Math.random() * (max - min)) + min);
        }
        catch (Exception e) {
            throw new ClassCastException("\n Attribute Values weren't of type Integer \n");
        }
    }

}