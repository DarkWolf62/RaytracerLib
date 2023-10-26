package fr.univartois.sae.raytracing.shadow;

import fr.univartois.sae.raytracing.scene.Scene;

public class ProxyShadow {

    public void shadowRequest(Scene scene){
        if (scene.isShadow()){
            RealShadow real = new RealShadow();
            //real.shadowRequest(scene);
        }


    }
}
