package simulaSAAB.modeloSimulacion.comunicacion;

import java.util.List;

public class Objetivo implements Concepto {
	
	private int id;
	
	private String enunciado;
	
	private List<Proposito> propositos;
	
	/**
	 * Constructor Objetivo
	 * @param enunciado en lenguaje natural
	 */
	public Objetivo(String enunciado){
		this.enunciado = enunciado;
	}

}
