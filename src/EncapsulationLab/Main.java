package EncapsulationLab;

import EncapsulationExercise.Task5FootballTeamGenerator.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public  class Main  {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        int n = Integer.parseInt(reader.nextLine());

        Team team = new Team("Real Madrid");
        for (int i = 0; i < n; i++) {
            String[] input = reader.nextLine().split("\\s+");
            try {
                team.addPlayer(new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.printf("First team have %d players%n", team.getFirstTeam().size());
        System.out.printf("Reserve team have %d players%n", team.getReserveTeam().size());
    }


}
