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
@Table(name="Habilidad")
public class Habilidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", length = 20, nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "idCurriculum", nullable = false)
	private Curriculum curriculum;

	public Habilidad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Habilidad(int id, String name, Curriculum curriculum) {
		super();
		this.id = id;
		this.name = name;
		this.curriculum = curriculum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}
	
	
	
	
}
