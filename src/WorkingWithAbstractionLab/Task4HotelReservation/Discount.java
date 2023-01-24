package WorkingWithAbstractionLab.Task4HotelReservation;

public enum Discount {
    VIP(0.80),
    SECOND_VISIT(0.90),
    NONE(1);

    private double priceReduction;

    Discount(double priceReduction) {
        this.priceReduction = priceReduction;
    }

    public double getPriceReduction() {
        return this.priceReduction;
    }

    public static Discount parseDiscount(String discount){
        switch (discount){
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalArgumentException("Unsupported enum value " + discount);
        }
    }
}
