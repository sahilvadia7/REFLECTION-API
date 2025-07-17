package org.reflection.runner.advanced;

import org.reflection.model.Student;
import org.reflection.runner.advanced.annotation.AutoWired;
import org.reflection.runner.advanced.annotation.Service;

@Service
public class StudentService {

    @AutoWired
    private Student student;

}
