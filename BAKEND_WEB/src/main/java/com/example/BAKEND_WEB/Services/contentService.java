package com.example.BAKEND_WEB.Services;

import com.example.BAKEND_WEB.respository.ContentRespository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class contentService {
    @Autowired
    private ContentRespository comtentRespository;

    @PersistenceContext
    private EntityManager entityManager;

    public String getContent(int story_id, int chapter_id) {
        String sql = "select content from chapters_novel WHERE story_id = " + story_id + " and chapter_id = " + chapter_id;
        Query query = entityManager.createNativeQuery(sql);
        return (String) query.getSingleResult();
    }
}
