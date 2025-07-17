package org.reflection.model;

import java.util.List;

public class Records <T>{

    private List<String> studentInfo(List<String> students){
        return students.stream().sorted().toList();
    }

}
