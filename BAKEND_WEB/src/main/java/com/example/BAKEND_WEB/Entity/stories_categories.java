package com.example.BAKEND_WEB.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "stories_categories")
public class stories_categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int story_id;

    @Column(name = "category_id")
    private int category_id;

    public int getStory_id() { return story_id; }

    public void setStory_id(int story_id) { this.story_id = story_id; }

    public int getCategory_id() { return category_id; }

    public void setCategory_id(int category_id) { this.category_id = category_id; }
}

