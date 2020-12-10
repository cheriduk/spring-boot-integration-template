package com.gary.dbrw.controller;

import com.gary.dbrw.model.Student;
import com.gary.dbrw.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("user")
public class StudentController {

    @Resource
    StudentService studentService;

    @GetMapping("/testRW")
    public String DbRead(Integer dbType) {
        System.out.println("dbType=:" + dbType);
        List<Student> students = studentService.selectAllList();
        return "ReadDB=>" + students;
    }

    @PostMapping("/testRW")
    public String DbWrite(Student student) {
        int count = studentService.addOneStudent(student);
        return "Wr DB=>" + count;
    }
}
