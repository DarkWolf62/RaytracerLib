package fr.univartois.sae.raytracing.light;

import fr.univartois.sae.raytracing.object.Sphere;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.triplet.Vector;

public interface IStrategy {

    public void modelMethod(Sphere object, Vector lookFrom, Vector d, double t, Scene scene);

}
