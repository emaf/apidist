package negocio;

import entity.OrdenDeProduccionCompletaEntity;

public class OrdenProduccionCompleta extends OrdenDeProduccion{

	public OrdenProduccionCompleta(int nroOrden, EstadoOrdenProduccion estado, PedidoPrendas pedido, Prenda prenda) {
		super(nroOrden, estado, pedido,prenda);
	}
	
	public OrdenProduccionCompleta(EstadoOrdenProduccion estado, PedidoPrendas pedido, Prenda prenda) {
		super(estado,pedido,prenda);
	}
	
	public OrdenProduccionCompleta(OrdenDeProduccionCompletaEntity lote) {
		super(lote);
	}
	
	public OrdenProduccionCompleta() {
		super();
	}
	
	@Override
	public int getCantidad() {
		// TODO Auto-generated method stub
		return 0;
	}
}
