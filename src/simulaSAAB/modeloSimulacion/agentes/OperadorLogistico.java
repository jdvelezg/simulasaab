/**
 * 
 */
package simulaSAAB.modeloSimulacion.agentes;

import java.util.List;

import simulaSAAB.modeloSimulacion.Producto;
import simulaSAAB.modeloSimulacion.comunicacion.Experiencia;
import simulaSAAB.modeloSimulacion.comunicacion.Objetivo;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.modeloSimulacion.comunicacion.Recurso;
import simulaSAAB.modeloSimulacion.comunicacion.Utilidad;
import simulaSAAB.modeloSimulacion.inteligencia.CerebroProductor;
import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;

/**
 * @author dampher
 *
 */
public class OperadorLogistico extends ActorDeAbastecimiento {
	
	private int AgentID;
	
	private String Nombre;
	
	private String Estado;
	
	private Objetivo Objetivo;
	
	//private CerebroProductor CerebroProductor;
	
	private Proposito PropositoVigente;
	
	private SistemaActividadHumana actividadVigente;
	
	
	
	
	/**
	 * Constructor
	 */
	public OperadorLogistico(){
		
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
	public void receiveMessage() {
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
		// TODO Auto-generated method stub

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
	
	

}
