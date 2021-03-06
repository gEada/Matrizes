package android.konrad.matrizes.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.konrad.matrizes.R;
import android.konrad.matrizes.controller.ControllerMatriz;
import android.konrad.matrizes.controller.ControllerMatrizA;
import android.konrad.matrizes.fragments.FragmentMatrizA;
import android.konrad.matrizes.fragments.FragmentMatrizB;
import android.konrad.matrizes.fragments.FragmentMatrizResultado;
import android.konrad.matrizes.fragments.FragmentModelo;
import android.konrad.matrizes.fragments.FragmentOperacoes;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentMatrizA.EnviarMatrizA, FragmentMatrizB.EnviarMatrizB  {

    FragmentManager fragmentManager;
    public static final String BUNDLEMATRIZ1 = "matriz1bundle";
    public static final String BUNDLEMATRIZ2 = "matriz2bundle";

    private double[][] matrizA;
    private double[][] matrizB;

    FragmentOperacoes fragmentOperacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();

        fragmentOperacoes = new FragmentOperacoes();



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            mostrarOpcoes();
            return true;
        }

        if (id == R.id.action_exit){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            setTitle(R.string.matriz_A);

            FragmentMatrizA fragmentMatrizA = new FragmentMatrizA();


          fragmentManager.beginTransaction().
                  replace(R.id.fragmentmodelo, fragmentMatrizA)
                  .commit();





        } else if (id == R.id.nav_gallery) {

            setTitle(R.string.matriz_B);
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentmodelo, new FragmentMatrizB())
                    .commit();

        } else if (id == R.id.nav_slideshow) {

            // Passar valores

           // Bundle bundle = new Bundle();
           // bundle.putString("teste", "TESTANDO");

           // fragmentOperacoes.setArguments(bundle);


            setTitle("Operações");

            fragmentManager.beginTransaction()
                   .replace(R.id.fragmentmodelo, fragmentOperacoes)
            .commit();

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // TODO: Criar o menu de opções
    private void mostrarOpcoes(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setMessage("Em desenvolvimento...")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO: Implementar as opções aqui
                    }
                });
        builder.show();
    }


    @Override
    public void enviarDadosMA(double[][] matriz) {

        // TODO: ALTERAR
        Log.i("acitivty", "SUCESSO???");
      //  fragmentOperacoes = new FragmentOperacoes();
        fragmentOperacoes.receberMatrizA(matriz);


     //   fragmentManager.beginTransaction().replace(R.id.fragmentmodelo, fragmentOperacoes).commit();

    }

    @Override
    public void enviarDadosMB(double[][] matriz) {
        Log.i("acitivty", "SUCESSO???");
        // TODO: ALTERAR

       // FragmentOperacoes fragmentOperacoes = new FragmentOperacoes();
        fragmentOperacoes.receberMatrizB(matriz);

       // fragmentManager.beginTransaction().replace(R.id.fragmentmodelo, fragmentOperacoes).commit();

    }
}
