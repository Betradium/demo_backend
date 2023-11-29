package com.example.demo.post.controller;

import com.example.demo.post.service.PostService;
import com.example.demo.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic/{topicId}/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping()
    public List<Post> getAllPostsByTopicId(@PathVariable Long topicId) {
        return postService.getAllPostsByTopicId(topicId);
    }

    @GetMapping("{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long topicId, @PathVariable Long id) {
        Post post = postService.getPost(topicId, id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> addPost(@PathVariable Long topicId, @RequestBody Post post) {
      post.setTopicId(topicId);
      postService.addPost(post);
      return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long topicId, @PathVariable Long id, @RequestBody Post post) {
        post.setId(id);
        post.setTopicId(topicId);
        postService.updatePost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Post> deletePost(@PathVariable Long topicId, @PathVariable Long id) {
        postService.deletePost(topicId, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
