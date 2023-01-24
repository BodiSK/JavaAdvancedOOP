package PolymorphismLab;

public class Main {
    public static void main(String[] args) {
        Task1MathOperation math = new Task1MathOperation();
        System.out.println(math.add(2, 2));
        System.out.println(math.add(3, 3, 3));
        System.out.println(math.add(4, 4, 4, 4));

    }
}
