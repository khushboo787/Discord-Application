package com.dis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.dis.exception.ChannelNotFoundException;
import com.dis.exception.DuplicateMessageIdException;
import com.dis.exception.DuplicateReactionIdException;
import com.dis.exception.DuplicateUserException;
import com.dis.exception.MessageNotFoundException;
import com.dis.exception.UserNotFoundException;
import com.dis.model.Channel;
import com.dis.model.Message;
import com.dis.model.Reaction;
import com.dis.model.User;

import jakarta.annotation.PostConstruct;

@Service
public class DiscordService {

	private Map<Integer, User> users = new HashMap<>();
	private Map<Integer, Message> messages = new HashMap<>();
	private Map<Integer, Reaction> reactions = new HashMap<>();
	private Map<Integer, Channel> channels = new HashMap<>();
	
	@PostConstruct
	public void init() {
		
		        User u1 = new User(1,"Khushboo Kumari", "ChatGPT#!@$");
		        User u2 = new User(2,"Gautam Jha", "ChatGPT#!%^5@$");
		        User u3 = new User(3,"Adhira", "ChatGPT1223!@");
		
				users.put(u1.getUserId(), u1);
		        users.put(u2.getUserId(), u2);
		        users.put(u3.getUserId(), u3);
		        
		       Message m1 = new Message(1,3, "Hello Everyone Lets me Khushboo",1);
		      
				messages.put(m1.getMessageId(), m1);
		     
		        
		        
	}
	
	@PostConstruct
	public void initChannels() {
		Channel ch1 = new Channel(1,"general");
		Channel ch2 = new Channel(2,"SB201");
		channels.put(ch1.getChannelId(),ch1);
		channels.put(ch1.getChannelId(),ch2);
		
	}
	
	// U S E R S 
	public List<User> getAllUsers(){
		return new ArrayList<>(users.values());
	}
	
	
	public User addNewUser(User user) {
		if(users.containsKey(user.getUserId())) {
		   throw new DuplicateUserException("user with id: " + user.getUserId() + " already exists.");
		}
		
		users.put(user.getUserId(), user);
		return user;
		
	}
	
	
	// M E S S A G E S
	public List<Message> getAllMessages(){
		return new ArrayList<>(messages.values());
	}
	
	
	public Message sendNewMessage(Message msg) {
		if(messages.containsKey(msg.getMessageId())) {
		   throw new DuplicateMessageIdException("Message with id: " + msg.getMessageId() + " already exists.");
		}
		
		if(!channels.containsKey(msg.getChannelId())) {
			   throw new ChannelNotFoundException("No channel with the channelId: " + msg.getChannelId()+ " is exists.");
		}
		
		channels.get(msg.getChannelId()).getMessageIds().add(msg.getMessageId());
		messages.put(msg.getMessageId(), msg);
		return msg;
		
	}
	
	// R E A C T I O N S
	public List<Reaction> getAllReactions(){
		return new ArrayList<>(reactions.values());
	}
	
	
	public Reaction addReaction(Reaction rct) {
		if(!messages.containsKey(rct.getMessageId())) {
			   throw new MessageNotFoundException("No message found with the given messageId.");
			}
		if(reactions.containsKey(rct.getReactionId())) {
		   throw new DuplicateReactionIdException("Reaction with the given reactionId: " + rct.getReactionId() + " is already exists.");
		}
		
		reactions.put(rct.getReactionId(), rct);
		messages.get(rct.getMessageId()).getUsersReacted().add(rct.getUserId());
		return rct;
	}
	
	
	// C H A N N E L S
	public List<Channel> getAllChannels(){
		return new ArrayList<>(channels.values());
	}
	
	
	public Channel createNewChannels(Channel ch) {
		if(channels.containsKey(ch.getChannelId())) {
		   throw new DuplicateMessageIdException("Channel with id: " + ch.getChannelId() + " already exists.");
		}
		
		channels.put(ch.getChannelId(), ch);
		return ch;
		
	}
	
	
	// M E S S A G E - H I S T O R Y
	public List<Message> messageHistoryByUserId(@PathVariable Integer id){
		if(!users.containsKey(id))  throw new UserNotFoundException("No user with the given user id  exists.");
		
		List<Message> mg= new ArrayList<>();
		for(Map.Entry<Integer, Message> entry: messages.entrySet()){
			if(entry.getValue().getUserid()==id) mg.add(entry.getValue());
		}
		if(mg.size()==0) throw new UserNotFoundException("No message found with userId: " + id);
		return mg;
	}
	
	
	
	


	
	
}
