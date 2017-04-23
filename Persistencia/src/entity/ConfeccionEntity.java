package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Confeccion")
public class ConfeccionEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne(targetEntity=PrendaEntity.class)
	private PrendaEntity prenda;
	
	private int tiempoProd;
	private String detalle;
	
	@OneToMany(mappedBy="confeccion")
	private List<AreaProduccionEntity> areaProduccion;
	
	@OneToMany(mappedBy="confeccion")
	private List<InsumoEntity> insumos;
	
	public ConfeccionEntity(){}

}
