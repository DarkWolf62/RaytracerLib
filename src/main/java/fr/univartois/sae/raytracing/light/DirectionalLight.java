package fr.univartois.sae.raytracing.light;

import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Vector;

/**
 * This class represent a {@link DirectionalLight}.
 * @author nicolas.blart
 */
public class DirectionalLight extends Light{
    /**
     * The direction {@link Vector} of the {@link Light}
     */
    private final Vector vector;

    /**
     * The constructor of this class
     * @param vector the direction {@link Vector}
     * @param color the color of the {@link Light}
     */
    public DirectionalLight(Vector vector, Color color){
        super(color);
        this.vector= vector;
    }

    /**
     * Encapsulation method to retrieve the direction {@link Vector}
     * @return the direction {@link Vector}
     */
    public Vector getVector() {
        return vector;
    }

    /**
     * Prints the current object
     * @return the {@link String} of a {@link DirectionalLight}
     */
    @Override
    public String toString() {
        return "DirectionalLight{" +
                "vector=" + vector +
                '}';
    }
}
