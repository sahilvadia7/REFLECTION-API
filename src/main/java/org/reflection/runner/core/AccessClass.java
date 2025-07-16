package org.reflection.runner.core;


import org.reflection.model.Student;

public class AccessClass {

    public static void main(String[] args) {

        /* 3 ways to access the class object */
        forName();
        objectDotClass();
        classLoaderDotLoadClass();
        classNameDotClass();



    }


    /**
     * Provides a summary of the {@link java.lang.Class#forName(String)} method,
     * which is used for dynamic class loading in Java.
     *
     * <p>Key characteristics of {@code Class.forName(String className)}:</p>
     * <ul>
     * <li>Dynamic Loading: It loads the class dynamically into the Java Virtual Machine (JVM) at runtime.</li>
     * <li>Returns Class Object: It returns the {@link java.lang.Class} object associated with the class
     * or interface specified by the given string name. This object is the entry point for Java Reflection.</li>
     * <li>Fully Qualified Name: The method requires the fully qualified name of the class (e.g., "java.lang.String", "com.example.MyClass").</li>
     * <li>Primitive Types: This specific overload of `forName()` is generally not used to obtain `Class` objects for primitive types (e.g., `int.class`, `boolean.class`) or `void.class`.</li>
     * <li>Automatic Initialization: By default, this method also triggers the initialization of the class (i.e., static blocks are executed and static fields are assigned their initial values) if it hasn't been initialized already.</li>
     * <li>Exception Handling**: It declares that it throws {@link java.lang.ClassNotFoundException}, which is a checked exception that must be handled by the calling code. Other runtime exceptions like {@link java.lang.LinkageError} or {@link java.lang.ExceptionInInitializerError} can also occur during the loading and initialization process.</li>
     * </ul>
     *
     * @see java.lang.Class#forName(String, boolean, ClassLoader) For more controlled class loading.
     * @see java.lang.ClassLoader For understanding class loading hierarchy and custom loaders.
     */
    public static void forName(){


        System.out.println("\n\n------------ Using forName() ------------");

        try {
            Class<?> clazz = Class.forName("org.reflection.model.Student");
            System.out.println("Class Name : "+clazz.getName());
            System.out.println("Simple Name: "+clazz.getSimpleName());

            System.out.println("-----------------------------\n");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Demonstrates obtaining a {@link java.lang.Class} object using the {@link java.lang.Object#getClass()} method.
     *
     * <p>This method retrieves the runtime {@link Class} object of a `Student` instance.</p>
     *
     * @see java.lang.Object#getClass()
     */
    public static void objectDotClass(){
        Student student = new Student(1,"sahil");
        Class<? extends Student> clazz = student.getClass();
        System.out.println(clazz);
    }

    /**
     * Demonstrates dynamic class loading using {@link java.lang.ClassLoader#loadClass(String)}.
     *
     * <p>This method obtains the {@link ClassLoader} of the `Student` class and
     * attempts to load the `org.reflection.model.Student` class using that loader.
     * This approach provides more control over the class loading process compared to
     * {@link java.lang.Class#forName(String)}, as it allows specifying the exact
     * class loader to use and does **not** automatically initialize the class.</p>
     *
     * <p>It is particularly useful when working with custom classloaders or
     * in environments where classes need to be loaded from specific sources
     * without immediate initialization.</p>
     *
     * @throws RuntimeException If the `org.reflection.model.Student` class cannot be found
     * by the class loader, wrapping a {@link ClassNotFoundException}.
     * @see java.lang.ClassLoader#loadClass(String)
     * @see java.lang.Class#forName(String)
     */
    public static void classLoaderDotLoadClass(){
        ClassLoader loader = Student.class.getClassLoader();
        try {
            Class<?> clazz = loader.loadClass("org.reflection.model.Student");
            System.out.println(clazz.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void classNameDotClass(){


        /*
        * It works with primitive type.
        * */
        System.out.println("\n------ Using className(Student.class) ------");
        Class<?> clazz = Student.class;
        System.out.println("Class Name : "+ clazz.getName());


        Class<Integer> integerClass = int.class;
        System.out.println("Primitive Class: "+integerClass.getName());

        System.out.println("-----------------------------\n");

    }
}
