package com.example.user.data;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "ONBOARD_USER")
public class User {

    public enum ChecksumType { DEFAULT, CUSTOM }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    @Column(name = "USER_NAME",length = 100)
    private String userName;

    @Column(name = "IS_ACTIVE")
    private Boolean active;

    @Column(name = "USER_CHECKSUM",length = 100)
    private String userChecksum;

    @Column(name = "CHECKSUM_TYPE")
    @Enumerated(EnumType.STRING)
    private  ChecksumType checksumType;

    @Column(name = "USER_NO")
    private String userNo;

    @Column(name = "FIRST_NAME",length = 50)
    private String firstName;

    @Column(name = "LAST_NAME",length = 50)
    private String lastName;

    private String tesColumn;

    @Embedded
    private TestUser testUser;


}
