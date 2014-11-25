package com.moon.domain;

// Generated 2014-9-28 13:03:56 by Hibernate Tools 3.4.0.CR1

/**
 * Customers generated by hbm2java
 */
public class Customers implements java.io.Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -116871931641757079L;
	private int id;
	private Address comAddress;
	private Address homeAddress;
	private String name;

	public Customers() {
	}

	public Customers(int id, Address comAddress, Address homeAddress,
			String name) {
		this.id = id;
		this.comAddress = comAddress;
		this.homeAddress = homeAddress;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getComAddress() {
		return comAddress;
	}

	public void setComAddress(Address comAddress) {
		this.comAddress = comAddress;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	@Override
	public String toString() {
		return id + " " + name;
	}
}