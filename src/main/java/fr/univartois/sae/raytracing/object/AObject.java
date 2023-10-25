package fr.univartois.sae.raytracing.object;

import fr.univartois.sae.raytracing.triplet.Point;
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
    public abstract double distance(Point p, Vector d);
}
