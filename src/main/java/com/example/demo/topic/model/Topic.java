package com.example.demo.topic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Topic {

    private Long id;
    
    @JsonProperty("title")
    private String title;
}

