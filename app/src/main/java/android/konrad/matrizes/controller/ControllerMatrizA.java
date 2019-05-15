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
        }else{
            valido = true;
        }

       this.setMatriz(new ModelMatrizA(m, n));

        return valido;
    }
}
