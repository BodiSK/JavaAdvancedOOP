package InterfacesAndAbstractionExercise.Task6.classes;

import InterfacesAndAbstractionExercise.Task6.classes.PrivateImpl;
import InterfacesAndAbstractionExercise.Task6.enumerations.Corps;
import InterfacesAndAbstractionExercise.Task6.interfaces.SpecializedSoldier;

public class SpecializedSoldierImpl extends PrivateImpl implements SpecializedSoldier {

    private Corps corps;

    public SpecializedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public Corps getCorps() {
        return corps;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                "Corps: " + getCorps();
    }
}
