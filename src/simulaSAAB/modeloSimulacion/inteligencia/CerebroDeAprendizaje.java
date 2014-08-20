package simulaSAAB.modeloSimulacion.inteligencia;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;
import simulaSAAB.modeloSimulacion.comunicacion.Experiencia;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;

public interface CerebroDeAprendizaje extends Cerebro {
	
	public void evaluarExperiencia();
	
	public List<SistemaActividadHumana> recordarExperiencia(List<SistemaActividadHumana> act);
	
	class EvaluarExperiencia{
		
		Experiencia experiencia;
		
		public void generarExperiencia(SistemaActividadHumana act, AgenteSaab agente){
			
			Proposito p						= act.getProposito();
			List<Experiencia> experiencia	= agente.getExperiencia(p);
			Experiencia exp					= agente.getExperiencia(act);
			
			
			
			if(exp==null){
				exp = new Experiencia();
				exp.setNumeroEjecuciones(1);
			}else{
				exp.setNumeroEjecuciones(exp.getNumeroEjecuciones()+1);
			}
			
			//Obtener mayor utilidad registrada para el proposito
			Collections.sort(experiencia,new ExperenciaUtilidadComparator());
			
			double MayorUtilidad 	= experiencia.get(0).getUtilidad();
			double UtilidadActual	= agente.getUltimaUtilidadObtenida();
			
			exp.setUtilidad(exp.getUtilidad()+UtilidadActual);
			
			if(UtilidadActual>=MayorUtilidad){
				
				exp.setConcepto("Bueno");
				exp.setEjecucionesExitosas(exp.getEjecucionesExitosas()+1);		
				
			}else{//calcula el promedio de utilidades obtenidas para el proposito
				
				int j = 0;
				double sumatoria =0;
				
				for(Experiencia e: experiencia){
					
					sumatoria += e.getUtilidad();
					j++;
				}
				
				if(UtilidadActual >=(sumatoria/j)){
					exp.setConcepto("Bueno");
					exp.setEjecucionesExitosas(exp.getEjecucionesExitosas()+1);
				}else{
					exp.setConcepto("Malo");
				}
			}
			
			
		}
		
	}

}

class ExperenciaUtilidadComparator implements Comparator<Experiencia>{


public int compare(Experiencia arg0, Experiencia arg1) {
	// TODO Auto-generated method stub
	return Double.compare(arg0.getUtilidad(), arg1.getUtilidad());		
}

}