package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.HashTag;
import com.survivingcodingbootcamp.blog.storage.HashTagStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HashTagController {

    private HashTagStorage hashTagStorage;

    public HashTagController(HashTagStorage hashTagStorage) {

        this.hashTagStorage = hashTagStorage;
    }

    @GetMapping("hashtags")
    public String displayHomePage(Model model){
        model.addAttribute("hashtags", hashTagStorage.retrieveAllHashTags());
        return "all-hashtag-template";
    }

@PostMapping("/hashtags")
    public String addHashTag(@RequestParam String name){
    HashTag hashTagToAdd = new HashTag(name);
    hashTagStorage.addHashTag(hashTagToAdd);
    return "redirect:/post";

}


}



