package fr.univartois.sae.raytracing.object;

import fr.univartois.sae.raytracing.triplet.Point;

/**
 * @author nicolas nourry
 *
 * this class represent a triangle
 */
public class Triangle extends AObject{
    /**
     * represent a point of the triangle
     */
    private Point a;
    /**
     * represent a point of the triangle
     */
    private Point b;
    /**
     * represent a point of the triangle
     */
    private Point c;

    /**
     * constructor of this class
     */
    public Triangle(){
        a=new Point(0,0,0);
        b=new Point(0,0,0);
        c=new Point(0,0,0);


    }

    /**
     * setter of point 'a' of the triangle
     * @param a
     */
    public void setA(Point a) {
        this.a = a;
    }
    /**
     * setter of point 'b' of the triangle
     * @param b
     */
    public void setB(Point b) {
        this.b = b;
    }
    /**
     * setter of point 'c' of the triangle
     * @param c
     */
    public void setC(Point c) {
        this.c = c;
    }
}
