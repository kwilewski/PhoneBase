package com.example.krzysiek.phonebase;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class PhoneSelect extends AppCompatActivity {

    private Spinner spinner1,spinner2;
    private Button btnprcs;
    private ArrayAdapter<CharSequence> adapter1,adapter2;
    private String brand,model;
    private int selectedID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_select);


        spinner1 = (Spinner) findViewById(R.id.brandSpinner);
        spinner2 = (Spinner) findViewById(R.id.modelSpinner);
        loadSpinner1Data();

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                brand = parent.getItemAtPosition(position).toString();
                loadSpinner2Data(brand);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                model = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnprcs = (Button) findViewById(R.id.processButton);
        btnprcs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                saveID(brand,model);
                showData();
                sendSelectedID(selectedID);

            }
        });





    }

    public void sendSelectedID(int selectedID){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.setSelectedID(selectedID);
        databaseAccess.close();
    }



    public int saveID(String brand,String model){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        int id = databaseAccess.getID(brand,model);
        databaseAccess.close();
        this.selectedID=id;
        return id;


    }




   private void loadSpinner1Data() {

       DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
       databaseAccess.open();
       List<String> brands = databaseAccess.getBrands();
       databaseAccess.close();

       HashSet<String> hashSet = new HashSet<String>();
       hashSet.addAll(brands);
       brands.clear();
       brands.addAll(hashSet);
       Collections.sort(brands);
       brands.add(0,"Nie wybrano");


       ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, brands);
       dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       spinner1.setAdapter(dataAdapter);
    }

    private void loadSpinner2Data(String brand){

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> models = databaseAccess.getModels(brand);
        databaseAccess.close();

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, models);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);

    }




   public void showData() {
        if(selectedID==0){
            Toast.makeText(this,"Nie wybrano telefonu",Toast.LENGTH_LONG).show();
        }
        else{
            Intent intent = new Intent(this,ShowPhone.class);
            startActivity(intent);

        }

   }




}
