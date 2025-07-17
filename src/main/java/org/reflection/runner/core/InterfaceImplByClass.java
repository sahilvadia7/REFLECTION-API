package org.reflection.runner.core;

import java.util.LinkedList;

public class InterfaceImplByClass {
    public static void main(String[] args) {

        Class<?> clazz = LinkedList.class;

        Class[] impls = clazz.getInterfaces();
        for(Class impl : impls){
            System.out.println(impl);
        }
    }
}
