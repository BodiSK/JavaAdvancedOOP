package ReflectionAndAnnotationsExercise.barracksWars.core.commands;

import ReflectionAndAnnotationsExercise.barracksWars.annotations.Inject;
import ReflectionAndAnnotationsExercise.barracksWars.interfaces.Repository;
import ReflectionAndAnnotationsExercise.barracksWars.interfaces.Unit;
import ReflectionAndAnnotationsExercise.barracksWars.interfaces.UnitFactory;

public class AddCommand extends Command {

    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public AddCommand(String[] data ){
        super(data);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        Unit unitToAdd = unitFactory.createUnit(unitType);
        repository.addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
