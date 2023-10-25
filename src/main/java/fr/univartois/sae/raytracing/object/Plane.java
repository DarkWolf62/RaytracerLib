package fr.univartois.sae.raytracing.object;

import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Triplet;
import fr.univartois.sae.raytracing.triplet.Vector;

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
    private Vector normal;

    /**
     * constructor of this class.
     */
    public Plane(Point coordinate, Vector normal){
        this.coordinate = coordinate;
        this.normal=normal;
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

    public Point calcP(Vector d,Triplet lookFrom){
        Point q =coordinate;
        double up=q.subtraction(lookFrom).scalarProduct(normal.getTriplet()) ;
        double down=d.scalarProduct(normal.getTriplet());
        if (down==0)
            return null;
        double t =up/down;
        Point p = new Point(lookFrom.addition(d.scalarMultiplication(t).getTriplet()));
        return p;
    }

    public double distance(Point p, Vector d) {
        if (d.scalarProduct(normal.getTriplet())==0)
            return -1;
        Point point= calcP(d, p.getTriplet());
        return point.subtraction(p.getTriplet()).norm();
    }
}
