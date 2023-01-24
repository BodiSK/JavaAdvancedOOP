package EncapsulationExercise.Task3ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setMoney(money);
        setName(name);
        products = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        if (products.size() < 1)
            return String.format("%s – Nothing bought", name);
        else
            return String.format("%s - %s",
                    name, String.join(", ", products.stream().map(Product::getName).collect(Collectors.toList())));

    }

    public void buyProduct(Product product) {
        if (product.getCost() <= money) {
            System.out.printf("%s bought %s%n", name, product.getName());
            money -= product.getCost();
            products.add(product);
        } else {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
        }
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < 1)
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0)
            throw new IllegalArgumentException("Money cannot be negative");
        this.money = money;
    }
}
