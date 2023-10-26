package fr.univartois.sae.raytracing.scene;

import fr.univartois.sae.raytracing.light.Light;
import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.triplet.Triplet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author matheo.dupuis
 *
 * This Interface is used to build a {@link Scene}
 */
public interface IBuilder {

    /**
     * Set the values for the Scene
     * @param width the width of the {@link Scene}
     * @param height the height of the {@link Scene}
     * @param shininess the shininess of the {@link Color}
     * @param output the output file of the {@link Scene}
     * @param shadow the shadow's activation
     */
    public void buildScene(int width, int height, double shininess, String output, boolean shadow);

    /**
     * Set the settings for the camera
     * @param camera an {@link ArrayList} with all the camera settings
     * @param fov the fov of the {@link Scene}
     */
    public void buildCamera(List<Triplet> camera, int fov);

    /**
     * Set the {@link Light} list
     * @param lights : the {@link Light} list
     */
    public void buildLight(List<Light> lights);

    /**
     * Set the {@link AObject} list
     * @param objects the {@link AObject}
     */
    public void buildObject(List<AObject> objects);

    /**
     * Set the values of the colors inside {@link Color} list using a {@link Map}
     * @param colors : the {@link Color} map
     */
    public void buildColors(Map<String, Object> colors);


}
