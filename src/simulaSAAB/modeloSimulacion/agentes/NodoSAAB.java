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

public class NodoSAAB extends NodoLogistico {
	
	private String nombre;
	
	private Geometry geometria;
	
	private List<AgenteSaab> OperadoresLogisticos;
	
	
	
	/**
	 * Constructor
	 * @param nombre
	 */
	public NodoSAAB(String nombre){
		this.nombre = nombre;
	}
	
	@Override
	public List<Experiencia> getExperiencia(Proposito p) {
		return null;
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
	public void almacenar(Producto p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void despachar(Producto p) {
		// TODO Auto-generated method stub

	}
	
	

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	/**
	 * @return the operadoresLogisticos
	 */
	public List<AgenteSaab> getOperadoresLogisticos() {
		return OperadoresLogisticos;
	}

	/**
	 * @param operadoresLogisticos the operadoresLogisticos to set
	 */
	public void addOperadoresLogisticos(AgenteSaab operadorLogistico) {
		OperadoresLogisticos.add(operadorLogistico);
	}

	@Override
	public Experiencia getExperiencia(SistemaActividadHumana act) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addExperiencia(Experiencia e) {
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
	public SistemaActividadHumana getActividadVigente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEstado(String e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getEstado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> atribuirSignificadoAlMundoPercibido() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void formarIntenciones(List<Producto> productos) {
		// TODO Auto-generated method stub
		
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

	@Override
	public boolean evaluarPropuesta(Oferta o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void entregarProductos(AgenteSaab a, Oferta o) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
