package com.dbs.payments.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slno;
	
	@Column(name = "cust_id")
	private long customerId;
	
	@Column(name = "account_holder_name")
	private String accountHolderName;
	
	@Column(name = "clear_balance")
	private double clearBalance;
	
	@Column(name = "overdraft")
	private String overDraft;
	
	@ManyToOne
	@JoinColumn(name = "bic_code")
	private Bic bicCode;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int slno, long customerId, String accountHolderName, double clearBalance, String overDraft,
			Bic bicCode) {
		super();
		this.slno = slno;
		this.customerId = customerId;
		this.accountHolderName = accountHolderName;
		this.clearBalance = clearBalance;
		this.overDraft = overDraft;
		this.bicCode = bicCode;
	}

	@Override
	public String toString() {
		return "Customer [slno=" + slno + ", customerId=" + customerId + ", accountHolderName=" + accountHolderName
				+ ", clearBalance=" + clearBalance + ", overDraft=" + overDraft + ", bicCode=" + bicCode + "]";
	}

	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getClearBalance() {
		return clearBalance;
	}

	public void setClearBalance(double clearBalance) {
		this.clearBalance = clearBalance;
	}

	public String getOverDraft() {
		return overDraft;
	}

	public void setOverDraft(String overDraft) {
		this.overDraft = overDraft;
	}

	public Bic getBicCode() {
		return bicCode;
	}

	public void setBicCode(Bic bicCode) {
		this.bicCode = bicCode;
	}
}
