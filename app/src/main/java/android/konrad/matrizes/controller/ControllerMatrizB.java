package android.konrad.matrizes.controller;

import android.konrad.matrizes.model.ModelMatrizB;

public class ControllerMatrizB extends ControllerMatriz {

    public ControllerMatrizB() {    }

    @Override
    public boolean criarMatriz(int m, int n, double[][] matriz) {

        boolean valido;
        if (matriz.length != m){
            valido = false;
            this.setCriada(false);
        }else{
            valido = true;
            this.setMatriz(new ModelMatrizB(m, n));
            this.getMatriz().setMatriz(matriz);
            this.setCriada(true);

        }


        return valido;
    }

}
