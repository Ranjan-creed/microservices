package com.example.documentservice.test;

import lombok.Data;

@Data
public class Teacher implements Person{
    @Override
    public String getPersonCategory() {
        return "This is Teacher category !!!";
    }
}
