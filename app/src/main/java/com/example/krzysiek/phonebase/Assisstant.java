package com.example.krzysiek.phonebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class Assisstant extends AppCompatActivity {

    private SeekBar perfSB,camSB;
    private int sbmax=4;
    private int perfprog=1,camprog=1;
    private EditText dispMin,dispMax,priceMin,priceMax,memMin;
    private double dispmin=0,dispmax=999,pricemin=0,pricemax=99999,memmin,memmax=999;
    private Button assProgButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assisstant);

        perfSB = (SeekBar) findViewById(R.id.perfSB);
        camSB = (SeekBar) findViewById(R.id.camSB);
        dispMin = (EditText) findViewById(R.id.dispMin);
        dispMax = (EditText) findViewById(R.id.dispMax);
        priceMin = (EditText) findViewById(R.id.priceMin);
        priceMax = (EditText) findViewById(R.id.priceMax);
        memMin = (EditText) findViewById(R.id.memMin);
        assProgButton = (Button) findViewById(R.id.assProgButton);

        perfSB.setMax(sbmax);
        perfSB.setProgress(0);
        perfSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                perfprog = progress+1;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        camSB.setMax(sbmax);
        camSB.setProgress(0);
        camSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                camprog = progress+1;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        assProgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String v1 = dispMin.getText().toString();
                if (v1.matches("")) {
                    dispmin=0;
                }
                else{
                    dispmin = Double.parseDouble(dispMin.getText().toString());
                }

                String v2 = dispMax.getText().toString();
                if (v2.matches("")) {
                    dispmax=99;
                }
                else{
                    dispmax = Double.parseDouble(dispMax.getText().toString());
                }

                String v3 = priceMin.getText().toString();
                if (v3.matches("")) {
                    pricemin=0;
                }
                else{
                    pricemin = Double.parseDouble(priceMin.getText().toString());
                }

                String v4 = priceMax.getText().toString();
                if (v4.matches("")) {
                    pricemax=9999;
                }
                else{
                    pricemax = Double.parseDouble(priceMax.getText().toString());
                }

                String v5 = memMin.getText().toString();
                if (v5.matches("")) {
                    memmin=0;
                }
                else{
                    memmin = Double.parseDouble(memMin.getText().toString());
                }

                if(dispmax<dispmin){
                    double a = dispmax;
                    double b = dispmin;
                    dispmin = a;
                    dispmax = b;
                }

                if(pricemax<pricemin){
                    double a = pricemax;
                    double b = pricemin;
                    pricemax = b;
                    pricemin = a;
                }


                sendReq(perfprog,camprog,dispmin,dispmax,pricemin,pricemax,memmin,memmax);
                goNext();
            }
        });


    }



    public void sendReq(int a,int b,double c,double d,double e,double f,double g,double h){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.setAssist(a,b,c,d,e,f,g,h);
        databaseAccess.close();
    }


    public void goNext(){
        Intent intent = new Intent(this,AssisstantSuggestions.class);
        startActivity(intent);
    }


}
