package com.collaboration.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.collaboration.dao.BlogCommentDAO;
import com.collaboration.dao.BlogCommentDAOImpl;
import com.collaboration.dao.BlogDAO;
import com.collaboration.dao.BlogDAOImpl;
import com.collaboration.dao.ForumCommentDAO;
import com.collaboration.dao.ForumCommentDAOImpl;
import com.collaboration.dao.ForumDAO;
import com.collaboration.dao.ForumDAOImpl;
import com.collaboration.dao.FriendDAO;
import com.collaboration.dao.FriendDAOImpl;
import com.collaboration.dao.JobDAO;
import com.collaboration.dao.JobDAOImpl;
import com.collaboration.dao.UserDetailDAO;
import com.collaboration.dao.UserDetailDAOImpl;
import com.collaboration.model.Blog;
import com.collaboration.model.BlogComment;
import com.collaboration.model.Forum;
import com.collaboration.model.ForumComment;
import com.collaboration.model.Friend;
import com.collaboration.model.Job;
import com.collaboration.model.ProfilePicture;
import com.collaboration.model.UserDetail;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.collaboration.*")
public class DBConfig 
{
	@Bean(name="datasource")
	public DataSource getoracleDataSource()
	{
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:immandatabas");
		datasource.setUsername("imm");
		datasource.setPassword("imm");
		System.out.println(">>>>>>Datasource object created<<<<<<");
		return datasource;
	}

	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateprop=new Properties();
		
		hibernateprop.put("hibernate.hbm2ddl.auto","update");
		hibernateprop.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getoracleDataSource());

		factory.addProperties(hibernateprop);
		factory.addAnnotatedClass(UserDetail.class);
		factory.addAnnotatedClass(Blog.class);
		factory.addAnnotatedClass(BlogComment.class);
		factory.addAnnotatedClass(Forum.class);
		factory.addAnnotatedClass(ForumComment.class);
		factory.addAnnotatedClass(Friend.class);
		factory.addAnnotatedClass(Job.class);
		factory.addAnnotatedClass(ProfilePicture.class);
		
		System.out.println(">>>>>>SessionFactory Object created<<<<<<");

		return factory.buildSessionFactory();
		
	}
@Bean(name="TransactionManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
{
	System.out.println(">>>>>TransactionManager Object created<<<<<<");
	return new HibernateTransactionManager(sessionFactory);
}
@Bean(name="userdetailDAO") 
public UserDetailDAO getUserDetailDAO() {
	return new UserDetailDAOImpl();
}
@Bean(name="blogDAO") 
public BlogDAO getBlogDAO() {
	return new BlogDAOImpl();
}
@Bean(name="blogcommentDAO") 
public BlogCommentDAO getBlogCommentDAO() {
	return new BlogCommentDAOImpl();
}
@Bean(name="forumDAO") 
public ForumDAO getForumDAO() {
	return new ForumDAOImpl();
}
@Bean(name="forumcommentDAO") 
public ForumCommentDAO getForumCommentDAO() {
	return new ForumCommentDAOImpl();
}
@Bean(name="friendDAO") 
public FriendDAO getFriendDAO() {
	return new FriendDAOImpl();
}
@Bean(name="jobDAO") 
public JobDAO getJobDAO() {
	return new JobDAOImpl();
}
}