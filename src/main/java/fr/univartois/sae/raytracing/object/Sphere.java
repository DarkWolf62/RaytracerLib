package fr.univartois.sae.raytracing.object;

import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Triplet;
import fr.univartois.sae.raytracing.triplet.Vector;


/**
 * this class represents a sphere
 */
public class Sphere extends AObject {
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
    public Sphere(Point coordinate, double radius){
        this.coordinate = coordinate;
        this.radius = radius;
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

    @Override
    public double distance(Point p, Vector d) {
        return 0;
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
