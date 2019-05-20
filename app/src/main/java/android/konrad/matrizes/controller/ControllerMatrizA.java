package android.konrad.matrizes.controller;

import android.konrad.matrizes.model.ModelMatriz;
import android.konrad.matrizes.model.ModelMatrizA;

public class ControllerMatrizA extends ControllerMatriz {



    public ControllerMatrizA() {

    }

    @Override
    public boolean criarMatriz(int m, int n, double[][] matriz) {
        boolean valido;
        if (matriz.length != m){
            valido = false;
            this.setCriada(false);
        }else{
            valido = true;
            this.setCriada(true);
            this.setMatriz(new ModelMatrizA(m, n));
            this.getMatriz().setMatriz(matriz);
        }



        return valido;
    }
}
