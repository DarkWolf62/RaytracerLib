package fr.univartois.sae.raytracing.light;

import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.object.Plane;
import fr.univartois.sae.raytracing.object.Sphere;
import fr.univartois.sae.raytracing.object.Triangle;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Triplet;
import fr.univartois.sae.raytracing.triplet.Vector;

import java.util.List;

import static java.lang.Math.max;

/**
 * @author matheo.dupuis
 *
 * This class is used for the Lambert model and implements the interface IStrategy
 */
public class LambertModel implements IStrategy{

    /**
     * This method returns the color of a pixel using the Lambert method
     *
     * @param object
     * @param idObj
     * @param p
     * @param scene
     * @param d
     * @return The color of a pixel using the basic method
     */
    @Override
    public Color modelMethod(AObject object, int idObj , Point p, Scene scene, Vector d) {
        Color color = new Color(0,0,0);
        Triplet cc;
        Vector n = new Vector(0,0,0);
        if (object instanceof Sphere) {
            cc = ((Sphere) object).getCoordinate().getTriplet();
            n = p.subtraction(cc).scalarMultiplication(1/ p.subtraction(cc).norm());
        } else if (object instanceof Plane) {
            n = ((Plane) object).getNormal();
        } else if (object instanceof Triangle) {
            n= ((Triangle) object).getNormal();
        }
        //The sum using the Lambert method
        for (Light light : scene.getLights()){

            Vector ldir = new Vector(0,0,0);

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
            color = color.addition(light.getColor().scalarMultiplication(cos).getTriplet());
        }
        Color cDiffuse = object.getColor();
        color = ((Color)scene.getColors().get("ambient")).addition(color.schurProduct(cDiffuse.getTriplet()).getTriplet());
        if (color.getTriplet().getX() > 1)
            color.getTriplet().setX(1);
        if (color.getTriplet().getY() > 1)
            color.getTriplet().setY(1);
        if (color.getTriplet().getZ() > 1)
            color.getTriplet().setZ(1);
        return color;
    }




    @Override
    public Color modelMethodShadow(AObject object, int idObj , Point p, Scene scene, Vector d, List<Light> list) {
        Color color = new Color(0, 0, 0);
        Triplet cc;
        Vector n = new Vector(0, 0, 0);
        if (object instanceof Sphere) {
            cc = ((Sphere) object).getCoordinate().getTriplet();
            n = p.subtraction(cc).scalarMultiplication(1 / p.subtraction(cc).norm());
        } else if (object instanceof Plane) {
            n = ((Plane) object).getNormal();
        } else if (object instanceof Triangle) {
            n = ((Triangle) object).getNormal();
        }
        //The sum using the Lambert method
        for (Light light : list) {

            Vector ldir = new Vector(0, 0, 0);

            // We are testing the type of the current light and adjust the value of ldir vector
            if (light instanceof DirectionalLight) {
                ldir = ((DirectionalLight) light).getVector().normalize();
            } else if (light instanceof PonctualLight) {
                Point l = ((PonctualLight) light).getPoint();
                ldir = l.subtraction(p.getTriplet()).scalarMultiplication(1 / l.subtraction(p.getTriplet()).norm());
            }

            //We add the value of the current color to the sum
            double cos = max(n.scalarProduct(ldir.getTriplet()), 0);
            color = color.addition(light.getColor().scalarMultiplication(cos).getTriplet());
        }
        Color cDiffuse = object.getColor();
        color = ((Color) scene.getColors().get("ambient")).addition(color.schurProduct(cDiffuse.getTriplet()).getTriplet());
        if (color.getTriplet().getX() > 1)
            color.getTriplet().setX(1);
        if (color.getTriplet().getY() > 1)
            color.getTriplet().setY(1);
        if (color.getTriplet().getZ() > 1)
            color.getTriplet().setZ(1);
        return color;
    }

}
