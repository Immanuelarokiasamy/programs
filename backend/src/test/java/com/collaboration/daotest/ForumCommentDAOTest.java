package com.collaboration.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaboration.dao.ForumCommentDAO;
import com.collaboration.model.ForumComment;

public class ForumCommentDAOTest {

	static ForumCommentDAO forumcommentDAO;
	
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.collaboration");
		context.refresh();
		forumcommentDAO=(ForumCommentDAO)context.getBean("forumcommentDAO");
	}
	@Ignore
	@Test
	public void addforumcommenttest() {
		ForumComment forumcomment=new ForumComment();
		forumcomment.setForumId(503);
		forumcomment.setForumComment("good");
		forumcomment.setCommentDate(new java.util.Date());
		forumcomment.setUsername("imman");
		assertTrue("problem in adding forum comment",forumcommentDAO.addForumComment(forumcomment));
	}
	
	@Test
	public void getforumcommenttest() {
		assertNotNull("problem in getting forumcomment",forumcommentDAO.getForumComment(504));
	}
	
	@Test
	public void updateforumcommenttest() {
		ForumComment forumcomment=forumcommentDAO.getForumComment(504);
		forumcomment.setForumComment("nice");
		assertTrue("problem in adding forum comment",forumcommentDAO.updateForumComment(forumcomment));
	}
	@Ignore
	@Test
	public void deleteforumcomment() {
		ForumComment forumcomment=forumcommentDAO.getForumComment(503);
		assertTrue("problem in deleting forum comment",forumcommentDAO.deleteForumComment(forumcomment));
	}
	@Test
	public void listforumcomment() {
		List<ForumComment> listComments=forumcommentDAO.getForumComments();
	    for(ForumComment forumcomment:listComments) {
	    	System.out.println("id:"+forumcomment.getCommentId());
	    }
	}
}
