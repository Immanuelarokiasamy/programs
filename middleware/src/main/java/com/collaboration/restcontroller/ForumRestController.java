package com.collaboration.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collaboration.dao.ForumDAO;
import com.collaboration.model.Forum;
import com.collaboration.model.Forum;

@RestController
public class ForumRestController {

	@Autowired
	ForumDAO forumDAO;
	
	@GetMapping("/getForums") 
	public ResponseEntity<List<Forum>> getForums() 
	{
		List<Forum> listForums=forumDAO.getForums();
		if(listForums.size()>0) {
			return new ResponseEntity<List<Forum>>(listForums,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Forum>>(listForums,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getForum/{forumId}")
	public ResponseEntity<Forum> getForum(@PathVariable("forumId") int forumId) 
	{
		Forum forum=forumDAO.getForum(forumId);
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
	}
	@PostMapping(value="/addForum",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> addForum(@RequestBody Forum forum)
	{
		forum.setCreateDate(new java.util.Date());
		forum.setStatus("NA");
		if(forumDAO.addForum(forum))
		{
			return new ResponseEntity<String>("Forum added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error adding forum",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/updateForum",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> updateForum(@RequestBody Forum forum)
	{
		Forum forum1=forumDAO.getForum(forum.getForumId());
		forum1.setForumName(forum.getForumName());
		forum1.setForumContent(forum.getForumContent());
		if(forumDAO.updateForum(forum1)) 
		{
			return new ResponseEntity<String>("Forum updated",HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<String>("Error updating forum",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping(value="/deleteForum/{forumId}",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deleteForum(@PathVariable("forumId") int forumId)
	{
		Forum forum=forumDAO.getForum(forumId);
		if(forumDAO.deleteForum(forum)) 
		{
			return new ResponseEntity<String>("Forum deleted",HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<String>("Error deleting forum",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(value="/approveForum/{forumId}",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> approveForum(@PathVariable("forumId") int forumId)
	{
		Forum forum=forumDAO.getForum(forumId);
		if(forumDAO.approveForum(forum)) 
		{
			return new ResponseEntity<String>("Forum approved",HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<String>("Error approving forum",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@GetMapping(value="/rejectForum/{forumId}",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> rejectForum(@PathVariable("forumId") int forumId)
	{
		Forum forum=forumDAO.getForum(forumId);
		if(forumDAO.rejectForum(forum)) 
		{
			return new ResponseEntity<String>("Forum rejected",HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<String>("Error rejecting forum",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
