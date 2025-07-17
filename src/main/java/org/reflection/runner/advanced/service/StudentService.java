package org.reflection.runner.advanced.service;

import org.reflection.runner.advanced.bean.Student;
import org.reflection.runner.advanced.annotation.AutoWired;
import org.reflection.runner.advanced.annotation.Service;

@Service
public class StudentService {

    @AutoWired
    private Student student;

    public void setStudentData(){
        student.setId(1);
        student.setName("sahil");
    }

    public String getStudentInfo() {
        return "this is form the studentService ::: "+student;
    }
}
