package android.konrad.matrizes.support;

public class CalculosMatriz {

    protected double calcularDeterminante(double[][] matriz){
        double temporario[][];
        double resultado = 0;

        if (matriz.length == 1) {
            resultado = matriz[0][0];
            return (resultado);
        }

        if (matriz.length == 2) {
            resultado = ((matriz[0][0] * matriz[1][1]) - (matriz[0][1] * matriz[1][0]));
            return (resultado);
        }

        for (int i = 0; i < matriz[0].length; i++) {
            temporario = new double[matriz.length - 1][matriz[0].length - 1];

            for (int j = 1; j < matriz.length; j++) {
                for (int k = 0; k < matriz[0].length; k++) {
                    if (k < i) {
                        temporario[j - 1][k] = matriz[j][k];
                    } else if (k > i) {
                        temporario[j - 1][k - 1] = matriz[j][k];
                    }
                }
            }

            resultado += matriz[0][i] * Math.pow (-1, (double) i) * calcularDeterminante(temporario);
        }
        return (resultado);
    }


    protected double[][] calcularMultiplicacao(double[][] matriz, double multiplicador){
        int n = matriz[0].length; // Colunas
        int m = matriz.length; // Linhas


            double[][] resultado;
            resultado = new double[n][m];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    resultado[i][j] = matriz[i][j] * multiplicador;
                }
            }
            return resultado;


    }


    protected double[][] calcularDivisao(double[][] matriz, double fator){
        int n = matriz[0].length; // Colunas
        int m = matriz.length; // Linhas


            double[][] resultado;
            resultado = new double[m][m];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    resultado[i][j] = matriz[i][j] / fator;
                }
            }
            return resultado;
       

    }


    protected double[][] calcularSomaMatrizes(double[][] matriz1, double[][] matriz2){
        int m1 = matriz1.length; // n°  linhas da  matriz 1
        int n1 = matriz1[0].length; // n° Colunas da matriz n1

        int m2 = matriz2.length; // n° linhas da matriz 2
        int n2 = matriz2[0].length; // n° colunas da matriz 2

        double resultado[][];
        if(m1 == m2 && n1 == n2){
            resultado = new double[m1][n1];

            for (int i = 0; i < m1 ; i++) {
                for (int j = 0; j < n1 ; j++) {
                    resultado[i][j] = matriz1[i][j] + matriz2[i][j];
                }
            }
        }else{
            resultado = null;
        }
        return resultado;
    }


    protected double[][] calcularMultiplicacaoMatrizes(double[][] matriz1, double[][] matriz2){
        int m1 = matriz1[0].length;
        int n1 = matriz1.length;

        int m2 = matriz2[0].length;
        int n2 = matriz2.length;

        double[][] resultado;

        if (n1 == m2){
            resultado = new double[m1][n2];

            for (int i = 0; i < m1 ; i++) {
                for (int j = 0; j < n2; j++) {
                    for (int k = 0; k < n1; k++) {
                        resultado[i][j] =
                                resultado[i][j] + matriz1[i][k] * matriz2[k][j];
                    }
                }
            }

            return resultado;
        }else{
            return null;
        }

    }


    // TODO: Implementar método de calcular a matriz inversa
    private double[][] calcularMatrizInversa(Double[][] matriz){
        return null;
    }


}
