package fr.univartois.sae.raytracing.scene;

import fr.univartois.sae.raytracing.light.Light;
import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Triplet;


import java.util.ArrayList;
import java.util.Map;

/**
 * @author matheo.dupuis
 *
 * This Interface is used to build a scene
 */
public interface IBuilder {

    /**
     * Set the values of width and height
     * @param width
     * @param height
     * @param shininess
     * @param output
     */
    public void buildScene(int width, int height, double shininess, String output);

    /**
     * Set the settings for the camera
     * @param camera an ArrayList with all the camera settings
     * @param fov the fov of the scene
     */
    public void buildCamera(ArrayList<Triplet> camera, int fov);

    /**
     * Set the lights list
     * @param lights
     */
    public void buildLight(ArrayList<Light> lights);

    /**
     * Set the object list
     * @param objects
     */
    public void buildObject(ArrayList<AObject> objects);

    /**
     * Set the values of the colors inside color list using a JSONObject
     * @param colors
     */
    public void buildColors(Map<String, Object> colors);


}
