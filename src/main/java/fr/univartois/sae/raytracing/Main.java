package fr.univartois.sae.raytracing;

import fr.univartois.sae.raytracing.parser.Parser;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.scene.SceneBuilder;

import java.net.URL;


/**
 * @author matheo.dupuis
 *
 * This is the main class
 *
 */
public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser("src/main/resources/fr.univartois.sae.raytracing/test.txt");
        parser.construct();
        SceneBuilder sceneBuilder = (SceneBuilder) parser.getBuilder();
        Scene scene = sceneBuilder.getResult();
        System.out.println(scene.toString());
        RayTracing r = new RayTracing(scene);
    }
}