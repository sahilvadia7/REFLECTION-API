package org.reflection.runner.core;

import org.reflection.model.Display;
import org.reflection.model.Loggable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class AccessAnnotation {
    public static void main(String[] args) {

        /*Class Annotation access  */

        System.out.println("\n\n Class Annotation");
    Class<?> clazz = Display.class;
    Annotation[] annotations = clazz.getAnnotations();

    for(Annotation annotation:annotations){
        System.out.println("- "+annotation);
    }


        /* Method annotation access */

        System.out.println("\n\n Method Annotation");
        Method[] methods = clazz.getDeclaredMethods();

        for(Method method: methods ){
            Annotation[] methodAnnotations = method.getAnnotations();
            Annotation[][] paraMethodAnnotations = method.getParameterAnnotations();
            Class<?>[] parameterTypes = method.getParameterTypes();

//            for (Annotation annotation: methodAnnotations){
//                System.out.println("Annotation : "+annotation);
//            }

            int i=0;
            for (Annotation[] annotationA:paraMethodAnnotations){

                Class parameterType = parameterTypes[i++];
                for (Annotation annotation: annotationA){
                    if (annotation instanceof Loggable){

                        System.out.println("param :: "+parameterType.getTypeParameters());

                    }
                }
            }
        }



    }
}
