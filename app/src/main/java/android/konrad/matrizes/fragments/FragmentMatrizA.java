package android.konrad.matrizes.fragments;

import android.content.Context;
import android.konrad.matrizes.R;
import android.konrad.matrizes.controller.ControllerMatrizA;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Toast;


public class FragmentMatrizA extends Fragment {



    private OnFragmentInteractionListener mListener;


    EnviarMatrizA EM;

    private Button btnMais;
    private  Button btnMenos;
    private  Button myButton;


    private GridLayout gridLayout;

    private View view;
    private Context context;

    private int linhas;
    private  int colunas;
    EditText editText[];

    public FragmentMatrizA() {

    }



    public static FragmentMatrizA newInstance(String param1, String param2) {
        FragmentMatrizA fragment = new FragmentMatrizA();
        Bundle args = new Bundle();

        fragment.setArguments(args);


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }



        context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_matriz_a, container, false);

        linhas = 2;
        colunas = 2;



        myButton = new Button(context);
        btnMais = view.findViewById(R.id.btnPlus);
        btnMenos = view.findViewById(R.id.btnMinus);
        gridLayout = view.findViewById(R.id.gl);


        inserirCamposMatriz();


        btnMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
      //  gridLayout.addView(myButton);



        if(linhas <= 10 || colunas <= 10){

            // TODO: MUDAR MÉTODO
            //criarMatriz();

                linhas++;
                colunas++;

                inserirCamposMatriz();

        }else{
            Toast.makeText(context, "Tamanho máximo", Toast.LENGTH_LONG).show();
        }
            }

        });

        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if(linhas > 1 || colunas > 1){
                        linhas--;
                        colunas--;

                        inserirCamposMatriz();
                    }else{
                        Toast.makeText(context, "Tamanho minimo", Toast.LENGTH_LONG).show();
                    }


            }
        });




        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        EM = (EnviarMatrizA) getActivity();
        try {
            EM = (EnviarMatrizA) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Erro ao enviar dados. Tenta novamente");
        }
    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    private void inserirCamposMatriz(){

        gridLayout.removeAllViews();
        gridLayout.setColumnCount(colunas);
        gridLayout.setRowCount(linhas);
        this.editText = new EditText[this.linhas * this.colunas];
        //Button button[] = new Button[this.linhas * this.colunas];


        for (int i = 0; i < editText.length; i++) {


           // button[i] = new Button(context);
           // gridLayout.addView(button[i]);

            editText[i] = new EditText(context);
            editText[i].setHorizontallyScrolling(true);
            editText[i].setEms(4);
            editText[i].setInputType(InputType.TYPE_CLASS_NUMBER);

            gridLayout.addView(editText[i]);
        }
    }

    /**
     *
     * @return Retorna o array da matriz criado caso tenha sucesso, retornará null caso ocorra algum erro
     */
    private double[][] criarMatriz(){


        double [][] resultado;

        try {
            ControllerMatrizA controllerMatrizA;

            double[][] matriz = new double[this.colunas][this.linhas];


            int aux = 0;

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
            try {
                matriz[i][j] = Double.parseDouble(editText[aux].getText().toString());
            }catch(Exception e){
                matriz[i][j] = 0.0d;
            }
                    Log.i("teste", editText[aux].getText().toString());
                    aux++;
                }

            }

            controllerMatrizA = new ControllerMatrizA();
            if (controllerMatrizA.criarMatriz(this.linhas, this.colunas, matriz)) {
                Toast.makeText(context, "Sucesso", Toast.LENGTH_SHORT).show();
                Log.i("fragmentmatriza", "SUCESSO!");
                resultado = controllerMatrizA.obterMatrizArray();
            } else {
                Toast.makeText(context, "Erro", Toast.LENGTH_SHORT).show();
                Log.e("fragmatriza", "ERRO!");
                resultado = null;
            }

            return resultado;
        }catch(Exception e){
            Log.e("fragmentmatriz", "ERRO: " + e.getMessage());
            return null;
        }

    }

    public interface EnviarMatrizA{
        void enviarDadosMA(double[][] matriz);
    }


    @Override
    public void onStop(){
        super.onStop();
        EM.enviarDadosMA(criarMatriz());
    }


}
