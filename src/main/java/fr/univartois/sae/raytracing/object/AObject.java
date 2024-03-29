package fr.univartois.sae.raytracing.object;

import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Triplet;
import fr.univartois.sae.raytracing.triplet.Vector;

/**
 *
 *  This class represent an {@link AObject}
 *
 * @author  nicolas.nourry
 */
public abstract class AObject {

    /**
     * The {@link Color} of the {@link AObject}
     */
    private Color color;

    /**
     * An abstract method to implement
     * @param p the interaction {@link Point}
     * @param d the direction {@link Vector}
     * @return the distance between the interaction {@link Point} and the direction {@link Vector}
     */
    public abstract double distance(Point p, Vector d);

    /**
     * Encapsulation method to set the {@link Color} of the {@link AObject}
     * @param color the {@link Color} to set.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Encapsulation method to retrieve the {@link Color} of the {@link AObject}
     * @return the {@link Color} of the {@link AObject}
     */
    public Color getColor() {
        return color;
    }

    /**
     * Calculates if there is an intersection {@link Point} between the current object and another point using a {@link Vector}
     * @param d the direction {@link Vector} to calculate the intersection
     * @param lookFrom The {@link Triplet} of the {@link Point} we want to know if there is an intersection
     * @return The intersection {@link Point} if it exists, else it returns a null {@link Point}
     */

    public abstract Point calcP(Vector d, Triplet lookFrom);
}
