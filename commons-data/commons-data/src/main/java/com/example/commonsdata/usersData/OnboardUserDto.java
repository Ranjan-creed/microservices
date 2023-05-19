package com.example.commonsdata.usersData;

import lombok.Data;

import java.util.UUID;

@Data
public class OnboardUserDto {

    private UUID userId;
    private String userName;
    private Boolean active;
    private String userNo;
    private String firstName;
    private String lastName;
}
