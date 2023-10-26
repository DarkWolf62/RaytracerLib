package fr.univartois.sae.raytracing.scene;

import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Triplet;
import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.light.Light;

import java.util.ArrayList;
import java.util.Map;


/**
 * @author matheo.dupuis
 *
 * this class represents the scene
 */
public class Scene {

    private int width;
    private int height;
    private ArrayList<Triplet> camera;
    private ArrayList<Light> lights;
    private Map<String,Object> colors;
    private ArrayList<AObject> objects;
    private int fov;
    private String output;

    private double shininess;
    private boolean shadow;


    /**
     * Constructor using image's dimension, camera's information, lights, colors, objects
     *
     * @param width
     * @param height
     * @param camera
     * @param lights
     * @param colors
     * @param objects
     * @param fov
     * @param shininess
     * @param output
     */
    public Scene(int width, int height, ArrayList<Triplet> camera, ArrayList<Light> lights, Map<String,Object> colors, ArrayList<AObject> objects, int fov, String output, double shininess, boolean shadow) {
        this.width = width;
        this.height = height;
        this.camera = camera;
        this.lights = lights;
        this.colors = colors;
        this.objects = objects;
        this.fov = fov;
        this.output = output;
        this.shininess = shininess;
        this.shadow= shadow;
    }

    public boolean isShadow() {
        return shadow;
    }

    /**
     * Getter for the width
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Getter for height
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Getter for camera
     * @return camera
     */
    public ArrayList<Triplet> getCamera() {
        return camera;
    }

    /**
     * Getter lights
     * @return lights
     */
    public ArrayList<Light> getLights() {
        return lights;
    }

    /**
     * Getter for colors
     * @return colors
     */
    public Map<String,Object> getColors() {
        return colors;
    }

    /**
     * Getter for objects
     * @return objects
     */
    public ArrayList<AObject> getObjects() {
        return objects;
    }

    /**
     * Returns the fov
     * @return the fov
     */
    public int getFov() {
        return fov;
    }

    public double getShininess(){ return fov; }

    /**
     * Returns the output
     * @return the output
     */
    public String getOutput() {
        return output;
    }

    /**
     * Prints the current object
     * @return String
     */
    @Override
    public String toString() {
        return "Scene{" +
                "width=" + width +
                ", height=" + height +
                ", camera=" + camera +
                ", lights=" + lights +
                ", colors=" + colors +
                ", objects=" + objects +
                ", fov=" + fov +
                ", shininess" + shininess +
                ", output=" + output +
                '}';
    }
}


