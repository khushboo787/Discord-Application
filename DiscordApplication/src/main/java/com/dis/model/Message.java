package com.dis.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Message {
	
	@NotNull(message ="messageId is mandatory")
	@Min(value = 1L, message = "messageId should be a positive value")
	private int messageId;
	
	@NotNull(message ="userId is mandatory")
	private int userid;
	
	private String content;
	
	public List<Integer> getUsersReacted() {
		return usersReacted;
	}

	public void setUsersReacted(List<Integer> usersReacted) {
		this.usersReacted = usersReacted;
	}

	private int channelId;
	
	private List<Integer> usersReacted = new ArrayList<>();

	public Message(int messageId, int userid, String content, int channelId ) {
		this.messageId = messageId;
		this.userid = userid;
		this.content = content;
		this.channelId = channelId;
		this.usersReacted = new ArrayList<>();
	}

	public Message() {
		
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	
	

}
