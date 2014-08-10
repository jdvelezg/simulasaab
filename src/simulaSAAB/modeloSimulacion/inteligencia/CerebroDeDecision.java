package simulaSAAB.modeloSimulacion.inteligencia;

import java.util.List;

import simulaSAAB.modeloSimulacion.Producto;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;

public interface CerebroDeDecision extends Cerebro {
	
	public  List<Proposito> fijarPropositos(List<Producto> productos);	
	
	public  SistemaActividadHumana escogerSistemaActividadHumana(List<Proposito> propositos,List<SistemaActividadHumana> actividades);
	

}
