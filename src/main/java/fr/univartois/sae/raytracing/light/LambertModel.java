package fr.univartois.sae.raytracing.light;

import fr.univartois.sae.raytracing.object.Sphere;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.triplet.Triplet;
import fr.univartois.sae.raytracing.triplet.Vector;

public class LambertModel implements IStrategy{

    @Override
    public void modelMethod(Sphere object, Vector lookFrom, Vector d, double t, Scene scene) {

        Triplet cc = object.getCoordinate().getTriplet();
        Vector p = lookFrom.addition(d.scalarMultiplication(t).getTriplet());
        Vector n = p.subtraction(cc).scalarMultiplication(1/ p.subtraction(cc).norm());
        Triplet col;
        Triplet somme;
        for (int i = 0; i < scene.getLights().size(); i++);{
            //DIRECTION DE LA LUMIERE VECTEUR LDIR
            // SUREMENT VERIFIER DANS LE FOR SI LA LUMIERE ACTUELLE EST PONCTUELLE OU PAS
            //ENSUITE CALCULER VECTEUR LDIR

        }
    }
}
