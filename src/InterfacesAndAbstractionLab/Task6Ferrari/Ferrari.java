package InterfacesAndAbstractionLab.Task6Ferrari;

import InterfacesAndAbstractionLab.Task6Ferrari.Car;

public class Ferrari implements Car {

    private String driverName;
    private String model;

    public Ferrari(String driverName) {
        this.driverName = driverName;
        this.model = "488";
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", model, brakes(), gas(), driverName);
    }
}
