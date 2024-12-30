package com.example.BAKEND_WEB.respository;

import com.example.BAKEND_WEB.Entity.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ContentRespository extends JpaRepository<URL, Integer> {
}

