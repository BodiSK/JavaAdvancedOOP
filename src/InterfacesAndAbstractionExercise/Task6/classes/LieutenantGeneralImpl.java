package InterfacesAndAbstractionExercise.Task6.classes;

import InterfacesAndAbstractionExercise.Task6.interfaces.LieutenantGeneral;
import InterfacesAndAbstractionExercise.Task6.interfaces.Private;
import InterfacesAndAbstractionExercise.Task6.interfaces.Soldier;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {

    private List<Private> commandPrivateImpl;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.commandPrivateImpl = new ArrayList<>();
    }

    public void addPrivate(Private priv){
        commandPrivateImpl.add(priv);
    }

    @Override
    public List<Private> getCommandPrivateImpl() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
               "Privates:" + ((commandPrivateImpl.isEmpty())?"": System.lineSeparator() +
                commandPrivateImpl.stream().sorted(Comparator.comparing(Soldier::getId).reversed())
                        .map(s-> " " + s)
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}
