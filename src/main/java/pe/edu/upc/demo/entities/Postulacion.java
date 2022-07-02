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
@Table(name="Postulacion")
public class Postulacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "state", length = 20, nullable = false)
	private String state;
	
	@ManyToOne
	@JoinColumn(name = "idEmpleado", nullable = false)
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name = "idConvocatoria", nullable = false)
	private Convocatoria convocatoria;

	public Postulacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Postulacion(int id, String state, Empleado empleado, Convocatoria convocatoria) {
		super();
		this.id = id;
		this.state = state;
		this.empleado = empleado;
		this.convocatoria = convocatoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Convocatoria getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(Convocatoria convocatoria) {
		this.convocatoria = convocatoria;
	}
	
	
	
}
