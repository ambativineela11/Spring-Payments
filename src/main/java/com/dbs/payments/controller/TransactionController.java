package com.dbs.payments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.payments.model.Transaction;
import com.dbs.payments.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/transaction")
	public ResponseEntity<Transaction> insertTransaction(@RequestBody Transaction transaction) throws Exception
	{
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Transaction details added successfully.");
		return new ResponseEntity<Transaction>(transactionService.insertTransaction(transaction),headers,HttpStatus.CREATED);
	}
}
