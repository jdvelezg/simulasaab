package simulaSAAB.main;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

import repast.simphony.context.Context;
import repast.simphony.dataLoader.ContextBuilder;
import repast.simphony.space.gis.Geography;
import repast.simphony.space.gis.GeographyParameters;
import repast.simphony.space.gis.SimpleAdder;
import repast.simphony.space.graph.Network;
import repast.simphony.context.space.gis.GeographyFactory;
import repast.simphony.context.space.gis.GeographyFactoryFinder;
import repast.simphony.context.space.graph.NetworkBuilder;
import simulaSAAB.modeloSimulacion.agentes.NodoSAAB;
import simulaSAAB.persistencia.RegionConfigurada;
import simulaSAAB.modeloSimulacion.agentes.AgenteSaab;
import simulaSAAB.contextos.*;


public class SAABContextBuilder implements ContextBuilder<Object> {
	
	//Contexto principal
	private static Context<Object> SAABContext;
	
	//Nutriredes SAAB
	private static Context<AgenteSaab> NutriredContext;
	private static Network<AgenteSaab> NutriredNetwork;
	//Agroredes
	private static Context<AgenteSaab> AgroredContext;
	private static Network<AgenteSaab> AgroredNetwork;
	//Vias principales
	private static Context<Object> ViasprincipalesContext;
	private static Geography<Object> ViasprincipalesGis;
	//Conexiones viales
	private static Context<Object> ConexionesContext;
	private static Geography<Object> ConexionesGis;
	private static Network<Object> ConexionesNetwork;
	//Municipios
	private static Context<Object> RuralContext;
	private static Geography<Object> RuralGis;
	//Oferta
	private static Context<Object> OfertaContext;
	private static Geography<Object> OfertaGis;
	private static Network<Object> OfertaNetwork;
	//Ciudad
	private static Context<Object> BogotaContext;
	private static Geography<Object> BogotaGis;
	//Demanda
	private static Context<Object> DemandaContext;
	private static Geography<Object> DemandaGis;
	private static Network<Object> DemandaNetwork;


