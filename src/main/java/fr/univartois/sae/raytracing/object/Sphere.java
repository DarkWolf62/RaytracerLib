package fr.univartois.sae.raytracing.object;

import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Vector;


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
     * Return the distance between the {@link Point} intersection and the direction {@link Vector}
     * @param p the intersection {@link Point}
     * @param d the direction {@link Vector}
     * @return the distance between the interaction {@link Point} and the direction {@link Vector}
     */
    @Override
    public double distance(Point p, Vector d) {
        return 0;
    }

    /**
     * Encapsulation method to retrieve the {@link Color}
     * @return the {@link Sphere} {@link Color}
     */
    public Color getColor() {
        return color;
    }

//    @Override
//    public double distance(Point p, Vector d) {
//        double res = -1;
//        double t2;
//        double tb = (p.subtraction(coordinate.getTriplet())).scalarMultiplication(2).scalarProduct(d.getTriplet());
//        double tc = (p.subtraction(coordinate.getTriplet()).scalarProduct(p.subtraction(coordinate.getTriplet()).getTriplet()))
//        double delta = Math.pow(tb, 2) - (4 * tc);
//        if (delta == 0) {
//            res = -tb / 2;
//        } else if (delta > 0) {
//            res = (-tb + Math.sqrt(delta)) / 2;
//            t2 = (-tb - Math.sqrt(delta)) / 2;
//            if (t2 > 0) {
//                res = t2;
//            } else if (t < 0) {
//                res = -1;
//            }
//        }
//    }
}
