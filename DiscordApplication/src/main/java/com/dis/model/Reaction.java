package com.dis.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Reaction {
     
	@NotNull(message ="reactionId is mandatory")
	private int reactionId;
	
	@NotNull(message ="userId is mandatory")
	private int userId;
	
	@NotNull(message ="messageId is mandatory")
	private int messageId;
	
	@NotBlank(message ="emoji can't be null for a reaction")
	private String emoji;
	
	
	
	
	public Reaction() {
		
	}


	


	public Reaction(int reactionId, int userId, int messageId, String emoji) {
		this.reactionId = reactionId;
		this.userId = userId;
		this.messageId = messageId;
		this.emoji = emoji;
	}





	public int getMessageId() {
		return messageId;
	}





	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}





	public int getReactionId() {
		return reactionId;
	}


	public void setReactionId(int reactionId) {
		this.reactionId = reactionId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getEmoji() {
		return emoji;
	}


	public void setEmoji(String emoji) {
		this.emoji = emoji;
	}
	
	
	
	
}
