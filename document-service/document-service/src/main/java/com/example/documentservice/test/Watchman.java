package com.example.documentservice.test;

import lombok.Data;

@Data
public class Watchman implements Person {

    private String name;

    @Override
    public String getPersonCategory() {
        return "This is Watchman Category !!!";
    }
}
