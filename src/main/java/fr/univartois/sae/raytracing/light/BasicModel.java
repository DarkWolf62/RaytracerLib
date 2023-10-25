package fr.univartois.sae.raytracing.light;

import fr.univartois.sae.raytracing.object.Sphere;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.triplet.Color;
import fr.univartois.sae.raytracing.triplet.Vector;

public class BasicModel implements IStrategy{

    @Override
    public Color modelMethod(Sphere object, int idObj , Vector lookFrom, Vector d, double t, Scene scene) {
    return null;
        //METHODE SI LA LUMIERE EST UNE LUMIERE D'AMBIANCE (JE CROIS SINON DEMANDER AU PROF CE QU'EST LE "MODELE DE BASE")

    }
}
