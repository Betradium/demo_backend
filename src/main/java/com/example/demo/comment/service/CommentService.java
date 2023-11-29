package com.example.demo.comment.service;

import com.example.demo.exceptions.CustomExceptions;
import com.example.demo.comment.model.Comment;
import com.example.demo.comment.model.CommentEntity;
import com.example.demo.comment.repository.CommentConverter;
import com.example.demo.comment.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments(Long topicId, Long postId) {
        List<CommentEntity> commentEntities = commentRepository.getAllComments(topicId, postId);
        return commentEntities.stream().map(CommentConverter::fromEntityToComment).collect(Collectors.toList());
    }

    public Comment getComment(Long topicId, Long postId, Long id) {
        CommentEntity existingComment = commentRepository.getComment(topicId, postId, id);
        if (existingComment == null) {
            throw new CustomExceptions.CommentNotFoundException();
        }
        return CommentConverter.fromEntityToComment(existingComment);
    }

    public void addComment(Comment comment) {
        if (comment.getContent() == null) {
            throw new CustomExceptions.InvalidCommentException();
        }
        CommentEntity commentEntity = CommentConverter.toCommentEntity(comment);
        commentRepository.addComment(commentEntity);
    }

    public void updateComment(Comment comment) {   
        CommentEntity existingComment = commentRepository.getComment(comment.getTopicId(), comment.getPostId(), comment.getId());
        if (existingComment == null) {
            throw new CustomExceptions.CommentNotFoundException();
        }
        if (comment.getContent() == null || comment.getTopicId() == null || comment.getPostId() == null) {
            throw new CustomExceptions.InvalidCommentException();
        }
        commentRepository.updateComment(comment.getId(), comment.getContent(), comment.getTopicId(), comment.getPostId());
    }

    public void deleteComment(Long topicId, Long postId, Long id) {
        try {
        commentRepository.deleteComment(topicId, postId, id);
            } catch (Exception ex) {
                throw new CustomExceptions.CommentNotFoundException();
            }        
    }
}