package org.reflection.runner.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.String;


public class AccessArray {
    public static void main(String[] args) {

        Class<String[]> clazz = String[].class;
        System.out.println(clazz.getName());

    }
}
