package negocio;

import dto.ItemPrendaDto;
import entity.OrdenDeProduccionEntity;

public class ItemPrenda {

	private int cantidad;
	private String talle;
	private String color;
	private float importe;
	private Prenda prenda;
	private OrdenDeProduccion lote;
	
	public ItemPrenda(int cantidad, String talle, String color,float importe, Prenda prenda, OrdenDeProduccion lote ){
		this.cantidad=cantidad;
		this.talle=talle;
		this.color=color;
		this.importe=importe;
		this.prenda=prenda;
		this.lote = lote;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}

	public OrdenDeProduccion getLote() {
		return lote;
	}

	public void setLote(OrdenDeProduccion lote) {
		this.lote = lote;
	}

	public boolean hayStocksuficiente(){
		return true;
	}
	
	public ItemPrendaDto toDto(){
		return new ItemPrendaDto(cantidad, talle, color, importe, prenda.toDto(), lote.toDto());
	}
}
