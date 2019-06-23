package com.collaboration.dao;

import java.util.List;

import com.collaboration.model.BlogComment;

public interface BlogCommentDAO {

public boolean addBlogComment(BlogComment blogcomment);
public boolean updateBlogComment(BlogComment blogComment);
public boolean deleteBlogComment(BlogComment blogcomment);
public BlogComment getBlogComment(int commentId);
public List<BlogComment> getBlogComments();
public List<BlogComment> getBlogComments(int blogId);
}
