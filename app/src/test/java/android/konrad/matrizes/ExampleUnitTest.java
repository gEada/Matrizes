package android.konrad.matrizes;

import android.konrad.matrizes.controller.ControllerMatriz;
import android.konrad.matrizes.controller.ControllerMatrizA;
import android.konrad.matrizes.controller.ControllerOperacoes;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testeMatrizes() {
        double teste[][] = new double[2][2];

        int num = 0;
        for (int i=0;i<2;i++){

            for (int j=0;j<2;j++){
                num++;
                teste[i][j] = num;
            }

        }


        ControllerMatriz controllerMatrizA = new ControllerMatrizA();


        controllerMatrizA.criarMatriz(2,2, teste);

        double j = teste[0][0];

        ControllerOperacoes controllerOperacoes = new ControllerOperacoes();
       //teste = controllerOperacoes.obterDivisao(teste, 2);

       double determinante = controllerOperacoes.obterDeterminante(teste);




       }





    }
