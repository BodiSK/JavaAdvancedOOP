package InheritanceExercise.Task2Zoo;

public class Animal {
    private String name;

    public Animal(String name) {
        setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
