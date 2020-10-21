package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.storage.HashTagStorage;
import org.springframework.stereotype.Controller;

@Controller
public class HasTagController {

    private HashTagStorage hashTagStorage;

    public HasTagController(HashTagStorage hashTagStorage) {
        this.hashTagStorage = hashTagStorage;
    }

}
