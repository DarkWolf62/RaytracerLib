package fr.univartois.sae.raytracing.parser;

import fr.univartois.sae.raytracing.light.DirectionalLight;
import fr.univartois.sae.raytracing.light.Light;
import fr.univartois.sae.raytracing.light.PonctualLight;
import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.object.Plane;
import fr.univartois.sae.raytracing.object.Sphere;
import fr.univartois.sae.raytracing.object.Triangle;
import fr.univartois.sae.raytracing.scene.IBuilder;
import fr.univartois.sae.raytracing.scene.SceneBuilder;
import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Triplet;
import fr.univartois.sae.raytracing.triplet.Vector;



import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

/**
 * Class parser used to read a configuration file.
 * @author leo.denis
 */
public class Parser {
    private IBuilder builder;
    private final String path;

    /**
     * Parser constructor
     * @param path the configuration file's path
     */
    public Parser(String path) {
        this.path = path;
        builder = new SceneBuilder();
    }

    /**
     * Returns all the colors in the configuration file
     *
     * @return A Map as {"ambient", "diffuse", "specular"}
     */
    public Map<String, Object> getColors() {
        Map<String, Object> res = new HashMap<>();
        ArrayList<Color> diffuseC = new ArrayList<>();
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] line = data.split(" ");
                switch (line[0]) {
                    case "ambient" : res.put("ambient", new Color(new Triplet(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3])))); break;
                    case "diffuse" : diffuseC.add(new Color(new Triplet(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3])))); break;
                    case "specular" : res.put("specular", new Color(new Triplet(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3])))); break;
                }
            }
            res.put("diffuse", diffuseC);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return res;
    }

    /**
     * Returns all the objects in the configuration file
     * @return an ArrayList with all the objects
     */
    public ArrayList<AObject> getObject() {
        ArrayList<AObject> res = new ArrayList<>();
        Point[] vertex = null;
        int nbV = 0;
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] line = data.split(" ");
                switch (line[0]) {
                    case "maxverts" : vertex = new Point[parseInt(line[1])]; break;
                    case "vertex" : vertex[nbV] = new Point(new Triplet(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3]))); nbV++; break;
                    case "tri" : res.add(new Triangle(vertex[parseInt(line[1])], vertex[parseInt(line[2])], vertex[parseInt(line[3])])); break;
                    case "sphere" : res.add(new Sphere(new Point(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3])), parseDouble(line[4]))); break;
                    case "plane" : res.add(new Plane(new Point(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3])),new Triplet(parseDouble(line[4]), parseDouble(line[5]), parseDouble(line[6])))); break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return res;
    }

    /**
     * Returns all the lights in the configuration file
     * @return an ArrayList with all the lights
     */
    public ArrayList<Light> getLights() {
        ArrayList<Light> res = new ArrayList<>();
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] line = data.split(" ");
                switch (line[0]) {
                    case "directional" : res.add(new DirectionalLight(new Vector(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3])), new Color(parseDouble(line[4]), parseDouble(line[5]), parseDouble(line[6])))); break;
                    case "point" : res.add(new PonctualLight(new Point(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3])), new Color(parseDouble(line[4]), parseDouble(line[5]), parseDouble(line[6])))); break;
                   }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return res;
    }

    /**
     * Returns the scene in the configuration file
     * @return a Map with all the scene parameters
     */
    public Map<String, Object> getScene() {
        Map<String, Object> res = new HashMap<>();
        res.put("height", (Integer) null);
        res.put("width", (Integer) null);
        res.put("camera", (ArrayList<Triplet>) null);
        res.put("shininess", 0.0);
        res.put("fov", (Double) null);
        res.put("output", "default.png");
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] line = data.split(" ");
                switch (line[0]) {
                    case "size" : res.put("width", parseInt(line[1])); res.put("height", parseInt(line[2])); break;
                    case "camera" :
                        ArrayList<Triplet> l = new ArrayList<Triplet>();
                        l.add(new Triplet(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3])));
                        l.add(new Triplet(parseDouble(line[4]), parseDouble(line[5]), parseDouble(line[6])));
                        l.add(new Triplet(parseDouble(line[7]), parseDouble(line[8]), parseDouble(line[9])));
                        res.put("camera",l);
                        res.put("fov", parseInt(line[10]));

                        break;
                    case "shininess" : res.put("shininess", parseDouble(line[1])); break;
                    case "output" : res.put("output", line[1]); break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return res;
    }

    /**
     * Getter for the builder
     * @return builder for the scene
     */
    public IBuilder getBuilder() {
        return builder;
    }

    /**
     * This function put the right values for the builder
     */
    public void construct(){
        builder.buildCamera((ArrayList<Triplet>) getScene().get("camera"),(Integer) getScene().get("fov"));
        builder.buildLight(getLights());
        builder.buildColors(getColors());
        builder.buildObject(getObject());
        builder.buildScene((Integer) getScene().get("width"), (Integer)getScene().get("height"), (Double) getScene().get("shininess"), (String) getScene().get("output"));

    }
}
