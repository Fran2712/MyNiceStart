package com.fj.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity
                        .this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1900);

        ImageView imagen = findViewById(R.id.logop);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        imagen.startAnimation(myanim);

        ImageView imagen2 = findViewById(R.id.imageView3);
        imagen2.setVisibility(View.VISIBLE);
        Animation myanim2 =  AnimationUtils.loadAnimation(this, R.anim.mover);
        imagen2.startAnimation(myanim2);

    }
}
