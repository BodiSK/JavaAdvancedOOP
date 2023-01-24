package EncapsulationExercise.Task4PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        String pizzaName = tokens[1];
        int numberOfToppings = Integer.parseInt(tokens[2]);
        Pizza pizza = new Pizza(pizzaName, numberOfToppings);

        tokens = scanner.nextLine().split("\\s+");
        String flourType = tokens[1];
        String bakingTechnique = tokens[2];
        double doughWeight = Double.parseDouble(tokens[3]);
        Dough dough = new Dough(flourType, bakingTechnique, doughWeight);
        pizza.setDough(dough);

        String line = "";
        while (!"END".equals(line = scanner.nextLine())) {
            tokens = line.split("\\s+");
            String type = tokens[1];
            double toppingWeight = Double.parseDouble(tokens[2]);
            Topping topping = new Topping(type, toppingWeight);
            pizza.addTopping(topping);
        }

        System.out.printf("%s - %.2f", pizzaName, pizza.getOverallCalories());
    }
}
