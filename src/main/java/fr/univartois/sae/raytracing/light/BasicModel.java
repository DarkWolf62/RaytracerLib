package fr.univartois.sae.raytracing.light;

import fr.univartois.sae.raytracing.object.Sphere;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Vector;

/**
 * @author matheo.dupuis
 *
 * This class is a part of the design pattern strategy and represents the basic method to apply
 * The class implements interface IStrategy
 */
public class BasicModel implements IStrategy{

    /**
     * This method returns the color of a pixel using the basic method
     *
     * @param object
     * @param idObj
     * @param p
     * @param scene
     * @return The color of a pixel using the basic method
     */
    @Override
    public Color modelMethod(Sphere object, int idObj , Point p, Scene scene) {
        Color color = (Color) scene.getColors().get("ambient");
        return color;

    }
}
