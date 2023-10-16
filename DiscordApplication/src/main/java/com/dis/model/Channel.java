package com.dis.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Channel {
    
      @NotNull(message ="channelId is mandatory")
      private int channelId;
      
      @NotBlank(message ="channelname must be present")
      private String channelName;
      
      private List<Integer> messageIds;
      
	

	public Channel(int channelId, String channelName) {
		this.channelId = channelId;
		this.channelName = channelName;
		this.messageIds = new ArrayList<>();
	}



	



	public List<Integer> getMessageIds() {
		return messageIds;
	}











	public Channel() {
		
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
      

      
      
      
}
