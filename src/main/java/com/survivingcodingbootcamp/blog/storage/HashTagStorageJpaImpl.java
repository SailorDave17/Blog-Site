package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.HashTag;
import com.survivingcodingbootcamp.blog.storage.repository.HashTagRepository;
import org.springframework.stereotype.Service;

@Service

public class HashTagStorageJpaImpl implements HashTagStorage {
    private HashTagRepository hashTagRepo;

    public HashTagStorageJpaImpl(HashTagRepository hashTagRepo){this.hashTagRepo = hashTagRepo;}

    @Override
    public Iterable<HashTag> retrieveAllHashTags(){return hashTagRepo.findAll();}

    @Override
    public HashTag retrieveHashTagById(long id) { return hashTagRepo.findById(id).get();}


    @Override
    public void save(HashTag hashTagToAdd) {hashTagRepo.save(hashTagToAdd);

    }
}
