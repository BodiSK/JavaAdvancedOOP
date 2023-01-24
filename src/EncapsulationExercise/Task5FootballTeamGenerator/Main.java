package EncapsulationExercise.Task5FootballTeamGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Team> teams = new HashMap<>();
        String line = "";

        while (!"END".equals(line = scanner.nextLine())) {
            String[] tokens = line.split(";");
            String command = tokens[0];
            String teamName = tokens[1];
            try {
                if (command.equals("Team")) {
                    teams.putIfAbsent(teamName, new Team(teamName));
                } else if (command.equals("Add")) {
                    if (!teams.containsKey(teamName))
                        throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
                    teams.get(teamName).addPlayer(new Player(tokens[2],
                            Integer.parseInt(tokens[3]),
                            Integer.parseInt(tokens[4]),
                            Integer.parseInt(tokens[5]),
                            Integer.parseInt(tokens[6]),
                            Integer.parseInt(tokens[7])));
                } else if (command.equals("Remove")) {
                    teams.get(teamName).removePlayer(tokens[2]);
                } else {
                    if (!teams.containsKey(teamName))
                        throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));

                    System.out.println(teamName + " - " + (int)teams.get(teamName).getRating());
                }
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

    }
}
