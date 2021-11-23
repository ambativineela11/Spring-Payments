package com.dbs.payments.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slno;
	
	@Column(name = "sender_id")
	private int senderId;
	
	@Column(name = "receiver_id")
	private int receiverId;
	
	@Column
	private LocalDateTime dateTime;
	
	@Column(name = "amount_sent")
	private double amountSent;
	
	@Column
	private String transactionType;

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

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
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


	@Override
	public String toString() {
		return "Transaction [slno=" + slno + ", senderId=" + senderId + ", receiverId=" + receiverId + ", dateTime="
				+ dateTime + ", amountSent=" + amountSent + ", transactionType=" + transactionType + "]";
	}

	public Transaction(int slno, int senderId, int receiverId, LocalDateTime dateTime, double amountSent,
			String transactionType) {
		super();
		this.slno = slno;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.dateTime = dateTime;
		this.amountSent = amountSent;
		this.transactionType = transactionType;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
}
