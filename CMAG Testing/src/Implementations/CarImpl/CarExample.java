package Implementations.CarImpl;

import ConstraintMultisetAttributeGrammar.*;
import GeneralComponents.AbstractSymbol;
import GeneralComponents.Operators.ArithmeticIntegerOperators.Addition;
import GeneralComponents.Operators.BooleanOperators.EqualTo;
import GeneralComponents.Operators.BooleanOperators.NotEqualTo;
import GeneralComponents.Operators.StringOperators.AssignString;
import Implementations.CarImpl.Components.Brand;
import Implementations.CarImpl.Components.Car;
import Implementations.CarImpl.Components.Colour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarExample {

    public static void main(String[] args) throws Exception {

        //Car Example

        //  - Colour
        String blue = Colour.BLUE.toString();
        String red = Colour.RED.toString();
        String white = Colour.WHITE.toString();

        //  - Brand
        String bmw = Brand.BMW.toString();
        String audi = Brand.AUDI.toString();
        String mercedes = Brand.MERCEDES.toString();


        //  - Wheel Size
        Integer wheelSize = 0;
        Integer wheel30 = 30;
        Integer wheel50 = 50;
        Integer wheel70 = 70;

        //  - Number of Seats
        Integer seatNo = 0;
        Integer seats2 = 2;
        Integer seats4 = 4;
        Integer seats5 = 5;


        //Attribute Definitions (with placeholder values, to be replaced in the production)
        Attribute CarColour = new Attribute("placeholderValue", "colour");
        Attribute CarBrand = new Attribute("placeholderValue", "brand");
        Attribute CarWheelSize = new Attribute(wheelSize, "wheelsize");
        Attribute CarSeats = new Attribute(seatNo, "seats");

        //List of all car attributes
        List<Attribute> carAttributes = Arrays.asList(CarColour, CarBrand, CarWheelSize, CarSeats);

        //Non-Terminal Symbols
        CMAGNonTerminalSymbol UnfinishedCar = new CMAGNonTerminalSymbol("UnfinishedCar", carAttributes);

        //Terminal Symbol
        CMAGTerminalSymbol FinishedCar = new CMAGTerminalSymbol("FinishedCar", carAttributes);


        //constraints
        //The constraint is fulfilled if the value IS NOT equal to the starting value
        Constraint colourIsSet = new Constraint(UnfinishedCar, "colour", new NotEqualTo(), "placeholderValue");
        Constraint brandIsSet = new Constraint(UnfinishedCar, "brand", new NotEqualTo(), "placeholderValue");
        Constraint wheelSizeIsSet = new Constraint(UnfinishedCar, "wheelsize", new NotEqualTo(), wheelSize);
        Constraint seatsIsSet = new Constraint(UnfinishedCar, "seats", new NotEqualTo(), seatNo);

        //The constraint is fulfilled if the value IS equal to the starting value
        Constraint colourIsNotSet = new Constraint(UnfinishedCar, "colour", new EqualTo(), "placeholderValue");
        Constraint brandIsNotSet = new Constraint(UnfinishedCar, "brand", new EqualTo(), "placeholderValue");
        Constraint wheelSizeIsNotSet = new Constraint(UnfinishedCar, "wheelsize", new EqualTo(), wheelSize);
        Constraint seatsIsNotSet = new Constraint(UnfinishedCar, "seats", new EqualTo(), seatNo);

        //Attribute Rules
        //colour
        AttributeRule assignBlue = new AttributeRule(blue, new AssignString(), "colour", UnfinishedCar);
        AttributeRule assignRed = new AttributeRule(red, new AssignString(), "colour", UnfinishedCar);
        AttributeRule assignWhite = new AttributeRule(white, new AssignString(), "colour", UnfinishedCar);

        //brand
        AttributeRule assignBMW = new AttributeRule(bmw, new AssignString(), "brand", UnfinishedCar);
        AttributeRule assignAudi = new AttributeRule(audi, new AssignString(), "brand", UnfinishedCar);
        AttributeRule assignMercedes = new AttributeRule(mercedes, new AssignString(), "brand", UnfinishedCar);

        //wheel size
        AttributeRule assign30WheelSize = new AttributeRule(wheel30, new Addition(), "wheelsize", UnfinishedCar);
        AttributeRule assign50WheelSize = new AttributeRule(wheel50, new Addition(), "wheelsize", UnfinishedCar);
        AttributeRule assign70WheelSize = new AttributeRule(wheel70, new Addition(), "wheelsize", UnfinishedCar);

        //seat number
        AttributeRule assign2Seats = new AttributeRule(seats2, new Addition(), "seats", UnfinishedCar);
        AttributeRule assign4Seats = new AttributeRule(seats4, new Addition(), "seats", UnfinishedCar);
        AttributeRule assign5Seats = new AttributeRule(seats5, new Addition(), "seats", UnfinishedCar);


        //Produtions
        List<AbstractSymbol> body = Collections.singletonList(UnfinishedCar);
        CMAGProduction assignColour = new CMAGProduction(UnfinishedCar, body, colourIsNotSet, assignBlue);


        CMAGProduction assignBrand = new CMAGProduction(UnfinishedCar, body, brandIsNotSet, assignAudi);
        CMAGProduction assignWheelSize = new CMAGProduction(UnfinishedCar, body, wheelSizeIsNotSet, assign30WheelSize);
        CMAGProduction assignSeats = new CMAGProduction(UnfinishedCar, body, seatsIsNotSet, assign2Seats);


        //final production
        List<Constraint> finalConstraints = Arrays.asList(colourIsSet, brandIsSet, wheelSizeIsSet, seatsIsSet);
        List<AbstractSymbol> finishedCar = Collections.singletonList(FinishedCar);
        //no attribute rules for final
        List<AttributeRule> emptyList = new ArrayList<>();
        CMAGProduction assembleCar = new CMAGProduction(UnfinishedCar, finishedCar, finalConstraints, emptyList);



        //Use productions:
        List<AbstractSymbol> result1 = assignColour.applyProduction(UnfinishedCar);
        CMAGNonTerminalSymbol colouredCar = (CMAGNonTerminalSymbol) result1.get(0);

        colouredCar.getAttributes().forEach(attribute -> System.out.println(attribute.getValue()));
        System.out.println("\n");

        List<AbstractSymbol> result2 = assignBrand.applyProduction(colouredCar);
        CMAGNonTerminalSymbol brandedCar = (CMAGNonTerminalSymbol) result2.get(0);

        brandedCar.getAttributes().forEach(attribute -> System.out.println(attribute.getValue()));
        System.out.println("\n");

        List<AbstractSymbol> result3 = assignWheelSize.applyProduction(brandedCar);
        CMAGNonTerminalSymbol wheelCar = (CMAGNonTerminalSymbol) result3.get(0);

        wheelCar.getAttributes().forEach(attribute -> System.out.println(attribute.getValue()));
        System.out.println("\n");

        List<AbstractSymbol> result4 = assignSeats.applyProduction(wheelCar);
        CMAGNonTerminalSymbol seatedCar = (CMAGNonTerminalSymbol) result4.get(0);

        seatedCar.getAttributes().forEach(attribute -> System.out.println(attribute.getValue()));
        System.out.println("\n");


        //Final Car
        List<AbstractSymbol> result5 = assembleCar.applyProduction(seatedCar);
        CMAGTerminalSymbol finalCar = (CMAGTerminalSymbol) result5.get(0);



        Colour colour = Colour.valueOf((String) finalCar.getAttributeWithName("colour").getValue());
        Brand brand = Brand.valueOf((String)finalCar.getAttributeWithName("brand").getValue());
        Integer wheelsize = (Integer) finalCar.getAttributeWithName("wheelsize").getValue();
        Integer seats = (Integer) finalCar.getAttributeWithName("seats").getValue();

        Car car = new Car(colour, brand, wheelsize, seats);
        System.out.println(car.toString());
    }

}
