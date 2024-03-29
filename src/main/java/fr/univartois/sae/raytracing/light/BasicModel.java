package fr.univartois.sae.raytracing.light;

import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Vector;

import java.util.List;

/**
 *
 * This class is a part of the design pattern strategy and represents the basic method to apply
 * The class implements interface {@link IStrategy}
 *
 * @author matheo.dupuis
 */
public class BasicModel implements IStrategy{

    /**
     * This method returns the {@link Color} of a pixel using the basic method
     *
     * @param object the {@link AObject}
     * @param idObj the id of the {@link AObject}
     * @param p the intersection {@link Point}
     * @param scene the scene of the image
     * @param d a {@link Vector}
     * @return The {@link Color} of a pixel using the basic method
     */
    @Override
    public Color modelMethod(AObject object, int idObj , Point p, Scene scene, Vector d) {
        return (Color) scene.getColors().get("ambient");

    }

    /**
     * This method returns the {@link Color} of a pixel using the basic method when shadow is on.
     *
     * @param object the {@link AObject}
     * @param idObj the id of the {@link AObject}
     * @param p the intersection {@link Point}
     * @param scene the scene of the image
     * @param d a {@link Vector}
     * @param list the {@link List<Light>} of the {@link Light} that illuminate the pixel
     * @return The {@link Color} of a pixel using the basic method with a shadow
     */
    @Override
    public Color modelMethodShadow(AObject object, int idObj, Point p, Scene scene, Vector d, List<Light> list) {
        return modelMethod(object, idObj, p, scene, d);
    }
}
