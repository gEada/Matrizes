package android.konrad.matrizes.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.konrad.matrizes.R;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        apresentarTelaSplash();
    }

    private void apresentarTelaSplash(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainActivity = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mainActivity);
                finish();
            }
        },SPLASH_TIME_OUT);
    }


}
