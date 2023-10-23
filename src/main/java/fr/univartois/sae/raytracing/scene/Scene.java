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
    private Light[] lights;
    private Color[] colors;
    private AObject[] objects;

    public Scene(Light[] lights, Color[] colors) {
        this.lights = lights;
        this.colors = colors;
    }
}
