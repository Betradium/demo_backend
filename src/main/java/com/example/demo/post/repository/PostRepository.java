package com.example.demo.post.repository;

import com.example.demo.post.model.PostEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepository {

    @Autowired
    PostRepositoryMyBatis postRepositoryMyBatis;

    public List<PostEntity> getAllPostsByTopicId(Long topicId) {
        return postRepositoryMyBatis.getAllPostsByTopicId(topicId);
    }

    public PostEntity getPost(Long topicId, Long id) {
        return postRepositoryMyBatis.getPost(topicId, id);
    }

    public void addPost(PostEntity postEntity) {
        postRepositoryMyBatis.save(postEntity);
    }

    public void updatePost(Long id, String content, Long topicId) {
        postRepositoryMyBatis.updatePost(id, content, topicId);
    }

    public void deletePost(Long topicId, Long id) {
        postRepositoryMyBatis.deletePost(topicId, id);
    }
}
