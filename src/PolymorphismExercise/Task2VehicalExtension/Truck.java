package PolymorphismExercise.Task2VehicalExtension;

public class Truck extends Vehicle {


    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public String driving(double distance) {
        double fuelConsumption = distance * (getFuelConsumption() + 1.6);
        return traveling(fuelConsumption, distance);
    }

    @Override
    public void refueling(double liters) {
        super.refueling(liters*0.95);
        setFuelQuantity(getFuelQuantity() + liters*0.95);
    }
}
