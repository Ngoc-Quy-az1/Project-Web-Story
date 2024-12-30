    package com.example.BAKEND_WEB.Entity;
    import jakarta.persistence.*;
    import java.util.ArrayList;
    import java.util.Date;
    import java.util.List;

    @Entity
    @Table(name = "stories")

    public class stories {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int story_id;

        @Column(name = "title")
        private String title;

        @Column(name = "description")
        private String description;

        @Column(name = "status")
        private String status;

        @Column(name = "created_at")
        private Date created_at;

        @Column(name = "updated_at")
        private Date updated_at;

        @Column(name = "url")
        private String url;

        @Column(name = "category_id")
        private int categoryID;

        public int getCategoryID() {
            return categoryID;
        }

        public void setCategoryID(int categoryID) {
            this.categoryID = categoryID;
        }

        @ManyToOne
        @JoinColumn(name = "author_id")
        private Authors author;

        @OneToMany(mappedBy = "story", fetch = FetchType.EAGER)
        private List<reviews> reviews = new ArrayList<>();

        @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JoinTable(
                name = "Stories_Categories",
                joinColumns = @JoinColumn(name = "story_id"),
                inverseJoinColumns = @JoinColumn(name = "category_id")
        )
        private List<categories> categories = new ArrayList<>();

        @OneToMany(mappedBy = "Story", fetch = FetchType.LAZY)
        private List<chapters_image> Chapter_image = new ArrayList<>();

        public List<com.example.BAKEND_WEB.Entity.reviews> getReviews() { return reviews; }

        public void setReviews(List<com.example.BAKEND_WEB.Entity.reviews> reviews) { this.reviews = reviews; }

        public List<chapters_image> getChapter_image() {
            return Chapter_image;
        }

        public void setChapter_image(List<chapters_image> chapter_image) {
            Chapter_image = chapter_image;
        }

        public String getStatus() {
            return status;
        }

        public int getStory_id() {
            return story_id;
        }

        public void setStory_id(int story_id) {
            this.story_id = story_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String isStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Date getCreated_at() {
            return created_at;
        }

        public void setCreated_at(Date created_at) {
            this.created_at = created_at;
        }

        public Date getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(Date updated_at) {
            this.updated_at = updated_at;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Authors getAuthor() {
            return author;
        }

        public void setAuthor(Authors author) {
            this.author = author;
        }

        public List<categories> getCategories() {
            return categories;
        }

        public void setCategories(List<categories> categories) {
            this.categories = categories;
        }
    }
