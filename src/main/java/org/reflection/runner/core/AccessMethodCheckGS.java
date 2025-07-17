package org.reflection.runner.core;

import org.reflection.model.Student;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class AccessMethodCheckGS {
    public static void main(String[] args) {
        Class<?> clazz = Student.class;

        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("\nPrint GetterMethod");

        // getter method
        Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("get"))
                .filter(method -> method.getParameterCount()==0 )
                .filter(method -> !method.getReturnType().equals(void.class))
                .forEach(System.out::println);

        System.out.println("\nPrint SetterMethod");

        Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("set"))
                .filter(method -> method.getParameterCount()!=0 )
                .filter(method -> method.getReturnType().equals(void.class))
                .forEach(System.out::println);


    }

}
