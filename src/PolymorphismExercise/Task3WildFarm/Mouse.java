package PolymorphismExercise.Task3WildFarm;

public class Mouse extends Mammal {

    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }
    @Override
    public void eat(Food food) {
        if(food instanceof Meat){
            throw new IllegalArgumentException(String.format("%s are not eating that type of food!", "Mice"));
        }
        super.eat(food);
    }
}
