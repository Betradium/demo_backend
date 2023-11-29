package com.example.demo.comment.repository;

import com.example.demo.comment.model.Comment;
import com.example.demo.comment.model.CommentEntity;

public class CommentConverter {

    public static Comment fromEntityToComment(CommentEntity commentEntity) {
        Comment comment = new Comment();
        comment.setId(commentEntity.getId());
        comment.setContent(commentEntity.getContent());
        comment.setTopicId(commentEntity.getTopicId());
        comment.setPostId(commentEntity.getPostId());
        return comment;
    }

    public static CommentEntity toCommentEntity(Comment comment) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(comment.getId());
        commentEntity.setContent(comment.getContent());
        commentEntity.setTopicId(comment.getTopicId());
        commentEntity.setPostId(comment.getPostId());
        return commentEntity;
    }
}

