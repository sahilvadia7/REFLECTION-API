package org.reflection.runner.intermediate;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InstantiatingObjectsWithConstructorObjects {
    public static void main(String[] args) {

        Class<?> strObj = String.class;

        try {

            Constructor<?> constructor = strObj.getConstructor(StringBuffer.class);
            StringBuffer buffer = new StringBuffer("hello world");

            String str = (String) constructor.newInstance(buffer);
            System.out.println(str);

            /*
            * Access the static method
            * */
            Method method = strObj.getDeclaredMethod("valueOf",new Class[]{Object.class});
            method.setAccessible(true);
            System.out.println("Invoke the Static method :: ValueOf :: "+method.invoke(constructor,buffer));

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static void  greet(){
        System.out.println("Greeting from the static method");
    }
}
