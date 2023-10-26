package fr.univartois.sae.raytracing.shadow;

import fr.univartois.sae.raytracing.light.DirectionalLight;
import fr.univartois.sae.raytracing.light.Light;
import fr.univartois.sae.raytracing.light.PonctualLight;
import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Vector;

import java.util.ArrayList;
import java.util.List;

public class RealShadow {

    public List<Light> shadowRequest(Scene scene, AObject object, Point p){
        List<Light> list = new ArrayList<>();
        for (Light light : scene.getLights()){
            Vector d;
            if(light instanceof DirectionalLight directionalLight)
                d = directionalLight.getVector();
            else
                d = p.subtraction(((PonctualLight)light).getPoint().getTriplet());
            boolean isHere = false;
            for (AObject obj : scene.getObjects()){
                if (! obj.equals(object)) {
                    p = obj.calcP(d, p.getTriplet());
                    if (p != null) {
                        isHere = true;
                        break;
                    }
                }
            }
            if (! isHere)
                list.add(light);
        }
        return list;
    }
}
