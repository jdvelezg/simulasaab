package simulaSAAB.main;

public abstract class VariablesGlobales {
	
	/**
	 * Variables que apuntan a la ubicación de los archivos de datos geograficos ESRI Shapefiles
	 */	
	public static final String MUNICIPIOS_SHAPEFILE			="data/municipios.shp";
	public static final String BOGOTA_SHAPEFILE				="data/bogota.shp";		
	public static final String CENTROSURBANOS_SHAPEFILE		="data/centros_urbanos.shp";
	public static final String NODOSSAAB_SHAPEFILE			="data/nodos_saab.shp";
	public static final String PLAZASDISTRITALES_SHAPEFILE	="data/plazas_distritales.shp";
	public static final String VIASPRINCIPALES_SHAPEFILE	="data/vias_principales.shp";
	public static final String CONEXIONESVIALES_SHAPEFILE	="data/municipios.shp";
	
	/**
	 * Variables que definen los nombres de los contextos usados en la simulación.
	 */	
	/**
	 * CONTEXTOS SAAB
	 */
	public static final String CONTEXTO_SAAB 		="SAABContext";
	public static final String GEOGRAFIA_SAAB		="SAABGeography";
	
	//nutrired
	public static final String CONTEXTO_NUTRIRED 	="NutriredContext";//Nodos urbanos (plazas distritales)+(tiendas)
	public static final String RED_NUTRIRED			="NutriredNetwork";
	//agrored
	public static final String CONTEXTO_AGRORED 	="AgroredContext";//Nodos rurales
	public static final String RED_AGRORED 			="AgroredNetwork";
	/**
	 * VIAS TRANSITABLES
	 */
	public static final String CONTEXTO_VIASPRINCIPALES	="RoadContext";//Vias transitables
	public static final String GEOGRAFIA_VIASPRINCIPALES="RoadGeography";
	public static final String CONTEXTO_CONEXIONES		="JunctionContext";//Puntos de entrada y salida de vias principales
	public static final String RED_CONEXIONES			="JunctionNetwork";
	public static final String GEOGRAFIA_CONEXIONES		="RoadGeography";
	/**
	 * CONTEXTOS RURALES
	 */
	public static final String CONTEXTO_RURAL	="RuralContext";
	public static final String GEOGRAFIA_RURAL	="RuralGeography";//Municipios
	//Puntos de Oferta
	public static final String CONTEXTO_OFERTA	="OfferContext";//Productores
	public static final String GEOGRAFIA_OFERTA	="OfferGeography";
	public static final String RED_OFERTA		="OfferNetwork";
	//Centros urbanos de los municipios
	public static final String CONTEXTO_PUEBLOS	="UrbanPointContext";//Centros urbanos
	public static final String GEOGRAFIA_PUEBLOS="UrbanPointGeography";
	public static final String RED_PUEBLOS		="UrbanPointNetwork";
	/**
	 * CONTEXTOS DISTRITALES
	 */
	public static final String CONTEXTO_DISTRITAL	="UrbanContext";
	public static final String GEOGRAFIA_DISTRITAL	="UrbanGeography";//Bogota
	//Puntos de Demanda
	public static final String CONTEXTO_DEMANDA		="DemandContext";//Tiendas
	public static final String GEOGRAFIA_DEMANDA	="DemandGeography";
	public static final String RED_DEMANDA			="DemandNetwork";
	
}
