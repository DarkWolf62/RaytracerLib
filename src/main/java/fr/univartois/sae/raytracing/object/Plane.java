package fr.univartois.sae.raytracing.object;

import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Triplet;
import fr.univartois.sae.raytracing.triplet.Vector;

/**
 * This class represents a {@link Plane}
 * @author nicolas nourry
 */
public class Plane extends AObject{

    /**
     * represents the {@link Color} of the {@link Plane}
     */
    private final Color color;

    /**
     * represents the coordinate {@link Point} of the {@link Plane}
     */
    private final Point coordinate;

    /**
     * Represents the normal {@link Vector} of the {@link Plane}
     */
    private final Vector normal;

    /**
     * constructor of this class.
     *
     * @param coordinate the coordinate of a {@link Point} of the Plane
     * @param normal the normal {@link Vector} of the plane
     * @param color the {@link Color} of the plane
     */
    public Plane(Point coordinate, Vector normal,Color color){
        this.coordinate = coordinate;
        this.normal=normal;
        this.color = color;
    }

    /**
     * Prints the current object
     * @return the {@link String} of a {@link Plane}
     */
    @Override
    public String toString() {
        return "Plane{" +
                "coordinate=" + coordinate +
                ", normal=" + normal +
                '}';
    }

    /**
     * Calculates if there is an intersection {@link Point} between the current {@link Plane} and another point using a {@link Vector}
     * @param d the direction {@link Vector} to calculate the intersection
     * @param lookFrom The {@link Triplet} of the {@link Point} we want to know if there is an intersection
     * @return The intersection {@link Point} if it exists, else it returns a null {@link Point}
     */
    public Point calcP(Vector d,Triplet lookFrom){
        double up= coordinate.subtraction(lookFrom).scalarProduct(normal.getTriplet()) ;
        double down=d.scalarProduct(normal.getTriplet());
        if (down==0)
            return null;
        double t =up/down;
        return new Point(lookFrom.addition(d.scalarMultiplication(t).getTriplet()));
    }


    /**
     * Returns the distance between the {@link Point} intersection and the direction {@link Vector}
     * @param p the intersection {@link Point}
     * @param d the direction {@link Vector}
     * @return the distance between the interaction {@link Point} and the direction {@link Vector}
     */
    @Override
    public double distance(Point p, Vector d) {
        Point point = calcP(d, p.getTriplet());
        if (p==null)
            return -1;
        return p.subtraction(point.getTriplet()).norm();
    }

    /**
     * Encapsulation method to retrieve the {@link Color}
     * @return the {@link Plane} {@link Color}
     */
    @Override
    public Color getColor() {
        return color;
    }



    /**
     * Encapsulation method to retrieve the normal {@link Vector} of the {@link Plane}
     * @return the normal {@link Vector}
     */
    public Vector getNormal() {
        return normal;
    }
}
