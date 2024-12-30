package com.example.BAKEND_WEB.DTO;

public class ReviewDTO {
    private String comment;
    private int rate;
    private int storyID;

    public int getStoryID() { return storyID;}

    public void setStoryID(int storyID) { this.storyID = storyID; }

    public String getComment() { return comment; }

    public void setComment(String comment) { this.comment = comment; }

    public int getRate() { return rate; }

    public void setRate(int rate) { this.rate = rate; }
}
