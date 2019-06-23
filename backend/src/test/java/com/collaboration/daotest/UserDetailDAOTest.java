package com.collaboration.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaboration.dao.UserDetailDAO;
import com.collaboration.model.UserDetail;

public class UserDetailDAOTest {

	static UserDetailDAO userdetailDAO;
	
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.collaboration");
		context.refresh();
		userdetailDAO=(UserDetailDAO)context.getBean("userdetailDAO");
	}
	
	@Ignore
	@Test
	public void addusertest() {
		UserDetail userDetail=new UserDetail();
		userDetail.setUsername("immadmin");
		userDetail.setFirstname("immanuel");
		userDetail.setPassword("immadmin");
		userDetail.setEmailId("immadmin@gmail.com");
		assertTrue("problem in adding user",userdetailDAO.addUser(userDetail));
	}
	@Ignore
	@Test
	public void getusertest() {
		assertNotNull("problem in getting user",userdetailDAO.getUser("imman"));
	}
	@Ignore
	@Test
	public void updateusertest() {
		UserDetail userDetail=userdetailDAO.getUser("imman");
		userDetail.setFirstname("imman");
		assertTrue("problem in updating user",userdetailDAO.updateUser(userDetail));
	}
	@Ignore
	@Test
	public void listusertest() {
		List<UserDetail> listUsers=userdetailDAO.getUsers();
		for(UserDetail userDetail:listUsers) {
			System.out.println("username:"+userDetail.getUsername());
		}
	}
	
	@Test
	public void checkusertest() {
		UserDetail userDetail=userdetailDAO.getUser("ravi");
		System.out.println("username:"+userDetail.getUsername());
		assertNotNull("problem in checking user",userdetailDAO.checkUser(userDetail));
	}
	
}
