package ExeptionAndErrorHandlingLab;

import java.util.Scanner;

public class Task2SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        try {
            System.out.printf("%.2f%n", sqrt(input));
        }catch (IllegalArgumentException ignored){
            System.out.println("Invalid");
        }
        System.out.println("Goodbye");

    }

    public static double sqrt(String str){
        int number = Integer.parseInt(str);

        if(number<0)
            throw new IllegalArgumentException("Number must be positive number");

        return Math.sqrt(number);
    }
}
