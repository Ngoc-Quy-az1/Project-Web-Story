package com.example.BAKEND_WEB.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Reviews")
public class reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String reviewId;

    @Column(name = "story_id")
    private int storyId;

    @Column(name = "rating")
    private int rate;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "story_id", insertable=false, updatable=false)
    private stories story;

    public stories getStory() { return story; }

    public void setStory(stories story) { this.story = story; }

    public String getReviewId() { return reviewId; }

    public void setReviewId(String reviewId) { this.reviewId = reviewId; }

    public int getStoryId() { return storyId; }

    public void setStoryId(int storyId) { this.storyId = storyId; }

    public int getRate() { return rate; }

    public void setRate(int rate) { this.rate = rate; }

    public String getComment() { return comment; }

    public void setComment(String comment) { this.comment = comment; }

}
