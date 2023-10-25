package fr.univartois.sae.raytracing.object;

import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Vector;

/**
 *  this class represent an object
 */
public abstract class AObject {
    public abstract double distance(Point p, Vector d);
}
