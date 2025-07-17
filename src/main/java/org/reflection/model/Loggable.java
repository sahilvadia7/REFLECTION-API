package org.reflection.model;

import java.lang.annotation.*;

/**
 * loggable custom annotation
 *  */
@Documented
@Inherited
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Loggable{
    String message() default "Executing: ";
    String category() default "DEFAULT"; // A text setting with a default value
    int level() default 1;             // A number setting
    boolean enabled() default true;    // A true or false setting
    String[] tags() default {};         // A list of text tags
    Class<?> targetClass() default Object.class; // A Class type setting
}
