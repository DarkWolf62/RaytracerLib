package fr.univartois.sae.raytracing.light;

import fr.univartois.sae.raytracing.object.Sphere;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Vector;

/**
 * @author matheo.dupuis
 *
 * This interface is used to implement a design pattern strategy to choose between the basic model and the Lambert model
 */
public interface IStrategy {

    /**
     * The method the class who implement the interface will have to do
     *
     * @param object
     * @param idObj
     * @param p
     * @param scene
     * @return The color of a pixel
     */
    public Color modelMethod(Sphere object, int idObj , Point p, Scene scene);
}
