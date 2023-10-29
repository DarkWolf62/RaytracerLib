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
 *
 * This class represents the method that uses the {@link PhongModel} and implements the interface {@link IStrategy}
 *
 * @author nicolas.blart
 */

public class PhongModel implements IStrategy{

    /**
     * This method returns the {@link Color} of a pixel using the Phong method.
     * @param object the {@link AObject}
     * @param idObj the id of the {@link AObject}
     * @param p the intersection {@link Point}
     * @param scene the scene of the image
     * @param d a {@link Vector}
     * @return The {@link Color} of a pixel using the {@link PhongModel}
     */
    @Override
    public Color modelMethod(AObject object, int idObj , Point p, Scene scene, Vector d) {
        Color color = new Color(0,0,0);
        Color color2 = new Color(0,0,0);
        Triplet cc;
        Vector n = new Vector(0,0,0);
        if (object instanceof Sphere sphere) {
            cc = sphere.getCoordinate().getTriplet();
            n = p.subtraction(cc).scalarMultiplication(1/ p.subtraction(cc).norm());
        } else if (object instanceof Plane plane) {
            n = plane.getNormal();
        } else if (object instanceof Triangle triangle) {
            n= triangle.getNormal();
        }
        //The sum using the Lambert method
        for (Light light : scene.getLights()){

            Vector ldir = new Vector(0,0,0);

            // We are testing the type of the current light and adjust the value of ldir vector
            if (light instanceof DirectionalLight directionalLight) {
                ldir = directionalLight.getVector();
            }
            else if (light instanceof  PonctualLight ponctualLight) {
                Point l = ponctualLight.getPoint();
                ldir = l.subtraction(p.getTriplet()).scalarMultiplication(1/l.subtraction(p.getTriplet()).norm());
            }
            Vector eyedir = d.scalarMultiplication(-1);
            //We add the value of the current color to the sum
            double cos = max(n.scalarProduct(ldir.getTriplet()), 0);
            color = color.addition(light.getColor().scalarMultiplication(cos).getTriplet());
            double cos2 = max(n.scalarProduct(ldir.addition(eyedir.getTriplet()).normalize().getTriplet()),0);
            color2 = color2.addition(light.getColor().scalarMultiplication(Math.pow(cos2,scene.getShininess())).getTriplet());
        }
        Color cDiffuse = object.getColor();
        color = ((Color)scene.getColors().get("ambient")).addition(color.schurProduct(cDiffuse.getTriplet()).getTriplet().addition(color2.schurProduct(((Color) scene.getColors().get("specular")).getTriplet()).getTriplet()));
        if (color.getTriplet().getX() > 1)
            color.getTriplet().setX(1);
        if (color.getTriplet().getY() > 1)
            color.getTriplet().setY(1);
        if (color.getTriplet().getZ() > 1)
            color.getTriplet().setZ(1);
        return color;
    }

    /**
     * This method returns the {@link Color} of a pixel using the Phong method when shadow is on.
     * @param object the {@link AObject}
     * @param idObj the id of the {@link AObject}
     * @param p the intersection {@link Point}
     * @param scene the scene of the image
     * @param d a {@link Vector}
     * @param list a {@link List} of {@link Light}
     * @return The {@link Color} of a pixel using the {@link PhongModel}
     */
    @Override
    public Color modelMethodShadow(AObject object, int idObj, Point p, Scene scene, Vector d, List<Light> list) {
        Color color = new Color(0,0,0);
        Color color2 = new Color(0,0,0);
        Triplet cc;
        Vector n = new Vector(0,0,0);
        if (object instanceof Sphere sphere) {
            cc = sphere.getCoordinate().getTriplet();
            n = p.subtraction(cc).scalarMultiplication(1/ p.subtraction(cc).norm());
        } else if (object instanceof Plane plane) {
            n = plane.getNormal();
        } else if (object instanceof Triangle triangle) {
            n= triangle.getNormal();
        }
        //The sum using the Lambert method
        for (Light light : list){

            Vector ldir = new Vector(0,0,0);

            // We are testing the type of the current light and adjust the value of ldir vector
            if (light instanceof DirectionalLight directionalLight) {
                ldir = directionalLight.getVector();
            }
            else if (light instanceof  PonctualLight ponctualLight) {
                Point l = ponctualLight.getPoint();
                ldir = l.subtraction(p.getTriplet()).scalarMultiplication(1/l.subtraction(p.getTriplet()).norm());
            }
            Vector eyedir = d.scalarMultiplication(-1);
            //We add the value of the current color to the sum
            double cos = max(n.scalarProduct(ldir.getTriplet()), 0);
            color = color.addition(light.getColor().scalarMultiplication(cos).getTriplet());
            double cos2 = max(n.scalarProduct(ldir.addition(eyedir.getTriplet()).normalize().getTriplet()),0);
            color2 = color2.addition(light.getColor().scalarMultiplication(Math.pow(cos2,scene.getShininess())).getTriplet());
        }
        Color cDiffuse = object.getColor();
        color = ((Color)scene.getColors().get("ambient")).addition(color.schurProduct(cDiffuse.getTriplet()).getTriplet().addition(color2.schurProduct(((Color) scene.getColors().get("specular")).getTriplet()).getTriplet()));
        if (color.getTriplet().getX() > 1)
            color.getTriplet().setX(1);
        if (color.getTriplet().getY() > 1)
            color.getTriplet().setY(1);
        if (color.getTriplet().getZ() > 1)
            color.getTriplet().setZ(1);
        return color;    }
}
