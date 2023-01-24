package PolymorphismExercise.calculator;

import PolymorphismExercise.calculator.core.CalculationEngine;
import PolymorphismExercise.calculator.core.Extensions;
import PolymorphismExercise.calculator.core.InputInterpreter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CalculationEngine engine = new CalculationEngine();
        InputInterpreter interpreter = Extensions.buildInterpreter(engine);
        String[] tokens = scanner.nextLine().split("\\s+");
        for (String token : tokens) {
            if(token.equals("end")){
                break;
            }
            interpreter.interpret(token);
        }

        System.out.println(engine.getCurrentResult());
    }
}
