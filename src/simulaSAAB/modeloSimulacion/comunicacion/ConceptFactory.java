package simulaSAAB.modeloSimulacion.comunicacion;

import simulaSAAB.main.Producto;
import simulaSAAB.persistencia.ProductoConfigurado;

public class ConceptFactory {
	
	public ConceptFactory(){	
	}
	
	/**
	 * @return un Proposito con enunciado -Realizar accion sobre el producto- 
	 *//*
	public Proposito crearProposito(String accion, Producto producto){		
		
		return new Proposito(accion,crearProducto(producto));
	}
	
	*//**
	 * @return un Proposito con enunciado -Realizar accion sobre el producto- 
	 *//*
	public Proposito crearProposito(String accion, ProductoConfigurado producto){		
		
		return new Proposito(accion,crearProducto(producto));
	}
	
	*//**
	 * @return Extrae el concepto de un objeto Producto
	 *//*
	public simulaSAAB.modeloSimulacion.comunicacion.Producto crearProducto(Producto producto){
		
		boolean agricola = producto.getTipo().equalsIgnoreCase("agricola"); 
		
		return new simulaSAAB.modeloSimulacion.comunicacion.Producto(producto.getNombre(),agricola);
	}
	
	*//**
	 * @return Extrae el concepto de un objeto ProductoConfigurado
	 *//*
	public simulaSAAB.modeloSimulacion.comunicacion.Producto crearProducto(ProductoConfigurado producto){
		
		boolean agricola = producto.getTipo().equalsIgnoreCase("agricola"); 
		
		return new simulaSAAB.modeloSimulacion.comunicacion.Producto(producto.getNombre(),agricola);
	}*/
	
	

}
