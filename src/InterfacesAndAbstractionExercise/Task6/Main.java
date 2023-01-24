package InterfacesAndAbstractionExercise.Task6;

import InterfacesAndAbstractionExercise.Task6.classes.*;
import InterfacesAndAbstractionExercise.Task6.enumerations.Corps;
import InterfacesAndAbstractionExercise.Task6.enumerations.State;
import InterfacesAndAbstractionExercise.Task6.interfaces.Private;
import InterfacesAndAbstractionExercise.Task6.interfaces.Soldier;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        Map<Integer, Soldier> soldiers = new LinkedHashMap<>();

        while (!"End".equals(input = scanner.nextLine())) {
            String[] attributes = input.split("\\s+");
            String soldierType = attributes[0];
            int id = Integer.parseInt(attributes[1]);
            String firstName = attributes[2];
            String lastName = attributes[3];
            double salary;

            switch (soldierType) {
                case "Private":
                    salary = Double.parseDouble(attributes[4]);
                    PrivateImpl newPrivate = new PrivateImpl(id, firstName, lastName, salary);
                    soldiers.put(id, newPrivate);
                    break;
                case "LieutenantGeneral":
                    salary = Double.parseDouble(attributes[4]);
                    LieutenantGeneralImpl lieutenantGeneral =
                            new LieutenantGeneralImpl(id, firstName, lastName, salary);
                    for (int i = 5; i < attributes.length; i++) {
                        lieutenantGeneral.addPrivate((Private) soldiers.get(Integer.parseInt(attributes[i])));
                    }

                    soldiers.put(id, lieutenantGeneral);
                    break;

                case "Engineer":
                    salary = Double.parseDouble(attributes[4]);
                    try {
                        Corps corps = Corps.valueOf(attributes[5]);

                        EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, corps);

                        for (int i = 6; i < attributes.length; i += 2) {
                            String partName = attributes[i];
                            int hoursWorked = Integer.parseInt(attributes[i + 1]);

                            engineer.addRepair(new Repair(partName, hoursWorked));
                        }

                        soldiers.put(id, engineer);
                    } catch (IllegalArgumentException ignored) {
                    }
                    break;

                case "Commando":
                    salary = Double.parseDouble(attributes[4]);
                    try {
                        Corps corps = Corps.valueOf(attributes[5]);

                        CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, corps);

                        for (int i = 6; i < attributes.length; i += 2) {
                            String codeName = attributes[i];
                            try {
                                State state = State.valueOf(attributes[i + 1]);
                                commando.addMission(new Mission(codeName, state));
                            } catch (IllegalArgumentException ignored) {
                            }
                        }

                        soldiers.put(id, commando);
                    } catch (IllegalArgumentException ignored) {
                    }
                    break;

                case "Spy":
                    String codeNumber = attributes[4];

                    SpyImpl spy = new SpyImpl(id, firstName, lastName, codeNumber);
                    soldiers.put(id, spy);
                    break;
            }
        }

        soldiers.values().forEach(System.out::println);
    }
}
