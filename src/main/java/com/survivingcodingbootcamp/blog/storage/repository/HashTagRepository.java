package com.survivingcodingbootcamp.blog.storage.repository;

import com.survivingcodingbootcamp.blog.model.HashTag;
import org.springframework.data.repository.CrudRepository;

public interface HashTagRepository extends CrudRepository<HashTag, Long> {

    HashTag findByHashTagName(String name);
}
