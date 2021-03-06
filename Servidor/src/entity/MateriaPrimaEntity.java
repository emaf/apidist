package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import negocio.MateriaPrima;
import negocio.StockMateriaPrima;

@Entity
@Embeddable
@Table(name="MateriaPrima")
public class MateriaPrimaEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	private String nombre;
	private int minimo;
	
	@OneToMany(mappedBy="materiaPrima",cascade = CascadeType.ALL)
	private List<StockMateriaPrimaEntity> stock;
	
	public MateriaPrimaEntity(){
		this.stock = new ArrayList<>();
	}
	public MateriaPrimaEntity(MateriaPrima materiaPrima){
		this.codigo = materiaPrima.getCodigo();
		this.nombre = materiaPrima.getNombre();
		this.minimo = materiaPrima.getMinimo();
		this.stock = new ArrayList<StockMateriaPrimaEntity>();
		if(materiaPrima.getStock() != null){
			for (StockMateriaPrima stockMateriaPrima : materiaPrima.getStock()) {
				this.stock.add(new StockMateriaPrimaEntity(stockMateriaPrima, this));
			}
		}
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public List<StockMateriaPrimaEntity> getStock() {
		return stock;
	}

	public void setStock(List<StockMateriaPrimaEntity> stock) {
		this.stock = stock;
	}
	
}
