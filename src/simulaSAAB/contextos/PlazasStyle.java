package simulaSAAB.contextos;

import gov.nasa.worldwind.render.SurfacePolygon;
import gov.nasa.worldwind.render.SurfaceShape;

import java.awt.Color;

import repast.simphony.visualization.gis3D.style.SurfaceShapeStyle;
import simulaSAAB.modeloSimulacion.PlazaDistrital;

public class PlazasStyle implements SurfaceShapeStyle<PlazaDistrital> {
	
	@Override
	public SurfaceShape getSurfaceShape(PlazaDistrital object, SurfaceShape shape) {
		// TODO Auto-generated method stub
		return new SurfacePolygon();
	}

	@Override
	public Color getFillColor(PlazaDistrital obj) {
		// TODO Auto-generated method stub
		return Color.CYAN;
	}

	@Override
	public double getFillOpacity(PlazaDistrital obj) {
		// TODO Auto-generated method stub
		return 0.25;
	}

	@Override
	public Color getLineColor(PlazaDistrital obj) {
		// TODO Auto-generated method stub
		return Color.BLACK;
	}

	@Override
	public double getLineOpacity(PlazaDistrital obj) {
		// TODO Auto-generated method stub
		return 0.9;
	}

	@Override
	public double getLineWidth(PlazaDistrital obj) {
		// TODO Auto-generated method stub
		return 1;
	}

}
