package org.reflection.model;

import java.lang.annotation.*;


@Loggable(category = "Display-Info",level = 3,tags = "Enable")
public class Display {

    @Loggable(message="Greet Method Called",targetClass = Display.class)
    public void Greet(){
        System.out.println("Hello there, i am Greet form the Display");
    }
}
