package simulaSAAB.modeloSimulacion.tareas;

import java.util.ArrayList;
import java.util.List;

import simulaSAAB.modeloSimulacion.Producto;
import simulaSAAB.modeloSimulacion.Terreno;
import simulaSAAB.modeloSimulacion.agentes.ActorDeAbastecimiento;
import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.modeloSimulacion.comunicacion.Utilidad;

public class ProcesoHumano implements SistemaActividadHumana {
	
	private Proposito proposito;		
	
	private String Estado;
	
	private int paso;

	@Override
	public String getEnunciado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proposito getProposito() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEstado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void secuenciaPrincipalDeAcciones(AgenteSaab actor) {
		// TODO Auto-generated method stub
		
if(this.Estado.compareToIgnoreCase(EstadoActividad.READY.toString())==1){
			
			this.Estado	=EstadoActividad.RUNNING.toString();
			this.paso	=1;			
		}
		else if(this.Estado.compareToIgnoreCase(EstadoActividad.RUNNING.toString())==1){
			
			List<Producto> opciones = new ArrayList<Producto>();
			
			switch(this.paso){
			case 1:
				
				opciones = actor.atribuirSignificadoAlMundoPercibido();
				actor.formarIntenciones(opciones);				
				
				paso++;
				break;
			case 2:
				actor.actuar();
				
				if(actor.getEstado()=="IDLE")
					paso++;
				
				break;
			case 3: 
				actor.juzgarMundoSegunEstandares(new Utilidad(actor.getUltimaUtilidadObtenida()));
				
				paso++;
				break;
			default:
				this.Estado =EstadoActividad.READY.toString();
			}
			
				
		}

	}

}
