package android.konrad.matrizes.controller;

import android.konrad.matrizes.support.CalculosMatriz;

public class ControllerOperacoes extends CalculosMatriz {

    public ControllerOperacoes() {

    }

    /**
     * Método para obter o determinante de uma matriz inserida
     * @param matriz O array da matriz (obrigatoriamente quadrada) a qual se deseja obter o determinante
     * @return Caso o processo tenha êxito retornará o numero(double) do determinante da matriz dada,
     * caso falhe retornará null
     */

    public double obterDeterminante(double[][] matriz){
        return calcularDeterminante(matriz);
    }

    /**
     * Método para obter a soma de duas matrizes
     * @param matriz1 O array bidimensional da primeira Matriz da soma
     * @param matriz2 O array bidimensional da segunda Matriz da soma
     * @return Retorna se o processo tenha êxito, a matriz da soma das duas matrizes, caso contrário retorna null
     */

    public double[][] obterSoma(double[][] matriz1, double[][] matriz2){

        return calcularSomaMatrizes(matriz1, matriz2);
    }

    /**
     * Método para obter uma matriz multiplicada por um numero
     * @param matriz O array bidimensional da matriz que se deseja multiplicar
     * @param multiplicador O expoente em double que se deseja multiplicar todos os elementos da matriz
     * @return Se o processo obtiver êxito, retornará a matriz com os elementos multiplicados pelo multiplicador,
     * caso contrário retornará null
     */
    public double[][] obterMultiplicacao(double[][] matriz, double multiplicador){


        return calcularMultiplicacao(matriz, multiplicador);
    }

    /**
     * Método para obter uma matriz dividida por um numero
     * @param matriz O array bidimensional da matriz que se deseja dividir
     * @param fator o faftor em double que se deseja dividir os elementos da matriz
     * @return Se o processo obtiver êxito, retornará a matriz com os elementos dividos pelo fator,
     *      * caso contrário retornará null
     */
    public double[][] obterDivisao(double[][] matriz, double fator){


        return calcularDivisao(matriz, fator);
    }

    /**
     * Obtem a multiplicação de uma matriz pela outra, caso o numero de colunas da Matriz A
     * for o mesmo do numero de linhas da matriz B
     * @param matriz1 A matriz A, a qual vai ser multiplicada pela matriz B
     * @param matriz2 A matriz B, a qual vai multiplicar a matriz A
     * @return Se o processo obtiver êxito, retornará a matriz que é o resultado da matriz
     * A multiplicada pela matriz B, caso falhe retornará null
     */
    public double[][] obterMultiplicacaoMatrizes(double[][] matriz1, double[][] matriz2){

        return calcularMultiplicacaoMatrizes(matriz1, matriz2);
    }

    /**
     * Obtem a matriz inversa da  matriz quadrada inserida
     * @param matriz A matriz obrigatoriamente quadrada que se deseja obter a matriz inversa
     * @return Se o processo obtiver êxito retornará a matriz invertida, caso falhe retornará null
     */
    public double[][] obterMatrizInversa(double[][] matriz){

        return calcularMatrizInversa(matriz);
    }

    /**
     * Método para obter a subtracao de duas matrizes
     * @param matriz1 O array bidimensional da primeira Matriz da subtraçao
     * @param matriz2 O array bidimensional da segunda Matriz da subtração
     * @return Retorna se o processo tenha êxito, a matriz da subtração das duas matrizes, caso contrário retorna null
     */
    public double[][] obterSubtracaoMatrizes(double[][] matriz1, double[][] matriz2){

        return calcularSubtracaoMatrizes(matriz1, matriz2);
    }

}
