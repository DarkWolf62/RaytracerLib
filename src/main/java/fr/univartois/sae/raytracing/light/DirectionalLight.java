package fr.univartois.sae.raytracing.light;

import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Vector;

/**
 * This class represent a directional light.
 * @author nicolas.blart
 */
public class DirectionalLight extends Light{
    /**
     * The direction of the light
     */
    private Vector vector;

    /**
     * The constructor of the Directional Light
     * @param vector
     * @param color
     */
    public DirectionalLight(Vector vector, Color color){
        super(color);
        this.vector= vector;
    }

    /**
     * Encapsulation method to retrieve the Vector
     * @return Vector
     */
    public Vector getVector() {
        return vector;
    }

    /**
     * Prints the current object
     * @return String
     */
    @Override
    public String toString() {
        return "DirectionalLight{" +
                "vector=" + vector +
                '}';
    }
}
