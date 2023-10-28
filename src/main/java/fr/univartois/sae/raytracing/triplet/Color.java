package fr.univartois.sae.raytracing.triplet;


/**
 * @author nicolas.nourry
 *
 * This class represents a {@link Color}.
 */
public class Color {
    /**
     * The {@link Triplet} who represents RGB values
     */
    private final Triplet triplet;

    /**
     * Constructor to create a {@link Color} with a {@link Triplet}
     * @param triplet : the RGB {@link Triplet}
     */
    public Color(Triplet triplet){
        this.triplet=triplet;
    }

    /**
     * Constructor to create a {@link Color} with coordinate
     * @param x : the red value
     * @param y : the green value
     * @param z : the blue value
     */
    public Color(double x,double y,double z){
        triplet=new Triplet(x,y,z);
    }

    /**
     * Create a new {@link Color} from the addition between the actual instance of {@link Triplet} and another {@link Triplet}
     * @param triplet the second {@link Triplet}
     * @return the new {@link Color}
     */
    public Color addition(Triplet triplet){
        return new Color(this.triplet.addition(triplet));
    }

    /**
     * create a new {@link Color} from the scalar multiplication between the actual {@link Triplet} and a double
     * @param d the double to multiply
     * @return the new {@link Color}
     */
    public Color scalarMultiplication(double d){

        return new Color(triplet.scalarMultiplication(d));
    }

    /**
     * create a new {@link Color} from the scalar product between the actual {@link Triplet} and another
     * @param triplet the other {@link Triplet}
     * @return the new {@link Color}
     */
    public Color schurProduct(Triplet triplet){

        return new Color(this.triplet.schurProduct(triplet));
    }

    /**
     * Encapsulation method to retrieve the {@link Triplet} of that {@link Color}
     * @return this {@link Triplet} of that {@link Color}
     */
    public Triplet getTriplet(){
        return triplet;
    }

    /**
     * Prints the current object
     * @return the {@link String} of a {@link Color}
     */
    @Override
    public String toString() {
        return "Color{" +
                "triplet=" + triplet +
                '}';
    }
}
