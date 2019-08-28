package android.konrad.matrizes.fragments;

import android.content.Context;
import android.konrad.matrizes.R;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.text.method.TransformationMethod;
import android.view.InputDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class FragmentMatrizA extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    private Button btnMais;
    private  Button btnMenos;
    private  Button myButton;
    private GridLayout gridLayout;

    private View view;
    private Context context;

    private int linhas;
    private  int colunas;

    public FragmentMatrizA() {
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentMatrizA newInstance(String param1, String param2) {
        FragmentMatrizA fragment = new FragmentMatrizA();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
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

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }






    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void inserirCamposMatriz(){

        gridLayout.removeAllViews();
        gridLayout.setColumnCount(colunas);
        gridLayout.setRowCount(linhas);
        EditText editText[] = new EditText[linhas * colunas];
        Button button[] = new Button[linhas * colunas];


        for (int i = 0; i < button.length; i++) {


           // button[i] = new Button(context);
           // gridLayout.addView(button[i]);

            editText[i] = new EditText(context);
            editText[i].setHorizontallyScrolling(true);
            editText[i].setEms(4);
            editText[i].setInputType(InputType.TYPE_CLASS_NUMBER);

            gridLayout.addView(editText[i]);
        }
    }
}
