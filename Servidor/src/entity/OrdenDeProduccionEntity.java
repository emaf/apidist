package entity;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;


@Entity 
@Table(name="OrdenDeProduccion") 
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name="discriminator",discriminatorType=DiscriminatorType.STRING) 
@DiscriminatorValue(value="default")
public abstract class OrdenDeProduccionEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int nroOrden;
	
	private String estado;
	
	@OneToMany()
	@JoinColumn(name="ordenDeProduccion_id")
	private List<MateriaPrimaEntity> materiaPrimaReservada;
	
	private int confeccionesTerminadas;
	
	@OneToMany()
	@JoinColumn(name="ordenDeProduccion_id")
	private List<PrendaEntity> prendas;
	
	@OneToOne()
	private PedidoPrendasEntity pedidoPrenda;
	
	public OrdenDeProduccionEntity(){}
	public OrdenDeProduccionEntity(int nroOrden, String estado, List<MateriaPrimaEntity> materiaPrimaReservada, PedidoPrendasEntity pedidoPrenda, List<PrendaEntity> prendas){
		this.estado=estado;
		this.materiaPrimaReservada=materiaPrimaReservada;
		this.confeccionesTerminadas=0;
		this.pedidoPrenda=pedidoPrenda;
		this.prendas=prendas;
		this.nroOrden = nroOrden;
	}

}