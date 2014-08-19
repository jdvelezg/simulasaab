package simulaSAAB.modeloSimulacion.tareas;

import com.vividsolutions.jts.geom.Coordinate;

import repast.simphony.space.gis.Geography;
import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;
import simulaSAAB.modeloSimulacion.comunicacion.Accion;
import simulaSAAB.modeloSimulacion.comunicacion.Item;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;

public class Moverse implements SistemaActividadHumana {
			
	private Coordinate destino;
	
	private int velocidad;
	
	private Geography<AgenteSaab> geography;
	
	private EstadoActividad estado;
	
	/**
	 * Constructor
	 * @param origen: Coordenada donde empieza el movimiento
	 * @param destino: Coordenada donde termina el movimiento
	 * @param velocidad: coeficiente de velocidad que limita el desplazamiento
	 */
	public Moverse(Coordinate destino,int velocidad, Geography<AgenteSaab> gis){		
		this.destino	=destino;
		this.velocidad	=velocidad;
		this.geography	=gis;
		this.estado		=estado.READY;
	}

	@Override
	public Proposito getProposito() {
		// TODO devuelve el proposito de la actividad
		return new Proposito(new Accion("Moverse"),new Item("",""),"al destino: "+destino.toString());
	}

	@Override
	public String getEstado() {
		// TODO Auto-generated method stub
		return this.estado.toString();
	}

	@Override
	public void secuenciaPrincipalDeAcciones(AgenteSaab actor) {
		// TODO Auto-generated method stub
		
		Coordinate origen	=geography.getGeometry(actor).getCoordinate();
		
		if(destino.x-origen.x>velocidad){			
			origen.x 	+=velocidad;						
		}else{
			origen.x = destino.x;
		}
		
		if(destino.y-origen.y>velocidad){			
			origen.y 	+=velocidad;						
		}else{
			origen.y = destino.y;
		}
		
		geography.move(actor,geography.getGeometry(actor));
		
		if(origen.distance(destino)==0){
			this.estado = estado.DONE;
		}else{
			this.estado = estado.RUNNING;
		}

	}

	@Override
	public String getEnunciado() {
		// TODO Auto-generated method stub
		return null;
	}

}
