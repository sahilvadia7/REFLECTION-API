package org.reflection.runner.core;


import org.reflection.model.Student;

import java.util.ArrayList;

public class PackageInformation {
    public static void main(String[] args) {

        Class<?> clazz = Student.class;
        Package packageObj = clazz.getPackage();

        System.out.println("Package name : "+packageObj.getName());
        System.out.println("ImplementationTitle : "+packageObj.getImplementationTitle());
        System.out.println("ImplementationVersion : "+ packageObj.getImplementationVersion());
        System.out.println("SpecificationVendor : "+packageObj.getSpecificationVendor());
        System.out.println("SpecificationTitle : "+packageObj.getSpecificationTitle());
    }
}
