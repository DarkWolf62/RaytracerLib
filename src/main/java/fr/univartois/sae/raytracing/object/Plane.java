package fr.univartois.sae.raytracing.object;

import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Triplet;

/**
 * this class represents a plane
 * @author nicolas nourry
 *
 */
public class Plane extends AObject{
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
    public Plane(Point coordinate, Triplet normal){
        this.coordinate = coordinate;
        this.normal=normal;
    }
}
