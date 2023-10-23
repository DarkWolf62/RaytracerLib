package fr.univartois.sae.raytracing.triplet;

/**
 * @author matheo.dupuis
 *
 *This class represents a vector
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
     * @return
     */
    public Vector addition(Triplet triplet){
        return null;
    }

    public Vector substraction(Triplet triplet){
        return null;
    }

    public Vector scalarMultiplication(double d){
        return null;
    }

    public Vector scalarProduct(Triplet triplet){
        return null;
    }

    public Vector vectorProduct(Triplet triplet){
        return null;
    }

    public Vector norm(){
        return null;
    }

    public Triplet getTriplet(){
        return this.triplet;
    }


}
