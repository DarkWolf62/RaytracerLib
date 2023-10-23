package fr.univartois.sae.raytracing.triplet;

public class Color {
    private Triplet triplet;

    public Color(Triplet triplet){
        this.triplet=triplet;
    }
    public Color(int x,int y,int z){
        triplet=new Triplet(x,y,z);
    }

    public Color addition(Triplet triplet){
        return null;
    }
    public Color scalarMultiplication(double d){
        return null;
    }
    public Color shurProduct(Triplet triplet){
        return null;
    }
}
