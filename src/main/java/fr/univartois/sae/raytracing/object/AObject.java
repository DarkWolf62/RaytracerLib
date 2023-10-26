package fr.univartois.sae.raytracing.object;

import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Triplet;
import fr.univartois.sae.raytracing.triplet.Vector;

/**
 * @author  nicolas.nourry
 *
 *  This class represent an object
 */
public abstract class AObject {


    /**
     * An abstract method to implement
     * @param p
     * @param d
     * @return
     */
    private Color color;

    public abstract double distance(Point p, Vector d);

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract Point calcP(Vector d, Triplet lookFrom);
}
