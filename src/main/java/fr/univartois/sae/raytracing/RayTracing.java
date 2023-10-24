package fr.univartois.sae.raytracing;

import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.scene.SceneBuilder;
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
    Vector w=new Vector(lookFrom.subtraction(looKAt)).vectorProduct((lookFrom.subtraction(looKAt).normalize()));
    for(int i=0;i<scene.getWidth();i++){
        for(int j=0;j<scene.getHeight();j++){



        }
    }
}


}

