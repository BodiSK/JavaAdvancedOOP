package ExeptionAndErrorHandlingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3EnterNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = 1;
        int end = 100;

        List<String> numbersInRange = new ArrayList<>();

        while (numbersInRange.size() < 10) {
            String number = "";
            try {
                number = String.valueOf(readNumber(start, end, scanner));
            } catch (IllegalStateException exception) {
                System.out.println(exception.getMessage());
            }catch (NumberFormatException ignored){
                System.out.println("Invalid Number!");
            }

            if(!number.equals("")){
                numbersInRange.add(number);
                start = Integer.parseInt(number);
            }
        }

        System.out.println(String.join(", ", numbersInRange));

    }

    public static int readNumber(int start, int end, Scanner scanner) {
        int number = Integer.parseInt(scanner.nextLine());

        if (!(number > start && number < end))
            throw new IllegalStateException("Your number is not in range " + start + " - 100!");

        return number;
    }
}
