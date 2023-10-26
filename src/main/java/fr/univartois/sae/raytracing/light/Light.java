package fr.univartois.sae.raytracing.light;

import fr.univartois.sae.raytracing.triplet.Color;

/**
 * This class represent a {@link Light}
 * @author nicolas.blart
 */
public class Light {
    /**
     * The {@link Color} of the {@link Light}
     */
    private final Color color;

    /**
     * The constructor of this class
     * @param color the {@link Color} of the light
     */
    public Light(Color color){
        this.color = color;
    }

    /**
     * Encapsulation method to retrieve the {@link Color}
     * @return the {@link Color} of the light
     */
    public Color getColor() {
        return color;
    }
}
