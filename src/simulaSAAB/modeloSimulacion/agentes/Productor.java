package simulaSAAB.modeloSimulacion.agentes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;

import repast.simphony.context.Context;
import repast.simphony.engine.environment.RunState;
import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.space.gis.Geography;
import repast.simphony.space.projection.Projection;
import repast.simphony.util.ContextUtils;
import simulaSAAB.main.VariablesGlobales;
import simulaSAAB.modeloSimulacion.Producto;
import simulaSAAB.modeloSimulacion.Terreno;
import simulaSAAB.modeloSimulacion.comunicacion.Item;
import simulaSAAB.modeloSimulacion.comunicacion.Dinero;
import simulaSAAB.modeloSimulacion.comunicacion.MensajeACL;
import simulaSAAB.modeloSimulacion.comunicacion.Oferta;
import simulaSAAB.modeloSimulacion.comunicacion.Recurso;
import simulaSAAB.modeloSimulacion.comunicacion.Objetivo;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.modeloSimulacion.comunicacion.Recurso;
import simulaSAAB.modeloSimulacion.comunicacion.Utilidad;
import simulaSAAB.modeloSimulacion.comunicacion.Experiencia;
import simulaSAAB.modeloSimulacion.inteligencia.CerebroProductor;
import simulaSAAB.modeloSimulacion.tareas.Moverse;
import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;
import simulaSAAB.persistencia.AgenteConfigurado;

public class Productor extends ActorDeAbastecimiento {
	
	private int AgentID;
	
	private Geography<Object> gis;
	
	private static Objetivo Objetivo;
	
	private String Nombre;
	
	private Geometry geometria;	

	private String Estado;	
	
	private Dinero Dinero;
	
	private List<Recurso> Recursos;

	private List<Terreno> TerrenosCultivables;
	
	private CerebroProductor CerebroProductor;
	
	private Proposito PropositoVigente;
	
	private SistemaActividadHumana actividadVigente;
	
	private List<Experiencia> Experiencia;
	
	private double UltimaUtilidadObtenida;
	
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
	
	/**
	 * Metodo que ejecuta el comportamiento del agente en cada ciclo de reloj enviado por repast
	 */
	@ScheduledMethod (start = 1, interval = 100)
	public void step () {
		
		if(actividadVigente!=null){
			actividadVigente.secuenciaPrincipalDeAcciones(this);
		}else{
			//PRUEBAS
			
			Coordinate c = new Coordinate(this.geometria.getCoordinate().x+1,this.geometria.getCoordinate().y+1);
			
			if(gis!=null){
				this.actividadVigente = new Moverse(c,0.2,(Geography<Object>)gis);
				System.out.println("Listo para moverse");
			}else{
				System.out.println("No se encontro el GIS");
			}
			//FIN PRUEBAS
		}
			
		
		
	}
	

	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub

	}
	

	/**
	 * @return the gis
	 */
	public Geography getGis() {
		return gis;
	}

	/**
	 * @param gis the gis to set
	 */
	public void setGis(Geography gis) {
		this.gis = gis;
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
		this.PropositoVigente = this.CerebroProductor.fijarProposito(productos);		
		
		for(Terreno finca : TerrenosCultivables){			
			ActividadesEjecutables.addAll(finca.getAmbiente().getActividadesViables());
		}		
		
		//Escoge actividad a ejecutar
		this.actividadVigente = this.CerebroProductor.escogerSistemaActividadHumana(this.PropositoVigente, ActividadesEjecutables);
		//Cambia estado a -Con proposito-	
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
	public Dinero getDinero() {
		return Dinero;
	}

	/**
	 * @param dinero the dinero to set
	 */
	public void setDinero(double dinero) {
		Dinero = new Dinero(dinero);
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
		
		if(this.TerrenosCultivables==null)
			this.TerrenosCultivables=new ArrayList();
		
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
	
	/**
	 * Agrega euna nueva experiencia al set de experiencias del agente
	 * @param e experiencia para adicionar
	 */
	@Override
	public void addExperiencia(Experiencia e) {
		
		if(this.Experiencia==null)
			this.Experiencia = new ArrayList();
		
		this.Experiencia.add(e);		
	}
	
	
	/**
	 * Filtra la experiencia a aquellos que concuerdan con la actividad.
	 * Si la experiencia no existe, devuelve null.
	 * @param act Sistema de actividad humana con proposito definido
	 * @return Experiencia relacionada al sistema de actividad humana. 
	 */
	@Override
	public Experiencia getExperiencia(SistemaActividadHumana act) {
		
		Iterator<Experiencia> iter 		= this.Experiencia.iterator();
		Experiencia exp		= null;
		boolean flag		= true;
		
		while(flag && iter.hasNext()){
			
			exp = iter.next();
			if(exp.getActividadEjecutada().equals(act)){
				flag=false;
			}
		}
		
		return exp;
	}

	@Override
	public double getUltimaUtilidadObtenida() {
		return this.UltimaUtilidadObtenida;
	}	
	
	public Geometry getGeometria() {
		return geometria;
	}

	public void setGeometria(Geometry geometria) {
		this.geometria = geometria;
	}

	public void setUltimaUtilidadObtenida(double ultimaUtilidadObtenida) {
		UltimaUtilidadObtenida = ultimaUtilidadObtenida;
	}

	public List<Recurso> getRecursos() {
		return Recursos;
	}

	@Override
	public void addRecurso(Recurso recurso) {
		// TODO Auto-generated method stub
		if(Recursos==null)
			this.Recursos=new ArrayList();
		
		this.Recursos.add(recurso);
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

	@Override
	public MensajeACL receiveMessage(MensajeACL mensaje) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double addDinero(double monto) {
		// TODO Auto-generated method stub
		return null;
	}
		
	
}
