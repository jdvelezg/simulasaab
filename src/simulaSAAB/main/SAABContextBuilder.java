package simulaSAAB.main;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

import repast.simphony.context.Context;
import repast.simphony.dataLoader.ContextBuilder;
import repast.simphony.random.RandomHelper;
import repast.simphony.space.gis.Geography;
import repast.simphony.space.gis.GeographyParameters;
import repast.simphony.space.gis.SimpleAdder;
import repast.simphony.space.graph.Network;
import repast.simphony.context.space.gis.GeographyFactory;
import repast.simphony.context.space.gis.GeographyFactoryFinder;
import repast.simphony.context.space.graph.NetworkBuilder;
import simulaSAAB.modeloSimulacion.AmbienteLocal;
import simulaSAAB.modeloSimulacion.CentroDeAcopio;
import simulaSAAB.modeloSimulacion.CentroUrbano;
import simulaSAAB.modeloSimulacion.PlazaDistrital;
import simulaSAAB.modeloSimulacion.Terreno;
import simulaSAAB.modeloSimulacion.Tienda;
import simulaSAAB.modeloSimulacion.Vehiculo;
import simulaSAAB.modeloSimulacion.ViaTransitable;
import simulaSAAB.modeloSimulacion.agentes.Intermediario;
import simulaSAAB.modeloSimulacion.agentes.NodoSAAB;
import simulaSAAB.modeloSimulacion.agentes.Productor;
import simulaSAAB.modeloSimulacion.agentes.VendedorFinal;
import simulaSAAB.persistencia.AgenteConfigurado;
import simulaSAAB.persistencia.RegionConfigurada;
import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;
import simulaSAAB.modeloSimulacion.comunicacion.Item;
import simulaSAAB.contextos.*;


public class SAABContextBuilder implements ContextBuilder<Object> {
	
	//Contexto principal
	private static Context<Object> SAABContext;
	private static Geography<Object> SAABGeography;
	
	//Nutriredes SAAB
	private static Context<Object> NutriredContext;
	private static Network<Object> NutriredNetwork;
	//Agroredes
	private static Context<Object> AgroredContext;
	private static Network<Object> AgroredNetwork;
	//Vias principales
	private static Context<Object> ViasprincipalesContext;
	//Conexiones viales
	private static Context<Object> ConexionesContext;
	private static Network<Object> ConexionesNetwork;
	//Municipios
	private static Context<Object> RuralContext;
	//Oferta
	private static Context<Object> OfertaContext;
	private static Network<Object> OfertaNetwork;
	//Ciudad
	private static Context<Object> BogotaContext;
	//Demanda
	private static Context<Object> DemandaContext;
	private static Network<Object> DemandaNetwork;


