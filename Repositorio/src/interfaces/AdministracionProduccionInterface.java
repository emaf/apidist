package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.AreaProduccionDto;
import dto.EmpleadoDto;
import dto.MateriaPrimaDto;
import dto.PedidoPrendasDto;
import dto.SucursalDto;

public interface AdministracionProduccionInterface extends Remote{

	public ArrayList<AreaProduccionDto> getAreasProduccion() throws RemoteException;
	
	public ArrayList<MateriaPrimaDto> getMateriasPrimas() throws RemoteException;
	
	public ArrayList<SucursalDto> getSucursales() throws RemoteException;
	
	public void despacharPedido(PedidoPrendasDto pedidoDto, EmpleadoDto encargadoDto) throws RemoteException;
	
	public ArrayList<PedidoPrendasDto> GetPedidosADespachar() throws RemoteException;
}
