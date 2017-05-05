package negocio;

import java.util.Date;

import dto.StockMateriaPrimaDto;
import dto.StockPrendaDto;

public class StockPrenda {
	private String color;
	private String talle;
	private OrdenDeProduccion lote;
	private Date fecha;
	private float costoProduccion;
	private int cantidad;
	private String ubicacion;
	private String estado;
	private Prenda prenda;
	private OrdenDeProduccion ordenProduccion;
	
	public StockPrenda(String color,String talle,OrdenDeProduccion lote,Date fecha,float costoProduccion,int cantidad,
			String ubicacion,String estado,Prenda prenda,OrdenDeProduccion ordenProduccion){
		this.color=color;
		this.talle=talle;
		this.lote=lote;
		this.fecha=fecha;
		this.costoProduccion=costoProduccion;
		this.cantidad=cantidad;
		this.ubicacion=ubicacion;
		this.estado=estado;
		this.prenda=prenda;
		this.ordenProduccion=ordenProduccion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}

	public OrdenDeProduccion getLote() {
		return lote;
	}

	public void setLote(OrdenDeProduccion lote) {
		this.lote = lote;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getCostoProduccion() {
		return costoProduccion;
	}

	public void setCostoProduccion(float costoProduccion) {
		this.costoProduccion = costoProduccion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}

	public OrdenDeProduccion getOrdenProduccion() {
		return ordenProduccion;
	}

	public void setOrdenProduccion(OrdenDeProduccion ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}
	
	public StockPrendaDto toDto(){
		return new StockPrendaDto(color, talle, lote.toDto(), fecha, costoProduccion, cantidad, ubicacion, estado,
				prenda.toDto(),ordenProduccion.toDto());
	}

}
