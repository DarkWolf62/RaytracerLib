package fr.univartois.sae.raytracing.scene;

import fr.univartois.sae.raytracing.light.Light;
import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Triplet;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

import java.util.ArrayList;

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
     */
    public void buildScene(int width, int height);

    /**
     * Set the settings for the camera
     * @param lookFrom
     * @param lookAt
     * @param up
     */
    public void buildCamera(Triplet lookFrom, Triplet lookAt, Triplet up);

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
    public void buildColors(JSONObject colors);


}
