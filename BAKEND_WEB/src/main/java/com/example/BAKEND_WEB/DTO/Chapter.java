package com.example.BAKEND_WEB.DTO;

import java.util.List;

public class Chapter {
    private String chapterID;
    private List<String> images;

    public String getChapterID() {
        return chapterID;
    }

    public void setChapterID(String chapterID) {
        this.chapterID = chapterID;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
