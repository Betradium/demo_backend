package com.example.demo.comment.repository;

import com.example.demo.comment.model.CommentEntity;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface CommentRepositoryMyBatis {

    @Select("SELECT id, content, topicId, postId FROM comment WHERE topicId=#{topicId} AND postId=#{postId}")
    List<CommentEntity> getAllComments(@Param("topicId") Long topicId, @Param("postId") Long postId);

    @Select("SELECT id, content, topicId, postId FROM comment WHERE id=#{id} AND topicId=#{topicId} AND postId=#{postId}")
    CommentEntity getComment(@Param("topicId") Long topicId, @Param("postId") Long postId, @Param("id") Long id);

    @Insert("INSERT INTO comment (content, topicId, postId) VALUES (#{content}, #{topicId}, #{postId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(@RequestBody CommentEntity comment);

    @Update("UPDATE comment SET content=#{content} WHERE id = #{id} AND topicId=#{topicId} AND postId=#{postId}")
    void updateComment(@Param("id") Long id, @Param("content") String content, @Param("topicId") Long topicId, @Param("postId") Long postId);

    @Delete("DELETE FROM comment WHERE id = #{id} AND topicId=#{topicId} AND postId=#{postId}")
    void deleteComment(@Param("topicId") Long topicId, @Param("postId") Long postId, @Param("id") Long id);
}
