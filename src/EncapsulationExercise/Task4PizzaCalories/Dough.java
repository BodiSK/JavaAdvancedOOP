package EncapsulationExercise.Task4PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    public double calculateCalories(){
        FlourType flourType = FlourType.valueOf(this.flourType);
        BakingTechnique bakingTechnique = BakingTechnique.valueOf(this.bakingTechnique);
        return 2 * this.weight * flourType.getModifier() * bakingTechnique.getModifier();
    }

    private void setFlourType(String flourType) {
        try {
            FlourType.valueOf(flourType);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        try {
            BakingTechnique.valueOf(bakingTechnique);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 0 || weight > 200)
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        this.weight = weight;
    }
}
