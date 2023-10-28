package fr.univartois.sae.raytracing.scene;

import fr.univartois.sae.raytracing.light.Light;
import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Triplet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author matheo.dupuis
 *
 * This class represents a builder for the {@link Scene} and implements the interface {@link IBuilder}
 */
public class SceneBuilder implements IBuilder{

    private int width;
    private int height;
    private ArrayList<Triplet> camera;
    private ArrayList<Light> lights;
    private Map<String, Object> colors;
    private ArrayList<AObject> objects;
    private int fov;
    private double shininess;
    private String output;

    private boolean shadow;

    /**
     * Set the values for the Scene
     * @param width the width of the {@link Scene}
     * @param height the height of the {@link Scene}
     * @param shininess the shininess of the {@link Color}
     * @param shadow the value of shadow for the {@link Scene}
     * @param output the output file of the {@link Scene}
     */
    @Override
    public void buildScene(int width, int height, double shininess, String output, boolean shadow) {
        this.width = width;
        this.height = height;
        if(shininess != 0)
            this.shininess = shininess;
        this.output = output;
        this.shadow = shadow;
    }

    /**
     * Set the settings for the camera
     * @param camera an {@link ArrayList} with all the camera settings
     * @param fov the fov of the {@link Scene}
     */
    @Override
    public void buildCamera(List<Triplet> camera, int fov) {
        this.camera = (ArrayList<Triplet>) camera;
        this.fov = fov;
    }

    /**
     * Set the {@link Light} list
     * @param lights : the {@link Light} list
     */
    @Override
    public void buildLight(List<Light> lights) {
        this.lights = (ArrayList<Light>) lights;
    }


    /**
     * Set the {@link AObject} list
     * @param objects the {@link AObject}
     */
    @Override
    public void buildObject(List<AObject> objects) {
        this.objects = (ArrayList<AObject>) objects;
    }

    /**
     * Set the values of the colors inside {@link Color} list using a {@link Map}
     * @param colors : the {@link Color} map
     */
    @Override
    public void buildColors(Map<String, Object> colors) {
        this.colors = colors;
    }


    /**
     * Create a new {@link Scene} object using the attributes of {@link SceneBuilder}
     * @return the new {@link Scene} just created
     */
    public Scene getResult(){
        return new Scene(width,height,camera,lights,colors,objects,fov, output, shininess, shadow);
    }
}
