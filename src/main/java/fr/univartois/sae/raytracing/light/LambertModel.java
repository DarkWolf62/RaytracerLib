package fr.univartois.sae.raytracing.light;

import fr.univartois.sae.raytracing.object.Sphere;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Triplet;
import fr.univartois.sae.raytracing.triplet.Vector;

import static java.lang.Math.max;

/**
 * @author matheo.dupuis
 *
 * This class is used to implement the Lambert model
 */
public class LambertModel implements IStrategy{

    @Override
    public void modelMethod(Sphere object, Vector lookFrom, Vector d, double t, Scene scene) {

        Triplet cc = object.getCoordinate().getTriplet();
        Point p = new Point(lookFrom.addition(d.scalarMultiplication(t).getTriplet()).getTriplet());
        Vector n = p.subtraction(cc).scalarMultiplication(1/ p.subtraction(cc).norm());
       // The color we will return
        Color color = new Color(0,0,0);

        //The sum using the Lambert method
        for (int i = 0; i < scene.getLights().size(); i++){

            Vector ldir = new Vector(0,0,0);
            // The current light i in the list
            Light light = scene.getLights().get(i);

            // We are testing the type of the current light and adjust the value of ldir vector
            if (light instanceof DirectionalLight) {
               ldir = ((DirectionalLight) light).getVector();
            }
            else if (light instanceof  PonctualLight) {
                Point l = ((PonctualLight) light).getPoint();
                ldir = l.subtraction(p.getTriplet()).scalarMultiplication(1/l.subtraction(p.getTriplet()).norm());
            }

            //We add the value of the current color to the sum
            double cos = max(n.scalarProduct(ldir.getTriplet()), 0);
            color.addition(light.getColor().scalarMultiplication(cos).getTriplet());
        }
        // A MODIFIER ON PEUT AVOIR PLUSIEURS COULEURS DANS DIFFUSE
        scene.getColors().get("diffuse");
    }
}
