package com.example.testproject.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.testproject.exceptions.InvalidInputFault;
import com.example.testproject.exceptions.IssueAlreadyExistException;
import com.example.testproject.exceptions.IssueNotFoundException;
import com.example.testproject.exceptions.NoDataFoundFault;
import com.example.testproject.model.Message;
import com.example.testproject.model.MessageType;

@ControllerAdvice
public class AutomationIssueServiceResponseHandler {
	@ExceptionHandler({ InvalidInputFault.class})
	public ResponseEntity<Object> handleInvalidInputFaultException(Exception ex, WebRequest request){
		Message msg = new Message.Builder(100, MessageType.ERROR,ex.getMessage()).build();
		return new ResponseEntity<Object>(msg, new HttpHeaders(), HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@ExceptionHandler({ IssueNotFoundException.class})
	public ResponseEntity<Object> handleIssueNotFoundException(Exception ex, WebRequest request){
		Message msg = new Message.Builder(101, MessageType.ERROR,ex.getMessage()).build();
		return new ResponseEntity<Object>(msg, new HttpHeaders(), HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@ExceptionHandler({ NoDataFoundFault.class})
	public ResponseEntity<Object> handleNoDataFoundFaultException(Exception ex, WebRequest request){
		Message msg = new Message.Builder(102, MessageType.ERROR,ex.getMessage()).build();
		return new ResponseEntity<Object>(msg, new HttpHeaders(), HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@ExceptionHandler({ IssueAlreadyExistException.class})
	public ResponseEntity<Object> handleIssueAlreadyExistException(Exception ex, WebRequest request){
		Message msg = new Message.Builder(104, MessageType.ERROR,ex.getMessage()).build();
		return new ResponseEntity<Object>(msg, new HttpHeaders(), HttpStatus.SERVICE_UNAVAILABLE);
	}
}
