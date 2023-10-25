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

    /**
     * constructor of this class
     */
    public Triangle(Point a, Point b, Point c, Color color){
        this.a = a;
        this.b = b;
        this.c = c;
        this.color = color;
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

    public Point calcP(Vector d, Triplet lookFrom){
        Vector n = b.subtraction(a.getTriplet()).vectorProduct(c.subtraction(a.getTriplet()).getTriplet()).normalize();
        double up=a.subtraction(lookFrom).scalarProduct(n.getTriplet()) ;
        double down=d.scalarProduct(n.getTriplet());
        if (down==0)
            return null;
        double t =up/down;
        Point p = new Point(lookFrom.addition(d.scalarMultiplication(t).getTriplet()));
        return p;
    }

    public double distance(Point p, Vector d) {
        Vector n = b.subtraction(a.getTriplet()).vectorProduct(c.subtraction(a.getTriplet()).getTriplet()).normalize();
        if (d.scalarProduct(n.getTriplet())==0)
            return -1;
        Point point= calcP(d, p.getTriplet());
        double v = b.subtraction(a.getTriplet()).vectorProduct(point.subtraction(a.getTriplet()).getTriplet()).scalarProduct(n.getTriplet());
        double w = c.subtraction(b.getTriplet()).vectorProduct(point.subtraction(b.getTriplet()).getTriplet()).scalarProduct(n.getTriplet());
        double x = a.subtraction(c.getTriplet()).vectorProduct(point.subtraction(c.getTriplet()).getTriplet()).scalarProduct(n.getTriplet());
        if (v>=0 && w>=0 && x>=0){
            return point.subtraction(p.getTriplet()).norm();

        }
        return -1;
    }
}
