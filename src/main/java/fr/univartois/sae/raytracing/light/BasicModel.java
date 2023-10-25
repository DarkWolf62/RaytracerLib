package fr.univartois.sae.raytracing.light;

import fr.univartois.sae.raytracing.object.Sphere;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Vector;

/**
 * @author matheo.dupuis
 *
 * This class is a part of  represents
 */
public class BasicModel implements IStrategy{

    @Override
    public Color modelMethod(Sphere object, int idObj , Point p, Scene scene) {
        Color color = (Color) scene.getColors().get("ambient");
        return color;

    }
}
