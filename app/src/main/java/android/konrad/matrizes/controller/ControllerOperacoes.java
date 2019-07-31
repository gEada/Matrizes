package android.konrad.matrizes.controller;

import android.konrad.matrizes.support.CalculosMatriz;

public class ControllerOperacoes extends CalculosMatriz {

    public ControllerOperacoes() {

    }

    // Métodos públicos
    // TODO: e documentar

    public double obterDeterminante(double[][] matriz){
        return calcularDeterminante(matriz);
    }

    // TODO: Implementar método de obter o resultado da soma das matrizes e documentar
    public double[][] obterSoma(double[][] matriz1, double[][] matriz2){

        return calcularSomaMatrizes(matriz1, matriz2);
    }

    // TODO: documentar
    public double[][] obterMultiplicacao(double[][] matriz, double multiplicador){

        // alterar
        return calcularMultiplicacao(matriz, multiplicador);
    }

    // TODO: documentar
    public double[][] obterDivisao(double[][] matriz, double fator){

        // alterar
        return calcularDivisao(matriz, fator);
    }

    // TODO: documentar
    public double[][] obterMultiplicacaoMatrizes(double[][] matriz1, double[][] matriz2){

        return calcularMultiplicacaoMatrizes(matriz1, matriz2);
    }

    // TODO: Documentar
    public double[][] obterMatrizInversa(double[][] matriz){

        return calcularMatrizInversa(matriz);
    }



}
