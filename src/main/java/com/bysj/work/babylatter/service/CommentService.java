package com.bysj.work.babylatter.service;

import java.util.List;

import com.bysj.work.babylatter.model.Comment;

public interface CommentService {

	List<Comment> findAllComment();

	List<Comment> getAllComment(Integer page, Integer limit);

	List<Comment> findByName(int tpage, Integer limit, String replyName);

	int Onetotal(String replyName);

	Comment getOnecomment(Integer commentId);

	void updateComment(int commentId, Comment comment);

	void delComment(int commentId);

}
