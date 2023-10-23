package fr.univartois.sae.raytracing.object;

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
    private Triplet coordinate;
    /**
     * represents the normal of the plane
     */
    private Triplet normal;

    /**
     * constructor of this class.
     */
    public Plane(){
        coordinate=new Triplet(0,0,0);
        normal=new Triplet(0,0,0);

    }
}
