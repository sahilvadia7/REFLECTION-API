package org.reflection.runner.advanced.di;

import org.reflection.runner.advanced.annotation.AutoWired;
import org.reflection.runner.advanced.annotation.Component;
import org.reflection.runner.advanced.annotation.Model;
import org.reflection.runner.advanced.annotation.Service;
import org.reflection.runner.advanced.service.StudentService;

import java.util.*;
import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;

public class MyDIContext {

    private final Map<Class<?>, Object> beanRegistry = new HashMap<>();
    private final Set<String> scannedPackages;

    public MyDIContext(String... packagesToScan) {
        this.scannedPackages = new HashSet<>(List.of(packagesToScan));
        try {
            scanAndInitializeBeans();
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize DI context", e);
        }
    }

    private void scanAndInitializeBeans() throws Exception {
        Set<Class<?>> componentClasses = new HashSet<>();
        for (String pkg : scannedPackages) {
            List<Class<?>> classesInPackage = findClassesInPackage(pkg);
            for (Class<?> clazz : classesInPackage) {
                if (clazz.isAnnotationPresent(Component.class) || clazz.isAnnotationPresent(Service.class) || clazz.isAnnotationPresent(Model.class)) {
                    componentClasses.add(clazz);
                }
            }
        }

        int previousSize;
        do {
            previousSize = beanRegistry.size();
            for (Class<?> clazz : componentClasses) {
                if (!beanRegistry.containsKey(clazz)) {
                    Object instance = tryCreateBean(clazz);
                    if (instance != null) {
                        beanRegistry.put(clazz, instance);
                    }
                }
            }
        } while (beanRegistry.size() > previousSize);

        if (beanRegistry.size() < componentClasses.size()) {
            System.err.println("Warning: Could not resolve all dependencies for some components. Circular dependency or missing bean?");
        }
    }

    private Object tryCreateBean(Class<?> clazz) throws Exception {
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();

            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(AutoWired.class)) {
                    Class<?> dependencyType = field.getType();
                    Object dependencyInstance = beanRegistry.get(dependencyType);

                    if (dependencyInstance == null) {
                        return null;
                    }

                    field.setAccessible(true);
                    field.set(instance, dependencyInstance);
                }
            }
            return instance;
        } catch (NoSuchMethodException e) {
            System.err.println("Error: Class " + clazz.getName() + " requires a no-arg constructor for MyDIContext.");
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> type) {
        return (T) beanRegistry.get(type);
    }

    private List<Class<?>> findClassesInPackage(String packageName) throws Exception {
        List<Class<?>> classes = new ArrayList<>();
        String path = packageName.replace('.', '/');
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources = classLoader.getResources(path);

        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            if (resource.getProtocol().equals("file")) {
                File directory = new File(resource.toURI());
                if (directory.exists() && directory.isDirectory()) {
                    for (File file : directory.listFiles()) {
                        if (file.getName().endsWith(".class")) {
                            String className = packageName + "." + file.getName().substring(0, file.getName().length() - 6);
                            try {
                                classes.add(Class.forName(className));
                            } catch (NoClassDefFoundError | ClassNotFoundException e) {
                                System.err.println("Could not load class " + className + ": " + e.getMessage());
                            }
                        }
                    }
                }
            }
        }
        return classes;
    }

    public static void main(String[] args) {
        System.out.println("Starting MyDIContext...");
        // Removed "org.reflection.runner.advanced.annotation" as it contains only annotations, not beans
        MyDIContext context = new MyDIContext("org.reflection.runner.advanced.bean", "org.reflection.runner.advanced.service");

        System.out.println("\nRetrieving StudentService bean...");
        StudentService studentService = context.getBean(StudentService.class);
        if (studentService != null) {
            // Call setStudentData() before getting info
            studentService.setStudentData();
            System.out.println(studentService.getStudentInfo());
        } else {
            System.out.println("Failed to retrieve StudentService bean!");
        }
    }
}