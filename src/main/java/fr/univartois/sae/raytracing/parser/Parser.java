package fr.univartois.sae.raytracing.parser;

import fr.univartois.sae.raytracing.light.DirectionalLight;
import fr.univartois.sae.raytracing.light.Light;
import fr.univartois.sae.raytracing.light.PonctualLight;
import fr.univartois.sae.raytracing.object.AObject;
import fr.univartois.sae.raytracing.object.Plane;
import fr.univartois.sae.raytracing.object.Sphere;
import fr.univartois.sae.raytracing.object.Triangle;
import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Point;
import fr.univartois.sae.raytracing.triplet.Triplet;
import fr.univartois.sae.raytracing.triplet.Vector;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Parser {
    private IBuilder builder;
    private final String chemin;

    public Parser(String chemin) {
        this.chemin = chemin;
        builder = new SceneBuilder();
    }

    public JSONObject getColors() {
        JSONObject res = new JSONObject();
        res.put("ambient", null);
        res.put("diffuse", null);
        res.put("specular", null);
        try {
            File myObj = new File(chemin);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] line = data.split(" ");
                switch (line[0]) {
                    case "ambient" : res.put("ambient", new Color(new Triplet(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3])))); break;
                    case "diffuse" : res.put("diffuse", new Color(new Triplet(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3])))); break;
                    case "specular" : res.put("specular", new Color(new Triplet(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3])))); break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList<AObject> getObject() {
        ArrayList<AObject> res = new ArrayList<>();
        Point[] vertex = null;
        int nbV = 0;
        try {
            File myObj = new File(chemin);
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

    public ArrayList<Light> getLights() {
        ArrayList<Light> res = new ArrayList<>();
        try {
            File myObj = new File(chemin);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] line = data.split(" ");
                switch (line[0]) {
                    case "directional" : new DirectionalLight(new Vector(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3])), new Color(parseDouble(line[4]), parseDouble(line[5]), parseDouble(line[6]))); break;
                    case "point" : new PonctualLight(new Point(parseDouble(line[1]), parseDouble(line[2]), parseDouble(line[3])), new Color(parseDouble(line[4]), parseDouble(line[5]), parseDouble(line[6]))); break;
                   }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return res;
    }
}
