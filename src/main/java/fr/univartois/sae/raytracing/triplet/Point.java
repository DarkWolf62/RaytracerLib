package fr.univartois.sae.raytracing.triplet;
/**
 * @author nicolas
 *
 * This class represents a point.
 */

public class Point {
    private Triplet triplet;

    /**
     * Constructor for create a point with a triplet
     * @param triplet is a triplet
     */

    public Point(Triplet triplet){
        this.triplet=triplet;
    }

    /**
     * Constructor for create a point with coordinate
     * @param x,y,z is a triplet
     */

    public Point(int x,int y,int z){
        triplet=new Triplet(x,y,z);
    }
    /**
     * this method subtraction the triplet of this class and a other triplet
     * @param triplet
     * @return a new vector
     */

    public Vector subtraction(Triplet triplet){

        return new Vector(this.triplet.subtraction(triplet));
    }
    /**
     * this method use the scalar multiplication on the triplet
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
}
