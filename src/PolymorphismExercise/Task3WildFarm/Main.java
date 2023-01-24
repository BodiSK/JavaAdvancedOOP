package PolymorphismExercise.Task3WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();
        String line = "";
        while(!"End".equals(line = scanner.nextLine())){
            Animal animal = createAnimal(line);
            Food food = createFood(scanner.nextLine());

            assert animal != null;
            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            animals.add(animal);
        }

        animals.forEach(System.out::println);
    }
    public static Food createFood(String food) {
        String[] attributes = food.split("\\s+");
        String foodKind = attributes[0];
        Integer quantity = Integer.parseInt(attributes[1]);
        if("Vegetable".equals(foodKind)){
            return new Vegetable(quantity);
        }
        return new Meat(quantity);
    }

    public static Animal createAnimal (String animalInfo){
        String[] attributes = animalInfo.split("\\s+");
        String animal = attributes[0];
        String name = attributes[1];
        Double weight = Double.parseDouble(attributes[2]);
        String region = attributes[3];

        switch (animal) {
            case "Tiger":
                return new Tiger(name, animal, weight, region);
            case "Zebra":
                return new Zebra(name, animal, weight, region);
            case "Mouse":
                return new Mouse(name, animal, weight, region);
            case "Cat":
                String breed = attributes[4];
                return new Cat(name, animal, weight, region, breed);
            default:
                return null;
        }
    }

}