	@Override
	public Context<Object> build(Context<Object> context){
		
		//Referencia al contexto principal
		SAABContext =context;		
		SAABContext.setId(VariablesGlobales.CONTEXTO_SAAB);
				
		GeographyParameters<Object>	geoparams 	= new GeographyParameters<Object>();
		
		//Ambiente Rural
		RuralContext	=new RuralContext();
		SAABContext.addSubContext(RuralContext);
		
		RuralGis	= GeographyFactoryFinder.createGeographyFactory(null).createGeography(VariablesGlobales.GEOGRAFIA_RURAL, RuralContext, geoparams);
		loadShapefiles(VariablesGlobales.MUNICIPIOS_SHAPEFILE,"municipios",RuralContext,RuralGis);
		
		OfertaContext	= new OfertaContext();
		OfertaGis		= GeographyFactoryFinder.createGeographyFactory(null).createGeography(
				VariablesGlobales.CONTEXTO_OFERTA, OfertaContext, new GeographyParameters<Object>(new SimpleAdder<Object>()));
		NetworkBuilder<Object> NetDemandaBuilder	=new NetworkBuilder<Object>(VariablesGlobales.RED_OFERTA,OfertaContext,false);
		OfertaNetwork	= NetDemandaBuilder.buildNetwork();
		
		RuralContext.addSubContext(OfertaContext);		
		
		
		//Ambiente Distrital
		BogotaContext 	= new DistritalContext();
		SAABContext.addSubContext(BogotaContext);
		
		BogotaGis		= GeographyFactoryFinder.createGeographyFactory(null).createGeography(VariablesGlobales.GEOGRAFIA_DISTRITAL, BogotaContext, geoparams);
		loadShapefiles(VariablesGlobales.BOGOTA_SHAPEFILE,"municipios",BogotaContext,BogotaGis);
		
		DemandaContext 	= new DemandaContext();
		DemandaGis		= GeographyFactoryFinder.createGeographyFactory(null).createGeography(
				VariablesGlobales.GEOGRAFIA_DEMANDA, DemandaContext, new GeographyParameters<Object>(new SimpleAdder<Object>()));
		NetworkBuilder<Object> NetOfertaBuilder	=new NetworkBuilder<Object>(VariablesGlobales.RED_OFERTA,OfertaContext,false);
		OfertaNetwork	= NetOfertaBuilder.buildNetwork();
		
		BogotaContext.addSubContext(DemandaContext);
		
		
		//Agroredes
		AgroredContext	= new AgroredContext();
		NetworkBuilder<AgenteSaab> NetAgroredBuilder = new NetworkBuilder<AgenteSaab>(VariablesGlobales.RED_AGRORED,AgroredContext,false);
		AgroredNetwork	= NetAgroredBuilder.buildNetwork();
		SAABContext.addSubContext(AgroredContext);
		
		//Nutriredes
		NutriredContext	= new NutriredContext();
		NetworkBuilder<AgenteSaab> NetNutriredBuilder = new NetworkBuilder<AgenteSaab>(VariablesGlobales.RED_NUTRIRED,NutriredContext,false);
		NutriredNetwork	= NetNutriredBuilder.buildNetwork();	
		SAABContext.addSubContext(NutriredContext);
		
		//Vias pricipales
		ViasprincipalesContext	= new ViasContext();
		ViasprincipalesGis		= GeographyFactoryFinder.createGeographyFactory(null).createGeography(
				VariablesGlobales.GEOGRAFIA_VIASPRINCIPALES, ViasprincipalesContext, new GeographyParameters<Object>(new SimpleAdder<Object>()));
		SAABContext.addSubContext(ViasprincipalesContext);
		
		ConexionesContext 	= new ConexionesContext();
		ConexionesGis 		= GeographyFactoryFinder.createGeographyFactory(null).createGeography(
				VariablesGlobales.GEOGRAFIA_CONEXIONES, ConexionesContext, new GeographyParameters<Object>(new SimpleAdder<Object>()));
		NetworkBuilder<Object> NetConxBuilder	=new NetworkBuilder<Object>(VariablesGlobales.RED_CONEXIONES,ConexionesContext,false);
		ConexionesNetwork = NetConxBuilder.buildNetwork();
		SAABContext.addSubContext(ConexionesContext);
							
			
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
		
		
		/*try{
			url = new File("").toURI().toURL();
			
		}catch(MalformedURLException e){
			e.printStackTrace();
		}*/
				
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
			NodoSAAB nodo			=null;
			Object plaza			=null;
			Object viatransitable	=null;
			
			
			if (geom instanceof MultiPolygon){
				
				MultiPolygon mp	=(MultiPolygon)feature.getDefaultGeometry();
				geom 			=(Polygon)mp.getGeometryN(0);
				name 			=(String)feature.getAttribute("NAME_2");
				System.out.println("Adding poligon-"+name+":"+geom.toText()+"//");
			}
			else if(geom instanceof Point){
				
				geom =(Point)feature.getDefaultGeometry();
				name =(String)feature.getAttribute("NAME_2");
			}
			else if(geom instanceof MultiLineString){
				
				MultiLineString linea	=(MultiLineString)feature.getDefaultGeometry();
				geom					=(LineString)linea.getGeometryN(0);
				name					=(String)feature.getAttribute("NAME_2");
			}
			
			switch(objeto){
			
			case "municipios": //Cuando carga municipios				
				
				region = new AmbienteLocal(new RegionConfigurada(name));
				region.setGeometria(geom);
				
				context.add(region);
				geography.move(region, geom);
				
				break;
			case "nodos": //Cuando carga Nodos
				
				nodo = new NodoSAAB(name);
				nodo.setGeometria(geom);
				
				context.add(nodo);
				geography.move(nodo, geom);
				
				break;
			case "plazas"://cuando carga Plazas
				
				break;
			case "vias"://Cuando carga Vias
				
				break;
			}			
		}		
	}
	
	/**
	 * Crea y ubica los productores aleatoriamente en el contexto rural
	 */
	private void crearProductores(){
		
	}

}
