package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.HashTag;
import com.survivingcodingbootcamp.blog.storage.HashTagStorage;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {
    private PostStorage postStorage;
    private HashTagStorage hashTagStorage;

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
}