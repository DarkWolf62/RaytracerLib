package fr.univartois.sae.raytracing.light;

import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Vector;

import java.util.List;

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
     * @param d
     * @return The color of a pixel using the basic method
     */
    @Override
    public Color modelMethod(AObject object, int idObj , Point p, Scene scene, Vector d) {
        Color color = (Color) scene.getColors().get("ambient");
        return color;

    }

    @Override
    public Color modelMethodShadow(AObject object, int idObj, Point p, Scene scene, Vector d, List<Light> list) {
        return modelMethod(object,idObj,p,scene, d);
    }
}
