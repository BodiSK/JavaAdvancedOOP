package PolymorphismExercise.Task2VehicalExtension;

public class Bus extends Vehicle {

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public String driving(double distance) {
        double fuelConsumption = distance * (getFuelConsumption()+1.4);
        return traveling(fuelConsumption, distance);
    }

    public String drivingEmpty(double distance) {
        double fuelConsumption = distance * (getFuelConsumption());
        return traveling(fuelConsumption, distance);
    }

    @Override
    public void refueling(double liters) {
        super.refueling(liters);
        setFuelQuantity(getFuelQuantity() + liters);
    }
}
