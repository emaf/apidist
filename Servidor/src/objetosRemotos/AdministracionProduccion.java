package objetosRemotos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import controller.Controller;
import controller.DespachoController;
import dto.AreaProduccionDto;
import dto.EmpleadoDto;
import dto.MateriaPrimaDto;
import dto.PedidoPrendasDto;
import dto.SucursalDto;
import interfaces.AdministracionProduccionInterface;

public class AdministracionProduccion extends UnicastRemoteObject implements AdministracionProduccionInterface {

	private static final long serialVersionUID = 1L;

	public AdministracionProduccion() throws RemoteException {
		super();
	}

	public ArrayList<AreaProduccionDto> getAreasProduccion() throws RemoteException{
		return Controller.getInstance().GetAreasProduccion();
	}

	public ArrayList<MateriaPrimaDto> getMateriasPrimas() throws RemoteException {
		return Controller.getInstance().GetMateriasPrimas();
	}

	public ArrayList<SucursalDto> getSucursales() throws RemoteException {
		return Controller.getInstance().getSucursales();
	}

	public void despacharPedido(PedidoPrendasDto pedidoDto, EmpleadoDto encargadoDto) throws RemoteException {
		DespachoController.getInstance().despacharPedido(pedidoDto, encargadoDto);
	}

	public ArrayList<PedidoPrendasDto> GetPedidosADespachar() throws RemoteException {
		return DespachoController.getInstance().GetPedidosADespachar();
	}
	

}
