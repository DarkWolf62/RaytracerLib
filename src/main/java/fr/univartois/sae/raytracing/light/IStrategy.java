package fr.univartois.sae.raytracing.light;

import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.object.Sphere;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Vector;

/**
 * @author matheo.dupuis
 *
 * This interface is used to implement a design pattern strategy to choose between the {@link BasicModel} and the {@link LambertModel}
 */
public interface IStrategy {

    /**
     * The method the class who implement the interface will have to do
     *
     * @param object the {@link AObject}
     * @param idObj the id of the {@link AObject}
     * @param p the intersection {@link Point}
     * @param scene the scene of the image
     * @return The {@link Color} of a pixel
     */
    Color modelMethod(AObject object, int idObj , Point p, Scene scene);
}
