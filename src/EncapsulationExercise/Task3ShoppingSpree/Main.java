package EncapsulationExercise.Task3ShoppingSpree;

import java.util.*;

public class Main {
    private static Map<String, Person> people = new LinkedHashMap<>();
    private static Map<String, Product> products = new LinkedHashMap<>();

    public static void main(String[] args) throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);

        fillMap("people", scanner);

        fillMap("products", scanner);

        String line = "";
        while (!"END".equals(line = scanner.nextLine())) {
            String personName = line.split("\\s+")[0];
            String productName = line.split("\\s+")[1];
            Person person = people.get(personName);
            Product product = products.get(productName);
            person.buyProduct(product);
        }

        people.values().forEach(p -> System.out.println(p.toString()));
    }

    private static void fillMap(String mapToFill, Scanner scanner) {
        String[] info = scanner.nextLine().split(";");
        Arrays.stream(info).forEach(element -> {
            String name = element.split("=")[0];
            double money = Double.parseDouble(element.split("=")[1]);
            if (mapToFill.equals("products")) {
                products.put(name, new Product(name, money));
            } else if (mapToFill.equals("people"))
                people.put(name, new Person(name, money));
        });
    }
}
