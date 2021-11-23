package com.dbs.payments.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message {

	@Id
	@Column(name = "msg_code")
	private String msgCode;
	
	@Column(name = "msg_Description")
	private String msgDescription;
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(String msgCode, String msgDescription) {
		super();
		this.msgCode = msgCode;
		this.msgDescription = msgDescription;
	}

	@Override
	public String toString() {
		return "Message [msgCode=" + msgCode + ", msgDescription=" + msgDescription + "]";
	}

	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}

	public String getMsgDescription() {
		return msgDescription;
	}

	public void setMsgDescription(String msgDescription) {
		this.msgDescription = msgDescription;
	}

	
}
