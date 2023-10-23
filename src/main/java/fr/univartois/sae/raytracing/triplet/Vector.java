package fr.univartois.sae.raytracing.triplet;

public class Vector {

    private Triplet triplet;

    public Vector(double x, double y, double z){
        this.triplet = new Triplet(x,y,z);
    }

    public Vector(Triplet triplet){
        this.triplet = triplet;
    }

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
