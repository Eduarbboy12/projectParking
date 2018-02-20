package co.ceiba.parking.dominio;

public class User {
	
	private String name;
	private String lastName;
	private String document;
	private String user;
	
	public User(String name, String lastName, String document, String user) {
		this.name = name;
		this.lastName = lastName;
		this.document=document;
		this.user=user;
	}

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

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
}