	@Override
	public Context<Object> build(Context<Object> context){
		
		//Referencia al contexto principal
		SAABContext =context;		
		SAABContext.setId(VariablesGlobales.CONTEXTO_SAAB);
				
		GeographyParameters<Object>	geoparams 	= new GeographyParameters<Object>();
		
		SAABGeography	= GeographyFactoryFinder.createGeographyFactory(null).createGeography(VariablesGlobales.GEOGRAFIA_SAAB, SAABContext, geoparams);
		
		//Ambiente Rural
		RuralContext	=new RuralContext();
		SAABContext.addSubContext(RuralContext);
		
		loadShapefiles(VariablesGlobales.MUNICIPIOS_SHAPEFILE,"municipios",RuralContext,SAABGeography);
		
		OfertaContext	= new OfertaContext();		
		NetworkBuilder<Object> NetDemandaBuilder	=new NetworkBuilder<Object>(VariablesGlobales.RED_OFERTA,OfertaContext,false);
		OfertaNetwork	= NetDemandaBuilder.buildNetwork();
		
		SAABContext.addSubContext(OfertaContext);		
		
		//Ambiente Distrital -NUTRIRED			
		
		NutriredContext	= new NutriredContext();
		NetworkBuilder<Object> NetNutriredBuilder = new NetworkBuilder<Object>(VariablesGlobales.RED_NUTRIRED,NutriredContext,false);
		NutriredNetwork	= NetNutriredBuilder.buildNetwork();	
		SAABContext.addSubContext(NutriredContext);
		
		loadShapefiles(VariablesGlobales.BOGOTA_SHAPEFILE,"urbano",NutriredContext,SAABGeography);
		loadShapefiles(VariablesGlobales.PLAZASDISTRITALES_SHAPEFILE,"plazas",NutriredContext,SAABGeography);
		loadShapefiles(VariablesGlobales.NODOSSAAB_SHAPEFILE,"nodos",NutriredContext,SAABGeography);
			
				
		//Agroredes
		AgroredContext	= new AgroredContext();
		NetworkBuilder<Object> NetAgroredBuilder = new NetworkBuilder<Object>(VariablesGlobales.RED_AGRORED,AgroredContext,false);
		AgroredNetwork	= NetAgroredBuilder.buildNetwork();
		SAABContext.addSubContext(AgroredContext);
		
		loadShapefiles(VariablesGlobales.CENTROSURBANOS_SHAPEFILE,"urbano",AgroredContext,SAABGeography);
		
		
		//Vias pricipales
		ViasprincipalesContext	= new ViasContext();
		SAABContext.addSubContext(ViasprincipalesContext);
		
		loadShapefiles(VariablesGlobales.VIASPRINCIPALES_SHAPEFILE,"vias",ViasprincipalesContext,SAABGeography);
		
		//ConexionesContext 	= new ConexionesContext();
		//SAABContext.addSubContext(ConexionesContext);
		
		//loadShapefiles(VariablesGlobales.BOGOTA_SHAPEFILE,"intersecciones",ConexionesContext,SAABGeography);
		
		//NetworkBuilder<Object> NetConxBuilder	=new NetworkBuilder<Object>(VariablesGlobales.RED_CONEXIONES,ConexionesContext,false);
		//ConexionesNetwork = NetConxBuilder.buildNetwork();
		
		
		return context;
	}
	
	
	/**
	 * Carga las formas geometricas de las proyecciones desde archivos ESRI-Shapefile
	 * @param filename
	 * @param objeto
	 * @param context
	 * @param geography
	 */
	private void loadShapefiles(String filename, String objeto, Context<Object> context, Geography<Object> geography){
		
		URL url 						= null;
		SimpleFeatureIterator fiter 	= null;
		ShapefileDataStore store 		= null;
		CoordinateReferenceSystem crs 	= null;
						
				
		try{
			
			url = new File(filename).toURI().toURL();
			store = new ShapefileDataStore(url);
			
		}catch(MalformedURLException e){
			e.printStackTrace();
		}
		
		try{
			crs = store.getSchema().getCoordinateReferenceSystem();
			fiter = store.getFeatureSource().getFeatures().features();
			
		}catch(IOException e1){
			e1.printStackTrace();
		}
		
		while(fiter.hasNext()){
			
			SimpleFeature feature 	= fiter.next();
			Geometry geom 			= (Geometry)feature.getDefaultGeometry();			
			String name				=null;
			
			AmbienteLocal region	=null;
			CentroUrbano pueblo		=null;
			ViaTransitable road		=null;
			NodoSAAB nodo			=null;			
			PlazaDistrital plaza	=null;			
			
			
			if (geom instanceof MultiPolygon){
				
				MultiPolygon mp	=(MultiPolygon)feature.getDefaultGeometry();
				geom 			=(Polygon)mp.getGeometryN(0);				
			}
			else if(geom instanceof Point){
				
				geom =(Point)feature.getDefaultGeometry();
				
			}
			else if(geom instanceof MultiLineString){
				
				MultiLineString linea	=(MultiLineString)feature.getDefaultGeometry();
				geom					=(LineString)linea.getGeometryN(0);				
			}
			
			switch(objeto){
			
			case "municipios": //Cuando carga municipios	
				
				name 			=(String)feature.getAttribute("NAME_2");
				region = new AmbienteLocal(new RegionConfigurada(name));
				region.setGeometria(geom);
				
				context.add(region);
				geography.move(region, geom);
				
				if(!name.equalsIgnoreCase("bogota")){
					crearProductores(region,10,geography,context);
				}
					
				
				break;
			case "urbano"://Cuando carga Centros urbanos				
				
				name 			=(String)feature.getAttribute("Name");
				pueblo = new CentroUrbano();
				pueblo.setGeometria(geom);
				
				context.add(pueblo);
				geography.move(pueblo, geom);
				
				crearIntermediarios(pueblo,5,geography,context);
				
				if(name.equalsIgnoreCase("Bogota")){
					crearTenderos(pueblo,30,geography,context);
				}				
				break;
			case "vias"://Cuando carga Vias				
				
				road = new ViaTransitable();
				road.setGeometria(geom);
				
				context.add(road);
				geography.move(road, geom);
				
				break;
			case "nodos": //Cuando carga Nodos
				
				name 			=(String)feature.getAttribute("NAME");
				nodo = new NodoSAAB(name);
				nodo.setGeometria(geom);
				
				context.add(nodo);
				geography.move(nodo, geom);
				
				break;
			case "plazas"://cuando carga Plazas
				
				name 			=(String)feature.getAttribute("NAME");
				plaza =new PlazaDistrital(name);
				plaza.setGeometria(geom);
				
				context.add(plaza);
				geography.move(plaza, geom);
				
				break;			
			}			
		}		
	}
	
