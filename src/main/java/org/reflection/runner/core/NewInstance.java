package org.reflection.runner.core;

import org.reflection.model.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NewInstance {
    public static void main(String[] args) {

        try {
            Class<?> clazz = Class.forName("org.reflection.model.Student");

            Constructor<?> constructor = clazz.getDeclaredConstructor();
            Student student = (Student) constructor.newInstance();
            System.out.println(student);

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
