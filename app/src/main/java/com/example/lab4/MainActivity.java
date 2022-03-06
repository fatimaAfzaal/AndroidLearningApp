package com.example.lab4;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView i;
    ImageView i2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i=(ImageView) findViewById(R.id.imageView6);
        i2=(ImageView) findViewById(R.id.imageView);

        Animation ani= AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
        i.startAnimation(ani);

        Animation anim= AnimationUtils.loadAnimation(MainActivity.this,R.anim.fade);
        i2.startAnimation(anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        },3000);


    }
}