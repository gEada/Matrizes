package android.konrad.matrizes.controller;

import android.konrad.matrizes.model.ModelMatriz;

public abstract class ControllerMatriz {

    private ModelMatriz matriz;
    private boolean criada;

    public ControllerMatriz() {
    }

    public abstract boolean criarMatriz(int m, int n, double[][] matriz);

    public ModelMatriz getMatriz() {
        return matriz;
    }


    // Zera a matriz apenas

    public void zerarMatriz(){
        double[][] matrizZerada = new double[matriz.getM()][matriz.getN()];

        for (int i=0; i < this.matriz.getM(); i++){
            for (int j=0; j < this.matriz.getN(); j++){
                matrizZerada[i][j] = 0;
            }
            this.matriz.setMatriz(matrizZerada);
        }

    }

    public void setMatriz(ModelMatriz matriz) {
        this.matriz = matriz;
    }

    public boolean isCriada() {
        return criada;
    }

    public void setCriada(boolean criada) {
        this.criada = criada;
    }
}

