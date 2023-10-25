package fr.univartois.sae.raytracing;

import fr.univartois.sae.raytracing.light.BasicModel;
import fr.univartois.sae.raytracing.light.IStrategy;
import fr.univartois.sae.raytracing.light.LambertModel;
import fr.univartois.sae.raytracing.parser.Parser;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.scene.SceneBuilder;
import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.object.Sphere;

import java.net.URL;
import java.util.ArrayList;


/**
 * @author matheo.dupuis
 *
 * This is the main class
 *
 */
public class Main {
    public static void main(String[] args){
        Parser parser = new Parser("src/main/resources/fr.univartois.sae.raytracing/test.txt");
        parser.construct();
        SceneBuilder sceneBuilder = (SceneBuilder) parser.getBuilder();
        Scene scene = sceneBuilder.getResult();
        System.out.println(scene.toString());
        IStrategy strategy;
        Sphere s = (Sphere) (scene.getObjects().get(0));
        if (s.getColor() == null)
            strategy = new BasicModel();
        else
            strategy = new LambertModel();
        RayTracing r = new RayTracing(scene, strategy);
    }
}