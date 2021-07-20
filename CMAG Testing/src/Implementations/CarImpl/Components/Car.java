package Implementations.CarImpl.Components;

public class Car {

    private Colour colour;
    private Brand brand;
    private Integer wheelSize;
    private Integer seatNumber;

    public Car(Colour colour, Brand brand, Integer wheelSize, Integer seatNumber){
        this.colour = colour;
        this.brand = brand;
        this.wheelSize = wheelSize;
        this.seatNumber = seatNumber;
    }

    public Brand getBrand() {
        return this.brand;
    }

    public Colour getColour() {
        return this.colour;
    }

    public Integer getWheelSize() {
        return this.wheelSize;
    }

    public Integer getSeatNumber() {
        return this.seatNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "colour=" + colour +
                ", brand=" + brand +
                ", wheelSize=" + wheelSize +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
