package fr.univartois.sae.raytracing;

import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.object.Sphere;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.scene.SceneBuilder;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Triplet;
import fr.univartois.sae.raytracing.triplet.Vector;

import java.awt.image.BufferedImage;

public class RayTracing {

    /*
    charger la scène
— pour chaque pixel (i, j) de l’image à générer
    — calculer le vecteur unitaire d qui représente un rayon allant de l’œil lookF rom au centre du
    pixel (i, j)
    — rechercher le point p = lookF rom + d × t d’intersection le plus proche (t minimal) avec un
    objet de la scène
    — si p existe alors calculer sa couleur
    — sinon utiliser du noir
    — peindre le pixel (i, j) avec la couleur adéquate
    — sauvegarder l’image
     */

private Scene scene;

private BufferedImage image;

public RayTracing(Scene scene){
    this.scene=scene;
    Triplet lookFrom=scene.getCamera().get(0);
    Triplet looKAt=scene.getCamera().get(1);
    Vector up = new Vector(scene.getCamera().get(2));
    Vector w=new Vector(lookFrom.subtraction(looKAt)).scalarMultiplication((1/(lookFrom.subtraction(looKAt).norm())));
    Vector u = (up.vectorProduct(w.getTriplet())).scalarMultiplication(1/up.vectorProduct(w.getTriplet()).norm());
    Vector v = (w.vectorProduct(u.getTriplet())).scalarMultiplication(1/up.vectorProduct(w.getTriplet()).norm());
    double fovr = (scene.getFov()*Math.PI)/180;
    double pixelHeight = Math.tan(fovr/2);
    double pixelWidth = pixelHeight * (scene.getWidth()/ scene.getHeight());
    for(int i=0;i<scene.getWidth();i++){
        for(int j=0;j<scene.getHeight();j++){
            double a = (-(scene.getWidth()/2)+(i+0.5)* pixelWidth);
            double b = ((scene.getHeight()/2)-(j+0.5)*pixelHeight);
            double t;
            Vector d = new Vector(u.scalarMultiplication(a).addition(v.scalarMultiplication(b).subtraction(w.getTriplet()).scalarMultiplication(1/u.scalarMultiplication(a).addition(v.scalarMultiplication(b).subtraction(w.getTriplet()).getTriplet()).norm()).getTriplet()).getTriplet());
            for (AObject object : scene.getObjects()) {
                if (object instanceof Sphere) {
                    double t2;
                    double tb = lookFrom.subtraction(((Sphere) object).getCoordinate().getTriplet()).scalarMultiplication(2).scalarProduct(d.getTriplet());
                    double tc = (lookFrom.subtraction(((Sphere) object).getCoordinate().getTriplet())).scalarProduct(lookFrom.subtraction(((Sphere) object).getCoordinate().getTriplet())) - (((Sphere) object).getRadius() * ((Sphere) object).getRadius());
                    double delta = Math.pow(tb, 2) - 4 * tc;
                    if (delta == 0) {
                        t = -tb / 2;
                    } else if (delta > 0) {
                        t = (-tb + Math.sqrt(delta)) / 2;
                        t2 = (-tb - Math.sqrt(delta)) / 2;
                        if (t2 > 0)
                            t = t2;
                        else if (t < 0)
                            t = -1;
                    }
                }
            }
            //Point p = new Point();
        }
    }
}


}

