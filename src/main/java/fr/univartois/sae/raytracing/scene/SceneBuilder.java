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

    /*
    ATTENTION CA RISQUE DE PAS MARCHER CAR IL MANQUE UN CONSTRUCTEUR DANS
    CETTE CLASSE OU PEUT ETRE DANS IBuilder !!!
     */


    /**
     * Set the values of width and height
     * @param width
     * @param height
     */
    @Override
    public void buildScene(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Set the settings for the camera
     * @param lookFrom
     * @param lookAt
     * @param up
     */
    @Override
    public void buildCamera(Triplet lookFrom, Triplet lookAt, Triplet up) {
        this.camera = new ArrayList<>();
        camera.add(lookFrom);
        camera.add(lookAt);
        camera.add(up);

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
        return new Scene(width,height,camera,lights,colors,objects);
    }
}
