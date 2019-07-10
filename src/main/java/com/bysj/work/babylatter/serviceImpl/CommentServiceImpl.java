package com.bysj.work.babylatter.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bysj.work.babylatter.dao.CommentDao;
import com.bysj.work.babylatter.model.Comment;
import com.bysj.work.babylatter.service.CommentService;
@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {
	@Autowired 
	private CommentDao commentDao;
	
	@Override
	public List<Comment> findAllComment() {
		// TODO Auto-generated method stub
		return commentDao.findAllComment();
	}
	
	@Override
	public List<Comment> getAllComment(Integer page, Integer limit) {
		// TODO Auto-generated method stub
		return commentDao.getAllComment(page,limit);
	}

	@Override
	public List<Comment> findByName(int tpage, Integer limit, String replyName) {
		// TODO Auto-generated method stub
		return commentDao.findByName(tpage,limit,replyName);
	}

	@Override
	public int Onetotal(String replyName) {
		// TODO Auto-generated method stub
		return commentDao.Onetotal(replyName);
	}

	@Override
	public Comment getOnecomment(Integer commentId) {
		// TODO Auto-generated method stub
		return commentDao.getOnecomment(commentId);
	}

	@Override
	public void updateComment(int commentId, Comment comment) {
		// TODO Auto-generated method stub
		commentDao.updateComment(commentId,comment);
	}

	@Override
	public void delComment(int commentId) {
		// TODO Auto-generated method stub
		commentDao.delComment(commentId);
	}
}
