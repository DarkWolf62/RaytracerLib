package fr.univartois.sae.raytracing.triplet;

import static java.lang.Math.sqrt;

/**Class Triplet.
 * @author leo.denis
 */
public class Triplet {
    private double x;
    private double y;
    private double z;

    /**Constructor using three doubles to create a triplet.
     * @param x The first triplet's variable
     * @param y The second triplet's variable
     * @param z The third triplet's variable
     */
    public Triplet(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Triplet{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    /**
     * Gets the x.
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y.
     * @return y
     */
    public double getY() {
        return y;
    }

    /**
     * Gets the z.
     * @return z
     */
    public double getZ() {
        return z;
    }

    /**
     * Create a new triplet from the addition between the actual instance of triplet and another triplet
     * @param triplet the second triplet
     * @return the new triplet
     */
    public Triplet addition(Triplet triplet) {
        return new Triplet(x + triplet.getX(),y + triplet.getY(),z + triplet.getZ());
    }

    /**
     * Create a new triplet from the subtraction of the actual triplet by another
     * @param triplet the other triplet
     * @return the new triplet
     */
    public Triplet subtraction(Triplet triplet) {
        return new Triplet(x - triplet.getX(),y - triplet.getY(),z - triplet.getZ());
    }

    /**
     * create a new triplet from the scalar multiplication between the actual triplet and a double
     * @param d the double
     * @return the new triplet
     */
    public Triplet scalarMultiplication(double d) {
        return new Triplet(d*x,d*y,d*z);
    }

    /**
     * create a new triplet from the scalar product between the actual triplet and another
     * @param triplet the other triplet
     * @return the new triplet
     */
    public double scalarProduct(Triplet triplet) {
        return x*triplet.getX() + y*triplet.getY() + z*triplet.getZ();
    }

    /**
     * Create a new triplet from the vector product of the actual triplet and another
     * @param triplet the other triplet
     * @return the new triplet
     */
    public Triplet vectorProduct(Triplet triplet) {
        return new Triplet(y*triplet.getZ()-z*triplet.getY(), z*triplet.getX()-x*triplet.getZ(),x* triplet.getY()-y* triplet.getX());
    }

    /**
     * Create a new triplet from the Schur product between the actual triplet and another
     * @param triplet the other triplet
     * @return the new triplet
     */
    public Triplet schurProduct(Triplet triplet) {
        return new Triplet(x* triplet.getX(),y* triplet.getY(),z* triplet.getZ());
    }

    /**
     * Returns the norm (length) of a triplet
     * @return the norm
     */
    public double norm(){
        return sqrt(x*x+y*y+z*z);
    }

    /**
     * Returns the normalisation of a triplet
     * @return the normalisation of the triplet
     */
    public Triplet normalize() {
        return scalarMultiplication(1/this.norm());
    }
}
