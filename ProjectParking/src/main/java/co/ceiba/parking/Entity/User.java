package co.ceiba.parking.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	private long Id;
	
	public User(Long Id) {
		this.Id = Id;
	}
	
	@Column(name = "Nombre")
    private String Nombre;
	
	@Column(name = "Apellido")
    private String Apellido;
	
	@Column(name = "Documento", nullable = false, unique = true)
    private String Documento;
	
	@Column(name = "Telefono")
    private String Telefono;
	
	@Column(name = "Direccion")
    private String Direccion;
	
	@Column(name = "Mail", nullable = false, unique = true)
    private String Mail;
	
	@Column(name = "Clave")
    private String Clave;
	
	private transient String confirmPassword;
	
	public User(String Nombre, String Apellido, String Documento, String Telefono, String Direccion, String Mail, String Clave) {
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.Documento=Documento;
		this.Telefono=Telefono;
		this.Direccion=Direccion;
		this.Mail=Mail;
		this.Clave=Clave;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	// GETTERS
	
	public Long getId() {
		return Id;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public String getApellido() {
		return Apellido;
	}
	
	public String getDocumento() {
		return Documento;
	}
	
	public String getDireccion() {
		return Direccion;
	}
	
	public String getTelefono() {
		return Telefono;
	}
	
	public String getMail() {
		return Mail;
	}
	
	public String getClave() {
		return Clave;
	}
	
	//SETTERS
	
	public void setId(Long Id) {
		this.Id = Id;
	}
	
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	
	public void setApellido(String Apellido) {
		this.Apellido = Apellido;
	}
	
	public void setDocumento(String Documento) {
		this.Documento = Documento;
	}
	
	public void setDireccion(String Direccion) {
		this.Direccion = Direccion;
	}
	
	public void setTelefono(String Telefono) {
		this.Telefono = Telefono;
	}
	
	public void setMail(String Mail) {
		this.Mail = Mail;
	}
	
	public void setClave(String Clave) {
		this.Clave = Clave;
	}
	
	public String getConfirmPassword() {
        return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
	        this.confirmPassword = confirmPassword;
	}
	

}
