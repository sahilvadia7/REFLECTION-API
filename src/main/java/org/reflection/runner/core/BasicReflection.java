package org.reflection.runner.core;

import org.reflection.model.Student;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BasicReflection {

    public static void main(String[] args) {
        System.out.println("------------ Class Info -------------");
        Class<? extends Student> clazz = Student.class;
        System.out.println("Class Detail : "+clazz);


        System.out.println("\nField's : ");
        for (Field field : clazz.getDeclaredFields()){
            System.out.println(" - "+field.getName());
        }

        System.out.println("\nAll the Method's : ");
        for (Method methods : clazz.getMethods()){
            System.out.println(" - "+methods.getName());
        }


        /*
         *
         * getDeclareMethods() :
         * it provide all the method use by any class
         * it also show the Object class method because every class byDefault extends the Object class.
         * wait, hashCode, notify, notifyAll and others.
         *
         *  */

        System.out.println("\nAll the Declare Method's : ");
        for (Method methods : clazz.getDeclaredMethods()){
            System.out.println(" - "+methods.getName());
        }
        System.out.println("-------------------------------------------");

    }

}


