package simulaSAAB.modeloSimulacion.comunicacion;

import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;

public class Experiencia implements Concepto {
	
	private static int consecutivo;
	
	private int id;
	
	private double PuntajeUtilidad;
	
	private String Concepto;
	
	private int NumeroEjecuciones;
	
	private Proposito proposito;
	
	private double utilidad;
	
	private double MayorUtilidad;
	
	private ActividadConProposito ActividadEjecutada;
	
	/**
	 * Constructor
	 */
	public Experiencia(){
		
	}
	
	/**
	 * Constructor
	 * @param a
	 * @param puntaje
	 */
	public Experiencia(SistemaActividadHumana a, double puntaje){
		
		consecutivo++;
		this.id					= consecutivo+1;
		this.proposito			= a.getProposito();
		this.ActividadEjecutada	= new ActividadConProposito(a);
		
	}

	/**
	 * @return the consecutivo
	 */
	public static int getConsecutivo() {
		return consecutivo;
	}

	/**
	 * @param consecutivo the consecutivo to set
	 */
	public static void setConsecutivo(int consecutivo) {
		Experiencia.consecutivo = consecutivo;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the puntajeUtilidad
	 */
	public double getPuntajeUtilidad() {
		return PuntajeUtilidad;
	}

	/**
	 * @param puntajeUtilidad the puntajeUtilidad to set
	 */
	public void setPuntajeUtilidad(double puntajeUtilidad) {
		PuntajeUtilidad = puntajeUtilidad;
	}

	/**
	 * @return the concepto
	 */
	public String getConcepto() {
		return Concepto;
	}

	/**
	 * @param concepto the concepto to set
	 */
	public void setConcepto(String concepto) {
		Concepto = concepto;
	}

	/**
	 * @return the numeroEjecuciones
	 */
	public int getNumeroEjecuciones() {
		return NumeroEjecuciones;
	}

	/**
	 * @param numeroEjecuciones the numeroEjecuciones to set
	 */
	public void setNumeroEjecuciones(int numeroEjecuciones) {
		NumeroEjecuciones = numeroEjecuciones;
	}

	/**
	 * @return the proposito
	 */
	public Proposito getProposito() {
		return proposito;
	}

	/**
	 * @param proposito the proposito to set
	 */
	public void setProposito(Proposito proposito) {
		this.proposito = proposito;
	}

	/**
	 * @return the utilidad
	 */
	public double getUtilidad() {
		return utilidad;
	}

	/**
	 * @param utilidad the utilidad to set
	 */
	public void setUtilidad(double utilidad) {
		this.utilidad = utilidad;
	}

	/**
	 * @return the mayorUtilidad
	 */
	public double getMayorUtilidad() {
		return MayorUtilidad;
	}

	/**
	 * @param mayorUtilidad the mayorUtilidad to set
	 */
	public void setMayorUtilidad(double mayorUtilidad) {
		MayorUtilidad = mayorUtilidad;
	}

	/**
	 * @return the actividadEjecutada
	 */
	public ActividadConProposito getActividadEjecutada() {
		return ActividadEjecutada;
	}

	/**
	 * @param actividadEjecutada the actividadEjecutada to set
	 */
	public void setActividadEjecutada(ActividadConProposito actividadEjecutada) {
		ActividadEjecutada = actividadEjecutada;
	}
	
	

}
