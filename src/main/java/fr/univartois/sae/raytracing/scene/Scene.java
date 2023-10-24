package fr.univartois.sae.raytracing.scene;

import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Triplet;
import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.light.Light;

import java.util.ArrayList;


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
    private ArrayList<Color> colors;
    private ArrayList<AObject> objects;
    private int fov;
    private String output;


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
     * @param output
     */
    public Scene(int width, int height, ArrayList<Triplet> camera, ArrayList<Light> lights, ArrayList<Color> colors, ArrayList<AObject> objects, int fov, String output) {
        this.width = width;
        this.height = height;
        this.camera = camera;
        this.lights = lights;
        this.colors = colors;
        this.objects = objects;
        this.fov = fov;
        this.output = output;
    }

    /**
     * Getter for the width
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Setter for the width
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Getter for height
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Setter for height
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Getter for camera
     * @return camera
     */
    public ArrayList<Triplet> getCamera() {
        return camera;
    }

    /**
     * Setter for camera
     * @param camera
     */
    public void setCamera(ArrayList<Triplet> camera) {
        this.camera = camera;
    }

    /**
     * Getter lights
     * @return lights
     */
    public ArrayList<Light> getLights() {
        return lights;
    }

    /**
     * Setter for lights
     * @param lights
     */
    public void setLights(ArrayList<Light> lights) {
        this.lights = lights;
    }

    /**
     * Getter for colors
     * @return colors
     */
    public ArrayList<Color> getColors() {
        return colors;
    }

    /**
     * Setter for colors
     * @param colors
     */
    public void setColors(ArrayList<Color> colors) {
        this.colors = colors;
    }

    /**
     * Getter for objects
     * @return objects
     */
    public ArrayList<AObject> getObjects() {
        return objects;
    }

    /**
     * Setter for objects
     * @param objects
     */
    public void setObjects(ArrayList<AObject> objects) {
        this.objects = objects;
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
                ", output=" + output +
                '}';
    }
}


