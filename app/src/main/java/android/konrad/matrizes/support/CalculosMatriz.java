package android.konrad.matrizes.support;

public class CalculosMatriz {

    protected double calcularDeterminante(double[][] matriz) {
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

            resultado += matriz[0][i] * Math.pow(-1, (double) i) * calcularDeterminante(temporario);
        }
        return (resultado);
    }


    protected double[][] calcularMultiplicacao(double[][] matriz, double multiplicador) {
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


    protected double[][] calcularDivisao(double[][] matriz, double fator) {
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


    protected double[][] calcularSomaMatrizes(double[][] matriz1, double[][] matriz2) {
        int m1 = matriz1.length; // n°  linhas da  matriz 1
        int n1 = matriz1[0].length; // n° Colunas da matriz n1

        int m2 = matriz2.length; // n° linhas da matriz 2
        int n2 = matriz2[0].length; // n° colunas da matriz 2

        double resultado[][];
        if (m1 == m2 && n1 == n2) {
            resultado = new double[m1][n1];

            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n1; j++) {
                    resultado[i][j] = matriz1[i][j] + matriz2[i][j];
                }
            }
        } else {
            resultado = null;
        }
        return resultado;
    }

    protected  double[][] calcularSubtracaoMatrizes(double[][] matriz1, double[][] matriz2){
        int m1 = matriz1.length; // n°  linhas da  matriz 1
        int n1 = matriz1[0].length; // n° Colunas da matriz n1

        int m2 = matriz2.length; // n° linhas da matriz 2
        int n2 = matriz2[0].length; // n° colunas da matriz 2

        double resultado[][];
        if (m1 == m2 && n1 == n2) {
            resultado = new double[m1][n1];

            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n1; j++) {
                    resultado[i][j] = matriz1[i][j] - matriz2[i][j];
                }
            }
        } else {
            resultado = null;
        }
        return resultado;
    }


    protected double[][] calcularMultiplicacaoMatrizes(double[][] matriz1, double[][] matriz2) {
        int m1 = matriz1[0].length;
        int n1 = matriz1.length;

        int m2 = matriz2[0].length;
        int n2 = matriz2.length;

        double[][] resultado;

        if (n1 == m2) {
            resultado = new double[m1][n2];

            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n2; j++) {
                    for (int k = 0; k < n1; k++) {
                        resultado[i][j] =
                                resultado[i][j] + matriz1[i][k] * matriz2[k][j];
                    }
                }
            }

            return resultado;
        } else {
            return null;
        }

    }



    // créditos: https://www.sanfoundry.com/java-program-find-inverse-matrix/
    protected double[][] calcularMatrizInversa(double[][] matriz) {
        int n = matriz.length;

        double x[][] = new double[n][n];

        double b[][] = new double[n][n];

        int index[] = new int[n];

        for (int i=0; i<n; ++i)

            b[i][i] = 1;



        // Transforma a matriz num tringulo superior

        gaussian(matriz, index);


        for (int i=0; i<n-1; ++i)

            for (int j=i+1; j<n; ++j)

                for (int k=0; k<n; ++k)

                    b[index[j]][k] -= matriz[index[j]][i]*b[index[i]][k];


        for (int i=0; i<n; ++i)

        {

            x[n-1][i] = b[index[n-1]][i]/matriz[index[n-1]][n-1];

            for (int j=n-2; j>=0; --j)

            {

                x[j][i] = b[index[j]][i];

                for (int k=j+1; k<n; ++k)

                {

                    x[j][i] -= matriz[index[j]][k]*x[k][i];

                }

                x[j][i] /= matriz[index[j]][j];

            }

        }

        return x;
    }


    // Executa na matriz o método de elinição de gaussian
    // créditos: https://www.sanfoundry.com/java-program-find-inverse-matrix/
    private static void gaussian(double a[][], int index[])

    {

        int n = index.length;

        double c[] = new double[n];




        for (int i = 0; i < n; ++i)

            index[i] = i;



        for (int i = 0; i < n; ++i)

        {

            double c1 = 0;

            for (int j = 0; j < n; ++j)

            {

                double c0 = Math.abs(a[i][j]);

                if (c0 > c1) c1 = c0;

            }

            c[i] = c1;

        }




        int k = 0;

        for (int j = 0; j < n - 1; ++j)

        {

            double pi1 = 0;

            for (int i = j; i < n; ++i)

            {

                double pi0 = Math.abs(a[index[i]][j]);

                pi0 /= c[index[i]];

                if (pi0 > pi1)

                {

                    pi1 = pi0;

                    k = i;

                }

            }




            int itmp = index[j];

            index[j] = index[k];

            index[k] = itmp;

            for (int i = j + 1; i < n; ++i)

            {

                double pj = a[index[i]][j] / a[index[j]][j];




                a[index[i]][j] = pj;




                for (int l = j + 1; l < n; ++l)

                    a[index[i]][l] -= pj * a[index[j]][l];

            }

        }


    }
}
