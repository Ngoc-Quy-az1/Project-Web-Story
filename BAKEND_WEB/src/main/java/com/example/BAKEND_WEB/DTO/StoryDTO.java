package com.example.BAKEND_WEB.DTO;

import java.util.Date;
import java.util.List;

public class StoryDTO {
    private String title;
    private String url;
    private String authorName;
    private int story_id;
    private int author_id;
    private Date created_at;


    public Date getCreated_at() { return created_at; }

    public void setCreated_at(Date created_at) { this.created_at = created_at; }

    public int getAuthor_id() { return author_id; }

    public void setAuthor_id(int author_id) { this.author_id = author_id; }

    public int getStory_id() { return story_id; }

    public void setStory_id(int story_id) { this.story_id = story_id; }

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
