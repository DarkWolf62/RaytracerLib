package fr.univartois.sae.raytracing.object;

import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Triplet;
import fr.univartois.sae.raytracing.triplet.Vector;

/**
 * @author nicolas nourry
 *
 * this class represent a triangle
 */
public class Triangle extends AObject{
    private Color color;
    /**
     * represent a point of the triangle
     */
    private Point a;
    /**
     * represent a point of the triangle
     */
    private Point b;
    /**
     * represent a point of the triangle
     */
    private Point c;

    private Vector normal;

    /**
     * constructor of this class
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
     * @return String
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
     *
     * @param p
     * @param d
     * @return
     */
    public Point calcP(Vector d, Triplet lookFrom){
        double up=a.subtraction(lookFrom).scalarProduct(normal.getTriplet()) ;
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
        double v = b.subtraction(a.getTriplet()).vectorProduct(point.subtraction(a.getTriplet()).getTriplet()).scalarProduct(normal.getTriplet());
        double w = c.subtraction(b.getTriplet()).vectorProduct(point.subtraction(b.getTriplet()).getTriplet()).scalarProduct(normal.getTriplet());
        double x = a.subtraction(c.getTriplet()).vectorProduct(point.subtraction(c.getTriplet()).getTriplet()).scalarProduct(normal.getTriplet());
        if (v>=0 && w>=0 && x>=0){
            return point.subtraction(p.getTriplet()).norm();

        }
        return -1;
    }

    public Color getColor() {
        return color;
    }

    public Vector getNormal() {
        return normal;
    }
}
