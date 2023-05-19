package com.example.message.messageservice.data;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "HISTORY")
public class History {

    public enum HistoryCategory{LOGIN}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "USER_NO")
    private String userNo;

    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "HISTORY_CATEGORY")
    private HistoryCategory historyCategory;
}
