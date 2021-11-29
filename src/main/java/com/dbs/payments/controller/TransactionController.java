package com.dbs.payments.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.payments.model.Message;
import com.dbs.payments.model.SuccessResponse;
import com.dbs.payments.model.Transaction;
import com.dbs.payments.service.MessageService;
import com.dbs.payments.service.TransactionService;

@CrossOrigin
@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@Autowired
	MessageService messageService;
	
	@PostMapping("/transaction")
	public ResponseEntity<SuccessResponse> insertTransaction(@RequestBody Transaction transaction)
	{
		HttpHeaders headers = new HttpHeaders();
		try
		{
		Message m = messageService.getMessage(transaction.getMessageCode());
		headers.add("message",m.getMsgDescription());
		LocalDateTime now = LocalDateTime.now();
		transaction.setDateTime(now);
		SuccessResponse s = new SuccessResponse(transactionService.insertTransaction(transaction),m.getMsgDescription(),true);
		return new ResponseEntity<SuccessResponse>(s,headers,HttpStatus.CREATED);
		//return new ResponseEntity<SuccessResponse>(new Transaction(),headers,HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			SuccessResponse s = new SuccessResponse(null,e.getMessage(),false);
			return new ResponseEntity<SuccessResponse>(s,headers,HttpStatus.ACCEPTED);
		}
	}
}
