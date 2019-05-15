package android.konrad.matrizes.model;

public abstract class ModelMatriz {

   private int m;
   private int n;

   private double matriz[][];

    public ModelMatriz(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public double[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(double[][] matriz) {
        this.matriz = matriz;
    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }
}
