package com.example.demo.topic.repository;

import com.example.demo.topic.model.TopicEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface TopicRepositoryMyBatis {

        @Select("SELECT id, title FROM topic WHERE id=#{id}")
        TopicEntity findById(@Param("id") Long id);
    
        @Select("SELECT id, title FROM topic")
        List<TopicEntity> getAllTopics();

        @Insert("INSERT INTO topic (title) VALUES (#{title})")
        @Options(useGeneratedKeys = true, keyProperty = "id")
        void save(@RequestBody TopicEntity topic);

        @Update("UPDATE topic SET title=#{title} WHERE id = #{id}")
        void updateTopic(@Param("id") Long id, @Param("title") String title);

        @Delete("DELETE FROM topic WHERE id = #{id}")
        void deleteTopic(@Param("id") Long id);
}
