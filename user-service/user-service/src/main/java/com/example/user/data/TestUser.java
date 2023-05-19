package com.example.user.data;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TestUser {

    @Column(name="Test_xnmg")
    String testName;
}
