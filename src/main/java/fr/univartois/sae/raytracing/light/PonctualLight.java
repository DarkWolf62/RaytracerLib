package fr.univartois.sae.raytracing.light;

import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;

/**
 * This class represent a ponctual light.
 * @author nicolas.blart
 */
public class PonctualLight extends Light{
    /**
     * The point where the light is emitted
     */
    private Point point;

    /**
     * The constructor of the Ponctual Light.
     * @param point
     * @param color
     */
    public PonctualLight(Point point, Color color){
        super(color);
        this.point= point;
    }

    /**
     * Encapsulation method to retrieve the Point
     * @return Point
     */
    public Point getPoint() {
        return point;
    }
}
