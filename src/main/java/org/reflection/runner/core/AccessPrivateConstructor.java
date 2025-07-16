
package org.reflection.runner.core;

import org.reflection.model.ClassRoom;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AccessPrivateConstructor {
    public static void main(String[] args) {

        /*
         * 1. Get the hold on the Class object
         * 2. Get hold on the Constructor
         *      1. Make constructor accessible
         *      2. Create the object of the class
         * 3. set the value of it
         * 4. done
         *  */
        Class<?> clazz = ClassRoom.class;
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            ClassRoom classroom = (ClassRoom) constructor.newInstance();
            classroom.setId(1L);
            classroom.setName("sahil");

            System.out.println(classroom);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}