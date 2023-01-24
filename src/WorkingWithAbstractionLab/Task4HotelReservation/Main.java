package WorkingWithAbstractionLab.Task4HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] tokens = scanner.nextLine().split("\\s+");

        double price = Double.parseDouble(tokens[0]);
        int days = Integer.parseInt(tokens[1]);
        Season season = Season.parseSeason(tokens[2]);
        Discount discount = Discount.parseDiscount(tokens[3]);

        PriceCalculator calc = new PriceCalculator(price, days, season, discount);
        System.out.printf("%.2f", calc.calculatePrice());

    }
}
