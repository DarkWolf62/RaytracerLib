package fr.univartois.sae.raytracing.triplet;
/**
 * @author nicolas.nourry
 *
 * This class represents a {@link Point}.
 */

public class Point {
    /**
     * The {@link Triplet} who represents the coordinates values
     */
    private final Triplet triplet;

    /**
     * Constructor to create a {@link Point} with a {@link Triplet}
     * @param triplet : the coordinates values
     */
    public Point(Triplet triplet){
        this.triplet=triplet;
    }

    /**
     * Constructor to create a {@link Point} with coordinate
     * @param x : the x coordinate
     * @param y : the y coordinate
     * @param z : the z coordinate
     */
    public Point(double x,double y,double z){
        triplet=new Triplet(x,y,z);
    }

    /**
     * Create a new {@link Vector} from the subtraction of the actual {@link Triplet} by another
     * @param triplet the other {@link Triplet}
     * @return the new {@link Vector}
     */
    public Vector subtraction(Triplet triplet){

        return new Vector(this.triplet.subtraction(triplet));
    }

    /**
     * create a new {@link Point} from the scalar multiplication between the actual {@link Triplet} and a double
     * @param d the double to multiply
     * @return the new {@link Point}
     */
    public Point scalarMultiplication(double d){
        return new Point(triplet.scalarMultiplication(d));

    }

    /**
     * Encapsulation method to retrieve the {@link Triplet} of the {@link Point}
     * @return the {@link Triplet} of the {@link Point}
     */
    public Triplet getTriplet(){
        return triplet;
    }

    /**
     * Prints the current object
     * @return the {@link String} of a {@link Point}
     */
    @Override
    public String toString() {
        return "Point{" +
                "triplet=" + triplet +
                '}';
    }
}
