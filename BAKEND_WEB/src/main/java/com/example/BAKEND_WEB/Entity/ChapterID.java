package com.example.BAKEND_WEB.Entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ChapterID implements Serializable {
    private int story_id;
    private int chapter_id;

    public int getStoryID() {
        return story_id;
    }

    public void setStoryID(int storyID) {
        this.story_id = storyID;
    }

    public int getChapterID() {
        return chapter_id;
    }

    public void setChapterID(int chapterID) {
        this.chapter_id = chapterID;
    }
}
