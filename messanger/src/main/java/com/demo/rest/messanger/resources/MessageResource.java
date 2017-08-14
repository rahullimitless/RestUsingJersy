package com.demo.rest.messanger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.demo.rest.messanger.beans.MessageFilterBean;
import com.demo.rest.messanger.model.Message;
import com.demo.rest.messanger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService=new MessageService();
	
	//Return All the messages
	@GET
	public List<Message> getAllMessages(){
		return messageService.getAllMessages();
	}
	
	//@Query Param example
	/*@GET
	public List<Message> getMessages(@QueryParam("year") int year,@QueryParam("start") int start,@QueryParam("size") int size){
		if(year>0)
		{
		return messageService.getAllMessagesForYear(year);
		}
		if(start>=0 && size>=0)
		{
			return messageService.getAllMessagesPaginated(start, size);
		}
		return messageService.getAllMessages();
	}*/
	
	/*@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean){
		if(filterBean.getYear()>0)
		{
		return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if(filterBean.getStart()>=0 && filterBean.getSize()>=0)
		{
			return messageService.getAllMessagesPaginated(filterBean.getStart(),filterBean.getSize());
		}
		return messageService.getAllMessages();
	}*/
	
	//send links with json respones HATEOAS
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id,@Context UriInfo uriInfo)
	{
		Message message=messageService.getMessage(id);
		message.addLink(getUriForSelf(uriInfo, message), "self");
		message.addLink(getUriForProfile(uriInfo, message),"profile");
		return message;
	}
	
	
	
	//post request with status code and location header
	
	@POST
	public Response addMessage(Message message,@Context UriInfo uriInfo)
	{
		Message newMessage=messageService.addMessage(message);
		String newId=String.valueOf(newMessage.getId());
		URI uri=uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newMessage).build();
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id,Message message)
	{
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id)
	{
	   messageService.removeMessage(id);
	}
	
	private String getUriForSelf(UriInfo uriInfo,Message message)
	{
		String uri=uriInfo.getBaseUriBuilder()
				  .path(MessageResource.class)
				  .path(Long.toString(message.getId()))
				  .build().toString();
		return uri;
	}
	
	private String getUriForProfile(UriInfo uriInfo,Message message)
	{
		String uri=uriInfo.getBaseUriBuilder()
				  .path(ProfileResource.class)
				  .path(message.getAuthor())
				  .build().toString();
		return uri;
	}

	@Path("/{messageId}/comments")
	public CommentResource getCommentResource()
	{
		return new CommentResource();
	}
}
