package com.example.BAKEND_WEB.respository;

import com.example.BAKEND_WEB.Entity.categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoriesRespository extends JpaRepository<categories, Integer> {
}

