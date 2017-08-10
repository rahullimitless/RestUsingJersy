package com.demo.rest.messanger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.demo.rest.messanger.database.DatabaseClass;
import com.demo.rest.messanger.exception.DataNotFoundException;
import com.demo.rest.messanger.model.Message;

public class MessageService {
	
private Map<Long,Message> messages=DatabaseClass.getMessages();

public MessageService() {
	// TODO Auto-generated constructor stub
	messages.put(1l,new Message(1,"Hello World","Rahul Chaturvedi"));
	messages.put(2l,new Message(2,"Hello jersey","Saurabh"));
}

	/*public List<Message> getAllMessages()
	{
		List<Message> list=new ArrayList<Message>();
		Message m1=new Message(1l,"Hello World","koushik");
		Message m2=new Message(2l,"Hello Jersey","koushik");
		list.add(m1);
		list.add(m2);
		return list;
	}*/

	public List<Message> getAllMessages()
	{
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year)
	{
		List<Message> messagesForYear=new ArrayList<>();
		Calendar cal=Calendar.getInstance();
		for(Message message:messages.values())
		{
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year)
			{
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start,int size)
	{
		ArrayList<Message> list=new ArrayList<Message>(messages.values());
		if(start+size>list.size())
			return new ArrayList<Message>();
				return list.subList(start, start+size);
	}
	/*public Message getMessage(long id)
	{
		return messages.get(id);
	}*/
	
	// method with exception handeling
	public Message getMessage(long id)
	{
		Message message=messages.get(id);
		if(message==null){
			throw new DataNotFoundException("Message with id="+ id + "not found");
		}
		return messages.get(id);
	}
	
	public Message addMessage(Message message)
	{
		message.setId(messages.size()+1);
		messages.put(message.getId(),message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId()<=0)
		{
			return null;
		}
		messages.put(message.getId(),message);
		return message;
	}
	
	public Message removeMessage(long id)
	{
		return messages.remove(id);
	}
}
