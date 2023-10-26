package fr.univartois.sae.raytracing.scene;

import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Triplet;
import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.light.Light;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author matheo.dupuis
 *
 * this class represents the {@link Scene}
 */
public class Scene {

    private final int width;
    private final int height;
    private final ArrayList<Triplet> camera;
    private final ArrayList<Light> lights;
    private final Map<String,Object> colors;
    private final ArrayList<AObject> objects;
    private final int fov;
    private final String output;
    private final double shininess;
    private final boolean shadow;

    /**
     * Constructor using image's dimension, camera's information, lights, colors, objects
     *
     * @param width : the width of the {@link Scene}
     * @param height : the height of the {@link Scene}
     * @param camera : the camera placement of the {@link Scene}
     * @param lights : the lights
     * @param colors : the colors
     * @param objects : the objects
     * @param fov : the field of view
     * @param shininess : the amount of shininess of the {@link AObject}
     * @param output : the output file
     */
    public Scene(int width, int height, List<Triplet> camera, List<Light> lights, Map<String,Object> colors, List<AObject> objects, int fov, String output, double shininess, boolean shadow) {
        this.width = width;
        this.height = height;
        this.camera = (ArrayList<Triplet>) camera;
        this.lights = (ArrayList<Light>) lights;
        this.colors = colors;
        this.objects = (ArrayList<AObject>) objects;
        this.fov = fov;
        this.output = output;
        this.shininess = shininess;
        this.shadow= shadow;
    }

    public boolean isShadow() {
        return shadow;
    }

    /**
     * Encapsulation method to retrieve the width
     * @return the width of the {@link Scene}
     */
    public int getWidth() {
        return width;
    }

    /**
     * Encapsulation method to retrieve the height
     * @return the height of the {@link Scene}
     */
    public int getHeight() {
        return height;
    }

    /**
     * Encapsulation method to retrieve the camera
     * @return the camera of the {@link Scene}
     */
    public List<Triplet> getCamera() {
        return camera;
    }

    /**
     * Encapsulation method to retrieve the lights {@link AObject}
     * @return the ligths of the {@link Scene}
     */
    public List<Light> getLights() {
        return lights;
    }

    /**
     * Encapsulation method to retrieve the colors {@link Color}
     * @return the colors of the {@link Scene}
     */
    public Map<String,Object> getColors() {
        return colors;
    }

    /**
     * Encapsulation method to retrieve the objects {@link AObject}
     * @return the objects of the {@link Scene}
     */
    public List<AObject> getObjects() {
        return objects;
    }

    /**
     * Encapsulation method to retrieve the field of view of the {@link Scene}
     * @return the field of view of the {@link Scene}
     */
    public int getFov() {
        return fov;
    }

    public double getShininess(){ return shininess; }

    /**
     * Encapsulation method to retrieve the output file
     * @return the output file of the {@link Scene}
     */
    public String getOutput() {
        return output;
    }

    /**
     * Prints the current object
     * @return the {@link String} of a {@link Scene}
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


