package com.example.BAKEND_WEB.Services;

import com.example.BAKEND_WEB.DTO.ReviewDTO;
import com.example.BAKEND_WEB.DTO.StoryDTO;
import com.example.BAKEND_WEB.Entity.reviews;
import com.example.BAKEND_WEB.Entity.stories;
import com.example.BAKEND_WEB.respository.StoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.max;

@Service
@Transactional
public class StoryService {


    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<StoryDTO> findAll() {
        String sql = "select * from stories";
        Query query = entityManager.createNativeQuery(sql, stories.class);
        List<stories> items = query.getResultList();;

        List<StoryDTO> results = new ArrayList<>();

        for (stories item : items)
        {
            StoryDTO story = modelMapper.map(item, StoryDTO.class);
            story.setAuthorName(item.getAuthor().getName());
            results.add(story);
        }
        return results;
    }

    public List<ReviewDTO> findReviewByID(int story_id){
        String sql = "select * from reviews where story_id ="+story_id;
        Query query = entityManager.createNativeQuery(sql, reviews.class);
        List<reviews> items = query.getResultList();
        List<ReviewDTO> results = new ArrayList<>();
        for (reviews item : items)
        {
            ReviewDTO review = modelMapper.map(item, ReviewDTO.class);
            results.add(review);
        }
        return results;
    }

    public List<StoryDTO> findAll1(int category_id)  {
        String sql = "select * from stories where category_id =" + category_id;
        Query query = entityManager.createNativeQuery(sql, stories.class);
        List<stories> items = query.getResultList();;
        List<StoryDTO> results = new ArrayList<>();

        for (stories item : items)
        {
            StoryDTO story = modelMapper.map(item, StoryDTO.class);
            story.setAuthorName(item.getAuthor().getName());
            results.add(story);
        }
        return results;
    }

    public Integer findStoryIdByTitle(String name) {
        String sql = "SELECT s.story_id " +
                "FROM stories s " +
                "WHERE s.title like '%" + name +"%'";
        Query query = entityManager.createNativeQuery(sql);
        try {
            return (Integer) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


    public int getNumberchapter(int story_id){
        String sql1 = "select count(chapter_id)" +
                "from chapters_image "  +
                "where story_id="+ story_id;
        String sql2 = "select count(chapter_id)\n" +
                "from chapters_novel \n" +
                "where story_id="+ story_id;
        Query query1 = entityManager.createNativeQuery(sql1);
        Query query2 = entityManager.createNativeQuery(sql2);
        Object result1 = query1.getSingleResult(); // Kết quả trả về là kiểu Object
        int firstId1 = ((Number) result1).intValue();
        Object result2 = query2.getSingleResult(); // Kết quả trả về là kiểu Object
        int firstId2 = ((Number) result2).intValue();
        return max(firstId1, firstId2);
    }

    public void giveReview(ReviewDTO reviewed)
    {
        reviews review = new reviews();
        review.setComment(reviewed.getComment());
        review.setRate(reviewed.getRate());
        review.setStoryId(reviewed.getStoryID());
        entityManager.persist(review);
    }

    public void deleteStoryByID(Integer ID){
        String sql = "delete from stories where story_id = " + ID;
        Query query = entityManager.createNativeQuery(sql);
        query.executeUpdate();
    }

    public List<String> getFullname() {
        String sql = " select s.title from stories s";
        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList();
    }
}