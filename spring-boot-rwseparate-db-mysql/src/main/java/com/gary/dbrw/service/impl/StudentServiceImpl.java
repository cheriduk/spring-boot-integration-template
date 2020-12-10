package com.gary.dbrw.service.impl;

import com.gary.dbrw.annotion.ReadOnly;
import com.gary.dbrw.mapper.StudentMapper;
import com.gary.dbrw.model.Student;
import com.gary.dbrw.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;

    @ReadOnly
    @Override
    public List<Student> selectAllList() {
        return studentMapper.selectAll();
    }


    @Override
    public int addOneStudent(Student student) {
        return studentMapper.insertSelective(student);
    }
}