	/**
	 * Crea y ubica los productores aleatoriamente en el contexto rural, usando el centroide de la region y sus vertices
	 * para acotar el sector.
	 * @param amb Ambiente local al que agregan los agentes
	 * @param cantidad Numero de agentes a agregar
	 * @param geography Geografia a la que se agregan los agentes
	 */
	private void crearProductores(GeografiaFija amb, int cantidad, Geography<Object> geography, Context<Object> contexto){	
				
		/**
		 * Obtiene el centroide de la region y las coordenadas de los vertices del ambiente, 
		 * luego genera coordenadas aleatorias que van desde el centroide a cualquiera de los
		 * vertices del ambiente.
		 */
		Coordinate[] coords = amb.getGeometria().getCoordinates();		
		Coordinate center 	= amb.getGeometria().getCentroid().getCoordinate();
		
		
		for(int i=0; i<=cantidad; i++){
			
			GeometryFactory geofact = new GeometryFactory();
			Productor productor		= new Productor("Productor"); 
			
			
			Coordinate AgentCoord 	= new Coordinate(RandomHelper.nextDoubleFromTo(center.x,coords[RandomHelper.nextIntFromTo(0, coords.length-1)].x),RandomHelper.nextDoubleFromTo(center.y,coords[RandomHelper.nextIntFromTo(0, coords.length-1)].y));//center;			
			Point geom 				= geofact.createPoint(AgentCoord);
			
			if(amb.getGeometria().intersects(geom.getGeometryN(0))){
				
				Coordinate TerrCoord 	= new Coordinate(RandomHelper.nextDoubleFromTo(center.x,coords[RandomHelper.nextIntFromTo(0, coords.length-1)].x),RandomHelper.nextDoubleFromTo(center.y,coords[RandomHelper.nextIntFromTo(0, coords.length-1)].y));//center;
				Point terrenogeom 		= geofact.createPoint(TerrCoord);
				Terreno terreno			= new Terreno(terrenogeom);
				
				contexto.add(productor);
				contexto.add(terreno);
				
				geography.move(productor, geom);
				geography.move(terreno, terreno.getGeom());			
				
				productor.setGis(geography);
				productor.setGeometria(geom);
				productor.addTerrenosCultivables(terreno);
				
				/*System.out.println("Productor inside");
				if(geom.equals(terrenogeom))
					System.out.println("terreno equal");*/
				
			}
			
		}
		
		
	}
	
