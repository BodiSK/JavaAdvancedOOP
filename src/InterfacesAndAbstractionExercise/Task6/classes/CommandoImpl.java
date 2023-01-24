package InterfacesAndAbstractionExercise.Task6.classes;

import InterfacesAndAbstractionExercise.Task6.enumerations.Corps;
import InterfacesAndAbstractionExercise.Task6.interfaces.Commando;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class CommandoImpl extends SpecializedSoldierImpl implements Commando {

    Collection<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        missions = new ArrayList<>();
    }

    public void addMission(Mission mission){
        missions.add(mission);
    }


    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                "Missions:" + (missions.isEmpty() ? "" : System.lineSeparator() +
                missions.stream().
                        map(m -> "  " + m).
                        collect(Collectors.joining(System.lineSeparator())));
    }
}
