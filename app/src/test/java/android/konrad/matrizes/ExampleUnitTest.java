package android.konrad.matrizes;

import android.konrad.matrizes.controller.ControllerMatriz;
import android.konrad.matrizes.controller.ControllerMatrizA;
import android.util.Log;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testeMatrizes() {
        double teste[][] = new double[2][2];

        int num = 2;
        for (int i=0;i<2;i++){

            for (int j=0;j<2;j++){
                num*=num;
                teste[i][j] = num;
            }

        }


        ControllerMatriz controllerMatrizA = new ControllerMatrizA();

        controllerMatrizA.criarMatriz(2,2, teste);

       if(controllerMatrizA.isCriada()) {
            double a1 = controllerMatrizA.getMatriz().getMatriz()[0][0];
            double a2 = controllerMatrizA.getMatriz().getMatriz()[1][0];
       }





    }
}