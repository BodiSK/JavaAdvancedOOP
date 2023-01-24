package ReflectionAndAnnotationsExercise.barracksWars.core.commands;

import ReflectionAndAnnotationsExercise.barracksWars.annotations.Inject;
import ReflectionAndAnnotationsExercise.barracksWars.interfaces.Repository;

public class RetireCommand extends Command {
    @Inject
    private Repository repository;

    public RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        try {
            String typeOfUnit = getData()[1];
            repository.removeUnit(typeOfUnit);
            return String.format("%s retired!", typeOfUnit);
        }catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }
}
