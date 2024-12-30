package com.example.BAKEND_WEB.DTO;

public class UrlCreationRequest {
    private int story_id;
    private int chapter_id;
    private String URL;

    public int getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(int chapter_id) {
        this.chapter_id = chapter_id;
    }

    public String getURL() {  // Cập nhật kiểu trả về
        return URL;
    }

    public void setURL(String URL) {  // Cập nhật kiểu tham số
        this.URL = URL;
    }

    public int getStory_id() {
        return story_id;
    }

    public void setStory_id(int story_id) {
        this.story_id = story_id;
    }
}

