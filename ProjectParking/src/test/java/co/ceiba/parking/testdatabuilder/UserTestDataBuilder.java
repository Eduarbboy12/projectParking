package co.ceiba.parking.testdatabuilder;

import co.ceiba.parking.dominio.User;

public class UserTestDataBuilder {
	
	private static final String NAME = "Carlos";
	private static final String LASTNAME = "Diaz";
	private static final String DOCUMENT = "11022201522";
	private static final String USER = "cardia01";
	
	private String name;
	private String lastName;
	private String document;
	private String user;
	
	public UserTestDataBuilder () {
		this.name = NAME;
		this.lastName = LASTNAME;
		this.document = DOCUMENT;
		this.user = USER;
	}
	
	public UserTestDataBuilder conName(String name) {
		this.name = name;
		return this;
	}
	
	public UserTestDataBuilder conLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public UserTestDataBuilder conDocument(String document) {
		this.document = document;
		return this;
	}
	
	public UserTestDataBuilder conUser(String user) {
		this.user = user;
		return this;
	}
	
	public User build() {
		return new User(this.name, this.lastName, this.document, this.user);
	}

}
