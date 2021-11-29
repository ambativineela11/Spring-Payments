package com.dbs.payments.model;


public class SuccessResponse {
	
	private Transaction transaction ;
	
	private String message;

	private boolean isValid;
	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SuccessResponse(Transaction transaction, String message,boolean isValid) {
		super();
		this.transaction = transaction;
		this.message = message;
		this.isValid = isValid;
	}

	

	public boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	
	
	
	
	

}
