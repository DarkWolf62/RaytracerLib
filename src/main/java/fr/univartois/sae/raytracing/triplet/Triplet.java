package fr.univartois.sae.raytracing.triplet;

import static java.lang.Math.sqrt;

/**
 * Class Triplet.
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

    /**
     * Prints the current object
     * @return the {@link String} of a {@link Triplet}
     */
    @Override
    public String toString() {
        return "Triplet{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }


    /**
     * Setter for X
     * @param x : the new X value
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Setter for Y
     * @param y : the new Y value
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Setter for Z
     * @param z : the new Z value
     */
    public void setZ(double z) {
        this.z = z;
    }

    /**
     * Getter for X.
     * @return the x value
     */
    public double getX() {
        return x;
    }

    /**
     * Getter for Y.
     * @return the y value
     */
    public double getY() {
        return y;
    }

    /**
     * Getter for Z.
     * @return the z value
     */
    public double getZ() {
        return z;
    }

    /**
     * Create a new {@link Triplet} from the addition between the actual instance of {@link Triplet} and another {@link Triplet}
     * @param triplet the second {@link Triplet}
     * @return the new {@link Triplet}
     */
    public Triplet addition(Triplet triplet) {
        return new Triplet(x + triplet.getX(),y + triplet.getY(),z + triplet.getZ());
    }

    /**
     * Create a new {@link Triplet} from the subtraction of the actual {@link Triplet} by another
     * @param triplet the other {@link Triplet}
     * @return the new {@link Triplet}
     */
    public Triplet subtraction(Triplet triplet) {
        return new Triplet(x - triplet.getX(),y - triplet.getY(),z - triplet.getZ());
    }

    /**
     * Create a new {@link Triplet} from the scalar multiplication between the actual {@link Triplet} and a double
     * @param d the double to multiply
     * @return the new {@link Triplet}
     */
    public Triplet scalarMultiplication(double d) {
        return new Triplet(d*x,d*y,d*z);
    }

    /**
     * Create a new {@link Triplet} from the scalar product between the actual {@link Triplet} and another
     * @param triplet the other {@link Triplet}
     * @return the new {@link Triplet}
     */
    public double scalarProduct(Triplet triplet) {
        return x*triplet.getX() + y*triplet.getY() + z*triplet.getZ();
    }

    /**
     * Create a new {@link Triplet} from the vector product of the actual {@link Triplet} and another
     * @param triplet the other {@link Triplet}
     * @return the new {@link Triplet}
     */
    public Triplet vectorProduct(Triplet triplet) {
        return new Triplet(y*triplet.getZ()-z*triplet.getY(), z*triplet.getX()-x*triplet.getZ(),x* triplet.getY()-y* triplet.getX());
    }

    /**
     * Create a new {@link Triplet} from the Schur product between the actual {@link Triplet} and another
     * @param triplet the other {@link Triplet}
     * @return the new {@link Triplet}
     */
    public Triplet schurProduct(Triplet triplet) {
        return new Triplet(x* triplet.getX(),y* triplet.getY(),z* triplet.getZ());
    }

    /**
     * Return the norm (length) of a {@link Triplet}
     * @return the norm
     */
    public double norm(){
        return sqrt(x*x+y*y+z*z);
    }

    /**
     * Return the normalisation of a {@link Triplet}
     * @return the normalisation of the {@link Triplet}
     */
    public Triplet normalize() {
        return scalarMultiplication(1/this.norm());
    }
}
