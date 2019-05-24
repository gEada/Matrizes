package android.konrad.matrizes.controller;

import android.konrad.matrizes.model.ModelMatrizB;

public class ControllerMatrizB extends ControllerMatriz {

    public ControllerMatrizB() {    }


    /**
     * Cria a Matriz B
     * @param m O numero de colunas da matriz
     * @param n O numero de linhas da matriz
     * @param matriz
     * @return Retorna boolean, true caso a matriz fora criada com sucesso, false caso ocorra um erro assim não sendo criada
     */
    @Override
    public boolean criarMatriz(int n, int m, double[][] matriz) {

        boolean valido;
        if (matriz.length != n //linhas
                || matriz[0].length != m // colunas
                ){
            valido = false;
            this.setCriada(false);
        }else{
            valido = true;
            this.setMatrizObj(new ModelMatrizB(n, m));
            this.getMatrizObj().setMatriz(matriz);
            this.setCriada(true);

        }


        return valido;
    }



}
