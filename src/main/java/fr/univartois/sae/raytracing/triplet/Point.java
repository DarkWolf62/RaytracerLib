package fr.univartois.sae.raytracing.triplet;

public class Point {
    private Triplet triplet;

    public Point(Triplet triplet){
        this.triplet=triplet;
    }
    public Point(int x,int y,int z){
        triplet=new Triplet(x,y,z);
    }
    public Vector subtraction(Triplet triplet){

        return new Vector(this.triplet.subtraction(triplet));
    }
    public Point scalarMultiplication(double d){
        return new Point(triplet.scalarMultiplication(d));

    }
    public Triplet getTriplet(){
        return triplet;
    }
}
