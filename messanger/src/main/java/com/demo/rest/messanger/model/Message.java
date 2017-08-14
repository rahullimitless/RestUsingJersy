package com.demo.rest.messanger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Rahul
 *
 */
@XmlRootElement
public class Message {
	
	private long id;
	
	private String message;
	
	private String author;
	
	private Date created;
	
	private Map<Long,Comment> comments=new HashMap<>();
	
	private List<Link> links=new ArrayList<>();
	
	public Message() {
		// TODO Auto-generated constructor stub
	}
	
	public Message(long id,String message,String author)
	{
		this.id=id;
		this.message=message;
		this.author=author;
		this.created=new Date();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}

	
	public void addLink(String url, String rel){
		Link link=new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + ", author="
				+ author + ", created=" + created + ", comments=" + comments
				+ ", links=" + links + "]";
	}

}
