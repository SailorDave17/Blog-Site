package com.survivingcodingbootcamp.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.List;

@Entity
public class HashTag {
    @Id
    @GeneratedValue
    private Long id;
    private String hashTagName;
    @ManyToMany
    private Collection<Post> posts;
    protected HashTag(){}
    public HashTag (String hashTagName, Post...posts){
        this.hashTagName = hashTagName;
        this.posts = List.of(posts);


    }

    public Long getId() {
        return id;
    }

    public String getHashTagName() {
        return hashTagName;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return "HashTag{" +
                "id=" + id +
                ", name='" + hashTagName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashTag hashTag = (HashTag) o;

        if (id != null ? !id.equals(hashTag.id) : hashTag.id != null) return false;
        return hashTagName != null ? hashTagName.equals(hashTag.hashTagName) : hashTag.hashTagName == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (hashTagName != null ? hashTagName.hashCode() : 0);
        return result;
    }

    public void addPost(Post postToAdd){
        posts.add(postToAdd);
    }
}
