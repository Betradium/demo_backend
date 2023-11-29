package com.example.demo.topic.repository;

import com.example.demo.topic.model.TopicEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TopicRepository {

    @Autowired
    TopicRepositoryMyBatis topicRepositoryMyBatis;

    public TopicEntity findById(Long id) {
        return topicRepositoryMyBatis.findById(id);
    }

    public void addTopic(TopicEntity topicEntity) {
        topicRepositoryMyBatis.save(topicEntity);
    }

    public void updateTopic(Long id, String title) {
        topicRepositoryMyBatis.updateTopic(id, title);
    }
    
    public List<TopicEntity> getAllTopics() {
        return topicRepositoryMyBatis.getAllTopics();
    }

    public void deleteTopic(Long id) {
        topicRepositoryMyBatis.deleteTopic(id);
    }
}
