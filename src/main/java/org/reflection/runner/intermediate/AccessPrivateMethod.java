package org.reflection.runner.intermediate;

import org.reflection.model.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AccessPrivateMethod {
    public static void main(String[] args) {


        /*
        * Access the private method
        * first get hold on the class
        * now hold on the constructor
        * using class object access the method by giving the name and argument
        *
        * now setAccessible(true) ~ allow to use the method even if it is private.
        * last using the method object you need to invoke the method.
        *  */
        try {

            Class<?> clazz = Class.forName("org.reflection.model.Student");
            Constructor<?> constructor = clazz.getDeclaredConstructor();

            /*
            * No-args method
            *  */
            Method method = clazz.getDeclaredMethod("studentClassInfo",null);
            Student student = (Student) constructor.newInstance();
            method.setAccessible(true);
            method.invoke(student,null);


            /*
            * parameterized method
            *  */
            Method paramConstructor = clazz.getDeclaredMethod("studentInfo",new Class[]{int.class, String.class});
            paramConstructor.setAccessible(true);
            System.out.println(paramConstructor.invoke(student,1,"sahil"));


        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
