package org.reflection.runner.intermediate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassMetaData {

    public static void main(String[] args) {

        try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the fully qualified class name: ");
        String className = reader.readLine();

        Class<?> clazz = Class.forName(className);

            System.out.println("\nFiled: ");

            Field[] fieldArray = clazz.getDeclaredFields();
            for (Field field: fieldArray){
                System.out.println("- "+field.getName());
            }

            System.out.println("\nConstructor: ");

            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            for (Constructor<?> cons: constructor){
                System.out.println("- "+cons);
            }

            System.out.println("\nMethod: ");

            Method[] methods = clazz.getDeclaredMethods();
            for (Method method: methods){
                System.out.println("- "+method);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
