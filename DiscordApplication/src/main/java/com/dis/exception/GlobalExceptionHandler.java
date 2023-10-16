package com.dis.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {
           
	@ExceptionHandler(DuplicateMessageIdException.class)
	public ResponseEntity<ErrorDetails> duplicateMessageIdExceptionHandler (DuplicateMessageIdException dme, WebRequest wr) {
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), dme.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DuplicateReactionIdException.class)
	public ResponseEntity<ErrorDetails> duplicateReactionIdExceptionHandler (DuplicateReactionIdException dre, WebRequest wr) {
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), dre.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DuplicateUserException.class)
	public ResponseEntity<ErrorDetails> duplicateUserExceptionHandler (DuplicateUserException due, WebRequest wr) {
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), due.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException .class)
	public ResponseEntity<ErrorDetails> methodArgumentNotValidExceptionHandler (MethodArgumentNotValidException manv,  WebRequest wr) {
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), manv.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDetails> userNotFoundExceptionHandler (UserNotFoundException unf, WebRequest wr) {
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), unf.getMessage(), wr.getDescription(false) );
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MessageNotFoundException.class)
	public ResponseEntity<ErrorDetails> messageNotFoundExceptionHandler (MessageNotFoundException unf, WebRequest wr) {
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), unf.getMessage(), wr.getDescription(false) );
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
