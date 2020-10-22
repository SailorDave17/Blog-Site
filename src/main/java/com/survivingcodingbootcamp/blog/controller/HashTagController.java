package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.storage.HashTagStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HashTagController {

    private HashTagStorage hashTagStorage;

    public HashTagController(HashTagStorage hashTagStorage) {

        this.hashTagStorage = hashTagStorage;
    }

    @RequestMapping("hastags/{id}")
    public String showSingleHashTag(Model model, @PathVariable long id) {
        model.addAttribute("hashtags", hashTagStorage.retrieveHashTagById(id));
        return "single-hashtag-template";
    }

}



