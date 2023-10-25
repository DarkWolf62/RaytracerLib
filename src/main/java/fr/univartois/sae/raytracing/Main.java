package fr.univartois.sae.raytracing;

import fr.univartois.sae.raytracing.light.BasicModel;
import fr.univartois.sae.raytracing.light.IStrategy;
import fr.univartois.sae.raytracing.light.LambertModel;
import fr.univartois.sae.raytracing.parser.Parser;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.scene.SceneBuilder;
import fr.univartois.sae.raytracing.object.Sphere;



/**
 * @author matheo.dupuis
 * @author nicolas.nourry
 * @author nicolas.blart
 * @author leo.denis
 *
 * This is the main class used to run the programm
 */
public class Main {
    public static void main(String[] args){
        // Creation of the parser and construction of the scene
        Parser parser = new Parser("src/main/resources/fr.univartois.sae.raytracing/test.txt");
        parser.construct();
        SceneBuilder sceneBuilder = (SceneBuilder) parser.getBuilder();
        Scene scene = sceneBuilder.getResult();

        // We print the scene to see the informations
        System.out.println(scene.toString());

        //Initialization of the strategy used, we create a new strategy and check if there are some diffused colors to use the Lambert method
        // Else we use the basic Method
        IStrategy strategy;
        Sphere s = (Sphere) (scene.getObjects().get(0));
        if (s.getColor() == null)
            strategy = new BasicModel();
        else
            strategy = new LambertModel();

        //Creation of a RayTracing object who generate the image thanks to his constructor
        RayTracing r = new RayTracing(scene, strategy);
    }
}