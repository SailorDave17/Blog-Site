package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.HashTag;
import com.survivingcodingbootcamp.blog.storage.HashTagStorage;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HashTagController {

    private final HashTagStorage hashTagStorage;
    private final PostStorage postStorage;

    public HashTagController(HashTagStorage hashTagStorage, PostStorage postStorage) {

        this.hashTagStorage = hashTagStorage;
        this.postStorage = postStorage;
    }

    @GetMapping("hashtags/{id}")
    public String displayHomePage(Model model, @PathVariable Long id) {
        model.addAttribute("hashtags", hashTagStorage.retrieveHashTagById(id));
        return "single-hashtag-template";
    }

    @PostMapping("/hashtags")
    public String addHashTag(@RequestParam String name) {
        HashTag hashTagToAdd = new HashTag(name);
        hashTagStorage.addHashTag(hashTagToAdd);
        return "redirect:/post";

    }

    @RequestMapping("/hashtags")
    public String displayAllHashTags(Model model){
        model.addAttribute("hashtags", hashTagStorage.retrieveAllHashTags());
        return "all-hashtag-template";
    }

    @PostMapping("/posts/{id}")
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



