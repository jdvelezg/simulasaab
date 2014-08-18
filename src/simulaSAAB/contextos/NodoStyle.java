package simulaSAAB.contextos;

import gov.nasa.worldwind.render.SurfacePolygon;
import gov.nasa.worldwind.render.SurfaceShape;

import java.awt.Color;

import repast.simphony.visualization.gis3D.style.SurfaceShapeStyle;
import simulaSAAB.modeloSimulacion.agentes.NodoSAAB;

public class NodoStyle implements SurfaceShapeStyle<NodoSAAB> {
	
	@Override
	public SurfaceShape getSurfaceShape(NodoSAAB object, SurfaceShape shape) {
		// TODO Auto-generated method stub
		return new SurfacePolygon();
	}

	@Override
	public Color getFillColor(NodoSAAB obj) {
		// TODO Auto-generated method stub
		return Color.LIGHT_GRAY;
	}

	@Override
	public double getFillOpacity(NodoSAAB obj) {
		// TODO Auto-generated method stub
		return 0.25;
	}

	@Override
	public Color getLineColor(NodoSAAB obj) {
		// TODO Auto-generated method stub
		return Color.BLACK;
	}

	@Override
	public double getLineOpacity(NodoSAAB obj) {
		// TODO Auto-generated method stub
		return 0.9;
	}

	@Override
	public double getLineWidth(NodoSAAB obj) {
		// TODO Auto-generated method stub
		return 1;
	}

}
