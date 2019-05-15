package com.example.krzysiek.phonebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class MultiplePhoneSelect extends AppCompatActivity {

    private Spinner spinner1,spinner2,spinner3,spinner4,spinner5,spinner6,spinner7,spinner8;
    private Button btnprcs;
    private String brand1,model1,brand2,model2,brand3,model3,brand4,model4;
    private int selectedID1=0,selectedID2=0,selectedID3=0,selectedID4=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_ps);


        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5 = (Spinner) findViewById(R.id.spinner5);
        spinner6 = (Spinner) findViewById(R.id.spinner6);
        spinner7 = (Spinner) findViewById(R.id.spinner7);
        spinner8 = (Spinner) findViewById(R.id.spinner8);
        loadSpinner1Data();

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                brand1 = parent.getItemAtPosition(position).toString();
                loadSpinner2Data(brand1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                model1 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                brand2 = parent.getItemAtPosition(position).toString();
                loadSpinner4Data(brand2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                model2 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                brand3 = parent.getItemAtPosition(position).toString();
                loadSpinner6Data(brand3);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                model3 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                brand4 = parent.getItemAtPosition(position).toString();
                loadSpinner8Data(brand4);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                model4 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        btnprcs = (Button) findViewById(R.id.procButton);
        btnprcs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                saveID(brand1,model1);
                saveID2(brand2,model2);
                saveID3(brand3,model3);
                saveID4(brand4,model4);
                segrID();
                sendSelectedID(selectedID1,selectedID2,selectedID3,selectedID4);
                showData();
            }
        });





    }

    public void sendSelectedID(int selectedID1, int selectedID2, int selectedID3, int selectedID4){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.setSelectedID(selectedID1);
        databaseAccess.setSelectedID1(selectedID1);
        databaseAccess.setSelectedID2(selectedID2);
        databaseAccess.setSelectedID3(selectedID3);
        databaseAccess.setSelectedID4(selectedID4);
        databaseAccess.close();
    }



    public int saveID(String brand,String model){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        int id = databaseAccess.getID(brand,model);
        databaseAccess.close();
        this.selectedID1=id;
        return id;
    }

    public int saveID2(String brand,String model){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        int id = databaseAccess.getID(brand,model);
        databaseAccess.close();
        this.selectedID2=id;
        return id;
    }

    public int saveID3(String brand,String model){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        int id = databaseAccess.getID(brand,model);
        databaseAccess.close();
        this.selectedID3=id;
        return id;
    }

    public int saveID4(String brand,String model){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        int id = databaseAccess.getID(brand,model);
        databaseAccess.close();
        this.selectedID4=id;
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
        spinner3.setAdapter(dataAdapter);
        spinner5.setAdapter(dataAdapter);
        spinner7.setAdapter(dataAdapter);
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

    private void loadSpinner4Data(String brand){

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> models = databaseAccess.getModels(brand);
        databaseAccess.close();

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, models);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(dataAdapter2);

    }
    private void loadSpinner6Data(String brand){

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> models = databaseAccess.getModels(brand);
        databaseAccess.close();

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, models);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner6.setAdapter(dataAdapter2);

    }
    private void loadSpinner8Data(String brand){

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> models = databaseAccess.getModels(brand);
        databaseAccess.close();

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, models);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner8.setAdapter(dataAdapter2);

    }


    public void segrID(){
        if(selectedID1==0 && selectedID2==0 && selectedID3==0 && selectedID4==0){

        }
        else{
            int pet=0;

            while(pet<4) {
                if (selectedID1 == selectedID2) {
                    selectedID2 = 0;
                }
                if (selectedID1 == selectedID3) {
                    selectedID3 = 0;
                }
                if (selectedID1 == selectedID4) {
                    selectedID4 = 0;
                }
                if (selectedID2 == selectedID3) {
                    selectedID3 = 0;
                }
                if (selectedID2 == selectedID4) {
                    selectedID4 = 0;
                }
                if (selectedID3 == selectedID4) {
                    selectedID4 = 0;
                }


                if (selectedID3 == 0 && selectedID4 != 0) {
                    selectedID3 = selectedID4;
                    selectedID4 = 0;
                }
                if (selectedID2 == 0 && selectedID3 != 0) {
                    selectedID2 = selectedID3;
                    selectedID3 = 0;
                }
                if (selectedID1 == 0 && selectedID2 != 0) {
                    selectedID1 = selectedID2;
                    selectedID2 = 0;
                }
                pet=pet+1;
            }
        }


    }




    public void showData() {

        if(selectedID1==0){
            Toast.makeText(this,"Nie wybrano telefonu",Toast.LENGTH_LONG).show();
        }
        else if(selectedID2==0){
            Intent intent = new Intent(this,ShowPhone.class);
            startActivity(intent);

        }
        else if(selectedID3==0){
            Intent intent = new Intent(this,Show2Phones.class);
            startActivity(intent);

        }
        else if(selectedID4==0){
            Intent intent = new Intent(this,Show3Phones.class);
            startActivity(intent);

        }
        else{
            Intent intent = new Intent(this,Show4Phones.class);
            startActivity(intent);
        }

    }


}
