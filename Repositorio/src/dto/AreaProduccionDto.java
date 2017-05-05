package dto;

import java.util.ArrayList;


public class AreaProduccionDto {
	private String nombre;
	private ArrayList<LineaProduccionDto> lineasProduccion;
	private ArrayList<OrdenDeProduccionDto> ordenesProduccion;
	
	public AreaProduccionDto(String nombre,ArrayList<LineaProduccionDto> lineasProduccion,ArrayList<OrdenDeProduccionDto> ordenesProduccion){
		this.nombre=nombre;
		this.lineasProduccion= lineasProduccion;
		this.ordenesProduccion=ordenesProduccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<LineaProduccionDto> getLineasProduccion() {
		return lineasProduccion;
	}

	public void setLineasProduccion(ArrayList<LineaProduccionDto> lineasProduccion) {
		this.lineasProduccion = lineasProduccion;
	}

	public ArrayList<OrdenDeProduccionDto> getOrdenesProduccion() {
		return ordenesProduccion;
	}

	public void setOrdenesProduccion(ArrayList<OrdenDeProduccionDto> ordenesProduccion) {
		this.ordenesProduccion = ordenesProduccion;
	}
	
}
