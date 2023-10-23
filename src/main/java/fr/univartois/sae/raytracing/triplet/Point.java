package fr.univartois.sae.raytracing.triplet;

public class Point {
    private Triplet triplet;

    public Point(Triplet triplet){
        this.triplet=triplet;
    }
    public Point(int x,int y,int z){
        triplet=new Triplet(x,y,z);
    }
    public Triplet subtraction(Triplet triplet){
        return null;
    }
    public Point scalarMultiplication(double d){
        return null;

    }
    public Triplet getTriplet(){
        return triplet;
    }
}
