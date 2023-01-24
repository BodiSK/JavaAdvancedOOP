package ReflectionAndAnnotationsExercise.barracksWars.core.commands;

import ReflectionAndAnnotationsExercise.barracksWars.annotations.Inject;
import ReflectionAndAnnotationsExercise.barracksWars.interfaces.CommandInterpreter;
import ReflectionAndAnnotationsExercise.barracksWars.interfaces.Executable;
import ReflectionAndAnnotationsExercise.barracksWars.interfaces.Repository;
import ReflectionAndAnnotationsExercise.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {

    private final static String COMMAND_PACKAGE = "ReflectionAndAnnotationsExercise.barracksWars.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {

        String className = parseToCommandName(commandName);
        Executable command = null;
        try {
            Class clazz = Class.forName(className);
            Constructor<Command> constructor = clazz.getDeclaredConstructor(String[].class);
            command = constructor.newInstance(new Object[]{data});
            Field [] fields = clazz.getDeclaredFields();
            for(Field field : fields){
                if(field.isAnnotationPresent(Inject.class)){
                    field.setAccessible(true);
                    if(field.getType().equals(Repository.class))
                        field.set(command, repository);
                    else if(field.getType().equals(UnitFactory.class))
                        field.set(command, unitFactory);
                }
            }
        } catch (ClassNotFoundException |
                NoSuchMethodException |
                InvocationTargetException |
                InstantiationException |
                IllegalAccessException e) {
            e.printStackTrace();
        }
        return command;

        //switch (commandName) {
        //case "add":
        //return  new AddCommand(data, repository, unitFactory);
        //case "report":
        //return  new ReportCommand(data, repository, unitFactory);
        // case "fight":
        //return  new FightCommand(data, repository, unitFactory);
        // case "retire":
        //return new RetireCommand(data, repository, unitFactory);
        //default:
        //throw new RuntimeException("Invalid command!");
        //}
    }

    private String parseToCommandName(String commandName) {
        commandName = commandName.substring(0, 1).toUpperCase() + commandName.substring(1);
        return COMMAND_PACKAGE + commandName + "Command";
    }

}
