package ReflectionAndAnnotationsExercise.barracksWars.core.commands;

import ReflectionAndAnnotationsExercise.barracksWars.interfaces.Executable;

public abstract class Command implements Executable {
    private String[] data;

    public Command(String[] data) {
        this.data = data;
    }

    public String[] getData() {
        return data;
    }
}
