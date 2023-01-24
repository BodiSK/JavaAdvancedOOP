package InterfacesAndAbstractionExercise.Task6.classes;

import InterfacesAndAbstractionExercise.Task6.enumerations.Corps;
import InterfacesAndAbstractionExercise.Task6.interfaces.Engineer;

import java.util.*;
import java.util.stream.Collectors;

public class EngineerImpl extends SpecializedSoldierImpl implements Engineer {
    private Collection<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        repairs = new ArrayList<>();
    }

    public void addRepair(Repair repair){
        repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return repairs;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + "Repairs:"+ (repairs.isEmpty()? "" : System.lineSeparator() + repairs.
                        stream().
                        map(r -> " " + r.toString()).collect(Collectors.joining(System.lineSeparator())));
    }
}
