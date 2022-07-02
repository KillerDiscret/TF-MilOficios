package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Curriculum")
public class Curriculum {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	private int id;
	
	@Column(name="description", length = 150, nullable = false)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "idEmpleado", nullable = false)
	private Empleado empleado;

	public Curriculum() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curriculum(int id, String description, Empleado empleado) {
		super();
		this.id = id;
		this.description = description;
		this.empleado = empleado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
	
}
