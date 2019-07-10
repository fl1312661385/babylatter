package com.bysj.work.babylatter.web;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bysj.work.babylatter.model.Comment;
import com.bysj.work.babylatter.model.Order;
import com.bysj.work.babylatter.service.CommentService;
import com.bysj.work.babylatter.util.LayuiData;

@Controller
public class CommentController {
		@Autowired
		private CommentService commentService;
		@RequestMapping("comment")
		public String comment(){
			return "comment";
		}
		
		
		@RequestMapping("commentData")
		@ResponseBody
		public LayuiData<Comment> commentData(Integer page,Integer limit,String replyName){
			LayuiData<Comment> result=new LayuiData<>();
			if(replyName==null){
				int tpage=(page-1)*limit;
				List<Comment> list=commentService.findAllComment();
				List<Comment> listpage=commentService.getAllComment(tpage,limit);
				int count =list.size();
				result.setData(listpage);
				result.setCount(count);
			}else{
				int tpage=(page-1)*limit;
				List<Comment> list=commentService.findByName(tpage,limit,replyName);
				result.setData(list);
				int count=commentService.Onetotal(replyName);
				result.setCount(count);
				}
			
			return result;
		}
		@RequestMapping("editComment")
		public String editComment(Integer commentId,HttpServletRequest request,HttpSession session){
			Comment comment=commentService.getOnecomment(commentId);
			request.setAttribute("comment", comment);
			session.setAttribute("commentId", commentId);
			
			return "editComment";
			
		}
		
		@RequestMapping("updateComment")
		@ResponseBody
		public void updateComment(Comment comment,HttpServletRequest request,HttpSession session){
//			Comment comment=new Comment();
//			comment.setState(state);
//			comment.setCommentDate(commentDate);
//			comment.setContent(content);
//			comment.setCommentTime(commentTime);
//			int state=Integer.parseInt(request.getParameter("state"));
//			comment.setState(state);
			System.out.println(comment);
			int commentId= (int) session.getAttribute("commentId");
//			Date d = new Date();
//			SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");
//			String commentTime=sd.format(d);
//			comment.setCommentTime(commentTime);
			commentService.updateComment(commentId,comment);
			
			
			
		}
		@ResponseBody
		@RequestMapping("delComment")
		public int delComment(int commentId){
			
			commentService.delComment(commentId);
			return 1;
		}
		
		
}
