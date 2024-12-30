package com.example.BAKEND_WEB.respository;

import com.example.BAKEND_WEB.Entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface authorRespository extends JpaRepository<Authors, Integer> {

}

