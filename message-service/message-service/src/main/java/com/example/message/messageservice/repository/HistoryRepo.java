package com.example.message.messageservice.repository;

import com.example.message.messageservice.data.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepo extends JpaRepository<History,Integer> {
}
