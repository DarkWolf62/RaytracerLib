package fr.univartois.sae.raytracing.triplet;

/**
 * @author matheo.dupuis
 *
 * This class represents a {@link Vector}
 */
public class Vector {
    /**
     * The {@link Triplet} who represents the coordinates values
     */
    private final Triplet triplet;

    /**
     * Constructor using coordinates
     * @param x : the x coordinate
     * @param y : the y coordinate
     * @param z : the z coordinate
     */
    public Vector(double x, double y, double z){
        this.triplet = new Triplet(x,y,z);
    }

    /**
     * Constructor using a {@link Triplet}
     * @param triplet : the coordinate of the {@link Vector}
     */
    public Vector(Triplet triplet){
        this.triplet = triplet;
    }


    /**
     * Create a new {@link Vector} from the addition between the actual instance of {@link Triplet} and another {@link Triplet}
     * @param triplet the second {@link Triplet}
     * @return the new {@link Vector}
     */
    public Vector addition(Triplet triplet){
        return new Vector(this.triplet.addition(triplet));
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
     * Create a new {@link Vector} from the scalar multiplication between the actual {@link Triplet} and a double
     * @param d the double to multiply
     * @return the new {@link Vector}
     */
    public Vector scalarMultiplication(double d){
        return new Vector(this.triplet.scalarMultiplication(d));
    }

    /**
     * Create a new {@link Vector} from the scalar product between the actual {@link Triplet} and another
     * @param triplet the other {@link Triplet}
     * @return the new {@link Vector}
     */
    public double scalarProduct(Triplet triplet){
        return this.triplet.scalarProduct(triplet);
    }

    /**
     * Create a new {@link Vector} from the vector product of the actual {@link Triplet} and another
     * @param triplet the other {@link Triplet}
     * @return the new {@link Vector}
     */
    public Vector vectorProduct(Triplet triplet){
        return new Vector(this.triplet.vectorProduct(triplet));
    }

    /**
     * Return the norm (length) of a {@link Triplet}
     * @return the norm
     */
    public double norm(){
        return this.triplet.norm();
    }

    /**
     * Return the normalisation of a {@link Triplet}
     * @return the normalisation of the {@link Triplet}
     */
    public Vector normalize() { return new Vector(this.triplet.normalize()); }

    /**
     * Encapsulation method to retrieve the {@link Triplet} of the {@link Vector}
     * @return the {@link Triplet} of the {@link Vector}
     */
    public Triplet getTriplet(){
        return this.triplet;
    }

    /**
     * Prints the current object
     * @return the {@link String} of a {@link Vector}
     */
    @Override
    public String toString() {
        return "Vector{" +
                "triplet=" + triplet +
                '}';
    }

    /**
     * Check if the current vector has an opposite direction from another vector v
     * @param v the other {@link Vector}
     * @return a boolean set at True if the 2 vectors are opposite
     */
    public boolean oppositeDirection(Vector v) {
        double k =  (getTriplet().getX()/v.getTriplet().getX());
        return (k>0);
    }
}
