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
 * Class {@link Parser} used to read a configuration file.
 * @author leo.denis
 */
public class Parser {
    /**
     * The {@link IBuilder} design pattern to Parse the information
     */
    private final IBuilder builder;

    /**
     * The {@link String} path of the configuration file
     */
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
     * @return A {@link Map} with keys : {"ambient", "specular"}
     */
    public Map<String, Object> getColors() {
        Map<String, Object> res = new HashMap<>();
        res.put("ambient", new Color(0,0,0));
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] line = data.split(" ");
                if (Objects.equals(line[0], "ambient")) {
                    res.put("ambient", new Color(new Triplet(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3]))));
                } else if (Objects.equals(line[0], "specular")){
                    res.put("specular", new Color(new Triplet(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3]))));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * Returns all the {@link AObject} in the configuration file
     * @return an {@link List} with all the objects
     */
    public List<AObject> getObject() {
        ArrayList<AObject> res = new ArrayList<>();
        Point[] vertex = null;
        int nbV = 0;
        Color c = new Color(0.0,0.0,0.0);
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] line = data.split(" ");
                switch (line[0]) {
                    case "diffuse" -> c = new Color(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3]));
                    case "maxverts" -> vertex = new Point[parseInt(line[1])];
                    case "vertex" -> {
                        assert vertex != null;
                        vertex[nbV] = new Point(new Triplet(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3])));
                        nbV++;
                    }
                    case "tri" -> {
                        assert vertex != null;
                        res.add(0,new Triangle(vertex[parseInt(line[1])], vertex[parseInt(line[2])], vertex[parseInt(line[3])], c));
                    }
                    case "sphere" ->
                            res.add(0,new Sphere(new Point(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3])), parseDouble(line[4]), c));
                    case "plane" ->
                            res.add(0, new Plane(new Point(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3])), new Vector(parseDouble(line[4]), parseDouble(line[5]), parseDouble(line[6])), c));
                    default -> {
                        break;
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * Returns all the {@link Light} in the configuration file
     * @return an {@link List} with all the {@link Light}
     */
    public List<Light> getLights() {
        ArrayList<Light> res = new ArrayList<>();
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] line = data.split(" ");
                switch (line[0]) {
                    case "directional" ->
                            res.add(new DirectionalLight(new Vector(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3])), new Color(parseDouble(line[4]), parseDouble(line[5]), parseDouble(line[6]))));
                    case "point" ->
                            res.add(new PonctualLight(new Point(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3])), new Color(parseDouble(line[4]), parseDouble(line[5]), parseDouble(line[6]))));
                    default -> {
                        break;
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * Returns the Scene in the configuration file
     * @return a {@link Map} with all the scene parameters
     */
    public Map<String, Object> getScene() {
        Map<String, Object> res = new HashMap<>();
        res.put("height", (Integer) null);
        res.put("width", (Integer) null);
        res.put("camera", (ArrayList<Triplet>) null);
        res.put("shininess", 0.0);
        res.put("fov", (Double) null);
        res.put("output", "default.png");
        res.put("shadow", false);
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] line = data.split(" ");
                switch (line[0]) {
                    case "size" -> {
                        res.put("width", parseInt(line[1]));
                        res.put("height", parseInt(line[2]));
                    }
                    case "camera" -> {
                        ArrayList<Triplet> l = new ArrayList<>();
                        l.add(new Triplet(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3])));
                        l.add(new Triplet(parseDouble(line[4]), parseDouble(line[5]), parseDouble(line[6])));
                        l.add(new Triplet(parseDouble(line[7]), parseDouble(line[8]), parseDouble(line[9])));
                        res.put("camera", l);
                        res.put("fov", parseInt(line[10]));
                    }
                    case "shininess" -> res.put("shininess", parseDouble(line[1]));
                    case "output" -> res.put("output", line[1]);
                    case "shadow" -> res.put("shadow", Objects.equals(line[1], "true"));
                    default -> {
                       break;
                   }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * Encapsulation method to retrieve the {@link IBuilder}
     * @return the {@link IBuilder} for the scene
     */
    public IBuilder getBuilder() {
        return builder;
    }

    /**
     * This function put the right values for the {@link SceneBuilder}
     */
    public void construct(){
        builder.buildCamera(
                (List<Triplet>) getScene().get("camera"),
                (Integer) getScene().get("fov")
        );
        builder.buildLight(getLights());
        builder.buildColors(getColors());
        builder.buildObject((ArrayList<AObject>) getObject());
        builder.buildScene((Integer) getScene().get("width"), (Integer)getScene().get("height"), (Double) getScene().get("shininess"), (String) getScene().get("output"), (boolean) getScene().get("shadow"));
    }
}
