package fr.univartois.sae.raytracing.shadow;

import fr.univartois.sae.raytracing.light.DirectionalLight;
import fr.univartois.sae.raytracing.light.Light;
import fr.univartois.sae.raytracing.light.PonctualLight;
import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * @author matheo.dupuis
 * @author leo.denis
 *This class is used to set a {@link List} of {@link Light} used create the shadow and impelments the interface {@link IShadow}
 */
public class RealShadow implements IShadow{

    /**
     * returns the {@link List} of {@link Light}  that illuminate the pixel
     *
     * @param scene the scene of the image
     * @param object the current {@link AObject}
     * @param p the intersection {@link Point} between the camera and the pixel
     * @return the {@link List} of {@link Light}  that illuminate the pixel
     */
    public List<Light> shadowRequest(Scene scene, AObject object, Point p){
        List<Light> list = new ArrayList<>();
        for (Light light : scene.getLights()){
            Vector d;
            double distMin;
            boolean isHere = false;
            if(light instanceof DirectionalLight directionalLight) {
                d = directionalLight.getVector().normalize();
                for (AObject obj : scene.getObjects()){
                    if (! obj.equals(object)) {
                        Point point = obj.calcP(d,p.getTriplet());
                        if (point!=null) {
                            Vector v = p.subtraction(point.getTriplet());
                            if (!v.oppositeDirection(d)) {
                                isHere = true;
                                break;
                            }
                        }
                    }
                }
            }
            else {
                d = p.subtraction(((PonctualLight) light).getPoint().getTriplet()).normalize();
                distMin = object.distance(((PonctualLight)light).getPoint(), d);
                for (AObject obj : scene.getObjects()){
                    if (! obj.equals(object)) {
                        double dist = obj.distance(((PonctualLight)light).getPoint(), d);
                        if (dist<=distMin && dist!=-1) {
                            isHere = true;
                            break;
                        }
                    }
                }
            }
            if (! isHere)
                list.add(light);
        }
        return list;
    }
}
