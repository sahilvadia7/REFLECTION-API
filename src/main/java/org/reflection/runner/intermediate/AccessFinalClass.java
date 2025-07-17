package org.reflection.runner.intermediate;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AccessFinalClass {

    public static void main(String[] args) {

        Class<?> clazz = Float.class;
        try {
            Constructor<?> constructor = clazz.getConstructor(float.class);
            Float floatt = (Float) constructor.newInstance(1.2f);
            System.out.println(floatt);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
