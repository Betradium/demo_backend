package com.example.demo.topic.service;

import com.example.demo.exceptions.CustomExceptions;
import com.example.demo.topic.model.Topic;
import com.example.demo.topic.model.TopicEntity;
import com.example.demo.topic.repository.TopicConverter;
import com.example.demo.topic.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;



    public List<Topic> getAllTopics() {
        List<TopicEntity> topicEntities = topicRepository.getAllTopics();
        return topicEntities.stream().map(TopicConverter::fromEntityToTopic).collect(Collectors.toList());
    }

    public Topic getTopicById(Long id) {
        TopicEntity existingTopic = topicRepository.findById(id);
        if (existingTopic == null) {
            throw new CustomExceptions.TopicNotFoundException();
        }
        return TopicConverter.fromEntityToTopic(existingTopic);
    }

    public void addTopic(Topic topic) {
        if (topic.getTitle() == null) {
            throw new CustomExceptions.InvalidPostException();
        }
        TopicEntity topicEntity = TopicConverter.toTopicEntity(topic);
        topicRepository.addTopic(topicEntity);
    }

    public void updateTopic(Topic topic) {
        TopicEntity existingTopic = topicRepository.findById(topic.getId());
        if (existingTopic == null) {
            throw new CustomExceptions.TopicNotFoundException();
        }
        if (topic.getTitle() == null || topic.getId() == null) {
            throw new CustomExceptions.InvalidTopicException();
        }
        topicRepository.updateTopic(topic.getId(), topic.getTitle());
    }

    public void deleteTopic(Long id) {
        TopicEntity existingTopic = topicRepository.findById(id);
        if (existingTopic == null) {
            throw new CustomExceptions.TopicNotFoundException();
        }
            topicRepository.deleteTopic(id);
    }
}