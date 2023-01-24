package PolymorphismLab.Tas3Animals;

import PolymorphismLab.Tas3Animals.Animal;

public class Dog extends Animal {
    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return super.explainSelf() + System.lineSeparator() +
                "DJAAF";
    }
}
