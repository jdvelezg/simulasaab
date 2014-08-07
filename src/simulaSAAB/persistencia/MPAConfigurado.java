package simulaSAAB.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import simulaSAAB.main.Producto;
import simulaSAAB.modeloSimulacion.comunicacion.Accion;
import simulaSAAB.modeloSimulacion.comunicacion.Item;
import simulaSAAB.modeloSimulacion.comunicacion.Proposito;

public class MPAConfigurado {
	
	
	private int id;
	
	private Proposito proposito;
	
	private String Enunciado;
	
	private double Costo;
	
	private List<Item> requisitos;
	
	
	/**
	 * Constructor
	 * @param nombreMPA
	 */
	public MPAConfigurado(String nombreMPA){
		
		ProductoConfigurado cebolla = new ProductoConfigurado("Cebolla de Bulbo");
		
		switch(nombreMPA){
		
		case  "ProduccionCebollaBulbo":
			
			this.id 				=1;
			this.proposito 			=new Proposito(new Accion("Producir"),new Item("Cebolla de Bulbo","Producto"),"en todas las hectareas disponibles");
			this.Enunciado			="";
			this.Costo				=cebolla.getCostoproduccionhectarea();
			
			this.requisitos = new ArrayList();
			this.requisitos.add(new Item("terreno","Terreno"));
			
			break;
		case  "ComprarCebollaBulbo":
			
			this.id 				=2;
			this.proposito 			=new Proposito(new Accion("Comprar"),new Item("Cebolla de Bulbo","Producto"),"mínimo 100 bultos");
			this.Enunciado			="";
			this.Costo				=cebolla.getPrecioSIPSA();
			
			this.requisitos = new ArrayList();
			this.requisitos.add(new Item("COP","Dinero"));
			
			break;
		case  "VenderCebollaBulbo":
			
			this.id 				=3;
			this.proposito 			=new Proposito(new Accion("Vender"),new Item("Cebolla de Bulbo","Producto"),"disponible");
			this.Enunciado			="";
			this.Costo				=cebolla.getPrecioSIPSA();
			
			this.requisitos = new ArrayList();
			this.requisitos.add(new Item("Cebolla de Bulbo","Producto"));
			
			break;
		case  "TransportarCebollaBulbo":
			
			this.id 				=4;
			this.proposito 			=new Proposito(new Accion("Transportar"),new Item("Cebolla de Bulbo","Producto"),"disponible");
			this.Enunciado			="";
			this.Costo				=100000;
			
			this.requisitos = new ArrayList();
			this.requisitos.add(new Item("Camion","Vehiculo"));
			
			break;		
		}
	}


	/**
	 * @return the costo
	 */
	public double getCosto() {
		return Costo;
	}


	/**
	 * @param costo the costo to set
	 */
	public void setCosto(double costo) {
		Costo = costo;
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
	 * @return the enunciado
	 */
	public String getEnunciado() {
		return Enunciado;
	}


	/**
	 * @param enunciado the enunciado to set
	 */
	public void setEnunciado(String enunciado) {
		Enunciado = enunciado;
	}


	/**
	 * @return the requisitos
	 */
	public List<Item> getRequisitos() {
		return requisitos;
	}


	/**
	 * @param requisitos the requisitos to set
	 */
	public void setRequisitos(List<Item> requisitos) {
		this.requisitos = requisitos;
	}

}
