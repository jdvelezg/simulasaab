package simulaSAAB.main;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

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
import simulaSAAB.modeloSimulacion.CentroUrbano;
import simulaSAAB.modeloSimulacion.PlazaDistrital;
import simulaSAAB.modeloSimulacion.ViaTransitable;
import simulaSAAB.modeloSimulacion.agentes.NodoSAAB;
import simulaSAAB.modeloSimulacion.agentes.Productor;
import simulaSAAB.persistencia.AgenteConfigurado;
import simulaSAAB.persistencia.RegionConfigurada;
import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;
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
		
		RuralContext.addSubContext(OfertaContext);		
		
		//Ambiente Distrital
		BogotaContext 	= new DistritalContext();
		SAABContext.addSubContext(BogotaContext);		
		
		loadShapefiles(VariablesGlobales.BOGOTA_SHAPEFILE,"municipios",BogotaContext,SAABGeography);
		
		DemandaContext 	= new DemandaContext();		
		NetworkBuilder<Object> NetOfertaBuilder	=new NetworkBuilder<Object>(VariablesGlobales.RED_OFERTA,OfertaContext,false);
		OfertaNetwork	= NetOfertaBuilder.buildNetwork();
		
		BogotaContext.addSubContext(DemandaContext);
				
		//Agroredes
		AgroredContext	= new AgroredContext();
		NetworkBuilder<Object> NetAgroredBuilder = new NetworkBuilder<Object>(VariablesGlobales.RED_AGRORED,AgroredContext,false);
		AgroredNetwork	= NetAgroredBuilder.buildNetwork();
		SAABContext.addSubContext(AgroredContext);
		
		loadShapefiles(VariablesGlobales.CENTROSURBANOS_SHAPEFILE,"urbano",AgroredContext,SAABGeography);
		
		//Nutriredes
		NutriredContext	= new NutriredContext();
		NetworkBuilder<Object> NetNutriredBuilder = new NetworkBuilder<Object>(VariablesGlobales.RED_NUTRIRED,NutriredContext,false);
		NutriredNetwork	= NetNutriredBuilder.buildNetwork();	
		SAABContext.addSubContext(NutriredContext);
		
		loadShapefiles(VariablesGlobales.PLAZASDISTRITALES_SHAPEFILE,"plazas",NutriredContext,SAABGeography);
				
		//Vias pricipales
		ViasprincipalesContext	= new ViasContext();
		SAABContext.addSubContext(ViasprincipalesContext);
		
		loadShapefiles(VariablesGlobales.VIASPRINCIPALES_SHAPEFILE,"vias",ViasprincipalesContext,SAABGeography);
		
		ConexionesContext 	= new ConexionesContext();
		SAABContext.addSubContext(ConexionesContext);
		
		//loadShapefiles(VariablesGlobales.BOGOTA_SHAPEFILE,"intersecciones",ConexionesContext,SAABGeography);
		
		NetworkBuilder<Object> NetConxBuilder	=new NetworkBuilder<Object>(VariablesGlobales.RED_CONEXIONES,ConexionesContext,false);
		ConexionesNetwork = NetConxBuilder.buildNetwork();
		
		
		
		//crea productores de cebolla por region
			
		
		//crea intermediarios aleatorios
		
				
		//crea vendedores finales en bogota aleatorio
		
		
		//crea network SAAB
			//crea agentes SAAB por regiones-cebolla
			//crea operadores logisticos en nodos
		
				
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
				
				break;
			case "urbano"://Cuando carga Centros urbanos				
				
				pueblo = new CentroUrbano();
				pueblo.setGeometria(geom);
				
				context.add(pueblo);
				geography.move(pueblo, geom);
				
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
	 * Crea y ubica los productores aleatoriamente en el contexto rural
	 */
	private void crearProductores(AmbienteLocal amb, int cantidad, Geography<Object> geography){
		
		GeometryFactory geofact 	= new GeometryFactory();
		Productor productor			= new Productor("Productor");
		
		//Obtiene el centroide de la region y el valor de la mitad de su longitud
		Coordinate center 	= amb.getGeometria().getCentroid().getCoordinate();
		double large		= amb.getGeometria().getLength()/2;
		
		double Xmaxpos = center.x+large;
		double Ymaxpos = center.y+large;
		
		for(int i=0; i<=cantidad; i++){
			
			Coordinate AgentCoord 	= new Coordinate(RandomHelper.nextDoubleFromTo(center.x, Xmaxpos),RandomHelper.nextDoubleFromTo(center.y, Ymaxpos));			
			Point geom 				= geofact.createPoint(AgentCoord);
			
			geography.move(productor, geom);
			
		}
		
		
	}

}
