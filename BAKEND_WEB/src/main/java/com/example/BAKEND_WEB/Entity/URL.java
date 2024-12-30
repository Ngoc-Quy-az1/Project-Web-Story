package com.example.BAKEND_WEB.Entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "URL")

public class URL {

    @EmbeddedId
    private ChapterID chapterID;

    @Column(name = "URL")
    private String URL;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "story_id", insertable = false, updatable = false),
            @JoinColumn(name = "chapter_id", insertable = false, updatable = false) })
    private  chapters_image chapter;

    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getURL() {
        return URL;
    }


    public void setURL(String URL) {
        this.URL = URL;
    }

//    public int getStory_id() {
//        return story_id;
//    }
//
//    public void setStory_id(int story_id) {
//        this.story_id = story_id;
//    }
//
//    public int getChapter_id() {
//        return chapter_id;
//    }
//
//    public void setChapter_id(int chapter_id) {
//        this.chapter_id = chapter_id;
//    }


    public ChapterID getChapterID() {
        return chapterID;
    }

    public void setChapterID(ChapterID chapterID) {
        this.chapterID = chapterID;
    }

    public chapters_image getChapter() {
        return chapter;
    }

    public void setChapter(chapters_image chapter) {
        this.chapter = chapter;
    }
}


