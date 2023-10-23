package fr.univartois.sae.raytracing.triplet;

import static java.lang.Math.sqrt;


public class Triplet {
    private double x;
    private double y;
    private double z;

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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Triplet addition(Triplet triplet) {
        return new Triplet(x + triplet.getX(),y + triplet.getY(),z + triplet.getZ());
    }

    public Triplet substraction(Triplet triplet) {
        return new Triplet(x - triplet.getX(),y - triplet.getY(),z - triplet.getZ());
    }

    public Triplet scalarMultiplication(double d) {
        return new Triplet(d*x,d*y,d*z);
    }

    public double scalarProduct(Triplet triplet) {
        return x*triplet.getX() + y*triplet.getY() + z*triplet.getZ();
    }

    public Triplet vectorProduct(Triplet triplet) {
        return new Triplet(y*triplet.getZ()-z*triplet.getY(), z*triplet.getX()+x*triplet.getZ(),x* triplet.getY()-y* triplet.getX());
    }

    public Triplet schurProduct(Triplet triplet) {
        return new Triplet(x* triplet.getX(),y* triplet.getY(),z* triplet.getZ());
    }

    public double norm(){
        return sqrt(x*x+y*y+z*z);
    }

    public Triplet normalize() {
        return scalarMultiplication(1/norm());
    }
}
