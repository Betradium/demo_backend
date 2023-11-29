package com.example.demo.comment.repository;

import com.example.demo.comment.model.CommentEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {

    @Autowired
    CommentRepositoryMyBatis commentRepositoryMyBatis;

    public List<CommentEntity> getAllComments(Long topicId, Long postId) {
        return commentRepositoryMyBatis.getAllComments(topicId, postId);
    }

    public CommentEntity getComment(Long topicId, Long postId, Long id) {
        return commentRepositoryMyBatis.getComment(topicId, postId, id);
    }

    public void addComment(CommentEntity commentEntity) {
        commentRepositoryMyBatis.save(commentEntity);
    }

    public void updateComment(Long id, String content, Long topicId, Long postId) {
        commentRepositoryMyBatis.updateComment(id, content, topicId, postId);
    }

    public void deleteComment(Long topicId, Long postId, Long id) {
        commentRepositoryMyBatis.deleteComment(topicId, postId, id);
    }
}
