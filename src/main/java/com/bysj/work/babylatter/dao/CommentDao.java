package com.bysj.work.babylatter.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bysj.work.babylatter.model.Comment;

public interface CommentDao {

	List<Comment> findAllComment();

	List<Comment> getAllComment(@Param("page")Integer page,@Param("limit") Integer limit);

	List<Comment> findByName(@Param("page")int tpage, @Param("limit")Integer limit, @Param("replyName")String replyName);

	int Onetotal(@Param("replyName")String replyName);

	Comment getOnecomment(Integer commentId);

	void updateComment(@Param("commentId")int commentId,@Param("comment") Comment comment);

	void delComment(int commentId);

	

}
