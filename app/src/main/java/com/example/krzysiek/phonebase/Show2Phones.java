package com.example.krzysiek.phonebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Show2Phones extends AppCompatActivity {

    private ImageView cam21,cam22,cam221,cam222,jack21,jack22,lte21,lte22,led21,led22;
    private TextView brand21,brand22,os21,os22,type21,type22,dispres21,dispres22,dispsize21,dispsize22,camRes21,camRes22,cam2res21,cam2res22,price21,price22,proc21,proc22,
            ram21,ram22,mem21,mem22;
    private int selectedID1,selectedID2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show2phones);

        cam21 = (ImageView) findViewById(R.id.cam21);
        cam221 = (ImageView) findViewById(R.id.cam221);
        lte21 = (ImageView) findViewById(R.id.lte21);
        led21 = (ImageView) findViewById(R.id.led21);
        jack21 = (ImageView) findViewById(R.id.jack21);

        brand21 = (TextView) findViewById(R.id.brand21);
        type21 = (TextView) findViewById(R.id.type21);
        os21 = (TextView) findViewById(R.id.os21);
        dispsize21 = (TextView) findViewById(R.id.dispsize21);
        dispres21 = (TextView) findViewById(R.id.dispres21);
        camRes21 = (TextView) findViewById(R.id.camRes21);
        cam2res21 = (TextView) findViewById(R.id.cam2res21);
        price21 = (TextView) findViewById(R.id.price21);
        proc21 = (TextView) findViewById(R.id.proc21);
        ram21 = (TextView) findViewById(R.id.ram21);
        mem21 = (TextView) findViewById(R.id.mem21);

        cam22 = (ImageView) findViewById(R.id.cam22);
        cam222 = (ImageView) findViewById(R.id.cam222);
        lte22 = (ImageView) findViewById(R.id.lte22);
        led22 = (ImageView) findViewById(R.id.led22);
        jack22 = (ImageView) findViewById(R.id.jack22);

        brand22 = (TextView) findViewById(R.id.brand22);
        type22 = (TextView) findViewById(R.id.type22);
        os22 = (TextView) findViewById(R.id.os22);
        dispsize22 = (TextView) findViewById(R.id.dispsize22);
        dispres22 = (TextView) findViewById(R.id.dispres22);
        camRes22 = (TextView) findViewById(R.id.camRes22);
        cam2res22 = (TextView) findViewById(R.id.cam2res22);
        price22 = (TextView) findViewById(R.id.price22);
        proc22 = (TextView) findViewById(R.id.proc22);
        ram22 = (TextView) findViewById(R.id.ram22);
        mem22 = (TextView) findViewById(R.id.mem22);

        setID();
        loadBrand(selectedID1,selectedID2);
        loadType(selectedID1,selectedID2);
        loadOS(selectedID1,selectedID2);
        loadDispSize(selectedID1,selectedID2);
        loadDispRes(selectedID1,selectedID2);
        loadCamCheck(selectedID1,selectedID2);
        loadCam2Check(selectedID1,selectedID2);
        loadCamRes(selectedID1,selectedID2);
        loadCam2Res(selectedID1,selectedID2);
        loadJack(selectedID1,selectedID2);
        loadPrice(selectedID1,selectedID2);
        loadProc(selectedID1,selectedID2);
        loadLED(selectedID1,selectedID2);
        loadLTE(selectedID1,selectedID2);
        loadRAM(selectedID1,selectedID2);
        loadMemory(selectedID1,selectedID2);
    }






    private void setID(){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        this.selectedID1=databaseAccess.getSelectedID1();
        this.selectedID2=databaseAccess.getSelectedID2();
    }

    private void loadBrand(int id1,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        String bnd1 = databaseAccess.getBrand(id1);
        String bnd2 = databaseAccess.getBrand(id2);
        String mdl1 = databaseAccess.getModel(id1);
        String mdl2 = databaseAccess.getModel(id2);
        databaseAccess.close();
        String mb1 = bnd1 + " " + mdl1;
        String mb2 = bnd2 + " " + mdl2;
        brand21.setText(mb1);
        brand22.setText(mb2);

    }

    private void loadType(int id1,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        String ReturnVal = databaseAccess.getType(id1);
        String ReturnVal2 = databaseAccess.getType(id2);
        databaseAccess.close();
        type21.setText(ReturnVal);
        type22.setText(ReturnVal2);
    }

    private void loadOS(int id1,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        String part1 = databaseAccess.getOS(id1);
        String part2 = databaseAccess.getOSVers(id1);
        String showos = " ";
        if(part2!=" "){
            showos = part1 + " " + part2;

        }
        else{
            showos = part1;
        }
        os21.setText(showos);
        String part3 = databaseAccess.getOS(id2);
        String part4 = databaseAccess.getOSVers(id2);
        String showos2 = " ";
        if(part4!=" "){
            showos2 = part3 + " " + part4;

        }
        else{
            showos2 = part3;
        }
        databaseAccess.close();
        os22.setText(showos2);
    }

    private void loadDispSize(int id,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        double size = databaseAccess.getDispSize(id);
        String dsize = Double.toString(size)+"\"";
        double size2 = databaseAccess.getDispSize(id2);
        String dsize2 = Double.toString(size2)+"\"";
        databaseAccess.close();
        dispsize21.setText(dsize);
        dispsize22.setText(dsize2);
    }

    private void loadDispRes(int id,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        String showed = databaseAccess.getDispRes(id);
        String showed2 = databaseAccess.getDispRes(id2);
        databaseAccess.close();
        dispres21.setText(showed);
        dispres22.setText(showed2);
    }

    private void loadCamCheck(int id,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        int showed = databaseAccess.getCam(id);
        if(showed==1){
            cam21.setImageResource(R.drawable.checkok);
        }
        else{
            cam21.setImageResource(R.drawable.checknope);
        }
        int showed2 = databaseAccess.getCam(id2);
        if(showed2==1){
            cam22.setImageResource(R.drawable.checkok);
        }
        else{
            cam22.setImageResource(R.drawable.checknope);
        }
        databaseAccess.close();
    }

    private void loadCamRes(int id,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        String showed = "-";
        String showed2 = "-";
        databaseAccess.open();
        double dwnld = databaseAccess.getCamRes(id);
        if(dwnld!=0){
            showed = Double.toString(dwnld)+"MPix";
        }
        double dwnld2 = databaseAccess.getCamRes(id2);
        if(dwnld2!=0){
            showed2 = Double.toString(dwnld2)+"MPix";
        }
        databaseAccess.close();
        camRes21.setText(showed);
        camRes22.setText(showed2);
    }

    private void loadCam2Check(int id,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        int showed = databaseAccess.getCam2(id);
        if(showed==1){
            cam221.setImageResource(R.drawable.checkok);
        }
        else{
            cam221.setImageResource(R.drawable.checknope);
        }
        int showed2 = databaseAccess.getCam2(id2);
        if(showed2==1){
            cam222.setImageResource(R.drawable.checkok);
        }
        else{
            cam222.setImageResource(R.drawable.checknope);
        }
        databaseAccess.close();
    }

    private void loadCam2Res(int id,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        String showed = "-";
        String showed2 = "-";
        databaseAccess.open();
        double dwnld = databaseAccess.getCam2Res(id);
        if(dwnld!=0){
            showed = Double.toString(dwnld)+"MPix";
        }
        double dwnld2 = databaseAccess.getCam2Res(id2);
        if(dwnld2!=0){
            showed2 = Double.toString(dwnld2)+"MPix";
        }
        databaseAccess.close();
        cam2res21.setText(showed);
        cam2res22.setText(showed2);
    }

    private void loadJack(int id,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        int showed = databaseAccess.getJack(id);
        if(showed==1){
            jack21.setImageResource(R.drawable.checkok);
        }
        else{
            jack21.setImageResource(R.drawable.checknope);
        }
        int showed2 = databaseAccess.getJack(id2);
        if(showed2==1){
            jack22.setImageResource(R.drawable.checkok);
        }
        else{
            jack22.setImageResource(R.drawable.checknope);
        }
        databaseAccess.close();
    }

    private void loadLTE(int id,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        int showed = databaseAccess.getLTE(id);
        if(showed==1){
            lte21.setImageResource(R.drawable.checkok);
        }
        else{
            lte21.setImageResource(R.drawable.checknope);
        }
        int showed2 = databaseAccess.getLTE(id2);
        if(showed2==1){
            lte22.setImageResource(R.drawable.checkok);
        }
        else{
            lte22.setImageResource(R.drawable.checknope);
        }
        databaseAccess.close();
    }

    private void loadLED(int id,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        int showed = databaseAccess.getLED(id);
        if(showed==1){
            led21.setImageResource(R.drawable.checkok);
        }
        else{
            led21.setImageResource(R.drawable.checknope);
        }
        int showed2 = databaseAccess.getLED(id2);
        if(showed2==1){
            led22.setImageResource(R.drawable.checkok);
        }
        else{
            led22.setImageResource(R.drawable.checknope);
        }
        databaseAccess.close();
    }

    private void loadPrice(int id,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        double dwnld = databaseAccess.getPrice(id);
        String showed = Double.toString(dwnld)+"0zł";
        double dwnld2 = databaseAccess.getPrice(id2);
        String showed2 = Double.toString(dwnld2)+"0zł";
        databaseAccess.close();
        price21.setText(showed);
        price22.setText(showed2);
    }

    private void loadProc(int id,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        String part1 = databaseAccess.getCPU(id);
        int p2 = databaseAccess.getCPUcores(id);
        double p3 = databaseAccess.getCPUfreq(id);
        String part2 = Integer.toString(p2);
        String part3 = Double.toString(p3);
        String showos = " ";
        if(p3!=0){
            showos = part1 + "\n" + part2 + "x" + part3 + "GHz";
        }
        else{
            showos = part1;
        }
        String part12 = databaseAccess.getCPU(id2);
        int p22 = databaseAccess.getCPUcores(id2);
        double p32 = databaseAccess.getCPUfreq(id2);
        String part22 = Integer.toString(p22);
        String part32 = Double.toString(p32);
        String showos2 = " ";
        if(p32!=0){
            showos2 = part12 + "\n" + part22 + "x" + part32 + "GHz";
        }
        else{
            showos2 = part12;
        }
        databaseAccess.close();
        proc21.setText(showos);
        proc22.setText(showos2);
    }

    private void loadRAM(int id,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        String showed = "-";
        String showed2 = "-";
        databaseAccess.open();
        double dwnld = databaseAccess.getRAM(id);
        if(dwnld!=0){
            showed = Double.toString(dwnld)+"GB";
        }
        double dwnld2 = databaseAccess.getRAM(id2);
        if(dwnld2!=0){
            showed2 = Double.toString(dwnld2)+"GB";
        }
        databaseAccess.close();
        ram21.setText(showed);
        ram22.setText(showed2);
    }

    private void loadMemory(int id,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        String showed = "-";
        String showed2 = "-";
        databaseAccess.open();
        double dwnld = databaseAccess.getMemory(id);
        if(dwnld!=0){
            showed = Double.toString(dwnld)+"GB";
        }
        double dwnld2 = databaseAccess.getMemory(id2);
        if(dwnld2!=0){
            showed2 = Double.toString(dwnld2)+"GB";
        }
        databaseAccess.close();
        mem21.setText(showed);
        mem22.setText(showed2);
    }


}
