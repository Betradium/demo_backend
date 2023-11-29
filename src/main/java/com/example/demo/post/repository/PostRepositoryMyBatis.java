package com.example.demo.post.repository;

import com.example.demo.post.model.PostEntity;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface PostRepositoryMyBatis {

    @Select("SELECT id, content, topicId FROM post WHERE topicId=#{topicId}")
    List<PostEntity> getAllPostsByTopicId(@Param("topicId") Long topicId);

    @Select("SELECT id, content, topicId FROM post WHERE id=#{id} AND topicId=#{topicId}")
    PostEntity getPost(@Param("topicId") Long topicId, @Param("id") Long id);

    @Insert("INSERT INTO post (content, topicId) VALUES (#{content}, #{topicId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(@RequestBody PostEntity post);

    @Update("UPDATE post SET content=#{content} WHERE id = #{id} AND topicId=#{topicId}")
    void updatePost(@Param("id") Long id, @Param("content") String content, @Param("topicId") Long topicId);

    @Delete("DELETE FROM post WHERE id = #{id} AND topicId=#{topicId}")
    void deletePost(@Param("topicId") Long topicId, @Param("id") Long id);
}
