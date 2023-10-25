package fr.univartois.sae.raytracing.object;

import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Vector;

/**
 * @author nicolas nourry
 *
 * this class represent a triangle
 */
public class Triangle extends AObject{
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
    public Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
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

    @Override
    public double distance(Point p, Vector d) {
        throw new UnsupportedOperationException();
    }
}
