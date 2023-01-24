package ReflectionAndAnnotationsLab;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Reflection> clazz = Reflection.class;

        //Task1
        //System.out.println(clazz);
        //System.out.println(clazz.getSuperclass());
        //Arrays.stream(clazz.getInterfaces())
        //.forEach(System.out::println);

        //Constructor<ReflectionAndAnnotationsLab.Reflection> constructor = clazz.getDeclaredConstructor();
        //ReflectionAndAnnotationsLab.Reflection reflection = constructor.newInstance();
        //System.out.println(reflection);


        Method[] methods = clazz.getDeclaredMethods();

        Comparator<Method> comparator = Comparator.comparing(Method::getName);

        Set<Field> fields = Arrays.stream(clazz.getDeclaredFields())
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Field::getName))));

        Set<Method> getters = new TreeSet<>(comparator);
        Set<Method> setters = new TreeSet<>(comparator);

        for (var m : methods) {
            if (m.getName().contains("get"))
                getters.add(m);
            else if (m.getName().contains("set"))
                setters.add(m);
        }

        for (var f : fields) {
            int mod = f.getModifiers();
            if (!Modifier.isPrivate(mod))
                System.out.printf("%s must be private!%n", f.getName());
        }

        for (var g : getters) {
            int mod = g.getModifiers();
            if (!Modifier.isPublic(mod))
                System.out.printf("%s have to be public!%n", g.getName());
        }

        for (var s : setters) {
            int mod = s.getModifiers();
            if (!Modifier.isPrivate(mod))
                System.out.printf("%s have to be private!%n", s.getName());
        }


        //Task2
        //getters.stream().forEach(g -> System.out.printf("%s will return class %s%n", g.getName(), g.getReturnType().getName()));

        //setters.stream().forEach(s -> System.out.printf("%s and will set field of class %s%n", s.getName(), s.getParameterTypes()[0].getName()));
    }
}
