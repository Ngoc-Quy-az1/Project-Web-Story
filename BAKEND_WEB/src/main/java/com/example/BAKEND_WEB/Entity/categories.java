package com.example.BAKEND_WEB.Entity;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  category_id;

    @Column(name = "name" )
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "avatarchapters_image")
    private String avatar;

    @ManyToMany(mappedBy = "categories",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<stories> stories = new ArrayList<>();

    public int getCategory_id() {
        return category_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setCategory_id(int category_id) { this.category_id = category_id; }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
