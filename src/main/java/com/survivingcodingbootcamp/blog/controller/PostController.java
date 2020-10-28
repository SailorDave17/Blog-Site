package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.HashTag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.storage.HashTagStorage;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.TopicStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class PostController {

    private final PostStorage postStorage;
    private final TopicStorage topicStorage;


    public PostController(PostStorage postStorage, TopicStorage topicStorage) {
        this.postStorage = postStorage;
        this.topicStorage = topicStorage;
    }

    @GetMapping("/posts/{id}")
    public String displaySinglePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postStorage.retrievePostById(id));
        return "single-post-template";
    }
    @PostMapping(value = {"/topics/{id}"}, params = {"titleText", "contentText", "authorText"})
    public String addPost(String titleText, String contentText, String authorText, @PathVariable long id) {
        Topic topic = topicStorage.retrieveSingleTopic(id);
        Post postToAdd = new Post(titleText, topic, contentText, authorText);
        postStorage.save(postToAdd);
    return "redirect:/topics/{id}";
    }

}