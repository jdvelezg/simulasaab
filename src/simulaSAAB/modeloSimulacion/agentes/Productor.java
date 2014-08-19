package simulaSAAB.modeloSimulacion.agentes;

import java.util.ArrayList;
import java.util.List;

import repast.simphony.engine.schedule.ScheduledMethod;
import simulaSAAB.modeloSimulacion.Producto;
import simulaSAAB.modeloSimulacion.Terreno;
import simulaSAAB.modeloSimulacion.comunicacion.Item;
import simulaSAAB.modeloSimulacion.comunicacion.Objetivo;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.modeloSimulacion.comunicacion.Utilidad;
import simulaSAAB.modeloSimulacion.comunicacion.Experiencia;
import simulaSAAB.modeloSimulacion.inteligencia.CerebroProductor;
import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;
import simulaSAAB.persistencia.AgenteConfigurado;

public class Productor extends ActorDeAbastecimiento {
	
	private int AgentID;
	
	private String Nombre;
	
	private String Estado;
	
	private Objetivo Objetivo;
	
	private Item Dinero;

	private List<Terreno> TerrenosCultivables;
	
	private CerebroProductor CerebroProductor;
	
	private Proposito PropositoVigente;
	
	private SistemaActividadHumana actividadVigente;
	
	private List<Experiencia> Experiencia;
	
	/**
	 * Constructor de la clase Productor
	 * @param tipo: Clasifica al productor
	 */
	public Productor(String tipo){		
		
		AgenteConfigurado agt 	=new AgenteConfigurado("Productor");
		this.Nombre				=agt.getTipo();
		this.Objetivo 			=agt.getObjetivo();
		this.CerebroProductor	=new CerebroProductor(this);
		
		this.estado = "IDLE";
	}

	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void receiveMessage() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Producto> atribuirSignificadoAlMundoPercibido() {
		// TODO Auto-generated method stub
		
		List<Producto> ProductosCultivables = new ArrayList();
		
		// Identificar recursos disponibles y productos cultivables
		for(Terreno finca : TerrenosCultivables){
			
			ProductosCultivables.addAll(finca.getAmbiente().getProductosAgricolasViables());
		}
				
		//Devuelve los productos cultivables
		return ProductosCultivables;		
	}

	@Override
	public void formarIntenciones(List<Producto> productos) {
		// TODO devuelve propositos viables	
		
		List<SistemaActividadHumana> ActividadesEjecutables =new ArrayList();
		
		List<Proposito> propositos =new ArrayList();		
		propositos.addAll(this.CerebroProductor.fijarPropositos(productos));
		
		for(Terreno finca : TerrenosCultivables){
			
			ActividadesEjecutables.addAll(finca.getAmbiente().getActividadesViables());
		}		
		
		//Escoge actividad a ejecutar
		this.actividadVigente 	=this.CerebroProductor.escogerSistemaActividadHumana(propositos, ActividadesEjecutables);
		this.PropositoVigente	=this.actividadVigente.getProposito();
		
		this.estado = "PURPOSEFULL";
	}

	@Override
	public Utilidad actuar() {
		// TODO Auto-generated method stub		
		
		
		return null;
	}

	@Override
	public void juzgarMundoSegunEstandares(Utilidad resultado) {
		// TODO Auto-generated method stub

	}
	
	@ScheduledMethod (start = 1, interval = 1)
	public void step () {
		
	}

	/**
	 * @return the agentID
	 */
	public int getAgentID() {
		return AgentID;
	}

	/**
	 * @param agentID the agentID to set
	 */
	public void setAgentID(int agentID) {
		AgentID = agentID;
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
	 * @return the estado
	 */
	public String getEstado() {
		return Estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		Estado = estado;
	}

	/**
	 * @return the objetivo
	 */
	public Objetivo getObjetivo() {
		return Objetivo;
	}

	/**
	 * @param objetivo the objetivo to set
	 */
	public void setObjetivo(Objetivo objetivo) {
		Objetivo = objetivo;
	}

	/**
	 * @return the dinero
	 */
	public Item getDinero() {
		return Dinero;
	}

	/**
	 * @param dinero the dinero to set
	 */
	public void setDinero(Item dinero) {
		Dinero = dinero;
	}

	/**
	 * @return the terrenosCultivables
	 */
	public List<Terreno> getTerrenosCultivables() {
		return TerrenosCultivables;
	}

	/**
	 * @param terrenosCultivables the terrenosCultivables to set
	 */
	public void setTerrenosCultivables(List<Terreno> terrenosCultivables) {
		TerrenosCultivables = terrenosCultivables;
	}
	
	/**
	 * @param terrenosCultivables the terrenosCultivables to set
	 */
	public void addTerrenosCultivables(Terreno terrenoCultivable) {
		TerrenosCultivables.add(terrenoCultivable);
	}

	/**
	 * @return the cerebroProductor
	 */
	public CerebroProductor getCerebroProductor() {
		return CerebroProductor;
	}

	/**
	 * @param cerebroProductor the cerebroProductor to set
	 */
	public void setCerebroProductor(CerebroProductor cerebroProductor) {
		CerebroProductor = cerebroProductor;
	}

	/**
	 * @return the propositoVigente
	 */
	public Proposito getPropositoVigente() {
		return PropositoVigente;
	}

	/**
	 * @param propositoVigente the propositoVigente to set
	 */
	public void setPropositoVigente(Proposito propositoVigente) {
		PropositoVigente = propositoVigente;
	}

	/**
	 * @return the actividadVigente
	 */
	public SistemaActividadHumana getActividadVigente() {
		return actividadVigente;
	}

	/**
	 * @param actividadVigente the actividadVigente to set
	 */
	public void setActividadVigente(SistemaActividadHumana actividadVigente) {
		this.actividadVigente = actividadVigente;
	}
	
	/**
	 * @return the experiencia
	 */
	public List<Experiencia> getExperiencia() {
		return Experiencia;
	}

	/**
	 *  Filtra la experiencia a aquellos que concuerdan con el proposito
	 * @param p Proposito
	 * @return Experiencia
	 */
	@Override
	public List<Experiencia> getExperiencia(Proposito p) {
		
		List<Experiencia> matchlist = new ArrayList<Experiencia>();
		
		for(Experiencia e : this.Experiencia){
			
			if(e.getProposito().equals(p)){
				matchlist.add(e);				
			}
		}
		
		return matchlist;
	}

	/**
	 * @param experiencia the experiencia to set
	 */
	public void setExperiencia(List<Experiencia> experiencia) {
		Experiencia = experiencia;
	}
	
	
	
	
	
}
