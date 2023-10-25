package fr.univartois.sae.raytracing.triplet;

/**
 * @author nicolas.nourry
 *
 * This class represents a color.
 */
public class Color {
    private Triplet triplet;

    /**
     * Constructor for create a color with a triplet
     * @param triplet is a triplet
     */
    public Color(Triplet triplet){
        this.triplet=triplet;
    }

    /**
     * Constructor for create a color with coordinate
     * @param x,y,z is are double
     */
    public Color(double x,double y,double z){
        triplet=new Triplet(x,y,z);
    }

    /**
     * this method addition the triplet of this class and a other triplet
     * @param triplet
     * @return a new color
     */
    public Color addition(Triplet triplet){

        return new Color(this.triplet.addition(triplet));
    }

    /**
     * this method use the scalar multiplication on the triplet
     * @param d
     * @return a new color
     */
    public Color scalarMultiplication(double d){

        return new Color(triplet.scalarMultiplication(d));
    }

    /**
     * this method use the schur product on the triplet
     * @param triplet
     * @return a new color
     */
    public Color schurProduct(Triplet triplet){

        return new Color(this.triplet.schurProduct(triplet));
    }

    /**
     *
     * @return this triplet of color
     */
    public Triplet getTriplet(){
        return triplet;
    }

    /**
     * Prints the current object
     * @return String
     */
    @Override
    public String toString() {
        return "Color{" +
                "triplet=" + triplet +
                '}';
    }
}
