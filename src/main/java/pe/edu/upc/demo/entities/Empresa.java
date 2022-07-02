package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ruc", length = 10, nullable = false)
	private String ruc;

	@Column(name = "name", length = 20, nullable = false)
	private String name;

	@Column(name = "phone", length = 9, nullable = false)
	private String phone;

	@Column(name = "address", length = 50, nullable = false)
	private String address;

	@Column(name = "email", length = 40, nullable = false)
	private String email;

	public Empresa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empresa(int id, String ruc, String name, String phone, String address, String email) {
		super();
		this.id = id;
		this.ruc = ruc;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	
	
	
	
	
	
}
