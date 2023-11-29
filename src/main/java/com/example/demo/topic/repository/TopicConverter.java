package com.example.demo.topic.repository;

import com.example.demo.topic.model.Topic;
import com.example.demo.topic.model.TopicEntity;

public class TopicConverter {

    public static Topic fromEntityToTopic(TopicEntity topicEntity) {
        Topic topic = new Topic();
        topic.setId(topicEntity.getId());
        topic.setTitle(topicEntity.getTitle());
        return topic;
    }

    public static TopicEntity toTopicEntity(Topic topic) {
        TopicEntity topicEntity = new TopicEntity();
        topicEntity.setId(topic.getId());
        topicEntity.setTitle(topic.getTitle());
        return topicEntity;
    }
}

