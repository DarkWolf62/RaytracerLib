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
 * This class is a part of the design pattern strategy and represents the basic method to apply
 * The class implements interface {@link IStrategy}
 */
public class BasicModel implements IStrategy{

    /**
     * This method returns the {@link Color} of a pixel using the basic method
     *
     * @param object the {@link AObject}
     * @param idObj the id of the {@link AObject}
     * @param p the intersection {@link Point}
     * @param scene the scene of the image
     * @return The {@link Color} of a pixel using the basic method
     */
    @Override
    public Color modelMethod(AObject object, int idObj , Point p, Scene scene) {
        return (Color) scene.getColors().get("ambient");
    }
}
