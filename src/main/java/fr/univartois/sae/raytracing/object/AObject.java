package fr.univartois.sae.raytracing.object;

import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Triplet;
import fr.univartois.sae.raytracing.triplet.Vector;

import java.util.Objects;

/**
 * @author  nicolas.nourry
 *
 *  This class represent an {@link AObject}
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

    public abstract Point calcP(Vector d, Triplet lookFrom);
}
