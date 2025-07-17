package org.reflection.runner.advanced.programs;

import org.reflection.model.Records;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GenericTypeDataAndMethodAccess {

    public static void main(String[] args) {

        Class<?> clazz = Records.class;
        List<String> students= Arrays.asList("nikhil","aryan","ankit","penil");

        try {
            Constructor<?> constructor = clazz.getConstructor();
            constructor.setAccessible(true);
            Records<?> records = (Records<?>) constructor.newInstance();
            Method method = clazz.getDeclaredMethod("studentInfo",new Class[]{List.class});
            method.setAccessible(true);

            /*
            * generic return type of method
            * */
            Type type = method.getGenericReturnType();
            System.out.println("Generic Return type ::"+type);

            /*
            * generic return type of param
            *  */
            Type[] types = method.getGenericParameterTypes();
            for (Type type1: types){
                System.out.println("- "+type1);
            }

            System.out.println("Sorted Students :: "+method.invoke(records,students));
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
