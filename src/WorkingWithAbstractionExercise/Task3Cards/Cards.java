package WorkingWithAbstractionExercise.Task3Cards;

public class Cards {
    private CardRanks rank;
    private CardSuits suit;

    public Cards(CardRanks rank, CardSuits suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int cardPower(){
        return  rank.getPower() + suit.getPower();
    }

    public CardRanks getRank() {
        return rank;
    }

    public CardSuits getSuit() {
        return suit;
    }
}
