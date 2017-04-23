package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Embeddable
@Table(name="Empleado")
public class EmpleadoEntity implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int legajo;
	private String nombre;
	private String domicilio;
	private String telefono;
	
	public EmpleadoEntity(){}
	public EmpleadoEntity(String nombre, String domicilio, String telefono, int legajo){
		this.nombre=nombre;
		this.domicilio=domicilio;
		this.telefono=telefono;
		this.legajo=legajo;
	}

}
