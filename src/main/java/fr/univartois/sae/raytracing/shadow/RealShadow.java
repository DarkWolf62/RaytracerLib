package fr.univartois.sae.raytracing.shadow;

import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Vector;

public class RealShadow {

    public void shadowRequest(AObject object,Point p, Vector d, Scene scene) {
        for (AObject o : scene.getObjects()) {

        }
    }
}
