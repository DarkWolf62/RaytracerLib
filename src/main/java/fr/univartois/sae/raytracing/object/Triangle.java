package fr.univartois.sae.raytracing.object;

import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Triplet;
import fr.univartois.sae.raytracing.triplet.Vector;

/**
 * @author nicolas.nourry
 *
 * This class represent a {@link Triangle}
 */
public class Triangle extends AObject{
    /**
     * represents the {@link Color} of the {@link Triangle}
     */
    private final Color color;

    /**
     * represent a {@link Point} of the triangle
     */
    private final Point a;

    /**
     * represent a {@link Point} of the triangle
     */
    private final Point b;

    /**
     * represent a {@link Point} of the triangle
     */
    private final Point c;

    /**
     * Represents the normal {@link Vector} of the {@link Triangle}
     */
    private final Vector normal;

    /**
     * Constructor of this class
     * @param a the 1st {@link Point} of the {@link Triangle}
     * @param b the 2nd {@link Point} of the {@link Triangle}
     * @param c the 3rd {@link Point} of the {@link Triangle}
     * @param color the {@link Color} of the {@link Triangle}
     */
    public Triangle(Point a, Point b, Point c, Color color){
        this.a = a;
        this.b = b;
        this.c = c;
        this.color = color;
        this.normal = b.subtraction(a.getTriplet()).vectorProduct(c.subtraction(a.getTriplet()).getTriplet()).normalize();
    }

    /**
     * Prints the current object
     * @return the {@link String} of a {@link Triangle}
     */
    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    /**
     * Calculate the intersection {@link Point}.
     * @param d the direction {@link Vector}
     * @param lookFrom the {@link Point} of the Camera
     * @return the intersection {@link Point}
     */
    public Point calcP(Vector d, Triplet lookFrom){
        double up=a.subtraction(lookFrom).scalarProduct(normal.getTriplet()) ;
        double down=d.scalarProduct(normal.getTriplet());
        if (down==0)
            return null;
        double t =up/down;
        return new Point(lookFrom.addition(d.scalarMultiplication(t).getTriplet()));
    }

    /**
     * Return the distance between the {@link Point} intersection and the direction {@link Vector}
     * @param p the intersection {@link Point}
     * @param d the direction {@link Vector}
     * @return the distance between the interaction {@link Point} and the direction {@link Vector}
     */
    public double distance(Point p, Vector d) {
        if (d.scalarProduct(normal.getTriplet())==0)
            return -1;
        Point point= calcP(d, p.getTriplet());
        double v = b.subtraction(a.getTriplet()).vectorProduct(point.subtraction(a.getTriplet()).getTriplet()).scalarProduct(normal.getTriplet());
        double w = c.subtraction(b.getTriplet()).vectorProduct(point.subtraction(b.getTriplet()).getTriplet()).scalarProduct(normal.getTriplet());
        double x = a.subtraction(c.getTriplet()).vectorProduct(point.subtraction(c.getTriplet()).getTriplet()).scalarProduct(normal.getTriplet());
        if (v>=0 && w>=0 && x>=0){
            return point.subtraction(p.getTriplet()).norm();
        }
        return -1;
    }

    /**
     * Encapsulation method to retrieve the {@link Color}
     * @return the {@link Triangle} {@link Color}
     */

    @Override
    public Color getColor() {
        return color;
    }

    /**
     * Encapsulation method to retrieve the normal {@link Vector} of the {@link Triangle}
     * @return the normal {@link Vector}
     */
    public Vector getNormal() {
        return normal;
    }
}
