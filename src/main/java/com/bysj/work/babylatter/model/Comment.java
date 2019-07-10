package com.bysj.work.babylatter.model;

public class Comment {
	private Integer commentId;
	private Integer userId;
	private String replyName;
	private Integer productId;
	private String productName;
	private String content;
	private String commentDate;
	private String commentTime;
	private Integer commentParentId;
	private String commentName;
	private Integer state;
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public String getCommentTime() {
		return commentTime;
	}
	
	public String getReplyName() {
		return replyName;
	}
	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}
	public Integer getCommentParentId() {
		return commentParentId;
	}
	public void setCommentParentId(Integer commentParentId) {
		this.commentParentId = commentParentId;
	}
	public String getCommentName() {
		return commentName;
	}
	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", userId=" + userId + ", replyName=" + replyName + ", productId="
				+ productId + ", productName=" + productName + ", content=" + content + ", commentDate=" + commentDate
				+ ", commentTime=" + commentTime + ", commentParentId=" + commentParentId + ", commentName="
				+ commentName + ", state=" + state + "]";
	}
	
	
}
