package fr.univartois.sae.raytracing.object;

import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Triplet;
import fr.univartois.sae.raytracing.triplet.Vector;


/**
 * @author nicolas.nourry
 * @author leo.denis
 *
 * this class represents a sphere
 */
public class Sphere extends AObject {
    private Color color;
    /**
     * represents the coordinate of the sphere
     */
    private Point coordinate;
    /**
     * represents the radius of the sphere
     */
    double radius;

    /**
     * constructor of this class
     */
    public Sphere(Point coordinate, double radius,Color color){
        this.coordinate = coordinate;
        this.radius = radius;
        this.color = color;

    }

    public Point getCoordinate() {
        return coordinate;
    }

    public double getRadius() {
        return radius;
    }

    /**
     * Prints the current object
     * @return String
     */
    @Override
    public String toString() {
        return "Sphere{" +
                "coordinate=" + coordinate +
                ", radius=" + radius +
                '}';
    }

    /**
     * Getter for the color
     *
     * @return
     */
    public Color getColor() {
        return color;
    }

    public Point calcP(Vector d,Triplet lookFrom) {
        double t;
        double t2;
        double tb = ((lookFrom.subtraction(this.getCoordinate().getTriplet())).scalarMultiplication(2)).scalarProduct(d.getTriplet());
        double tc = (lookFrom.subtraction(this.getCoordinate().getTriplet())).scalarProduct(lookFrom.subtraction(this.getCoordinate().getTriplet())) - (Math.pow((this.getRadius()), 2));
        double delta = Math.pow(tb, 2) - (4 * tc);
        if (delta == 0) {
            t = -tb / 2;
        } else if (delta > 0) {
            t = (-tb + Math.sqrt(delta)) / 2;
            t2 = (-tb - Math.sqrt(delta)) / 2;
            if (t2 > 0) {
                t = t2;
            } else if (t < 0) {
                t = -1;
            }
        } else {
            return null;
        }
        return new Point(lookFrom.addition(d.getTriplet().scalarMultiplication(t)));
    }

    @Override
    public double distance(Point p, Vector d) {
        Point point = calcP(d, p.getTriplet());
        if (point == null)
            return -1;
        return (point.subtraction(p.getTriplet())).norm();
    }
}
