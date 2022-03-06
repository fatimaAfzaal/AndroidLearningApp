package com.example.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Mcqs extends AppCompatActivity implements View.OnClickListener{
    String[] mcq_q,mcq_a1,mcq_a2,mcq_a3,mcq_a4,mcq_ac;
    TextView tmq,tmx,tmy;
    Button bn;
    RadioButton r1,r2,r3,r4;
    RadioGroup rg;
    int correct,icorrect=0;
    int index=0;
    boolean flag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcqs);

        tmq=(TextView) findViewById(R.id.textView5);
        tmx=(TextView) findViewById(R.id.textView2);
        tmy=(TextView) findViewById(R.id.textView4);
        bn=(Button) findViewById(R.id.button8);
        r1=(RadioButton) findViewById(R.id.radioButton6);
        r2=(RadioButton) findViewById(R.id.radioButton7);
        r3=(RadioButton) findViewById(R.id.radioButton8);
        r4=(RadioButton) findViewById(R.id.radioButton9);
        rg=(RadioGroup) findViewById(R.id.r) ;


        mcq_q=getResources().getStringArray(R.array.mcq_question);
        mcq_a1=getResources().getStringArray(R.array.mcq_Answer1);
        mcq_a2=getResources().getStringArray(R.array.mcq_Answer2);
        mcq_a3=getResources().getStringArray(R.array.mcq_Answer3);
        mcq_a4=getResources().getStringArray(R.array.mcq_Answer4);
        mcq_ac=getResources().getStringArray(R.array.mcq_Answerc);

        tmq.setText(mcq_q[index]);
        tmx.setText(String.valueOf(index+1));
        tmy.setText("/"+String.valueOf(mcq_q.length));
        r1.setText(String.valueOf(mcq_a1[index]));
        r2.setText(String.valueOf(mcq_a2[index]));
        r3.setText(String.valueOf(mcq_a3[index]));
        r4.setText(String.valueOf(mcq_a4[index]));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button8:

                if(index<9) {
                    if(r1.isChecked()||r2.isChecked()||r3.isChecked()||r4.isChecked()==true) {
                        if ((r1.isChecked() && (mcq_ac[index].equals(r1.getText()))) || (r2.isChecked() && (mcq_ac[index].equals(r2.getText()))) || (r3.isChecked() && (mcq_ac[index].equals(r3.getText()))) || (r4.isChecked() && (mcq_ac[index].equals(r4.getText())))) {
                            correct++;
                        } else {
                            icorrect++;
                        }
                    }

                    if(r1.isChecked()||r2.isChecked()||r3.isChecked()||r4.isChecked()==true) {
                        rg.clearCheck();
                        index++;
                        tmq.setText(mcq_q[index]);
                        tmx.setText(String.valueOf(index + 1));
                        r1.setText(String.valueOf(mcq_a1[index]));
                        r2.setText(String.valueOf(mcq_a2[index]));
                        r3.setText(String.valueOf(mcq_a3[index]));
                        r4.setText(String.valueOf(mcq_a4[index]));
                    }
                    else {
                        Toast.makeText(this,"Select option",Toast.LENGTH_SHORT).show();
                    }
                }
                else if(index==9&&flag==true) {
                    if(r1.isChecked()||r2.isChecked()||r3.isChecked()||r4.isChecked()==true) {
                        if ((r1.isChecked() && (mcq_ac[index].equals(r1.getText()))) || (r2.isChecked() && (mcq_ac[index].equals(r2.getText()))) || (r3.isChecked() && (mcq_ac[index].equals(r3.getText()))) || (r4.isChecked() && (mcq_ac[index].equals(r4.getText())))) {
                            correct++;
                        } else {
                            icorrect++;
                        }
                    }
                    flag=false;
                    Toast.makeText(this,"Quiz end",Toast.LENGTH_SHORT).show();
                    bn.setText("Show Result");
                }
                else if(index==9 && flag==false) {
                    rg.setVisibility(view.INVISIBLE);
                    tmq.setText("Correct : "+correct+"\nIncorrect: "+icorrect);
                    tmx.setText("Result: ");
                    tmy.setText(" ");
                    tmq.setTextSize(40);
                    bn.setText("RETRY!!");
                    index++;
                }
                else if(index>9&&flag==false) {
                    Intent intent=new Intent(Mcqs.this,Mcqs.class);
                    startActivity(intent);
                }
                break;
            } } }