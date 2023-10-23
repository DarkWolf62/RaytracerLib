package fr.univartois.sae.raytracing.object;

import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Triplet;


/**
 * this class represents a sphere
 */
public class Sphere extends AObject {
    /**
     * represents the coordinate of the sphere
     */
    private Point coordinate;
    /**
     * represents the radius of the sphere
     */
    double radius;

    /**
     * constructor of this class
     */
    public Sphere(Point coordinate, double radius){
        this.coordinate = coordinate;
        this.radius = radius;
    }
}
