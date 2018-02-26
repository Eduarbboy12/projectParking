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

	public String getLastName() {
		return lastName;
	}

	public String getDocument() {
		return document;
	}

	public String getUser() {
		return user;
	}
	
}
