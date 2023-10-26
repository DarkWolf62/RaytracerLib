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
    private Vector normal;

    /**
     * constructor of this class.
     *
     * @param coordinate
     * @param normal
     * @param color
     */
    public Plane(Point coordinate, Vector normal,Color color){
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

    /**
     *
     * @param p
     * @param d
     * @return
     */
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


    @Override
    public double distance(Point p, Vector d) {
        Point point = calcP(d, p.getTriplet());
        if (p==null)
            return -1;
        return p.subtraction(point.getTriplet()).norm();
    }
    public Color getColor() {
        return color;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public Vector getNormal() {
        return normal;
    }
}
