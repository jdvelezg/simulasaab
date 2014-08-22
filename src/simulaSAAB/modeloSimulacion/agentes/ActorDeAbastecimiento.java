package simulaSAAB.modeloSimulacion.agentes;

import java.util.List;

import simulaSAAB.modeloSimulacion.Producto;
import simulaSAAB.modeloSimulacion.comunicacion.Experiencia;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.modeloSimulacion.comunicacion.Utilidad;

public abstract class ActorDeAbastecimiento implements AgenteSaab {
	
	public String estado;
	
	private List<Experiencia> Experiencia;
	
	public abstract List<Producto> atribuirSignificadoAlMundoPercibido();
	
	public abstract void formarIntenciones(List<Producto> productos);
	
	public abstract Utilidad actuar();
	
	public abstract void juzgarMundoSegunEstandares(Utilidad resultar);	
	
	public abstract void ejecutarActividadesConProposito();

}

