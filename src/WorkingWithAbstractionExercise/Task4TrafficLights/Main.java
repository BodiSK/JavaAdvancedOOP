package WorkingWithAbstractionExercise.Task4TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<TrafficLight> trafficLights = new ArrayList<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(token -> trafficLights.add(new TrafficLight(Color.valueOf(token))));

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            trafficLights.stream().forEach(trafficLight -> {
                trafficLight.changeColor();
                System.out.print(trafficLight.getColor() + " ");
            });
            System.out.println();
        }
    }
}
