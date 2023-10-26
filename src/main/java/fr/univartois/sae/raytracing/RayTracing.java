package fr.univartois.sae.raytracing;

import fr.univartois.sae.raytracing.light.IStrategy;
import fr.univartois.sae.raytracing.light.Light;
import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.object.Plane;
import fr.univartois.sae.raytracing.object.Sphere;
import fr.univartois.sae.raytracing.object.Triangle;
import fr.univartois.sae.raytracing.scene.Scene;

import fr.univartois.sae.raytracing.shadow.IShadow;

import fr.univartois.sae.raytracing.shadow.ProxyShadow;
import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Vector;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Class RayTracing to generate an image from a scene
 * @author leo.denis
 * @author matheo.dupuis
 * @author nicolas.nourry
 * @author nicolas.blart
 */
public class RayTracing {

    private Scene scene;

    private BufferedImage image;

    private IStrategy strategy;

    /**
     * Create an image from a scene
     * @param scene the scene
     * @param strategy The strategy used to create the light
     */
    public RayTracing(Scene scene, IStrategy strategy){
        this.scene=scene;
        IShadow shadow = new ProxyShadow();

        Vector lookFrom=new Vector(scene.getCamera().get(0));
        Vector looKAt=new Vector(scene.getCamera().get(1));
        Vector up = new Vector(scene.getCamera().get(2));
        Vector w=lookFrom.subtraction(looKAt.getTriplet()).scalarMultiplication((1/(lookFrom.subtraction(looKAt.getTriplet()).norm())));
        Vector u = (up.vectorProduct(w.getTriplet())).scalarMultiplication(1/up.vectorProduct(w.getTriplet()).norm());
        Vector v = (w.vectorProduct(u.getTriplet())).scalarMultiplication(1/w.vectorProduct(u.getTriplet()).norm());
        double fovr = (scene.getFov()*Math.PI)/180;
        double realHeight = 2*Math.tan(fovr/2);
        double pixelHeight = realHeight / scene.getHeight();
        double realWidth = scene.getWidth() * pixelHeight;
        double pixelWidth = realWidth / scene.getWidth();
        Color[][] colors = new Color[scene.getWidth()][scene.getHeight()];
        int intersectedObjectIndex = -1;
        for(int i=0;i<scene.getWidth();i++){
            for(int j=0;j<scene.getHeight();j++) {
                double a = (-(realWidth / 2) + ((i + 0.5) * pixelWidth));
                double b = ((realHeight / 2) - ((j + 0.5) * pixelHeight));
                double t = -1;
                Vector d = new Vector((((u.scalarMultiplication(a)).addition(v.scalarMultiplication(b).getTriplet())).subtraction(w.getTriplet())).scalarMultiplication(1 / (((u.scalarMultiplication(a).addition(v.scalarMultiplication(b).getTriplet()).subtraction(w.getTriplet())).getTriplet()).norm())).getTriplet());
                Color color = new Color(0.0, 0.0, 0.0);
                for (int index = 0; index < scene.getObjects().size(); index++) {
                    AObject object = scene.getObjects().get(index);
                    if (object instanceof Sphere) {
                        Point p = ((Sphere) object).calcP(d, lookFrom.getTriplet());
                        if (p != null) {
                            double distance = object.distance(p, d);
                            if (distance >= 0) {
                                intersectedObjectIndex = index;
                                List<Light> lights = shadow.shadowRequest(scene, object, p);
                                if(lights == null) {
                                    color = strategy.modelMethod(scene.getObjects().get(intersectedObjectIndex), intersectedObjectIndex, p, scene, d);
                                } else {
                                    color = strategy.modelMethodShadow(scene.getObjects().get(intersectedObjectIndex), intersectedObjectIndex, p, scene, d, lights);
                                }
                                if (i==506&&j==396)
                                    System.out.println(lights);
                            }
                        }
                    } else if (object instanceof Plane) {
                        Point p = ((Plane) object).calcP(d,lookFrom.getTriplet());
                        double distance = object.distance(p, d);
                        if (distance>=0) {
                            intersectedObjectIndex=index;
                            List<Light> lights = shadow.shadowRequest(scene, object, p);
                            if(lights == null) {
                                color = strategy.modelMethod(scene.getObjects().get(intersectedObjectIndex), intersectedObjectIndex, p, scene, d);
                            } else {
                                color = strategy.modelMethodShadow(scene.getObjects().get(intersectedObjectIndex), intersectedObjectIndex, p, scene, d, lights);
                            }
                        }
                    } else if (object instanceof Triangle) {
                        Point p = ((Triangle) object).calcP(d, lookFrom.getTriplet());
                        double distance = object.distance(p, d);
                        if (distance >= 0) {
                            intersectedObjectIndex = index;
                            List<Light> lights = shadow.shadowRequest(scene, object, p);
                            if(lights == null) {
                                color = strategy.modelMethod(scene.getObjects().get(intersectedObjectIndex), intersectedObjectIndex, p, scene, d);
                            } else {
                                color = strategy.modelMethodShadow(scene.getObjects().get(intersectedObjectIndex), intersectedObjectIndex, p, scene, d, lights);
                            }
                        }
                    } else {
                        throw new UnsupportedOperationException();
                    }
                    colors[i][j] = new Color(color.getTriplet());
                }
            }
        }
        createImage(colors);
    }

    /**
     * Create an image with a 2D array of colors
     * @param colors a 2D array of colors
     */
    public void createImage(Color[][] colors) {
        try {
            image = new BufferedImage(scene.getWidth(),scene.getHeight(), 1);
            for (int i=0; i< scene.getWidth(); i++) {
                for (int j=0; j< scene.getHeight();j++) {
                    image.setRGB(i,j,new java.awt.Color((int) (colors[i][j].getTriplet().getX()*255), (int) (colors[i][j].getTriplet().getY()*255), (int) (colors[i][j].getTriplet().getZ()*255)).getRGB());
                }
            }
            File outputfile = new File("image/"+scene.getOutput());
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

