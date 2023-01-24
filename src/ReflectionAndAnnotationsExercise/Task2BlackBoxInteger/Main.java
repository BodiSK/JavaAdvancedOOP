package ReflectionAndAnnotationsExercise.Task2BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> cnt = clazz.getDeclaredConstructor();
        cnt.setAccessible(true);
        BlackBoxInt blackBoxInt = cnt.newInstance();

        Scanner scanner = new Scanner(System.in);
        String command = "";

        Field hiddenVal = clazz.getDeclaredField("innerValue");
        hiddenVal.setAccessible(true);

        while(!"END".equals(command = scanner.nextLine())){
            String [] inputs = command.split("_");
            String methodName = inputs[0];
            int argument = Integer.parseInt(inputs[1]);

            Method methodToInvoke = clazz.getDeclaredMethod(methodName, int.class);
            methodToInvoke.setAccessible(true);

            methodToInvoke.invoke(blackBoxInt, argument);

            System.out.println(hiddenVal.get(blackBoxInt));
        }
    }
}
