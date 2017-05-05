package dto;

import java.util.ArrayList;



public class AdministracionDto {
	private ArrayList<ClienteDto> clientes;
	private ArrayList<PrendaDto> prendas;
	
	public AdministracionDto(ArrayList<ClienteDto> clientes,ArrayList<PrendaDto> prendas){
		this.clientes=clientes;
		this.prendas=prendas;
	}

	public ArrayList<ClienteDto> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<ClienteDto> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<PrendaDto> getPrendas() {
		return prendas;
	}

	public void setPrendas(ArrayList<PrendaDto> prendas) {
		this.prendas = prendas;
	}
	
	
}
