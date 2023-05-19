package com.example.documentservice.test;

import lombok.Data;

@Data
public class Student implements Person{

    private String name;
    @Override
    public String getPersonCategory() {
       return "This is student category !!!";
    }
}
