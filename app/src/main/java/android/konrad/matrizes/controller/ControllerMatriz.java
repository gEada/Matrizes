package android.konrad.matrizes.controller;

import android.konrad.matrizes.model.ModelMatriz;

public abstract class ControllerMatriz {

    private ModelMatriz matrizObj;
    private boolean criada;

    public ControllerMatriz() {
    }

    public abstract boolean criarMatriz(int n, int m, double[][] matriz);

    /**
     * Obtem a matriz como array
     * @return Retorna a Matriz, tanto A ou B em array bimidimensional
     */
    public double[][] obterMatrizArray(){
        return this.getMatrizObj().getMatriz();
    }

    /**
     * Obtem o objeto matriz da ModelMatriz, utilizar somente na Controller
     * @return Retorna o objeto Matriz, tanto A ou B
     */
    public ModelMatriz getMatrizObj() {
        return matrizObj;
    }

    /**
     * Zera a matriz caso exista
     * @return Retorna um boolean, true se foi possivel zerar a matriz e false caso algum erro tenha ocorrido
     */

    public boolean zerarMatriz(){

        boolean sucesso = true;

        double[][] matrizZerada = new double[matrizObj.getM()][matrizObj.getN()];

        if(this.isCriada()) {
            for (int i = 0; i < this.matrizObj.getM(); i++) {
                for (int j = 0; j < this.matrizObj.getN(); j++) {
                    matrizZerada[i][j] = 0;
                }
                this.matrizObj.setMatriz(matrizZerada);
            }

            sucesso = true;
        }else{
            sucesso = false;
        }

        return sucesso;

    }

    public void setMatrizObj(ModelMatriz matriz) {
        this.matrizObj = matriz;
    }

    public boolean isCriada() {
        return criada;
    }

    public void setCriada(boolean criada) {
        this.criada = criada;
    }
}

