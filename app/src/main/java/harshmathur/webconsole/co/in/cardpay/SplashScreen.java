package harshmathur.webconsole.co.in.cardpay;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends Activity {

    private static int SPLASH_TIME_OUT = 2000;
    private PrefManager prefManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Checking for first time launch - before calling setContentView()
                Intent i = new Intent(SplashScreen.this, WelcomeActivity.class);
                startActivity(i);

                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
