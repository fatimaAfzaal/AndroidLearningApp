package com.example.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Tough_questions extends AppCompatActivity implements View.OnClickListener {
    String[] tough_question,tough_answer;
    TextView tq,ta,tx,ty;
    ImageView bl,br,ba;
    int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tough_questions);
        tq=(TextView) findViewById(R.id.textView5);
        ta=(TextView) findViewById(R.id.textView6);
        tx=(TextView) findViewById(R.id.textView2);
        ty=(TextView) findViewById(R.id.textView4);
        bl=(ImageView) findViewById(R.id.imageView2);
        br=(ImageView) findViewById(R.id.imageView5);
        ba=(ImageView) findViewById(R.id.imageView4);

        tough_question=getResources().getStringArray(R.array.to_question);
        tough_answer=getResources().getStringArray(R.array.to_answers);

        tq.setText(tough_question[index]);
        ta.setText("Press \"A\" Button for answer");
        tx.setText(String.valueOf(index+1));
        ty.setText("/"+String.valueOf(tough_question.length));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageView2:
                if(index>0) {
                    ta.setText("Press \"A\" Button for answer");
                    index--;
                    tq.setText(tough_question[index]);
                    tx.setText(String.valueOf(index + 1));
                }
                else
                {
                    Toast.makeText(this,"No previous questions",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.imageView5:
                if(index<9) {
                    ta.setText("Press \"A\" Button for answer");
                    index++;
                    tq.setText(tough_question[index]);
                    tx.setText(String.valueOf(index + 1));
                }
                else
                {
                    Toast.makeText(this,"Questions end",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.imageView4:

                ta.setText(tough_answer[index]);
                break;

        }

    }
}