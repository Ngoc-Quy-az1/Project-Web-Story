package com.example.BAKEND_WEB.respository;

import com.example.BAKEND_WEB.Entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<Authors, Integer> {
}
