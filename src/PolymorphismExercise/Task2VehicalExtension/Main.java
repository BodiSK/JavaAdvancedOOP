package PolymorphismExercise.Task2VehicalExtension;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static Car car = null;
    public static Truck truck = null;
    public static Bus bus = null;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            try {
                getVehicle(scanner);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        int numberOfLines = Integer.parseInt(scanner.nextLine());

        while (numberOfLines-- > 0) {
            String[] commandAttribute = scanner.nextLine().split("\\s+");
            String command = commandAttribute[0];
            double argument = Double.parseDouble(commandAttribute[2]);
            Vehicle vehicle = getVehicleType(commandAttribute[1]);
            try {

                switch (command) {
                    case "Drive":
                        System.out.println(Objects.requireNonNull(vehicle).driving(argument));
                        break;
                    case "DriveEmpty":
                        System.out.println(bus.drivingEmpty(argument));
                        break;
                    case "Refuel":
                        Objects.requireNonNull(vehicle).refueling(argument);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }
    private static void getVehicle(Scanner console) {
        String []attributes = console.nextLine().split("\\s+");

        switch (attributes[0]) {
            case "Car":
                car = new Car(Double.parseDouble(attributes[1]), Double.parseDouble(attributes[2]), Double.parseDouble(attributes[3]));
                break;
            case "Truck":
                truck = new Truck(Double.parseDouble(attributes[1]), Double.parseDouble(attributes[2]), Double.parseDouble(attributes[3]));
                break;
            case "Bus":
                bus = new Bus(Double.parseDouble(attributes[1]), Double.parseDouble(attributes[2]), Double.parseDouble(attributes[3]));
                break;
        }
    }
    private static Vehicle getVehicleType(String vehicleType) {
        switch (vehicleType) {
            case "Car":
                return car;
            case "Truck":
                return truck;
            case "Bus":
                return bus;
            default:
                return null;
        }
    }
}
