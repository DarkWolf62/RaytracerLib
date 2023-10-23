package fr.univartois.sae.raytracing.scene;

import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Triplet;
import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.light.Light;

import java.util.ArrayList;


public class Scene {

    private int width;
    private int height;
    private ArrayList<Triplet> camera;
    private ArrayList<Light> lights;
    private ArrayList<Color> colors;
    private ArrayList<AObject> objects;


    public Scene(int width, int height, ArrayList<Triplet> camera, ArrayList<Light> lights, ArrayList<Color> colors, ArrayList<AObject> objects) {
        this.width = width;
        this.height = height;
        this.camera = camera;
        this.lights = lights;
        this.colors = colors;
        this.objects = objects;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ArrayList<Triplet> getCamera() {
        return camera;
    }

    public void setCamera(ArrayList<Triplet> camera) {
        this.camera = camera;
    }

    public ArrayList<Light> getLights() {
        return lights;
    }

    public void setLights(ArrayList<Light> lights) {
        this.lights = lights;
    }

    public ArrayList<Color> getColors() {
        return colors;
    }

    public void setColors(ArrayList<Color> colors) {
        this.colors = colors;
    }

    public ArrayList<AObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<AObject> objects) {
        this.objects = objects;
    }
}
