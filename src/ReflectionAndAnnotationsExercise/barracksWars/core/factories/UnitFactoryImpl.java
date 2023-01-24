package ReflectionAndAnnotationsExercise.barracksWars.core.factories;

import ReflectionAndAnnotationsExercise.barracksWars.interfaces.Unit;
import ReflectionAndAnnotationsExercise.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "ReflectionAndAnnotationsExercise.barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        try {
            Class unit = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor <Unit> cnt = unit.getDeclaredConstructor();
            cnt.setAccessible(true);
            return cnt.newInstance();
        } catch (ClassNotFoundException |InvocationTargetException|InstantiationException|IllegalAccessException| NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
