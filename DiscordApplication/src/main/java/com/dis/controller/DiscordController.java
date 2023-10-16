package com.dis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dis.model.Channel;
import com.dis.model.Message;
import com.dis.model.Reaction;
import com.dis.model.User;
import com.dis.service.DiscordService;

import jakarta.validation.Valid;

@RestController
public class DiscordController {
 
	 
	 @Autowired
	 private DiscordService discordService;
	 
	 @GetMapping(value = "/users")
	 public ResponseEntity<List<User>> getAllUsers(){
		 return new ResponseEntity<List<User>>(discordService.getAllUsers(),HttpStatus.FOUND);
	 }
	 

	 @PostMapping(value = "/users")
	 public ResponseEntity<User> addNewUser(@Valid @RequestBody User user){
		 discordService.addNewUser(user);
		 return new ResponseEntity<User>(user,HttpStatus.CREATED);
	 }
	 
	 
	 @GetMapping(value = "/messages")
	 public ResponseEntity<List<Message>> getAllMessages(){
		 return new ResponseEntity<List<Message>>(discordService.getAllMessages(),HttpStatus.FOUND);
	 }
	 

	 @PostMapping(value = "/messages")
	 public ResponseEntity<Message> sendNewMesages(@Valid @RequestBody Message msg){
		 return new ResponseEntity<Message>(discordService.sendNewMessage(msg),HttpStatus.CREATED);
	 }
	 
	 
	 @GetMapping(value = "/reactions")
	 public ResponseEntity<List<Reaction>> getAllReactions(){
		 return new ResponseEntity<List<Reaction>>(discordService.getAllReactions(),HttpStatus.FOUND);
	 }
	 
	 @PostMapping(value = "/reactions")
	 public ResponseEntity<Reaction> addReaction(@Valid @RequestBody Reaction rct){
		 return new ResponseEntity<Reaction>(discordService.addReaction(rct),HttpStatus.CREATED);
	 }
	 
	 @GetMapping(value = "/messages/{id}")
	 public ResponseEntity<List<Message>>messageHistoryByUserId(@PathVariable Integer id){
		 return new ResponseEntity<List<Message>>(discordService.messageHistoryByUserId(id),HttpStatus.FOUND);
	 }

	 
	 
	 @GetMapping(value = "/channels")
	 public ResponseEntity<List<Channel>> getAllChannels(){
		 return new ResponseEntity<List<Channel>>(discordService.getAllChannels(),HttpStatus.FOUND);
	 }	 
	 
	 @PostMapping(value = "/channels")
	 public ResponseEntity<Channel> addNewChannel(@Valid @RequestBody Channel ch){
		 return new ResponseEntity<Channel>(discordService.createNewChannels(ch),HttpStatus.CREATED);
	 }
	
	 
	 
	 
}
