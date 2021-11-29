package com.dbs.payments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.payments.model.Customer;
import com.dbs.payments.service.CustomerService;

@CrossOrigin
@RestController
public class CustomerController {

	@Autowired
	CustomerService custService;
	
	@GetMapping("/getcustomer/{customer_id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(name = "customer_id") long custid) throws Exception
	{
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Customer is available.");
		return new ResponseEntity<Customer>(custService.getCustomerById(custid), headers, HttpStatus.OK);
	}
}
