package com.w00k.rest.webservices.restwebservices.version;

public class Personv2 {
	private String name;
	private String lastName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Personv2(String name, String lastName) {
		super();
		this.name = name;
		this.lastName = lastName;
	}

}
