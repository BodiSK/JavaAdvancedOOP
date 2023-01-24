package ReflectionAndAnnotationsExercise.Task1HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		Class<RichSoilLand> clazz = RichSoilLand.class;
		Field [] fields = clazz.getDeclaredFields();

		Consumer<Field> printMethods =
				f-> System.out.printf("%s %s %s%n",
						Modifier.toString(f.getModifiers()),
						f.getType().getSimpleName(),
						f.getName());
		String command = "";
		while(!"HARVEST".equals(command = scanner.nextLine())){
			switch(command){
				case "private":
					Arrays.stream(fields)
							.filter(f-> Modifier.isPrivate(f.getModifiers()))
							.forEach(printMethods);
					break;
				case "protected":
					Arrays.stream(fields)
							.filter(f-> Modifier.isProtected(f.getModifiers()))
							.forEach(printMethods);
					break;
				case "public":
					Arrays.stream(fields)
							.filter(f-> Modifier.isPublic(f.getModifiers()))
							.forEach(printMethods);
					break;
				case "all":
					Arrays.stream(fields)
							.forEach(printMethods);
					break;
			}
		}
	}
}
