package PolymorphismExercise.Task2VehicalExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public abstract String driving(double distance);

    public  void refueling(double liters){
        checkFuelLiters(liters);
        checkTankCapacity(liters);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        checkFuelLiters(fuelQuantity);
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
    public double getTankCapacity() {
        return this.tankCapacity;
    }
    public void checkFuelLiters(double liters){
        if(liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
    }

    public void checkTankCapacity(double liters) {
        if(getFuelQuantity() + liters > getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }

    public String traveling(double fuelConsumption, double distance){
        DecimalFormat format = new DecimalFormat( "#.##" );
        if(fuelConsumption <= getFuelQuantity()){
            setFuelQuantity(getFuelQuantity() - fuelConsumption);
            return String.format("%s travelled %s km", getClass().getSimpleName(), format.format(distance));
        }
        return String.format("%s needs refueling", getClass().getSimpleName());
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), getFuelQuantity());
    }
}
