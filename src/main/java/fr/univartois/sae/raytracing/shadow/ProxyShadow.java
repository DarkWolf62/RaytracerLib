package fr.univartois.sae.raytracing.shadow;

import fr.univartois.sae.raytracing.light.Light;
import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.triplet.Point;

import java.util.List;

/**
 * @author matheo.dupuis
 *
 * This class is used as a proxy to call the method of {@link RealShadow} and implements the interface {@link IShadow}
 */
public class ProxyShadow implements IShadow{

    /**
     * Checks if the value of shadow is set to True to call the method shadowRequest from {@link RealShadow}
     *
     * @param scene the scene of the image
     * @param object the current {@link AObject}
     * @param p the intersection {@link Point} between the camera and the pixel
     * @return the {@link List} of {@link Light}  that illuminate the pixel
     */
    public List<Light> shadowRequest(Scene scene, AObject object, Point p){
        if (scene.isShadow()){
            RealShadow real = new RealShadow();
            return real.shadowRequest(scene,object,p);
        }
        return null;
    }
}
