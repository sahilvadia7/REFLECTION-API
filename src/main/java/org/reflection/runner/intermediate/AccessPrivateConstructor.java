package org.reflection.runner.intermediate;

import org.reflection.model.ClassRoom;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class AccessPrivateConstructor {
    public static void main(String[] args) {


        /*
        * Access the private parameterized constructor and set the constructor value
        * */
        Class<?> classRoom = ClassRoom.class;
        Constructor<?>[] constructors = classRoom.getDeclaredConstructors();
        classConstructorInfo(constructors);
        try {
            Constructor<?> constructor = classRoom.getDeclaredConstructor(new Class[]{Long.class, String.class});
            constructor.setAccessible(true);


            ClassRoom classRoomObj = (ClassRoom) constructor.newInstance(1L,"Orange-A");
//            classRoomObj.setId(1L);
//            classRoomObj.setName("Orange-A");
            System.out.println(classRoomObj);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static void classConstructorInfo(Constructor<?>[] constructors) {
        int counter = 0;
        System.out.println("Constructor Details :: ");
        for(Constructor<?> constructor: constructors){
            System.out.println("Constructor :: "+constructor);

            Parameter[] parameters = constructor.getParameters();
            for(Parameter parameter: parameters){

                System.out.println("Parameters "+ counter +": "+parameter);
                counter++;
            }
        }

        System.out.println();
    }
}
