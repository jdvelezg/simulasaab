/**
 * 
 */
package simulaSAAB.modeloSimulacion.agentes;

import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

import simulaSAAB.modeloSimulacion.Producto;
import simulaSAAB.modeloSimulacion.comunicacion.Experiencia;
import simulaSAAB.modeloSimulacion.comunicacion.Oferta;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.modeloSimulacion.comunicacion.Recurso;
import simulaSAAB.modeloSimulacion.comunicacion.Utilidad;
import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;

/**
 * @author dampher
 *
 */
public interface AgenteSaab {
	
	/**
	 * Agrega recursos al agente
	 * @param recurso
	 */
	void addRecurso(Recurso recurso);
	/**
	 * Devuelve el listado de experiencias registradas en el agente
	 * que coinciden con el proposito p
	 * @param p Proposito.
	 * @return
	 */
	List<Experiencia> getExperiencia(Proposito p);
	
	/**
	 * Devuelve la experiencias registrada en el agente
	 * que coincide con el sistema de actividad humana
	 * @param act Sistema de actividad Humana.
	 * @return
	 */
	Experiencia getExperiencia(SistemaActividadHumana act);
	
	/**
	 * Devuelve el sistema de actividad Humana que el agente está
	 * ejecutando o que prentende ejecutar.
	 * @return
	 */
	SistemaActividadHumana getActividadVigente();
	
	/**
	 * Fija el estado del agente.
	 * @param e
	 */
	void setEstado(String e);
	
	/**
	 * Obtiene el estado del Agente.
	 * @return Estado del agente
	 */
	String getEstado();
	
	/**
	 * Agrega una experiencia al listado de experiencias del agente.
	 * @param e
	 */
	void addExperiencia(Experiencia e);
	
	/**
	 * Devuelve la ultima utilidad obtenida por el agente.
	 * @return
	 */
	double getUltimaUtilidadObtenida();
	
	/**
	 * Envía un mensaje ACL
	 */
	void sendMessage();
	
	/**
	 * Recive un mensaje ACL
	 */
	void receiveMessage();
	
	/**
	 * Devuelve un listado de productos, que deben ser interpretados como opciones de accion
	 * resultado de la percepcion del entorno llevada a cabo por el agente
	 * @return Listado de productos, como opciones para la toma de decisiones.
	 */
	public List<Producto> atribuirSignificadoAlMundoPercibido();
	
	/**
	 * Inicializa el proposito del agente segun las opciones pasadas como parametro
	 * en un listado de productos.
	 * @param productos. Listado de productos a usar como opciones en la toma de decisiones.
	 */
	public void formarIntenciones(List<Producto> productos);
	
	/**
	 * Determina el sistema de actividad humana con el que pretende cumplir su proposito
	 * y lo ejecuta. 
	 * @return Devuelve la Utilidad resultante.
	 */
	public Utilidad actuar();
	
	/**
	 * Evalua la experiencia sobre la ultima actividad ejecutada de acuerdo con la utilidad obtenida.
	 * @param resultado Utilidad obtenida.
	 */
	public void juzgarMundoSegunEstandares(Utilidad resultado);
	
	/**
	 * Devuelve la geometria asignada al agente en la proyección
	 */
	public Geometry getGeometria();
	
	/**
	 * Evalua la viabilidad de la oferta recibida como parametro. Devuleve verdadero si la acepta.
	 * @param o
	 * @return Booleano de respuesta, Verdadero si acepta la oferta, Falso en caso contrario.
	 */
	public boolean evaluarPropuesta(Oferta o);
	
	/**
	 * Entrega los productos vigentes en la oferta al agente definido
	 * @param a agente al que se le entregan los productos
	 * @param o Oferta sobre la cual se lleva a cabo la trnasferencia
	 */
	public void entregarProductos(AgenteSaab a, Oferta o);	
	

}

