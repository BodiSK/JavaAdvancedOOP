package WorkingWithAbstractionLab;

import java.util.Scanner;

public class Task1RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printRhombus(n);
    }

    public static void printRhombus(int n) {
        for(int i=1; i<=n; i++)
            printTriangle(n-i, i);
        for(int i=1; i<=n-1; i++)
            printTriangle(i, n-i);
    }

    private static void printTriangle(int firstCount, int secondCount) {
        for (int j = 0; j < firstCount; j++)
            System.out.print(" ");
        for (int j = 0; j < secondCount; j++)
            System.out.print("* ");
        System.out.println();
    }

}
