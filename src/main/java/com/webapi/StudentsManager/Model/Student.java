package com.webapi.StudentsManager.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    private int id;
    private String name;
    private String sex;
    private int age;
    private float mathResult;
    private float physResult;
    private float chemistryResult;
    private float average;
    private String academic;
}
