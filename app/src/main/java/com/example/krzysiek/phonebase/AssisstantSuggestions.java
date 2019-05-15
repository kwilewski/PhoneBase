package com.example.krzysiek.phonebase;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AssisstantSuggestions extends AppCompatActivity {

    private ListView assSuggLV;
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<Integer> adapter3;
    private int a;


    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ass_sugg);

        assSuggLV = (ListView) findViewById(R.id.assSuggLV);



        loadIDS();


        final List<Integer> ids = loadIDS();
        final List<String> brands = new ArrayList<>();

        a = ids.size();
        for(int n=0;n<a;n++){
            int id = (int)ids.get(n);
            brands.add(loadBrand(id));
        }

        if(a==0){
            brands.add("Nie znaleziono telefonu o zadanych wymaganiach.");
        }

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,brands);
        assSuggLV.setAdapter(adapter);



        if(a!=0) {
            assSuggLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    sendSelectedID(ids.get(position));
                    openSP();


                }
            });
        }

    }

    

    public List<Integer> loadIDS(){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<Integer> ids = databaseAccess.getAssID();
        databaseAccess.close();
        return ids;
    }

    public void sendSelectedID(int selectedID){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.setSelectedID(selectedID);
        databaseAccess.close();
    }

    public void openSP(){
        Intent intent = new Intent(this,ShowPhone.class);
        startActivity(intent);
    }

    private String loadBrand(int id){

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        String branddwn = databaseAccess.getBrand(id);
        String modeldwn = databaseAccess.getModel(id);
        int prc = databaseAccess.getPrice(id);
        databaseAccess.close();
        String prcs = Integer.toString(prc);
        String mb1 = branddwn + " " + modeldwn + "      " + prcs + "zł";
        return mb1;


    }


}
