package com.gary.dbrw.service;

import com.gary.dbrw.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectAllList();
    int addOneStudent(Student student);
}
