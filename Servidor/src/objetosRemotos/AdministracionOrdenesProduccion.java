package objetosRemotos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import controller.AreaProduccionController;
import dto.AreaProduccionDto;
import dto.OrdenDeProduccionDto;
import exceptions.AreaProduccionException;
import exceptions.RemoteObjectNotFoundException;
import interfaces.AdministracionOrdenesProduccionInterface;

public class AdministracionOrdenesProduccion extends UnicastRemoteObject implements AdministracionOrdenesProduccionInterface{

	private static final long serialVersionUID = 1L;

	public AdministracionOrdenesProduccion() throws RemoteException {
		super();
	}

	public ArrayList<OrdenDeProduccionDto> getOrdenesAreaProduccion(AreaProduccionDto area) throws RemoteException {
		return AreaProduccionController.getInstance().getOrdenesProduccion(area);
	}

	public void IniciarProduccion(OrdenDeProduccionDto ordenDto, AreaProduccionDto areaDto) throws RemoteObjectNotFoundException, AreaProduccionException {
		AreaProduccionController.getInstance().IniciarProduccion(ordenDto, areaDto);
	}

}
