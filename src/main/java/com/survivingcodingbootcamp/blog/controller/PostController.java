package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.HashTag;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.storage.HashTagStorage;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.TopicStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {
    private PostStorage postStorage;
    private HashTagStorage hashTagStorage;
    private String author;
    private Object topic;

    public PostController(PostStorage postStorage, HashTagStorage hashTagStorage) {
        this.postStorage = postStorage;
        this.hashTagStorage = hashTagStorage;
    }

    @GetMapping("/{id}")
    public String displaySinglePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postStorage.retrievePostById(id));
        return "single-post-template";
    }

    @PostMapping("/{id}")
    public String addHashTagToPost(@RequestParam String hashTagName, @PathVariable long id) {
        if (!hashTagName.startsWith("#")) {
            hashTagName = "#" + hashTagName;

        } else {

        }
        HashTag hashTagToAdd = hashTagStorage.retrieveHashTagByName(hashTagName);
        if (hashTagToAdd == null) {
            hashTagToAdd = new HashTag(hashTagName, postStorage.retrievePostById(id));

        } else {
            hashTagToAdd.addPost(postStorage.retrievePostById(id));

        }
        hashTagStorage.addHashTag(hashTagToAdd);
        return "redirect:/posts/{id}";
    }
//    @PostMapping("/topic")
//    public String createTopic(@RequestParam long newPost, @RequestParam String topic, @RequestParam String author, @RequestParam String post){
//        this.author = author;
//        this.topic;
//        Topic selectedTopic = postStorage(id);
//        Topic  = new post(selectedTopic, topic, post);
//        TopicStorage.addPost(newPost);
//        return "redirect:/";
//    }
}