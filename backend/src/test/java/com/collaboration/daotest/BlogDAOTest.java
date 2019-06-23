package com.collaboration.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaboration.dao.BlogDAO;
import com.collaboration.model.Blog;

public class BlogDAOTest {

	static BlogDAO blogDAO;
	
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.collaboration");
		context.refresh();
		blogDAO=(BlogDAO)context.getBean("blogDAO");
	}
	
	@Ignore
	@Test
	public void addblogtest() {
		Blog blog=new Blog();
		blog.setBlogName("new blog");
		blog.setBlogContent("third content");
		blog.setCreateDate(new java.util.Date());
		blog.setUsername("imman");
		assertTrue("problem in adding blog",blogDAO.addBlog(blog));
	}
	@Ignore
	@Test
	public void getblogtest() {
		assertNotNull("problem in getting blog",blogDAO.getBlog(501));
	}
	@Ignore
	@Test
	public void updateblogtest() {
		Blog blog=blogDAO.getBlog(503);
		blog.setBlogName("second blog");
		assertTrue("problem in updating blog",blogDAO.updateBlog(blog));
	}
	@Ignore
	@Test
	public void deleteblogtest() {
		Blog blog=blogDAO.getBlog(504);
		assertTrue("problem in deleting blog",blogDAO.deleteBlog(blog));
	}
	@Ignore
	@Test
	public void listblogtest() {
		List<Blog> listBlogs=blogDAO.getBlogs();
		for(Blog blog:listBlogs) {
			System.out.println("id:"+blog.getBlogId());
		}
	}
	
	@Test
	public void incrementlikestest() {
		assertTrue("problem in incrementing likes",blogDAO.incrementLikes(501));
	}
	@Ignore
	@Test
	public void incrementdislikestest() {
		assertTrue("problem in incrementing likes",blogDAO.incrementDislikes(501));
	}
	@Ignore
	@Test
	public void approveblogtest() {
		Blog blog=blogDAO.getBlog(501);
		assertTrue("problem in incrementing likes",blogDAO.rejectBlog(blog));
	}
	@Ignore
	@Test
	public void rejectblogtest() {
		Blog blog=blogDAO.getBlog(503);
		assertTrue("problem in incrementing likes",blogDAO.approveBlog(blog));
	}
}
