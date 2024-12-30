package com.example.BAKEND_WEB.Services;

import com.example.BAKEND_WEB.respository.URLrespository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class URLSevice {
    @Autowired
    private URLrespository urlRespository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<String> getURL(int story_id, int chapter_id)
    {
        String sql = "select url from URL WHERE story_id = " + story_id+" and chapter_id = " + chapter_id;
        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList();
    };
}
