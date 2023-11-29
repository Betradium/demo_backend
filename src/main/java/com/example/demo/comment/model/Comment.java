package com.example.demo.comment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Comment {

    private Long id;

    @JsonProperty("content")
    private String content;

    @JsonProperty("topicId")
    private Long topicId;

    @JsonProperty("postId")
    private Long postId;
}

