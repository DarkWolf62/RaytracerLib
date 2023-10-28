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
     * @param d a {@link Vector}
     * @return The {@link Color} of a pixel
     */
    public Color modelMethod(AObject object, int idObj , Point p, Scene scene, Vector d);

    /**
     * The method the class who implement the interface will have to do with shadow
     *
     * @param object the {@link AObject}
     * @param idObj the id of the {@link AObject}
     * @param p the intersection {@link Point}
     * @param scene the scene of the image
     * @param d a {@link Vector}
     * @param list the {@link List<Light>} of {@link Light} that illuminate the pixel
     * @return The {@link Color} of a pixel
     */
    public Color modelMethodShadow(AObject object, int idObj , Point p, Scene scene, Vector d, List<Light> list);
}
