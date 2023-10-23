package fr.univartois.sae.raytracing.light;

import fr.univartois.sae.raytracing.triplet.Color;

/**
 * This class represent a light
 * @author nicolas.blart
 */
public class Light {
    /**
     * The color of the light
     */
    private Color color;

    /**
     * The constructor of the Light
     * @param color
     */
    public Light(Color color){
        this.color = color;
    }

    /**
     * Encapsulation method to retrieve the Color
     * @return Color
     */
    public Color getColor() {
        return color;
    }
}
