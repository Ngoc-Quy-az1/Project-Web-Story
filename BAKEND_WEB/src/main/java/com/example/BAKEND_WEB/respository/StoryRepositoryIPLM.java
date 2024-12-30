package com.example.BAKEND_WEB.respository;

import com.example.BAKEND_WEB.Entity.stories;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class StoryRepositoryIPLM {
    public List<stories> findAll(Map<String, Object> params)
    {
        List<stories> results = new ArrayList<>();
        String sql = "select * from stories ";
        return results;
    }
}
