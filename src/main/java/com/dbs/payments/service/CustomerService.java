package com.dbs.payments.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.payments.model.Customer;
import com.dbs.payments.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository custRepository;

	public Customer getCustomerById(long custid) throws Exception {
		Optional<Customer> custOptional = custRepository.findByCustomerId(custid);
		if (custOptional != null)
			return custOptional.get();
		throw new Exception("This customer does not exist.");
		
//		if(custRepository.findByCustomerId(custid) != null)
//			return ;
	}

}
