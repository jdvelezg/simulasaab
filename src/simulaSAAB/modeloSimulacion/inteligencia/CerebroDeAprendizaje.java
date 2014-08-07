package simulaSAAB.modeloSimulacion.inteligencia;

import java.util.List;

import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;

public interface CerebroDeAprendizaje extends Cerebro {
	
	public void evaluarExperiencia();
	
	public List<SistemaActividadHumana> recordarExperiencia(List<SistemaActividadHumana> act);

}
