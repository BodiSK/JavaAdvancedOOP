package WorkingWithAbstractionExercise.Task3Cards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardRanks cardRank = CardRanks.parseRank(scanner.nextLine());
        CardSuits cardSuit = CardSuits.parseSuit(scanner.nextLine());

        Cards card = new Cards(cardRank, cardSuit);

        System.out.printf("Card name: %s of %s; Card power: %d",
                card.getRank().name(), card.getSuit().name(), card.cardPower());
    }
}
