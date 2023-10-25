package fr.univartois.sae.raytracing.object;

import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Triplet;
import fr.univartois.sae.raytracing.triplet.Vector;

/**
 * this class represents a plane
 * @author nicolas nourry
 *
 */
public class Plane extends AObject{
    private Color color;
    /**
     * represents the coordinate of the plane
     */
    private Point coordinate;
    /**
     * represents the normal of the plane
     */
    private Triplet normal;

    /**
     * constructor of this class.
     */
    public Plane(Point coordinate, Triplet normal, Color color){
        this.coordinate = coordinate;
        this.normal=normal;
        this.color = color;
    }

    /**
     * Prints the current object
     * @return String
     */
    @Override
    public String toString() {
        return "Plane{" +
                "coordinate=" + coordinate +
                ", normal=" + normal +
                '}';
    }

    @Override
    public double distance(Point p, Vector d) {
        throw new UnsupportedOperationException();
    }
}
