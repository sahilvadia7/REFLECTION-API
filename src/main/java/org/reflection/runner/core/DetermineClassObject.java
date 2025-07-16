package org.reflection.runner.core;

import org.reflection.model.Student;

public class DetermineClassObject {
    public static void main(String[] args) {

        ClassLoader loader = Student.class.getClassLoader();
        try {
            Class<?> clazz = loader.loadClass("org.reflection.model.Student");
            Class<?> list = loader.loadClass("java.util.List");

            // UDC ~ Student
            System.out.println("Is the "+clazz+" is interface: "+clazz.isInterface());
            System.out.println("Is the "+clazz+" is member class: "+clazz.isMemberClass());
            System.out.println("Is the "+clazz+" is primitive: "+clazz.isPrimitive());
            //it prints the super class of the current class.
            System.out.println("Super class : "+clazz.getSuperclass());


            // PDC ~ List
            System.out.println("Is the "+list+" is interface: "+list.isInterface());
            System.out.println("Is the "+list+" is member class: "+list.isMemberClass());
            System.out.println("Is the "+list+" is primitive: "+list.isPrimitive());

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
