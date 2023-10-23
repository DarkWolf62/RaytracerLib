package fr.univartois.sae.raytracing.scene;

import fr.univartois.sae.raytracing.light.Light;
import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Triplet;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public interface IBuilder {

    public void buildScene(int width, int height);
    public void buildCamera(Triplet lookFrom, Triplet lookAt, Triplet up);
    public void buildLight(ArrayList<Light> lights);
    public void buildObject(ArrayList<AObject> object);
    public void buildColors(JSONObject color);


}
