package org.reflection.runner.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InstantiatingObjectsWithConstructorObjects {
    public static void main(String[] args) {

        Class<?> strObj = String.class;
        try {
            Constructor<?> constructor = strObj.getConstructor(StringBuffer.class);
            StringBuffer buffer = new StringBuffer("hello world");

            String str = (String) constructor.newInstance(buffer);
            System.out.println(str);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
