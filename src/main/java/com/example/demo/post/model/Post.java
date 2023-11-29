package com.example.demo.post.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Post {

    private Long id;

    @JsonProperty("content")
    private String content;

    @JsonProperty("topicId")
    private Long topicId;
}

