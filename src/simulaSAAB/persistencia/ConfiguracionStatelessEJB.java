package simulaSAAB.persistencia;

import java.util.List;

import simulaSAAB.main.Producto;
import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;

public class ConfiguracionStatelessEJB {
	
	private String ordenpordefecto;//ASC o DSC
	
	
	/*
	 * @param orden: 'ASC' si se desea obtener las listas en orden ascendente. 'DSC' en caso opuesto 
	 */
	public ConfiguracionStatelessEJB(String orden){
		this.ordenpordefecto = orden;
	}
	
	
	public ProductoConfigurado obtenerProductosConfigurados(){
		
		return null;
	}
	
	public List<Producto> obtenerProductosConfigurados(List<Producto> productos){		
		
		//Busca de los productos de la lista por utilidad en orden "ordenpordefecto"
		
		//devuelve lista de productos ordenados 
		return null;
	}
	
	public ProductoConfigurado obtenerProductoConfigurado(int id){
		
		return null;
	}
	
	public ProductoConfigurado obtenerProductoConfigurado(String nombre){
		
		return null;
	}
	
	public List<SistemaActividadHumana> obtenerActividadesConfiguradas(List<SistemaActividadHumana> actividades){
		
		//Busca las actividades de la lista por utilidad en orden "ordenpordefecto"

		//devuelve la lista de actividades ordenada
		return null;
	}

}
