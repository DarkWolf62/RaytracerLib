package fr.univartois.sae.raytracing.light;

import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;

/**
 * This class represent a {@link PonctualLight}.
 * @author nicolas.blart
 */
public class PonctualLight extends Light{
    /**
     * The {@link Point} where the light is emitted
     */
    private final Point point;

    /**
     * The constructor of this class.
     * @param point the {@link Point} where the light is emitted
     * @param color the {@link Color} of the light
     */
    public PonctualLight(Point point, Color color){
        super(color);
        this.point= point;
    }

    /**
     * Encapsulation method to retrieve the {@link Point}
     * @return the {@link Point} where the light is emitted
     */
    public Point getPoint() {
        return point;
    }

    /**
     * Prints the current object
     * @return the {@link String} of a {@link PonctualLight}
     */
    @Override
    public String toString() {
        return "PonctualLight{" +
                "point=" + point +
                '}';
    }
}
