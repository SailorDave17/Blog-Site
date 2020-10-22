package com.survivingcodingbootcamp.blog.storage;


import com.survivingcodingbootcamp.blog.model.HashTag;

public interface HashTagStorage {
    Iterable<HashTag> retrieveAllHashTags();


    HashTag retrieveHashTagById(long id);

    default void save(HashTag hashTagToAdd) {

    }
}
