package com.example.demo.comment.controller;

import com.example.demo.comment.service.CommentService;
import com.example.demo.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic/{topicId}/post/{postId}/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping()
    public List<Comment> getAllComments(@PathVariable Long topicId, @PathVariable Long postId) {
        return commentService.getAllComments(topicId, postId);
    }

    @GetMapping("{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long topicId, @PathVariable Long postId, @PathVariable Long id) {
        Comment comment = commentService.getComment(topicId, postId, id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment> addComment(@PathVariable Long topicId, @PathVariable Long postId, @RequestBody Comment comment) {
      comment.setTopicId(topicId);
      comment.setPostId(postId);
      commentService.addComment(comment);
      return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<Comment> updateComment(@PathVariable Long topicId, @PathVariable Long postId, @PathVariable Long id, @RequestBody Comment comment) {
        comment.setId(id);
        comment.setPostId(postId);
        comment.setTopicId(topicId);
        commentService.updateComment(comment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comment> deleteComment(@PathVariable Long topicId, @PathVariable Long postId, @PathVariable Long id) {
        commentService.deleteComment(topicId, postId, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
