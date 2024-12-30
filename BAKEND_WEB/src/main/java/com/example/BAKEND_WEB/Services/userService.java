package com.example.BAKEND_WEB.Services;

import com.example.BAKEND_WEB.DTO.Chapter;
import com.example.BAKEND_WEB.DTO.Receiver;
import com.example.BAKEND_WEB.DTO.StoryDTO;
import com.example.BAKEND_WEB.Entity.*;
import com.example.BAKEND_WEB.respository.userRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class userService {
    @Autowired
   private userRepository UserRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ModelMapper modelMapper;

    public List<USER> getAccount() {
        String sql = "select * from users";
        Query query = entityManager.createNativeQuery(sql, USER.class);
        List<USER> items = query.getResultList();
        return items;
    }

    public void giveAccount(USER Account){
        USER user = new USER();
        user.setEmail(Account.getEmail());
        user.setUsername(Account.getUsername());
        user.setPassword(Account.getPassword());
        entityManager.persist(user);
    }

    public Integer findAuthorID(String name)
    {
        String sql = "Select author_id from authors where name = '" + name + "'";
        Query query = entityManager.createNativeQuery(sql);
        try {
            return (Integer) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    };

    public Authors findAuthorByName(String name)
    {
        String sql = "Select * from authors where name = '" + name + "'";
        Query query = entityManager.createNativeQuery(sql, Authors.class);
        List<Authors> result = query.getResultList();
        return result.getFirst();
    }

    public List<categories> findCatebyName(String name)
    {
        String sql = "Select * from categories where name = '" + name + "'";
        Query query = entityManager.createNativeQuery(sql, categories.class);
        return query.getResultList();
    }

    public Integer findStoryID(String name)
    {
        String sql = "SELECT s.story_id " +
                "FROM stories s " +
                "WHERE s.title = '" + name +"'";
        Query query = entityManager.createNativeQuery(sql);
        try {
            return (Integer) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Integer existChapterID(Integer storyID, int chapterID)
    {
        String sql = "select chapter_id from chapters where story_id = " + storyID + " and chapter_id = " + chapterID;
        Query query = entityManager.createNativeQuery(sql);
        try {
            return (Integer) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void createStory(Receiver story) {
        // Kiểm tra tác giả có tồn tại không, nếu chưa thì thêm tác giả
        Integer author_id = findAuthorID(story.getName());
        Authors authors = new Authors();

        if (author_id == null) {
            authors.setName(story.getName());
            authors.setBio(story.getBio());
            entityManager.persist(authors);
        }

        // Kiểm tra story có tồn tại không, nếu chưa thì thêm truyện

        Integer test = findStoryID(story.getTitle());

        if (test == null) {
            authors = findAuthorByName(story.getName());
            List<categories> categorie = findCatebyName(story.getCategory());
            stories newStory = new stories();
            newStory.setTitle(story.getTitle());
            newStory.setDescription(story.getDescription());
            newStory.setStatus("Ongoing");
            newStory.setCreated_at(story.getPublishDate());
            newStory.setUrl(story.getAvtStory());
            newStory.setAuthor(authors);
            newStory.setCategoryID(categorie.getFirst().getCategory_id());
            entityManager.persist(newStory);
        }
        System.out.println("Thêm được tác giả rồi");

    }

    public void createChapter(Receiver story)
    {
        Integer story_id = findStoryID(story.getTitle());
        for (Chapter item : story.getChapters()) {

            if ( existChapterID(story_id, Integer.parseInt(item.getChapterID())) == null) {
                chapters_image chapter = new chapters_image();

                ChapterID chapterID = new ChapterID();
                chapterID.setChapterID(Integer.parseInt(item.getChapterID()));
                chapterID.setStoryID(story_id);
                chapter.setChapterID(chapterID);
                entityManager.persist(chapter);

                item.getImages();


                for (int i = 0; i< item.getImages().size(); i++)
                {
                    URL url = new URL();
                    url.setChapterID(chapterID);
                    url.setURL(item.getImages().get(i));
                    int j = i+1;
                    url.setImage(j);
                    entityManager.persist(url);
                    entityManager.flush();
                    entityManager.clear();
                }
                System.out.println("Thêm được image rồi");
            }
        }
    }

}
