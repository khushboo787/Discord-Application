package com.dis.exception;

public class ChannelNotFoundException extends RuntimeException{

	
	public ChannelNotFoundException() {
	}

	public ChannelNotFoundException(String message) {
		super(message);
	}

}
