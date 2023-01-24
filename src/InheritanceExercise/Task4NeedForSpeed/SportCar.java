package InheritanceExercise.Task4NeedForSpeed;

import InheritanceExercise.Task4NeedForSpeed.Car;

public class SportCar extends Car {
    final static double	DEFAULT_FUEL_CONSUMPTION = 10;
    public SportCar(double fuel, int horsePower) {
        super(fuel, horsePower);
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
