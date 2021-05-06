import ConstraintMultisetAttributeGrammar.*;
import GeneralComponents.Operators.ArithmeticOperators.Subtraction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

public class CarExample {



    public static void main(String[] args) {

        //Car

        //  - Colour
        var blue = Colour.BLUE;
        var red = Colour.RED;
        var white = Colour.WHITE;
        var black = Colour.BLACK;
        var grey = Colour.GREY;

        //  - Brand
        var bmw = Brand.BMW;
        var audi = Brand.AUDI;
        var mercedes = Brand.MERCEDES;
        var vw = Brand.VW;
        var volvo = Brand.VOLVO;
        var porsche = Brand.PORSCHE;

        //  - Wheel Size
        Integer wheelSize = 0;

        //  - Number of Seats
        Integer seatNo = 0;


        //Attribute Definitions (with placeholder values, to be replaced in the production)
        Attribute CarColour = new Attribute("placeholderValue", "colour");
        Attribute CarBrand = new Attribute("placeholderValue", "brand");
        Attribute CarWheelSize = new Attribute("placeholderValue", "wheelsize");
        Attribute CarSeats = new Attribute("placeholderValue", "seats");


        List carAttributes = Arrays.asList(CarColour, CarBrand, CarWheelSize, CarSeats);

        //Non-Terminal Symbols
        CMAGNonTerminalSymbol UnfinishedCar = new CMAGNonTerminalSymbol("UnfinishedCar", carAttributes);

        //Terminal Symbol
        CMAGTerminalSymbol FinishedCar = new CMAGTerminalSymbol("FinishedCar", carAttributes);

        //start
        CMAGStartSymbol start = new CMAGStartSymbol(UnfinishedCar);

        //constraints
//        Constraint c1 = new Constraint();
//
//        //Attribute Rules
//        AttributeRule assignBlue = new AttributeRule(blue, , "colour", UnfinishedCar);
//        AttributeRule assignRed = new AttributeRule();
//
//
//        List body = Arrays.asList(NT1, NT2);
//        CMAGProduction p1 = new CMAGProduction(start, body, )
    }


    public enum Brand {
        BMW, AUDI, MERCEDES, VW, VOLVO, PORSCHE;
    }

    public enum Colour {
        BLUE, RED, WHITE, BLACK, GREY;
    }
}
