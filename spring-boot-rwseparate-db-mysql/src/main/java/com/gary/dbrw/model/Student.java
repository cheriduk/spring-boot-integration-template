package com.gary.dbrw.model;

import java.io.Serializable;
import lombok.Data;

/**
 * student
 * @author 
 */
@Data
public class Student implements Serializable {
    private Long id;

    private String name;

    private Integer age;

    private static final long serialVersionUID = 1L;
}