package android.konrad.matrizes.controller;

import android.konrad.matrizes.model.ModelMatriz;
import android.konrad.matrizes.model.ModelMatrizA;

public class ControllerMatrizA extends ControllerMatriz  {



    public ControllerMatrizA() {

    }

    /**
     * Cria a Matriz A
     * @param m O numero de colunas da matriz
     * @param n O numero de linhas da matriz
     * @param matriz
     * @return Retorna boolean, true caso a matriz fora criada com sucesso, false caso ocorra um erro assim não sendo criada
     */
    @Override
    public boolean criarMatriz(int n, int m, double[][] matriz) {
        boolean valido;
        if (matriz.length != n || matriz[0].length != m){
            valido = false;
            this.setCriada(false);
        }else{
            valido = true;
            this.setCriada(true);
            this.setMatrizObj(new ModelMatrizA(n, m));
            this.getMatrizObj().setMatriz(matriz);
        }

        return valido;
    }




}
