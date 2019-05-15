package android.konrad.matrizes.controller;

import android.konrad.matrizes.model.ModelMatriz;
import android.konrad.matrizes.model.ModelMatrizA;

import java.util.ArrayList;
import java.util.List;

public abstract class ControllerMatriz {

    private ModelMatriz matriz;
    private boolean validade;

    public ControllerMatriz() {
    }

    public abstract boolean criarMatriz(int m, int n, double[][] matriz);

    public ModelMatriz getMatriz() {
        return matriz;
    }

    public void setMatriz(ModelMatriz matriz) {
        this.matriz = matriz;
    }

    public boolean isValidade() {
        return validade;
    }

    public void setValidade(boolean validade) {
        this.validade = validade;
    }
}

