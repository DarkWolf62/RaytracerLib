package fr.univartois.sae.raytracing.shadow;

import fr.univartois.sae.raytracing.light.Light;
import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.triplet.Point;

import java.util.List;

/**
 * @author matheo.dupuis
 *
 *This interface is used to implements the shadows
 */
public interface IShadow {

    /**
     * returns the {@link List} of {@link Light}  that illuminate the pixel
     *
     * @param scene the scene of the image
     * @param object the current {@link AObject}
     * @param p the intersection {@link Point} between the camera and the pixel
     * @return the {@link List} of {@link Light}  that illuminate the pixel
     */
    public List<Light> shadowRequest(Scene scene, AObject object, Point p);
}
