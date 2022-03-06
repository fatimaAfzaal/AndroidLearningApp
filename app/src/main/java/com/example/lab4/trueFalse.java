package com.example.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class trueFalse extends AppCompatActivity implements View.OnClickListener {
    String[] tf_q,tf_ac;
    TextView tfq,tfx,tfy;
    Button bn;
    RadioButton r1,r2;
    RadioGroup rgg;
    int c,i=0;
    int index=0;
    boolean flag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_false);

        tfq=(TextView) findViewById(R.id.textView5);
        tfx=(TextView) findViewById(R.id.textView2);
        tfy=(TextView) findViewById(R.id.textView4);
        bn=(Button) findViewById(R.id.button8);
        r1=(RadioButton) findViewById(R.id.radioButton7);
        r2=(RadioButton) findViewById(R.id.radioButton8);
        rgg=(RadioGroup) findViewById(R.id.r) ;


        tf_q=getResources().getStringArray(R.array.t_questions);
        tf_ac=getResources().getStringArray(R.array.t_answers);

        tfq.setText(tf_q[index]);
        tfx.setText(String.valueOf(index+1));
        tfy.setText("/"+String.valueOf(tf_q.length));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button8:

                if(index<9) {
                    if(r1.isChecked()||r2.isChecked()) {
                        if ((r1.isChecked() && (tf_ac[index].equals(r1.getText()))) || (r2.isChecked() && (tf_ac[index].equals(r2.getText())))) {
                            c++;
                        } else {
                            i++;
                        }
                    }

                    if(r1.isChecked()||r2.isChecked()) {
                        rgg.clearCheck();
                        index++;
                        tfq.setText(tf_q[index]);
                        tfx.setText(String.valueOf(index + 1));
                    }
                    else {
                        Toast.makeText(this,"Select option",Toast.LENGTH_SHORT).show();
                    }
                }
                else if(index==9&&flag==true) {
                    if(r1.isChecked()||r2.isChecked()) {
                        if ((r1.isChecked() && (tf_ac[index].equals(r1.getText()))) || (r2.isChecked() && (tf_ac[index].equals(r2.getText())))) {
                            c++;
                        } else {
                            i++;
                        }
                    }
                    flag=false;
                    Toast.makeText(this,"Quiz end",Toast.LENGTH_SHORT).show();
                    bn.setText("Show Result");
                }
                else if(index==9 && flag==false) {
                    rgg.setVisibility(view.INVISIBLE);
                    tfq.setText("Correct : "+c+"\nIncorrect: "+i);
                    tfx.setText("Result: ");
                    tfy.setText(" ");
                    tfq.setTextSize(40);
                    bn.setText("RETRY!!");
                    index++;
                }
                else if(index>9&&flag==false) {
                    Intent intent=new Intent(trueFalse.this,trueFalse.class);
                    startActivity(intent);
                }

                break;
        }
    }
}
