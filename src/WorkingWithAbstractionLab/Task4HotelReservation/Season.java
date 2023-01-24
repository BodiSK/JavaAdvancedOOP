package WorkingWithAbstractionLab.Task4HotelReservation;

public enum Season {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private int multiplier;

    Season(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return this.multiplier;
    }

    public static Season parseSeason(String season){
        return Season.valueOf(season.toUpperCase());
    }
}
