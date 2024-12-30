package com.example.BAKEND_WEB.CONTROLLER;

import com.example.BAKEND_WEB.DTO.*;
import com.example.BAKEND_WEB.Entity.USER;
import com.example.BAKEND_WEB.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500", allowCredentials = "true")  // Cấu hình CORS cho tất cả các API
public class BuildAPI {

    @Autowired
    private URLSevice urlSevice;

    @Autowired
    private contentService contentservice;

    @Autowired
    private StoryService storyService;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private userService userservice;

    @GetMapping("/api/FullStorytitle")
    public List<String> getStorytitle(){
        List<String> result = storyService.getFullname();
        return result;
    }

    // API lấy ảnh của story
    @GetMapping("/api/story_manga")
    public List<String> getStoryImage(@RequestParam(name = "story_id") int story_Id,
                                      @RequestParam(name = "chapter_id" ) int chapter_Id){
        List<String> results = urlSevice.getURL(story_Id, chapter_Id);
        return results;
    }

    // API lấy nội dung story
    @GetMapping("/api/story_novels")
    public String getStoryContent(@RequestParam(name = "story_id") int story_Id,
                                  @RequestParam(name = "chapter_id") int chapter_Id) {
        String results = contentservice.getContent(story_Id, chapter_Id);
        return results;
    }

    // API tìm kiếm story
    @GetMapping("/api/search")
    public List<StoryDTO> getStory() {
        List<StoryDTO> results = storyService.findAll();
        return results;
    }

    // API tìm kiếm story theo category
    @GetMapping("/api/search_category")
    public List<StoryDTO> getStory(@RequestParam(name = "category_id") int category_id) {
        List<StoryDTO> results = storyService.findAll1(category_id);
        return results;
    }

    // API tìm kiếm story theo title
    @GetMapping("/api/search_titlestory")
    public ResponseEntity<Map<String, Object>> getStory(@RequestParam(name = "name") String name) {
        Integer result = storyService.findStoryIdByTitle(name);
        Map<String, Object> response = new HashMap<>();
        response.put("story_id", result);
        return ResponseEntity.ok(response);
    }

    // API lấy thông tin chapter theo story_id
    @GetMapping("/api/chapter")
    public ChapterDTO getStoryDetail(@RequestParam(name = "story_id") int story_id) {
        ChapterDTO results = chapterService.findByID(story_id);
        return results;
    }

    // API lấy comment (review) theo story_id
    @GetMapping("/api/comment")
    public List<ReviewDTO> getReviewByStoryID(@RequestParam(name = "story_id") int story_id) {
        List<ReviewDTO> result = storyService.findReviewByID(story_id);
        return result;
    }

    // API lấy chapter theo title
    @GetMapping("/api/chaptername")
    public ChapterDTO getStoryDetailByTitle(@RequestParam(name = "title") String title) {
        ChapterDTO results = chapterService.findByTitle(title);
        return results;
    }

    // API lấy số lượng chapter của story
    @GetMapping("/api/number_chapter")
    public int getnumberChapter(@RequestParam(name = "story_id") int story_Id) {
        int results = storyService.getNumberchapter(story_Id);
        return results;
    }

    //API lấy dữ liệu thông tin người dùng
    @GetMapping("/api/informationUser")
    public List<USER>  getIn4(){
        List<USER> result = userservice.getAccount();
        return result;
    }

    //API xoá dữ liệu của 1 truyện được chọn
    @CrossOrigin(origins = "http://127.0.0.1:5500", allowCredentials = "true")
    @GetMapping("/api/deleteStory")
    public void deleteStory(@RequestParam(name = "title") String title)
    {
        Integer id = storyService.findStoryIdByTitle(title);
        storyService.deleteStoryByID(id);
    }
    // API POST lưu review (comment) từ frontend
    @CrossOrigin(origins = "http://127.0.0.1:5500", allowCredentials = "true")
    @PostMapping("/api/saveComment")
    public void giveReview(@RequestBody ReviewDTO reviewDTO) {
        storyService.giveReview(reviewDTO);
        System.out.println("Ghi thành công");
    }

    //API POST thông tin người dùng vào trong database
    @CrossOrigin(origins = "http://127.0.0.1:5500", allowCredentials = "true")
    @PostMapping("/api/saveAccount")
    public void giveAccount(@RequestBody USER User) {
        userservice.giveAccount(User);
        System.out.println("Ghi thành công");
    }

    //API post thêm truyện vào database
    @CrossOrigin(origins = "http://127.0.0.1:5500", allowCredentials = "true")
    @PostMapping("/api/addStory")
    public void createStory(@RequestBody Receiver story) {
        userservice.createStory(story);
        userservice.createChapter(story);
        System.out.println("Ghi thành công");
    }

}
