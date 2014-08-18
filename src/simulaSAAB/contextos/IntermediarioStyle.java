package simulaSAAB.contextos;

import gov.nasa.worldwind.WorldWind;
import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.render.Material;
import gov.nasa.worldwind.render.Offset;
import gov.nasa.worldwind.render.PatternFactory;
import gov.nasa.worldwind.render.WWTexture;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;

import repast.simphony.visualization.gis3D.BufferedImageTexture;
import repast.simphony.visualization.gis3D.PlaceMark;
import repast.simphony.visualization.gis3D.style.MarkStyle;
import simulaSAAB.modeloSimulacion.agentes.Intermediario;

public class IntermediarioStyle implements MarkStyle<Intermediario> {
	
	private Offset labelOffset;
	
	public IntermediarioStyle(){
		
		/**
		 * The gov.nasa.worldwind.render.Offset is used to position the label from 
		 *   the mark point location.  The first two arguments in the Offset 
		 *   constructor are the x and y offset values.  The third and fourth 
		 *   arguments are the x and y units for the offset. AVKey.FRACTION 
		 *   represents units of the image texture size, with 1.0 being one image 
		 *   width/height.  AVKey.PIXELS can be used to specify the offset in pixels. 
		 */
		labelOffset = new Offset(1.2d, 0.6d, AVKey.FRACTION, AVKey.FRACTION);
	}

	@Override
	public WWTexture getTexture(Intermediario object, WWTexture texture) {
		// WWTexture is null on first call.
		
		Color color = Color.RED;	
						
		BufferedImage image = PatternFactory.createPattern(PatternFactory.PATTERN_CIRCLE, 
					new Dimension(10, 10), 0.7f,  color);

		return new BufferedImageTexture(image);	
	}
	
	/**
	 * The PlaceMark is a WWJ PointPlacemark implementation with a different 
	 *   texture handling mechanism.  All other standard WWJ PointPlacemark 
	 *   attributes can be changed here.  PointPlacemark label attributes could be
	 *   set here, but are also available through the MarkStyle interface.
	 *   
	 *   @see gov.nasa.worldwind.render.PointPlacemark for more info.
	 */
	@Override
	public PlaceMark getPlaceMark(Intermediario object, PlaceMark mark) {
		
		// PlaceMark is null on first call.
		if (mark == null)
		mark = new PlaceMark();
				
		/**
		 * The Altitude mode determines how the mark appears using the elevation.
		 *   WorldWind.ABSOLUTE places the mark at elevation relative to sea level
		 *   WorldWind.RELATIVE_TO_GROUND places the mark at elevation relative to ground elevation
		 *   WorldWind.CLAMP_TO_GROUND places the mark at ground elevation
		 */
		mark.setAltitudeMode(WorldWind.RELATIVE_TO_GROUND);
		mark.setLineEnabled(false);
			
		return mark;
	}
	
	
	@Override
	public double getElevation(Intermediario obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getScale(Intermediario obj) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public double getHeading(Intermediario obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getLabel(Intermediario obj) {
		// TODO Auto-generated method stub
		return "Intermediario";
	}

	@Override
	public Color getLabelColor(Intermediario obj) {
		// TODO Auto-generated method stub
		return Color.BLUE;
	}

	@Override
	public Font getLabelFont(Intermediario obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Return an Offset that determines the label position relative to the mark 
	 * position.  @see gov.nasa.worldwind.render.Offset
	 * 
	 */
	@Override
	public Offset getLabelOffset(Intermediario obj) {
		// TODO Auto-generated method stub
		return labelOffset;
	}
	
	/** Width of the line that connects an elevated mark with the surface.  Use
	 *    a value of 0 to disable line drawing.
	 *   
	 */
	@Override
	public double getLineWidth(Intermediario obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Material getLineMaterial(Intermediario obj, Material lineMaterial) {
		
		if (lineMaterial == null){
			lineMaterial = new Material(Color.RED);
		}
		
		return lineMaterial;
	}

}
