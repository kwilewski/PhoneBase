package com.example.krzysiek.phonebase;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button btn1,btn2,btn3,btninfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btn1 = (Button) findViewById(R.id.DBbutton);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPS();

            }
        });

        btn2 = (Button) findViewById(R.id.CPbutton);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openCP();
            }
        });

        btn3 = (Button) findViewById(R.id.ASbutton);
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openAS();
            }
        });

        btninfo = (Button) findViewById(R.id.INFObutton);
        btninfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openInfo();
            }
        });





    }

    public void openPS(){
        Intent intent = new Intent(this, PhoneSelect.class);
        startActivity(intent);
    }

    public void openCP(){
        Intent intent = new Intent(this,MultiplePhoneSelect.class);
        startActivity(intent);
    }

    public void openAS(){
        Intent intent = new Intent(this,Assisstant.class);
        startActivity(intent);

    }

    public void openInfo(){
        Intent intent = new Intent(this,AppInfo.class);
        startActivity(intent);
    }





}
