package PolymorphismExercise.Task2VehicalExtension;

public class Car extends Vehicle {


    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public String driving(double distance) {
        double fuelConsumption = distance * (getFuelConsumption() + 0.9);
        return traveling(fuelConsumption, distance);
    }

    @Override
    public void refueling(double liters) {
        super.refueling(liters);
        setFuelQuantity(getFuelQuantity() + liters);
    }
}
