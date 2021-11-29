package com.dbs.payments.service;

import java.util.ArrayList;
import java.util.Optional;

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
	@Autowired
	SanctionService sanctionService;
	
	public Transaction insertTransaction(Transaction transaction) throws Exception {
		String senderId = transaction.getSenderId();
		double amount = transaction.getAmountSent();
		String receiverId = transaction.getReceiverId();
		if(transaction.getSenderId().equals(transaction.getReceiverId()))
		{
			throw new Exception("sender and receiver id are same");
		}
		if(!isValidUser(transaction.getReceiverName()))
		{
			throw new Exception("user is not valid");
		}
		if(checkTransaferType(transaction.getTransactionType(),senderId,receiverId) && checkReceiver(receiverId) && checkSenderBalance(senderId, amount))
		{
			
			changeBalance(senderId, receiverId, amount);
			return transactionRepository.save(transaction);
		}
		throw new Exception("Cannot Transfer");
	}
	
	private boolean isValidUser(String receiverName) {
		return sanctionService.getSanctionName(receiverName);

	}

	public Boolean checkSenderBalance(String senderId,double amount) throws Exception {
		Optional<Customer> customerOptional =  customerRepository.findByCustomerId(Long.parseLong(senderId));
		if(customerOptional != null)
		{
			Customer customer = customerOptional.get();
		String overdraft = customer.getOverDraft();
		double clearBalance = customer.getClearBalance();
		double totalTransferableBal = amount + (0.0025)*amount;
		if(overdraft.toLowerCase().equals("no"))
		{
			if(totalTransferableBal <= clearBalance)
			{
				return true;
			}
			throw new Exception("Insufficient Balance");
			//return false;
		}
		return true;
		}
		throw new Exception("Invalid Sender");
		//return false;
		}
	
	public Boolean checkReceiver(String receiverId) throws Exception
	{
		Optional<Customer> customerOptional =  customerRepository.findByCustomerId(Long.parseLong(receiverId));
		if(customerOptional.isPresent())
			return true;
		throw new Exception("Receiver id is not present");
		//return false;
	}
	
	public void changeBalance(String senderId,String receiverId,double amount)
	{
		Customer sender = getCustomer(senderId);
		Customer receiver = getCustomer(receiverId);
		Customer senderWithNewBalance = new Customer(sender.getSlno(),sender.getCustomerId(),sender.getAccountHolderName(),sender.getClearBalance()-amount,sender.getOverDraft());
		customerRepository.save(senderWithNewBalance);
		Customer receiverWithNewBalance = new Customer(receiver.getSlno(),receiver.getCustomerId(),receiver.getAccountHolderName(),receiver.getClearBalance()+amount,receiver.getOverDraft());
		customerRepository.save(receiverWithNewBalance);
	}
	
	public Customer getCustomer(String customerId)
	{
		Optional<Customer> customerOptional =  customerRepository.findByCustomerId(Long.parseLong(customerId));
		return customerOptional.get();
	}

	public boolean checkTransaferType(String ttype,String c_acct,String r_acct) throws Exception
	{
	
		if(ttype.toLowerCase().equals("bank"))
		{
			String c_name = customerRepository.findByCustomerId(Long.parseLong(c_acct)).get().getAccountHolderName();
			String r_name = customerRepository.findByCustomerId(Long.parseLong(r_acct)).get().getAccountHolderName();
			
////			boolean match1 = Pattern.matches("HDFC Bank", c_name.toLowerCase());
////			boolean match2 = Pattern.matches("HDFC Bank", r_name.toLowerCase());
////			
//			if(c_name.contains("HDFC BANK") && r_name.contains("HDFC BANK"))
//				return true;
//			else
//				throw new Exception("Bank type is not supported");
//				//return false;
			ArrayList<String> names =  new ArrayList<String>();
			names.add("HDFC BANK -(C1-A)");
			names.add("HDFC BANK -(B1-A)");
			names.add("HDFC BANK -(H0-A)");
			if(names.contains(c_name) && names.contains(r_name))
				return true;
			throw new Exception("Bank type is not supported");
		
		}
		else if(ttype.toLowerCase().equals("customer"))
		{
			String c_name = customerRepository.findByCustomerId(Long.parseLong(c_acct)).get().getAccountHolderName();
			
			//boolean match1 = Pattern.matches("HDFC Bank", c_name.toLowerCase());
			
			if(c_name.indexOf("HDFC BANK") == -1)
				return true;
			else
				throw new Exception("Customer type is not supported");

		}
		throw new Exception("Invalid transfer type");
		//return false;
	}

}
