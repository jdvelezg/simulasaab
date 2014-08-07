package simulaSAAB.modeloSimulacion.agentes;

import java.util.ArrayList;
import java.util.List;

import simulaSAAB.main.Producto;
import simulaSAAB.main.Terreno;
import simulaSAAB.modeloSimulacion.comunicacion.Item;
import simulaSAAB.modeloSimulacion.comunicacion.Objetivo;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;
import simulaSAAB.modeloSimulacion.comunicacion.Utilidad;
import simulaSAAB.modeloSimulacion.inteligencia.CerebroProductor;
import simulaSAAB.modeloSimulacion.tareas.SistemaActividadHumana;
import simulaSAAB.persistencia.AgenteConfigurado;

public class Productor extends ActorDeAbastecimiento {
	
	private int AgentID;
	
	private String Nombre;
	
	private String Estado;
	
	private Objetivo Objetivo;
	
	private Item Dinero;

	private List<Terreno> TerrenosCultivables;
	
	private CerebroProductor CerebroProductor;
	
	private Proposito PropositoVigente;
	
	private SistemaActividadHumana actividadVigente;
	
	/**
	 * Constructor de la clase Productor
	 * @param tipo: Clasifica al productor
	 */
	public Productor(String tipo){		
		
		AgenteConfigurado agt 	=new AgenteConfigurado("Productor");
		this.Nombre				=agt.getTipo();
		this.Objetivo 			=agt.getObjetivo();
		this.CerebroProductor	=new CerebroProductor();
		
		this.estado = "IDLE";
	}

	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void receiveMessage() {
		// TODO Auto-generated method stub

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
		
		List<Proposito> propositos =new ArrayList();		
		propositos.addAll(this.CerebroProductor.fijarPropositos(productos));
		
		for(Terreno finca : TerrenosCultivables){
			
			ActividadesEjecutables.addAll(finca.getAmbiente().getActividadesViables());
		}		
		
		//Escoge actividad a ejecutar
		this.actividadVigente 	=this.CerebroProductor.escogerSistemaActividadHumana(propositos, ActividadesEjecutables);
		this.PropositoVigente	=this.actividadVigente.getProposito();
		
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

}
