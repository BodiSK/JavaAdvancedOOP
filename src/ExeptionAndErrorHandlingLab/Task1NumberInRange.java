package ExeptionAndErrorHandlingLab;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Task1NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] range = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.printf("Range: [%d...%d]%n", range[0], range[1]);

        boolean isValidInput = false;
        String input = "";

        while (true){
            input = scanner.nextLine();

            Optional<Integer> number = Optional.empty();

            try{
                number = Optional.of(Integer.parseInt(input));
            }
            catch (NumberFormatException ignored){

            }

            if(number.isPresent() &&number.get()>=range[0]&&number.get()<=range[1])
                break;
            System.out.printf("Invalid number: %s%n", input);
        }
        System.out.printf("Valid number: %s", input);
    }
}
