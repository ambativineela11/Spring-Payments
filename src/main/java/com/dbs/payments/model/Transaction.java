package com.dbs.payments.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_table")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slno;
	
	@Column(name = "sender_id")
	private String senderId;
	
	@Column(name = "receiver_id")
	private String receiverId;
	
	@Column
	private LocalDateTime dateTime;
	
	@Column(name = "amount_sent")
	private double amountSent;
	
	@Column
	private String transactionType;
	
	@Column
	private String receiverName;
	
	@Column
	private String messageCode;
	
	@Column
	private String bicCode;

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public double getAmountSent() {
		return amountSent;
	}

	public void setAmountSent(double amountSent) {
		this.amountSent = amountSent;
	}



	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	

	public String getBicCode() {
		return bicCode;
	}

	public void setBicCode(String bicCode) {
		this.bicCode = bicCode;
	}

	

	@Override
	public String toString() {
		return "Transaction [slno=" + slno + ", senderId=" + senderId + ", receiverId=" + receiverId + ", dateTime="
				+ dateTime + ", amountSent=" + amountSent + ", transactionType=" + transactionType + ", receiverName="
				+ receiverName + ", messageCode=" + messageCode + ", bicCode=" + bicCode + "]";
	}

	public Transaction(int slno, String senderId, String receiverId, LocalDateTime dateTime, double amountSent,
			String transactionType, String receiverName, String messageCode, String bicCode) {
		super();
		this.slno = slno;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.dateTime = dateTime;
		this.amountSent = amountSent;
		this.transactionType = transactionType;
		this.receiverName = receiverName;
		this.messageCode = messageCode;
		this.bicCode = bicCode;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
}
