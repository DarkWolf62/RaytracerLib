package fr.univartois.sae.raytracing;

import fr.univartois.sae.raytracing.light.BasicModel;
import fr.univartois.sae.raytracing.light.IStrategy;
import fr.univartois.sae.raytracing.light.LambertModel;
import fr.univartois.sae.raytracing.light.PhongModel;
import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.parser.Parser;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.scene.SceneBuilder;

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

        //Initialization of the strategy used, we create a new strategy and check if there are some diffused colors to use the Lambert method
        // Else we use the basic Method
        IStrategy strategy;
        AObject s = scene.getObjects().get(0);
        if (s.getColor() == null)
            strategy = new BasicModel();
        else if(scene.getColors().get("specular") != null){
            strategy = new PhongModel();
        } else
            strategy = new LambertModel();


        //Creation of a RayTracing object who generate the image thanks to his constructor
        new RayTracing(scene, strategy);
    }
}