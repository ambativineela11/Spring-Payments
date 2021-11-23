package com.dbs.payments.service;

import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.payments.model.Customer;
import com.dbs.payments.model.Transaction;
import com.dbs.payments.repository.CustomerRepository;
import com.dbs.payments.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	CustomerRepository customerRepository;
	
	public Transaction insertTransaction(Transaction transaction) throws Exception {
		long senderId = transaction.getSenderId();
		double amount = transaction.getAmountSent();
		long receiverId = transaction.getReceiverId();
		if(checkSenderBalance(senderId, amount)&& checkReceiver(receiverId) && checkTransaferType(transaction.getTransactionType(),senderId,receiverId))
		{
			changeBalance(senderId, receiverId, amount);
			return transactionRepository.save(transaction);
		}
		throw new Exception("cannot transfer");
	}
	
	public Boolean checkSenderBalance(long senderId,double amount) {
		Optional<Customer> customerOptional =  customerRepository.findByCustomerId(senderId);
		if(customerOptional != null)
		{
			Customer customer = customerOptional.get();
		String overdraft = customer.getOverDraft();
		double clearBalance = customer.getClearBalance();
		double totalTransferableBal = amount + (0.0025)*amount;
		if(overdraft.equals("no"))
		{
			if(totalTransferableBal <= clearBalance)
			{
				return true;
			}
			return false;
		}
		return true;
		}
		return false;
		}
	
	public Boolean checkReceiver(long receiverId)
	{
		Optional<Customer> customerOptional =  customerRepository.findByCustomerId(receiverId);
		if(customerOptional.isPresent())
			return true;
		return false;
	}
	
	public void changeBalance(long senderId,long receiverId,double amount)
	{
		Customer sender = getCustomer(senderId);
		Customer receiver = getCustomer(receiverId);
		Customer senderWithNewBalance = new Customer(sender.getSlno(),sender.getCustomerId(),sender.getAccountHolderName(),sender.getClearBalance()-amount,sender.getOverDraft(),sender.getBicCode());
		customerRepository.save(senderWithNewBalance);
		Customer receiverWithNewBalance = new Customer(receiver.getSlno(),receiver.getCustomerId(),receiver.getAccountHolderName(),receiver.getClearBalance()+amount,receiver.getOverDraft(),receiver.getBicCode());
		customerRepository.save(receiverWithNewBalance);
	}
	
	public Customer getCustomer(long customerId)
	{
		Optional<Customer> customerOptional =  customerRepository.findByCustomerId(customerId);
		return customerOptional.get();
	}

	public boolean checkTransaferType(String ttype,long c_acct,long r_acct)
	{
	
		if(ttype.equals("bank"))
		{
			String c_name = customerRepository.findByCustomerId(c_acct).get().getAccountHolderName();
			String r_name = customerRepository.findByCustomerId(r_acct).get().getAccountHolderName();
			
			boolean match1 = Pattern.matches("HDFC Bank[.]*", c_name);
			boolean match2 = Pattern.matches("HDFC Bank[.]*", r_name);
			
			if(match1 && match2)
				return true;
			else
				return false;
		
		}
		else if(ttype.equals("customer"))
		{
			String c_name = customerRepository.findByCustomerId(c_acct).get().getAccountHolderName();
			
			boolean match1 = Pattern.matches("HDFC Bank[.]*", c_name);
			
			if(!match1)
				return true;
			else
				return false;
		}
		return false;
	}

}
