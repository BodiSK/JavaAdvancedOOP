package WorkingWithAbstractionLab.Task4HotelReservation;

public class PriceCalculator {
    private  double pricePerDay;
    private int numberOfDays;
    private Season season;
    private Discount discountType;

    public PriceCalculator(double pricePerDay, int numberOfDays, Season season, Discount discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discountType;
    }

    public double calculatePrice(){
        return pricePerDay*numberOfDays* season.getMultiplier()*discountType.getPriceReduction();
    }
}
