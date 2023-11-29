package com.example.demo.post.service;


import com.example.demo.exceptions.CustomExceptions;
import com.example.demo.post.model.Post;
import com.example.demo.post.model.PostEntity;
import com.example.demo.post.repository.PostConverter;
import com.example.demo.post.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPostsByTopicId(Long topicId) {
        List<PostEntity> postEntities = postRepository.getAllPostsByTopicId(topicId);
        return postEntities.stream().map(PostConverter::fromEntityToPost).collect(Collectors.toList());
    }

    public Post getPost(Long topicId, Long id) {
        PostEntity existingPost = postRepository.getPost(topicId, id);
        if (existingPost == null) {
            throw new CustomExceptions.PostNotFoundException();
        }
        return PostConverter.fromEntityToPost(existingPost);
    }

    public void addPost(Post post) {
        if (post.getContent() == null) {
            throw new CustomExceptions.InvalidPostException();
        }
        try {
        PostEntity postEntity = PostConverter.toPostEntity(post);
        postRepository.addPost(postEntity);
                } catch (Exception ex) {
                    throw new CustomExceptions.InvalidPostException();
                }  
    }

    public void updatePost(Post post) {
        PostEntity existingPost = postRepository.getPost(post.getTopicId(), post.getId());
        if (existingPost == null) {
            throw new CustomExceptions.PostNotFoundException();
        }
        if (post.getContent() == null || post.getTopicId() == null || post.getId() == null) {
            throw new CustomExceptions.InvalidPostException();
        }
        postRepository.updatePost(post.getId(), post.getContent(), post.getTopicId());
    }

    public void deletePost(Long topicId, Long id) {
        try {
        postRepository.deletePost(topicId, id);
        } catch (Exception ex) {
            throw new CustomExceptions.PostNotFoundException();
        }
    }
} 