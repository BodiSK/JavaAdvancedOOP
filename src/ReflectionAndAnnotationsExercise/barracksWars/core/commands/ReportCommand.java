package ReflectionAndAnnotationsExercise.barracksWars.core.commands;

import ReflectionAndAnnotationsExercise.barracksWars.annotations.Inject;
import ReflectionAndAnnotationsExercise.barracksWars.interfaces.Repository;

public class ReportCommand extends Command {

    @Inject
    private Repository repository;
    public ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return repository.getStatistics();
    }
}
