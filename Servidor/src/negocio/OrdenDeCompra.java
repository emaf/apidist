package negocio;

import java.util.Date;

import dto.OrdenDeCompraDto;

public class OrdenDeCompra {

	private Date fechaGeneracion;
	private Date fechaProbableDespacho;
	private Date fechaRealDespacho;
	private int cantidad;
	private float precioUnitario;
	private OrdenDeProduccion ordenProduccion;
	private Proveedor proveedor;
	
	public OrdenDeCompra(Date fechaGeneracion,Date fechaProbableDespacho,Date fechaRealDespacho,int cantidad,
			float precioUnitario,OrdenDeProduccion ordenProduccion,Proveedor proveedor){
		this.fechaGeneracion=fechaGeneracion;
		this.fechaProbableDespacho=fechaProbableDespacho;
		this.fechaRealDespacho=fechaRealDespacho;
		this.cantidad=cantidad;
		this.precioUnitario=precioUnitario;
		this.ordenProduccion=ordenProduccion;
		this.proveedor=proveedor;
	}
	
	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public Date getFechaProbableDespacho() {
		return fechaProbableDespacho;
	}

	public void setFechaProbableDespacho(Date fechaProbableDespacho) {
		this.fechaProbableDespacho = fechaProbableDespacho;
	}

	public Date getFechaRealDespacho() {
		return fechaRealDespacho;
	}

	public void setFechaRealDespacho(Date fechaRealDespacho) {
		this.fechaRealDespacho = fechaRealDespacho;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public OrdenDeProduccion getOrdenProduccion() {
		return ordenProduccion;
	}

	public void setOrdenProduccion(OrdenDeProduccion ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public float calcularPrecioFinal(){
		return this.precioUnitario*this.cantidad;
	}
	
	public OrdenDeCompraDto toDto(){
		return new OrdenDeCompraDto(fechaGeneracion, fechaProbableDespacho, fechaRealDespacho, cantidad, precioUnitario,
				ordenProduccion.toDto(), proveedor.toDto());
	}
}
