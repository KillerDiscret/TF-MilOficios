package pe.edu.upc.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	@Column(name = "fullname", length = 100, nullable = false)
	private String fullname;
	
	@Column(name = "dni", length = 10, nullable = false)
	private String dni;
	
	@Column(name = "phone", length = 9, nullable = false)
	private String phone;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "birth", nullable = false)
	private Date birth;
	
	@Column(name = "address", length = 50, nullable = false)
	private String address;

	@Column(name = "email", length = 40, nullable = false)
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "idDistrito", nullable = false)
	private Distrito distrito;
	

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Empleado(int id, String fullname, String dni, String phone, Date birth, String address, String email,
			Distrito distrito) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.dni = dni;
		this.phone = phone;
		this.birth = birth;
		this.address = address;
		this.email = email;
		this.distrito = distrito;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Date getBirth() {
		return birth;
	}


	public void setBirth(Date birth) {
		this.birth = birth;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Distrito getDistrito() {
		return distrito;
	}


	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	
	
}
