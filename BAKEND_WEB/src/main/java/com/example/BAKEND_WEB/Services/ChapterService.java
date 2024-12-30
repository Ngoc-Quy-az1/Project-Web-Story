package com.example.BAKEND_WEB.Services;

import com.example.BAKEND_WEB.DTO.ChapterDTO;
import com.example.BAKEND_WEB.Entity.chapters_image;
import com.example.BAKEND_WEB.Entity.stories;
import jakarta.persistence.EntityManager;
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
public class ChapterService
{
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ModelMapper modelMapper;

    public ChapterDTO findByID(int ID)
    {
        String sql = "select S.*, A.name, C.chapter_id from stories S, authors A, chapters C " +
                "where S.author_id = A.author_id  and S.story_id = C.story_id and S.story_id = " + ID;
        Query query = entityManager.createNativeQuery(sql, stories.class);
        List<stories> item= query.getResultList();
        ChapterDTO result = modelMapper.map(item.getFirst(), ChapterDTO.class);
        result.setAuthorName(item.getFirst().getAuthor().getName());
        List<Integer> chapter_id = new ArrayList<>();
        List<chapters_image> results =  item.getFirst().getChapter_image();
        for (chapters_image chapterID  : results)
        {
            chapter_id.add(chapterID.getChapterID().getChapterID());
        }
        result.setChapter_id(chapter_id);
        result.setChapterNumber(item.size());
        result.setType("TRUYỆN TRANH");
        return result;
    }

    public ChapterDTO findByTitle(String title)
    {
            String sql = "select S.*, A.name, C.chapter_id from stories S, authors A, chapters C " +
                    "where S.author_id = A.author_id  and S.story_id = C.story_id and S.title like '%" + title + "%'";
            Query query = entityManager.createNativeQuery(sql, stories.class);
            List<stories> item= query.getResultList();
            ChapterDTO result = modelMapper.map(item.getFirst(), ChapterDTO.class);
            result.setAuthorName(item.getFirst().getAuthor().getName());
            List<Integer> chapter_id = new ArrayList<>();
            List<chapters_image> results =  item.getFirst().getChapter_image();
        for (chapters_image chapterID  : results)
        {
            chapter_id.add(chapterID.getChapterID().getChapterID());
        }
            result.setChapter_id(chapter_id);
            result.setChapterNumber(item.size());
            result.setType("TRUYỆN TRANH");
        return result;
    }
}