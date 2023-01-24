package WorkingWithAbstractionLab.Task3StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> studentByName;

    public StudentSystem() {
        this.studentByName = new HashMap<>();
    }

    public Map<String, Student> getStudentByName() {
        return this.studentByName;
    }

    public void ParseCommand(String[] args) {

        String command = args[0];
        String name = args[1];

        if (command.equals("Create")) {
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);

            if (!studentByName.containsKey(name)) {
                Student student = new Student(name, age, grade);
                studentByName.put(name, student);
            }
        } else if (command.equals("Show")) {

            Student student = studentByName.get(name);

            if (student != null) {
                System.out.println(student.getInfo());
            }
        } else {
            throw new IllegalStateException("Unknown command " + command);
        }
    }
}
