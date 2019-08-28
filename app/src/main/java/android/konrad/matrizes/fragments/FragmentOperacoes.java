package android.konrad.matrizes.fragments;

import android.content.Context;
import android.konrad.matrizes.R;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FragmentOperacoes extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


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





    private OnFragmentInteractionListener mListener;

    private View view;

    public FragmentOperacoes() {
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentOperacoes newInstance(String param1, String param2) {
        FragmentOperacoes fragment = new FragmentOperacoes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getContext();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
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
        btnInversoA = view.findViewById(R.id.btnInversoA);
        btnInversoB = view.findViewById(R.id.btnInversoB);
        btnSomar = view.findViewById(R.id.btnSomar);
        btnSubtrair = view.findViewById(R.id.btnSubtrair);
        btnMultiplicar = view.findViewById(R.id.btnMultiplicar);


        btnDerterminanteA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnDeterminanteB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
}
