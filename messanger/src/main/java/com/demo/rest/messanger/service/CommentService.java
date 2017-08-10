package com.demo.rest.messanger.service;

import java.util.Map;

import com.demo.rest.messanger.database.DatabaseClass;
import com.demo.rest.messanger.model.Message;

public class CommentService {
	
	private Map<Long,Message> messages=DatabaseClass.getMessages();
	
	public CommentService() {
		// TODO Auto-generated constructor stub
		
	}

}
