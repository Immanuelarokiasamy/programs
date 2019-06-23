package com.collaboration.dao;

import java.util.List;

import com.collaboration.model.Forum;


public interface ForumDAO {

public boolean addForum(Forum forum);
public boolean updateForum(Forum forum);
public boolean deleteForum(Forum forum);
public Forum getForum(int forumId);
public List<Forum> getForums();
public boolean approveForum(Forum forum);
public boolean rejectForum(Forum forum);
}
