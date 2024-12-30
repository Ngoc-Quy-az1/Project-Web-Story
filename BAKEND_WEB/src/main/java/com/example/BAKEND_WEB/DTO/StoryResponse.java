package com.example.BAKEND_WEB.DTO;

public class StoryResponse {
    private Integer story_id;

    public StoryResponse(Integer story_id) {
        this.story_id = story_id;
    }

    public Integer getStory_id() {
        return story_id;
    }

    public void setStory_id(Integer story_id) {
        this.story_id = story_id;
    }
}