	/**
	 * Crea y ubica intermedirios aleatoriamente en el contexto rural, usando el centroide de la
	 * region y sus vertices para acotar el sector.
	 * @param amb
	 * @param cantidad
	 * @param geography
	 */
	private void crearIntermediarios(GeografiaFija amb, int cantidad, Geography<Object> geography, Context<Object> contexto){
						
		/**
		 * Obtiene el centroide de la region y las coordenadas de los vertices del ambiente, 
		 * luego genera coordenadas aleatorias que van desde el centroide a cualquiera de los
		 * vertices del ambiente.
		 */
		Coordinate[] coords = amb.getGeometria().getCoordinates();		
		Coordinate center 	= amb.getGeometria().getCentroid().getCoordinate();
		
		for(int i=0; i<=cantidad; i++){
			
			GeometryFactory geofact 	= new GeometryFactory();
			Intermediario agente		= new Intermediario();
			
			int random				= RandomHelper.nextInt();
			Coordinate AgentCoord 	= new Coordinate(RandomHelper.nextDoubleFromTo(center.x,coords[RandomHelper.nextIntFromTo(0, coords.length-1)].x),RandomHelper.nextDoubleFromTo(center.y,coords[RandomHelper.nextIntFromTo(0, coords.length-1)].y));//center;			
			Point geom 				= geofact.createPoint(AgentCoord);
			
			if(amb.getGeometria().intersects(geom.getGeometryN(0))){
				
				Point bodegageom 		= geofact.createPoint(AgentCoord);
				Point cargeom			= geofact.createPoint(AgentCoord);
				
				contexto.add(agente);
				geography.move(agente, geom);
				
				if(random%3==0){//Crea y asigna centro de acopio aleatoriamente
					
					CentroDeAcopio bodega = new CentroDeAcopio("",AgentCoord);
					bodega.setPropietario(agente);
					agente.addPosesiones(new Item("bodega","CentroDeAcopio"));
					
					contexto.add(bodega);
					geography.move(bodega, bodegageom);
					
				}else if(random%2==0){//crea y asigna camion de carga aleatoriamente
					
					Vehiculo camion = new Vehiculo("Camion","",2003,"");
					camion.setPropietario(agente);
					agente.addPosesiones(new Item("camion","Vehiculo"));
					
					contexto.add(camion);
					geography.move(camion, cargeom);
				}
			}				
			
		}
	}
	
	/**
	 * Crea y ubica los vendedores finales aleatoriamente en el contexto rural, usando el centroide
	 * de la region y sus vertices para acotar el sector.
	 * @param amb
	 * @param cantidad
	 * @param geography
	 * @param contexto
	 */
	private void crearTenderos(GeografiaFija amb, int cantidad, Geography<Object> geography, Context<Object> contexto){
		
			
		
		/**
		 * Obtiene el centroide de la region y las coordenadas de los vertices del ambiente, 
		 * luego genera coordenadas aleatorias que van desde el centroide a cualquiera de los
		 * vertices del ambiente.
		 */
		Coordinate[] coords = amb.getGeometria().getCoordinates();		
		Coordinate center 	= amb.getGeometria().getCentroid().getCoordinate();
		
		for(int i=0; i<=cantidad; i++){
			
			GeometryFactory geofact = new GeometryFactory();
			VendedorFinal agente	= new VendedorFinal();	
			
			Coordinate AgentCoord 	= new Coordinate(RandomHelper.nextDoubleFromTo(center.x,coords[RandomHelper.nextIntFromTo(0, coords.length-1)].x),RandomHelper.nextDoubleFromTo(center.y,coords[RandomHelper.nextIntFromTo(0, coords.length-1)].y));//center;			
			Point geom 				= geofact.createPoint(AgentCoord);
			
			if(amb.getGeometria().intersects(geom.getGeometryN(0))){
				
				Point tiendageom 		= geofact.createPoint(AgentCoord);
				Tienda tienda			= new Tienda("",AgentCoord);
				
				contexto.add(agente);
				contexto.add(tienda);
				
				geography.move(agente, geom);
				geography.move(tienda, tiendageom);	
				
			}					
			
		}		
		
	}
	
	
		


}
