package fr.univartois.sae.raytracing.scene;

import fr.univartois.sae.raytracing.light.Light;
import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Triplet;
import org.json.simple.JSONObject;

import java.util.ArrayList;


/**
 * @author matheo.dupuis
 *
 * This class represents a builder for the scene and implements the interface IBuilder
 */
public class SceneBuilder implements IBuilder{
    private int width;
    private int height;
    private ArrayList<Triplet> camera;
    private ArrayList<Light> lights;
    private ArrayList<Color> colors;
    private ArrayList<AObject> objects;
    private int fov;
    private double shininess;
    private String output;

    /*
    ATTENTION CA RISQUE DE PAS MARCHER CAR IL MANQUE UN CONSTRUCTEUR DANS
    CETTE CLASSE OU PEUT ETRE DANS IBuilder !!!
     */


    /**
     * Set the values of width and height
     * @param width
     * @param height
     * @param shininess
     * @param output
     */
    @Override
    public void buildScene(int width, int height, double shininess, String output) {
        this.width = width;
        this.height = height;
        if(shininess != 0)
            this.shininess = shininess;
        this.output = output;
    }

    /**
     * Set the settings for the camera
     * @param camera
     * @param fov
     */
    @Override
    public void buildCamera(ArrayList<Triplet> camera, int fov) {
        this.camera = camera;
        this.fov = fov;
    }

    /**
     * Set the lights list
     * @param lights
     */
    @Override
    public void buildLight(ArrayList<Light> lights) {
        this.lights = lights;
    }


    /**
     * Set the object list
     * @param objects
     */
    @Override
    public void buildObject(ArrayList<AObject> objects) {
        this.objects = objects;
    }

    /**
     * Set the values of the colors inside color list using a JSONObject
     * @param colors
     */
    @Override
    public void buildColors(JSONObject colors) {
        this.colors = new ArrayList<>();
        if (colors.get("ambient") != null)
            this.colors.add((Color) colors.get("ambient"));
        if (colors.get("diffuse") != null)
            this.colors.add((Color) colors.get("diffuse"));
        if (colors.get("specular") != null)
            this.colors.add((Color)colors.get("specular"));
    }


    /**
     * Create a new Scene object using the attributes of SceneBuilder
     * @return the new Scene just created
     */
    public Scene getResult(){
        return new Scene(width,height,camera,lights,colors,objects,fov, output);
    }
}
