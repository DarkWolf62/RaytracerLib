package fr.univartois.sae.raytracing.object;

import fr.univartois.sae.raytracing.triplet.Triplet;


/**
 * this class represents a sphere
 */
public class Sphere extends AObject {
    /**
     * represents the coordinate of the sphere
     */
    private Triplet coordinate;
    /**
     * represents the radius of the sphere
     */
    double radius;

    /**
     * constructor of this class
     */
    public Sphere(){
        coordinate=new Triplet(0,0,0);
        radius=0;


    }
}
