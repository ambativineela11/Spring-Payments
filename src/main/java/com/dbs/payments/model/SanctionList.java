package com.dbs.payments.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sanctionlist")
public class SanctionList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slno;
	
	@Column
	private String name;

	public SanctionList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SanctionList(int slno, String name) {
		super();
		this.slno = slno;
		this.name = name;
	}

	public SanctionList(Boolean sanctionName) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SanctionList [slno=" + slno + ", name=" + name + "]";
	}

	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
