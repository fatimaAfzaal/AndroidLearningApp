package com.example.lab4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    Button b1,b2,b3,b4;
    Boolean flag=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        b4=(Button) findViewById(R.id.button4);
    }

    public void clickIQ(View view) {
        if(flag==true)
        {
            b1.setText("Simple Questions");
            b2.setText("Tough Questions");
            b3.setVisibility(View.INVISIBLE);
            b4.setText("Move back to main activity");
            flag=false;
        }
        else{
            Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
            startActivity(intent);
        }
    }

    public void clicklm(View view) {
        if(flag==true)
        {
            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://developer.android.com/"));
            startActivity(intent);
        }
         else
        {
            Intent intent=new Intent(MainActivity2.this,MainActivity2.class);
            startActivity(intent);
        }
    }

    public void clickmc(View view) {
        if(flag==true)
        {
            Intent intent=new Intent(MainActivity2.this,Mcqs.class);
            startActivity(intent);
        }
        else{
            Intent intent=new Intent(MainActivity2.this,Tough_questions.class);
            startActivity(intent);
        }

    }

    public void clickTf(View view) {
        Intent intent=new Intent(MainActivity2.this,trueFalse.class);
        startActivity(intent);
    }
}