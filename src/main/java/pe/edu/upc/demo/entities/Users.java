package pe.edu.upc.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@Size(min = 3, max = 30)
	@NotEmpty(message = "Ingrese su usuario")
	@Column(length = 30, unique = true)
	private String username;

	
	@Size(min = 3)
	@NotEmpty(message = "Ingrese su contraseña")
	@Column(length = 200)
	private String password;

	@Column(name = "auxrole", length = 20)
	private String auxrole;

	private Boolean enabled;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Role> roles;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(Long id, String username, String password, String auxrole, Boolean enabled, List<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.auxrole = auxrole;
		this.enabled = enabled;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuxrole() {
		return auxrole;
	}

	public void setAuxrole(String auxrole) {
		this.auxrole = auxrole;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	

}