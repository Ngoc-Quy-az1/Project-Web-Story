package com.example.BAKEND_WEB.DTO;

import java.util.List;

public class ChapterDTO {
    private String title;
    private String url;
    private String authorName;
    private String description;
    private String Type;
    private List<Integer> chapter_id;
    private int chapterNumber;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public List<Integer> getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(List<Integer> chapter_id) {
        this.chapter_id = chapter_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
