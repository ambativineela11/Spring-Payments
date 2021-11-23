package com.dbs.payments.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BIC")
public class Bic {
	
	@Id
	@Column(name = "bic_code")
	private String bicCode;
	
	@Column(name = "inst_name")
	private String instName;

	@Override
	public String toString() {
		return "Bic [bicCode=" + bicCode + ", instName=" + instName + "]";
	}

	public Bic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bic(String bicCode, String instName) {
		super();
		this.bicCode = bicCode;
		this.instName = instName;
	}

	public String getBicCode() {
		return bicCode;
	}

	public void setBicCode(String bicCode) {
		this.bicCode = bicCode;
	}

	public String getInstName() {
		return instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}
}
