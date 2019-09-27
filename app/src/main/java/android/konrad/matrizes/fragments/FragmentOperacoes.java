package android.konrad.matrizes.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.konrad.matrizes.R;
import android.konrad.matrizes.controller.ControllerOperacoes;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FragmentOperacoes extends Fragment {



    private String mParam1;
    private String mParam2;

    ControllerOperacoes controllerOperacoes;


    Context context;
    // Componentes interface

    private Button btnDerterminanteA;
    private Button btnDeterminanteB;
    private Button btnInversoA;
    private Button btnInversoB;
    private Button btnMultiplicarA;    private EditText numMultiplicarA;
    private Button btnMultiplicarB;    private EditText numMultiplicarB;
    private Button btnDividirA;        private EditText numDividirA;
    private Button btnDividirB;        private EditText numDividirB;

    private Button btnSomar;
    private Button btnMultiplicar;
    private Button btnSubtrair;

    private double[][] matrizA;
    private double[][] matrizB;


    private OnFragmentInteractionListener mListener;

    private View view;

    public FragmentOperacoes() {
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentOperacoes newInstance() {
        FragmentOperacoes fragment = new FragmentOperacoes();
        Bundle args = new Bundle();

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getContext();

        Bundle bundle = getArguments();

        controllerOperacoes = new ControllerOperacoes();

        if (bundle != null) {
            String test = bundle.getString("teste");
            Toast.makeText(context, test, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_operacoes, container, false);



        btnDerterminanteA = view.findViewById(R.id.btnDeterminanteA);
        btnDeterminanteB = view.findViewById(R.id.btnDeterminanteB);
        btnDividirA = view.findViewById(R.id.btnDividirA);
        btnDividirB = view.findViewById(R.id.btnDividirB);
        btnMultiplicarA = view.findViewById(R.id.btnMultiplicarA);
        btnMultiplicarB = view.findViewById(R.id.btnMultiplicarB);
        btnInversoA = view.findViewById(R.id.btnInversoA);
        btnInversoB = view.findViewById(R.id.btnInversoB);
        btnSomar = view.findViewById(R.id.btnSomar);
        btnSubtrair = view.findViewById(R.id.btnSubtrair);
        btnMultiplicar = view.findViewById(R.id.btnMultiplicar);


        btnDerterminanteA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(matrizA != null) {
                            double[][] msg = matrizA;
                            Toast
                                    .makeText(context, "" + controllerOperacoes.obterDeterminante(msg), Toast.LENGTH_LONG)
                                    .show();
                        }
            }
        });

        btnDeterminanteB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(matrizB != null) {
                    double[][] msg = matrizB;
                    Toast
                            .makeText(context, "" + controllerOperacoes.obterDeterminante(msg), Toast.LENGTH_LONG)
                            .show();
                }
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnDividirA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnDividirB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnInversoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double[][] inverso = controllerOperacoes.obterMatrizInversa(matrizA);

                String resultado = "";
                for (int i = 0; i < inverso[0].length; i++) {
                    resultado += "| ";
                    for (int j = 0; j < inverso.length; j++) {
                        resultado += " " + inverso[i][j];
                    }
                    resultado += " |";
                    resultado += "\n";
                }

                // TODO: ALTERAR


                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage(resultado)
                        .setTitle("Teste");

                AlertDialog dialog = builder.create();
                builder.show();




            }
        });

        btnInversoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnMultiplicarA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnMultiplicarB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void receberMatrizA(double[][] matriz){
        this.matrizA = matriz;
    }

    public void receberMatrizB(double[][] matriz){
        this.matrizB = matriz;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
