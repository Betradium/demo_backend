package com.example.demo.post.repository;

import com.example.demo.post.model.Post;
import com.example.demo.post.model.PostEntity;

public class PostConverter {

    public static Post fromEntityToPost(PostEntity postEntity) {
        Post post = new Post();
        post.setId(postEntity.getId());
        post.setContent(postEntity.getContent());
        post.setTopicId(postEntity.getTopicId());
        return post;
    }

    public static PostEntity toPostEntity(Post post) {
        PostEntity postEntity = new PostEntity();
        postEntity.setId(post.getId());
        postEntity.setContent(post.getContent());
        postEntity.setTopicId(post.getTopicId());
        return postEntity;
    }
}

