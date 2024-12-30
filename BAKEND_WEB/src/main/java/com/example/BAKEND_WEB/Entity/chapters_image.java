package com.example.BAKEND_WEB.Entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "chapters")

public class chapters_image {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column (name = "chapter_id")
//    private int chapter_id;
//
//    @Column(name = "story_id")
//    private int story_id;

    @EmbeddedId
    private ChapterID chapterID;

    @Column(name = "created_at")
    private String Chapter_created_at;

    @Column(name = "updated_at")
    private String Chapter_updated_at;

    @ManyToOne
    @JoinColumn(name = "story_id", insertable=false, updatable=false)
    private  stories Story;

    @OneToMany(mappedBy = "chapter", fetch = FetchType.EAGER)
    private List<URL> urls;

    public ChapterID getChapterID() {
        return chapterID;
    }

    public void setChapterID(ChapterID chapterID) {
        this.chapterID = chapterID;
    }

    public List<URL> getUrls() {
        return urls;
    }

    public void setUrls(List<URL> urls) {
        this.urls = urls;
    }

    public stories getStory() {
        return Story;
    }

    public void setStory(stories story) {
        Story = story;
    }

    public String getChapter_updated_at() {
        return Chapter_updated_at;
    }

    public void setChapter_updated_at(String chapter_updated_at) {
        Chapter_updated_at = chapter_updated_at;
    }

    public String getChapter_created_at() {
        return Chapter_created_at;
    }

    public void setChapter_created_at(String chapter_created_at) {
        Chapter_created_at = chapter_created_at;
    }
//
//    public int getChapter_id() {
//        return chapter_id;
//    }
//
//    public int getStory_id() {
//        return story_id;
//    }

    public String getCreate_at() {
        return Chapter_created_at;
    }

    public String getUpdate_at() {
        return Chapter_updated_at;
    }

//    public void setChapter_id(int chapter_id) {
//        this.chapter_id = chapter_id;
//    }
//
//    public void setStory_id(int story_id) {
//        this.story_id = story_id;
//    }

    public void setCreate_at(String create_at) {
        this.Chapter_created_at = create_at;
    }

    public void setUpdate_at(String update_at) {
        this.Chapter_updated_at = update_at;
    }
}
