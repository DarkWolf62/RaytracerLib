package fr.univartois.sae.raytracing.shadow;

import fr.univartois.sae.raytracing.light.Light;
import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.triplet.Point;

import java.util.List;

public class ProxyShadow implements IShadow{

    public List<Light> shadowRequest(Scene scene, AObject object, Point p){
        if (scene.isShadow()){
            RealShadow real = new RealShadow();
            return real.shadowRequest(scene,object,p);
        }
        return null;
    }
}
