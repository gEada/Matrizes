package android.konrad.matrizes.controller;

import android.konrad.matrizes.model.ModelMatrizB;

public class ControllerMatrizB extends ControllerMatriz {

    public ControllerMatrizB() {    }

    @Override
    public boolean criarMatriz(int m, int n, double[][] matriz) {

        boolean valido;
        if (matriz.length != m){
            valido = false;
        }else{
            valido = true;
        }

        this.setMatriz(new ModelMatrizB(m, n));

        return valido;
    }

}
