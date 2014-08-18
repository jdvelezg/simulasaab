/**
 * 
 */
package simulaSAAB.modeloSimulacion.inteligencia;

import java.util.ArrayList;
import java.util.List;

import simulaSAAB.modeloSimulacion.Producto;
import simulaSAAB.modeloSimulacion.agentes.Intermediario;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;

/**
 * @author dampher
 *
 */
public class CerebroIntermediario implements CerebroDeDecision, CerebroDeAprendizaje{
	
	public List<Proposito> fijarPropositosIntermediacion(){/*
		
		//Inicializa el proposito
		ArrayList<Proposito> propositos = new ArrayList<Proposito>();
		
		Intermediario getLocation(){
			
		}
		*/
		return null;
	}

	@Override
	public void evaluarExperiencia() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SistemaActividadHumana> recordarExperiencia(
			List<SistemaActividadHumana> act) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proposito> fijarPropositos(List<Producto> productos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SistemaActividadHumana escogerSistemaActividadHumana(
			List<Proposito> propositos, List<SistemaActividadHumana> actividades) {
		// TODO Auto-generated method stub
		return null;
	}

}
