package negocio;

import java.util.ArrayList;

import dto.MateriaPrimaDto;
import dto.StockMateriaPrimaDto;
import entity.MateriaPrimaEntity;
import entity.StockMateriaPrimaEntity;

public class MateriaPrima {

	private String nombre;
	private int codigo;
	private int minimo;
	private ArrayList<StockMateriaPrima> stock;
	private OrdenDeCompra ordenDeCompra;
	
	public MateriaPrima( MateriaPrimaEntity materia){
		ArrayList<StockMateriaPrima> stockMateria = new ArrayList<StockMateriaPrima>();
		for (StockMateriaPrimaEntity stockMateriaPrimaEntity : materia.getStock()) 
			stockMateria.add(new StockMateriaPrima(stockMateriaPrimaEntity, this));

		this.stock=stockMateria;
		this.nombre=materia.getNombre();
		this.codigo=materia.getCodigo();
		this.minimo=materia.getMinimo();
	}
	
	public MateriaPrima( String nombre, int codigo, int minimo){
		this.stock=new ArrayList<StockMateriaPrima>();
		this.nombre=nombre;
		this.codigo=codigo;
		this.minimo=minimo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getMinimo() {
		return minimo;
	}
	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}
	public ArrayList<StockMateriaPrima> getStock() {
		return stock;
	}
	public void setStock(ArrayList<StockMateriaPrima> stock) {
		this.stock = stock;
	}
	public boolean tenesStock(int cantidad){
		return true;
	}
	public OrdenDeCompra getOrdenDeCompra() {
		return ordenDeCompra;
	}
	public void setOrdenDeCompra(OrdenDeCompra ordenDeCompra) {
		this.ordenDeCompra = ordenDeCompra;
	}
	
	public Float calcularPrecioCosto(int cantidadNecesaria){
		Float costo=0F;
		
		for (StockMateriaPrima stockMateriaPrima : stock) {
			if(cantidadNecesaria > 0){
				
				if(stockMateriaPrima.getCantidad()-cantidadNecesaria >= 0){
					
					costo = costo + ( cantidadNecesaria * stockMateriaPrima.getPrecioFinalCompra() );
					
					cantidadNecesaria = 0;
				}else{
					
					cantidadNecesaria = cantidadNecesaria - stockMateriaPrima.getCantidad();
					
					costo = costo + ( stockMateriaPrima.getCantidad() *stockMateriaPrima.getPrecioFinalCompra() );
				}
			}
		}
		
		return costo;
	}
	
	public MateriaPrimaDto toDto(){
		MateriaPrimaDto mpDto = new MateriaPrimaDto(nombre, codigo, minimo); 

		ArrayList<StockMateriaPrimaDto> stockDto = new ArrayList<>();
		for (StockMateriaPrima stockMateriaPrima : stock)
			stockDto.add(stockMateriaPrima.toDto(mpDto));
		
		mpDto.setStock(stockDto);
		
		return mpDto;
	}
}
