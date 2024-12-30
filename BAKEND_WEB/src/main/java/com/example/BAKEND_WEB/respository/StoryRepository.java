package com.example.BAKEND_WEB.respository;

import com.example.BAKEND_WEB.Entity.stories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public class StoryRepository  {

    @PersistenceContext
    private EntityManager entityManager;

    public List<stories> getAllStory()
    {
        String sql = "select * from stories";
        Query query = entityManager.createNativeQuery(sql, stories.class);
        return query.getResultList();
    }
}
