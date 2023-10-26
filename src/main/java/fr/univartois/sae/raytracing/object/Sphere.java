package fr.univartois.sae.raytracing.object;

import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Triplet;
import fr.univartois.sae.raytracing.triplet.Vector;

import java.util.Objects;


/**
 * @author nicolas.nourry
 * @author leo.denis
 *
 * this class represents a {@link Sphere}
 */
public class Sphere extends AObject {
    /**
     * Represents the {@link Color} of the {@link Sphere}
     */
    private final Color color;

    /**
     * represents the coordinate {@link Point} of the {@link Sphere}
     */
    private final Point coordinate;

    /**
     * represents the radius of the {@link Sphere}
     */
    double radius;

    /**
     * Constructor of this class
     * @param coordinate the coordinate {@link Point} of the {@link Sphere}
     * @param radius the radius of the {@link Sphere}
     * @param color the {@link Color} of the {@link Sphere}
     */
    public Sphere(Point coordinate, double radius,Color color){
        this.coordinate = coordinate;
        this.radius = radius;
        this.color = color;

    }

    /**
     * Encapsulation method to retrieve the coordinate {@link Point} of the {@link Sphere}
     * @return the coordinate {@link Point}
     */
    public Point getCoordinate() {
        return coordinate;
    }

    /**
     * Encapsulation method to retrieve the radius of the {@link Sphere}
     * @return the radius of the {@link Sphere}
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Prints the current object
     * @return the {@link String} of a {@link Sphere}
     */
    @Override
    public String toString() {
        return "Sphere{" +
                "coordinate=" + coordinate +
                ", radius=" + radius +
                '}';
    }

    /**
     * Encapsulation method to retrieve the {@link Color}
     * @return the {@link Sphere} {@link Color}
     */
    public Color getColor() {
        return color;
    }

    public Point calcP(Vector d, Triplet lookFrom) {
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

    /**
     * Return the distance between the {@link Point} intersection and the direction {@link Vector}
     * @param p the intersection {@link Point}
     * @param d the direction {@link Vector}
     * @return the distance between the interaction {@link Point} and the direction {@link Vector}
     */
    @Override
    public double distance(Point p, Vector d) {
        Point point = calcP(d, p.getTriplet());
        if (point == null)
            return -1;
        return (point.subtraction(p.getTriplet())).norm();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sphere sphere = (Sphere) o;
        return Double.compare(radius, sphere.radius) == 0 && Objects.equals(color, sphere.color) && Objects.equals(coordinate, sphere.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, coordinate, radius);
    }
}
