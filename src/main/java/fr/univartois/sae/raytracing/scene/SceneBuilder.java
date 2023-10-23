package fr.univartois.sae.raytracing.scene;

import fr.univartois.sae.raytracing.light.Light;
import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Triplet;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class SceneBuilder implements IBuilder{
    private int width;
    private int height;
    private ArrayList<Triplet> camera;
    private ArrayList<Light> lights;
    private ArrayList<Color> colors;
    private ArrayList<AObject> objects;



    @Override
    public void buildScene(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void buildCamera(Triplet lookFrom, Triplet lookAt, Triplet up) {
        this.camera = new ArrayList<>();
        camera.add(lookFrom);
        camera.add(lookAt);
        camera.add(up);

    }

    @Override
    public void buildLight(ArrayList<Light> lights) {
        this.lights = lights;
    }

    @Override
    public void buildObject(ArrayList<AObject> objects) {
        this.objects = objects;
    }

    @Override
    public void buildColors(JSONObject colors) {
        if (colors.get("ambient") != null)
            this.colors.add((Color) colors.get("ambient"));
        if (colors.get("diffuse") != null)
            this.colors.add((Color) colors.get("diffuse"));
        if (colors.get("specular") != null)
            this.colors.add((Color)colors.get("specular"));
    }

    public Scene getResult(){
        return new Scene(width,height,camera,lights,colors,objects);
    }
}
