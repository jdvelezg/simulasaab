/**
 * 
 */
package simulaSAAB.modeloSimulacion.agentes;

import java.util.ArrayList;
import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

import simulaSAAB.modeloSimulacion.Producto;
import simulaSAAB.modeloSimulacion.Terreno;
import simulaSAAB.modeloSimulacion.comunicacion.ActoComunicativo;
import simulaSAAB.modeloSimulacion.comunicacion.Experiencia;
import simulaSAAB.modeloSimulacion.comunicacion.Item;
import simulaSAAB.modeloSimulacion.comunicacion.MensajeACL;
import simulaSAAB.modeloSimulacion.comunicacion.Objetivo;
import simulaSAAB.modeloSimulacion.comunicacion.Oferta;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.modeloSimulacion.comunicacion.Recurso;
import simulaSAAB.modeloSimulacion.comunicacion.Utilidad;
import simulaSAAB.modeloSimulacion.inteligencia.CerebroIntermediario;
import simulaSAAB.modeloSimulacion.inteligencia.CerebroProductor;
import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;
import simulaSAAB.persistencia.AgenteConfigurado;

/**
 * @author dampher
 *
 */
public class Intermediario extends ActorDeAbastecimiento {
	
	private int AgentID;
	
	private String Nombre;
	
	private String Estado;
	
	private Objetivo Objetivo;
	
	private Item Dinero;

	private List<Item> Posesiones;
	
	private CerebroIntermediario Cerebro;
	
	private Proposito PropositoVigente;
	
	private SistemaActividadHumana actividadVigente;
	
	/**
	 * Constructor
	 */
	public Intermediario(){
		
		AgenteConfigurado agt 	=new AgenteConfigurado("Intermediario");
		this.Nombre				=agt.getTipo();
		this.Objetivo 			=agt.getObjetivo();
		//this.Cerebro	=new CerebroIntermediario();
		this.Posesiones			= new ArrayList<Item>();
		
		this.estado = "IDLE";
		
	}
	
	@Override
	public List<Experiencia> getExperiencia(Proposito p) {
		return null;
	}

	/* (non-Javadoc)
	 * @see simulaSAAB.modeloSimulacion.agentes.AgenteSaab#sendMessage()
	 */
	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see simulaSAAB.modeloSimulacion.agentes.AgenteSaab#receiveMessage()
	 */
	@Override
	public MensajeACL receiveMessage(MensajeACL mensaje) {
		
		String p = mensaje.getPerformative();
		
		switch(p){
		
		case "Propose" : //Cuando el Acto comunicativo es de tipo Propose
		if(p instanceof ) {
			
		}
		case "Call for Proposal"
		case "inform"
		case "not-understood"
		case "propose"
		case "query-IF"
		case "refuse"
		case "reject-proposal"
		case "request"
		
		}

		
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see simulaSAAB.modeloSimulacion.agentes.ActorDeAbastecimiento#atribuirSignificadoAlMundoPercibido()
	 */
	@Override
	public List<Producto> atribuirSignificadoAlMundoPercibido() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see simulaSAAB.modeloSimulacion.agentes.ActorDeAbastecimiento#formarIntenciones(java.util.List)
	 */
	@Override
	public void formarIntenciones(List<Producto> productos) {
		// TODO devuelve propositos viables
		
		List<SistemaActividadHumana> ActividadesEjecutables =new ArrayList();		
		this.PropositoVigente = this.Cerebro.fijarProposito(productos);

	}

	/* (non-Javadoc)
	 * @see simulaSAAB.modeloSimulacion.agentes.ActorDeAbastecimiento#actuar()
	 */
	@Override
	public Utilidad actuar() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see simulaSAAB.modeloSimulacion.agentes.ActorDeAbastecimiento#juzgarMundoSegunEstandares(simulaSAAB.modeloSimulacion.comunicacion.Utilidad)
	 */
	@Override
	public void juzgarMundoSegunEstandares(Utilidad resultar) {
		// TODO Auto-generated method stub

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
	 * @return the posesiones
	 */
	public List<Item> getPosesiones() {
		return Posesiones;
	}

	/**
	 * @param posesiones the posesiones to set
	 */
	public void addPosesiones(Item posesiones) {
		Posesiones.add(posesiones);
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

	@Override
	public simulaSAAB.modeloSimulacion.comunicacion.Experiencia getExperiencia(
			SistemaActividadHumana act) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addExperiencia(
			simulaSAAB.modeloSimulacion.comunicacion.Experiencia e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getUltimaUtilidadObtenida() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addRecurso(Recurso recurso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Geometry getGeometria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean evaluarPropuesta(Oferta o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void entregarProductos(AgenteSaab a, Oferta o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ejecutarActividadesConProposito() {
		// TODO Auto-generated method stub
		
	}
	
	

}
