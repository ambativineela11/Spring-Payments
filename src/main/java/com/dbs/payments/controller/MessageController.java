package com.dbs.payments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.payments.model.Message;
import com.dbs.payments.service.MessageService;

@RestController
public class MessageController {

	@Autowired
	MessageService msgService;
	
	@GetMapping("/getmsg/{msg_code}")
	public ResponseEntity<Message> getMessage(@PathVariable(name = "msg_code") String msgCode) throws Exception
	{
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "message code is available.");
		return new ResponseEntity<Message>(msgService.getMessage(msgCode), headers, HttpStatus.OK);
	}
}
