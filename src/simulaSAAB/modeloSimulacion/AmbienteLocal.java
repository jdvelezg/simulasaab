package simulaSAAB.modeloSimulacion;

import java.util.ArrayList;
import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

import repast.simphony.context.Context;
import repast.simphony.engine.schedule.ScheduledMethod;
import simulaSAAB.contextos.GeografiaFija;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;
import simulaSAAB.persistencia.RegionConfigurada;

public class AmbienteLocal implements GeografiaFija{
	
	
	private int AmbienteID;
	
	private String Nombre;
	
	private Geometry geometria;
	
	private String Clima;
	
	private String PisoTermico;
	
	private List<Producto> ProductosAgricolasViables;
	
	private List<SistemaActividadHumana> ActividadesViables;
	
	private List NodosSAAB;
	
	private List CentrosUrbanos;
	
	private List ViaPrincipal;
	
	
	/**
	 * Constructor
	 */
	public AmbienteLocal(){
		
	}
	
	
	public AmbienteLocal(RegionConfigurada r){
		
		this.AmbienteID	=r.getId();
		this.Nombre		=r.getNombre();
		this.Clima		=r.getClima();
		this.PisoTermico=r.getPisoTermico();
		
	}
	
	
	/**
	 * @return the productosAgricolasViables
	 */
	public List<Producto> getProductosAgricolasViables() {
		return ProductosAgricolasViables;
	}
	/**
	 * @return the actividadesViables
	 */
	public List<SistemaActividadHumana> getActividadesViables() {
		return ActividadesViables;
	}
	/**
	 * @return the actividadesViables
	 */
	public List<SistemaActividadHumana> getActividadesViables(Proposito p) {
		
		List<SistemaActividadHumana> matchlist = new ArrayList<SistemaActividadHumana>();
		
		for(SistemaActividadHumana a : this.ActividadesViables){
			
			if(a.getProposito().equals(p)){
				matchlist.add(a);
			}
		}
		
		return matchlist;
	}
	/**
	 * @return the ambienteID
	 */
	public int getAmbienteID() {
		return AmbienteID;
	}
	/**
	 * @param ambienteID the ambienteID to set
	 */
	public void setAmbienteID(int ambienteID) {
		AmbienteID = ambienteID;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return Nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	/**
	 * @return the clima
	 */
	public String getClima() {
		return Clima;
	}
	/**
	 * @param clima the clima to set
	 */
	public void setClima(String clima) {
		Clima = clima;
	}
	/**
	 * @return the pisoTermico
	 */
	public String getPisoTermico() {
		return PisoTermico;
	}
	/**
	 * @param pisoTermico the pisoTermico to set
	 */
	public void setPisoTermico(String pisoTermico) {
		PisoTermico = pisoTermico;
	}


	/**
	 * @return the geometria
	 */
	public Geometry getGeometria() {
		return geometria;
	}


	/**
	 * @param geometria the geometria to set
	 */
	public void setGeometria(Geometry geometria) {
		this.geometria = geometria;
	}
	
	
	

}
