package fr.univartois.sae.raytracing.light;

import fr.univartois.sae.raytracing.object.Sphere;
import fr.univartois.sae.raytracing.scene.Scene;
import fr.univartois.sae.raytracing.triplet.Vector;

public class BasicModel implements IStrategy{

    @Override
    public void modelMethod(Sphere object, Vector lookFrom, Vector d, double t, Scene scene) {

        //METHODE SI LA LUMIERE EST UNE LUMIERE D'AMBIANCE (JE CROIS SINON DEMANDER AU PROF CE QU'EST LE "MODELE DE BASE")

    }
}
