package fr.univartois.sae.raytracing.triplet;
/**
 * @author nicolas.nourry
 *
 * This class represents a point.
 */

public class Point {
    private Triplet triplet;

    /**
     * Constructor to create a point with a triplet
     * @param triplet is a triplet
     */

    public Point(Triplet triplet){
        this.triplet=triplet;
    }

    /**
     * Constructor to create a point with coordinate
     * @param x,y,z are double
     */

    public Point(double x,double y,double z){
        triplet=new Triplet(x,y,z);
    }
    /**
     * this method subtracts the triplet of this class with another triplet
     * @param triplet
     * @return a new vector
     */

    public Vector subtraction(Triplet triplet){

        return new Vector(this.triplet.subtraction(triplet));
    }
    /**
     * this method uses the scalar multiplication on the triplet
     * @param d
     * @return a new point
     */

    public Point scalarMultiplication(double d){
        return new Point(triplet.scalarMultiplication(d));

    }

    /**
     *
     * @return this triplet of point
     */

    public Triplet getTriplet(){
        return triplet;
    }

    /**
     * Print the current object
     * @return String
     */
    @Override
    public String toString() {
        return "Point{" +
                "triplet=" + triplet +
                '}';
    }
}
