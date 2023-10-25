package fr.univartois.sae.raytracing.triplet;

/**
 * @author matheo.dupuis
 *
 * This class represents a vector
 */
public class Vector {

    private Triplet triplet;

    /**
     * Constructor using coordinates
     * @param x
     * @param y
     * @param z
     */
    public Vector(double x, double y, double z){
        this.triplet = new Triplet(x,y,z);
    }

    /**
     * Constructor using a triplet
     * @param triplet
     */
    public Vector(Triplet triplet){
        this.triplet = triplet;
    }


    /**
     * addition of 2 vectors using a triplet
     * @param triplet
     * @return Vector using current triplet added with triplet in parameter
     */
    public Vector addition(Triplet triplet){
        return new Vector(this.triplet.addition(triplet));
    }

    /**
     * subtraction of 2 vectors using a triplet
     * @param triplet
     * @return Vector using current triplet subtracted with triplet in parameter
     */
    public Vector subtraction(Triplet triplet){
        return new Vector(this.triplet.subtraction(triplet));
    }

    /**
     * calculate the scalar multiplication of the current vector by the number d
     * @param d
     * @return scalar multiplication of the current vector by the number d
     */
    public Vector scalarMultiplication(double d){
        return new Vector(this.triplet.scalarMultiplication(d));
    }

    /**
     * calculate the scalar product of the current vector by a triplet
     * @param triplet
     * @return the scalar product of the current vector by a triplet
     */
    public double scalarProduct(Triplet triplet){
        return this.triplet.scalarProduct(triplet);
    }

    /**
     calculate the vector product of the current vector by a triplet
     * @param triplet
     * @return the vector product of the current vector by a triplet
     */
    public Vector vectorProduct(Triplet triplet){
        return new Vector(this.triplet.vectorProduct(triplet));
    }

    /**
     *
     * @return the norm of the current vector
     */
    public double norm(){
        return this.triplet.norm();
    }

    /**
     * Return the normalisation of a triplet
     * @return the normalisation of the triplet
     */
    public Vector normalize() { return new Vector(this.triplet.normalize()); }

    /**
     *
     * @return the triplet of the current vector
     */
    public Triplet getTriplet(){
        return this.triplet;
    }

    /**
     * Print the current object
     * @return String
     */
    @Override
    public String toString() {
        return "Vector{" +
                "triplet=" + triplet +
                '}';
    }
}
