package InterfacesAndAbstractionExercise.Task6.classes;

import InterfacesAndAbstractionExercise.Task6.interfaces.Private;

public class PrivateImpl extends SoldierImpl implements Private {

    private double salary;
    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d Salary: %.2f",
                getFirstName(), getLastName(), getId(), salary);
    }
}
