package EncapsulationExercise.Task4PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public double calculateCalories(){
        ToppingType toppingType = ToppingType.valueOf(this.toppingType);
        return 2 * this.weight * toppingType.getModifier();
    }

    private void setToppingType(String toppingType) {
        try {
            ToppingType.valueOf(toppingType);
        }catch (IllegalArgumentException exception){
            throw  new IllegalArgumentException (
                    String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if(weight<1||weight>50)
            throw new IllegalArgumentException(
                    String.format("%s weight should be in the range [1..50].",toppingType));
        this.weight = weight;
    }
}
