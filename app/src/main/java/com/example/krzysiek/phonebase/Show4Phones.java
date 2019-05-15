package com.example.krzysiek.phonebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Show4Phones extends AppCompatActivity {

    private ImageView cam21,cam22,cam221,cam222,jack21,jack22,lte21,lte22,led21,led22;
    private TextView brand21,brand22,os21,os22,type21,type22,dispres21,dispres22,dispsize21,dispsize22,camRes21,camRes22,cam2res21,cam2res22,price21,price22,proc21,proc22,
            ram21,ram22,mem21,mem22;
    private int selectedID1,selectedID2,selectedID3,selectedID4;
    private ImageView acam21,acam22,acam221,acam222,ajack21,ajack22,alte21,alte22,aled21,aled22;
    private TextView abrand21,abrand22,aos21,aos22,atype21,atype22,adispres21,adispres22,adispsize21,adispsize22,acamRes21,acamRes22,acam2res21,acam2res22,aprice21,aprice22,aproc21,aproc22,
            aram21,aram22,amem21,amem22;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show4phones);


        cam21 = (ImageView) findViewById(R.id.cam41);
        cam221 = (ImageView) findViewById(R.id.cam241);
        lte21 = (ImageView) findViewById(R.id.lte41);
        led21 = (ImageView) findViewById(R.id.led41);
        jack21 = (ImageView) findViewById(R.id.jack41);

        brand21 = (TextView) findViewById(R.id.brand41);
        type21 = (TextView) findViewById(R.id.type41);
        os21 = (TextView) findViewById(R.id.os41);
        dispsize21 = (TextView) findViewById(R.id.dispsize41);
        dispres21 = (TextView) findViewById(R.id.dispres41);
        camRes21 = (TextView) findViewById(R.id.camRes41);
        cam2res21 = (TextView) findViewById(R.id.cam2res41);
        price21 = (TextView) findViewById(R.id.price41);
        proc21 = (TextView) findViewById(R.id.proc41);
        ram21 = (TextView) findViewById(R.id.ram41);
        mem21 = (TextView) findViewById(R.id.mem41);

        cam22 = (ImageView) findViewById(R.id.cam42);
        cam222 = (ImageView) findViewById(R.id.cam242);
        lte22 = (ImageView) findViewById(R.id.lte42);
        led22 = (ImageView) findViewById(R.id.led42);
        jack22 = (ImageView) findViewById(R.id.jack42);

        brand22 = (TextView) findViewById(R.id.brand42);
        type22 = (TextView) findViewById(R.id.type42);
        os22 = (TextView) findViewById(R.id.os42);
        dispsize22 = (TextView) findViewById(R.id.dispsize42);
        dispres22 = (TextView) findViewById(R.id.dispres42);
        camRes22 = (TextView) findViewById(R.id.camRes42);
        cam2res22 = (TextView) findViewById(R.id.cam2res42);
        price22 = (TextView) findViewById(R.id.price42);
        proc22 = (TextView) findViewById(R.id.proc42);
        ram22 = (TextView) findViewById(R.id.ram42);
        mem22 = (TextView) findViewById(R.id.mem42);

        acam21 = (ImageView) findViewById(R.id.cam43);
        acam221 = (ImageView) findViewById(R.id.cam243);
        alte21 = (ImageView) findViewById(R.id.lte43);
        aled21 = (ImageView) findViewById(R.id.led43);
        ajack21 = (ImageView) findViewById(R.id.jack43);

        abrand21 = (TextView) findViewById(R.id.brand43);
        atype21 = (TextView) findViewById(R.id.type43);
        aos21 = (TextView) findViewById(R.id.os43);
        adispsize21 = (TextView) findViewById(R.id.dispsize43);
        adispres21 = (TextView) findViewById(R.id.dispres43);
        acamRes21 = (TextView) findViewById(R.id.camRes43);
        acam2res21 = (TextView) findViewById(R.id.cam2res43);
        aprice21 = (TextView) findViewById(R.id.price43);
        aproc21 = (TextView) findViewById(R.id.proc43);
        aram21 = (TextView) findViewById(R.id.ram43);
        amem21 = (TextView) findViewById(R.id.mem43);

        acam22 = (ImageView) findViewById(R.id.cam44);
        acam222 = (ImageView) findViewById(R.id.cam244);
        alte22 = (ImageView) findViewById(R.id.lte44);
        aled22 = (ImageView) findViewById(R.id.led44);
        ajack22 = (ImageView) findViewById(R.id.jack44);

        abrand22 = (TextView) findViewById(R.id.brand44);
        atype22 = (TextView) findViewById(R.id.type44);
        aos22 = (TextView) findViewById(R.id.os44);
        adispsize22 = (TextView) findViewById(R.id.dispsize44);
        adispres22 = (TextView) findViewById(R.id.dispres44);
        acamRes22 = (TextView) findViewById(R.id.camRes44);
        acam2res22 = (TextView) findViewById(R.id.cam2res44);
        aprice22 = (TextView) findViewById(R.id.price44);
        aproc22 = (TextView) findViewById(R.id.proc44);
        aram22 = (TextView) findViewById(R.id.ram44);
        amem22 = (TextView) findViewById(R.id.mem44);

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

        aloadMemory(selectedID1,selectedID4);
        aloadBrand(selectedID3,selectedID4);
        aloadType(selectedID3,selectedID4);
        aloadOS(selectedID3,selectedID4);
        aloadDispSize(selectedID3,selectedID4);
        aloadDispRes(selectedID3,selectedID4);
        aloadCamCheck(selectedID3,selectedID4);
        aloadCam2Check(selectedID3,selectedID4);
        aloadCamRes(selectedID3,selectedID4);
        aloadCam2Res(selectedID3,selectedID4);
        aloadJack(selectedID3,selectedID4);
        aloadPrice(selectedID3,selectedID4);
        aloadProc(selectedID3,selectedID4);
        aloadLED(selectedID3,selectedID4);
        aloadLTE(selectedID3,selectedID4);
        aloadRAM(selectedID3,selectedID4);
        aloadMemory(selectedID3,selectedID4);
    }






    private void setID(){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        this.selectedID1=databaseAccess.getSelectedID1();
        this.selectedID2=databaseAccess.getSelectedID2();
        this.selectedID3=databaseAccess.getSelectedID3();
        this.selectedID4=databaseAccess.getSelectedID4();
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

    private void aloadBrand(int id1,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        String bnd1 = databaseAccess.getBrand(id1);
        String bnd2 = databaseAccess.getBrand(id2);
        String mdl1 = databaseAccess.getModel(id1);
        String mdl2 = databaseAccess.getModel(id2);
        databaseAccess.close();
        String mb1 = bnd1 + " " + mdl1;
        String mb2 = bnd2 + " " + mdl2;
        abrand21.setText(mb1);
        abrand22.setText(mb2);

    }

    private void aloadType(int id1,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        String ReturnVal = databaseAccess.getType(id1);
        String ReturnVal2 = databaseAccess.getType(id2);
        databaseAccess.close();
        atype21.setText(ReturnVal);
        atype22.setText(ReturnVal2);
    }

    private void aloadOS(int id1,int id2){
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
        aos21.setText(showos);
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
        aos22.setText(showos2);
    }

    private void aloadDispSize(int id,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        double size = databaseAccess.getDispSize(id);
        String dsize = Double.toString(size)+"\"";
        double size2 = databaseAccess.getDispSize(id2);
        String dsize2 = Double.toString(size2)+"\"";
        databaseAccess.close();
        adispsize21.setText(dsize);
        adispsize22.setText(dsize2);
    }

    private void aloadDispRes(int id,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        String showed = databaseAccess.getDispRes(id);
        String showed2 = databaseAccess.getDispRes(id2);
        databaseAccess.close();
        adispres21.setText(showed);
        adispres22.setText(showed2);
    }

    private void aloadCamCheck(int id,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        int showed = databaseAccess.getCam(id);
        if(showed==1){
            acam21.setImageResource(R.drawable.checkok);
        }
        else{
            acam21.setImageResource(R.drawable.checknope);
        }
        int showed2 = databaseAccess.getCam(id2);
        if(showed2==1){
            acam22.setImageResource(R.drawable.checkok);
        }
        else{
            acam22.setImageResource(R.drawable.checknope);
        }
        databaseAccess.close();
    }

    private void aloadCamRes(int id,int id2){
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
        acamRes21.setText(showed);
        acamRes22.setText(showed2);
    }

    private void aloadCam2Check(int id,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        int showed = databaseAccess.getCam2(id);
        if(showed==1){
            acam221.setImageResource(R.drawable.checkok);
        }
        else{
            acam221.setImageResource(R.drawable.checknope);
        }
        int showed2 = databaseAccess.getCam2(id2);
        if(showed2==1){
            acam222.setImageResource(R.drawable.checkok);
        }
        else{
            acam222.setImageResource(R.drawable.checknope);
        }
        databaseAccess.close();
    }

    private void aloadCam2Res(int id,int id2){
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
        acam2res21.setText(showed);
        acam2res22.setText(showed2);
    }

    private void aloadJack(int id,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        int showed = databaseAccess.getJack(id);
        if(showed==1){
            ajack21.setImageResource(R.drawable.checkok);
        }
        else{
            ajack21.setImageResource(R.drawable.checknope);
        }
        int showed2 = databaseAccess.getJack(id2);
        if(showed2==1){
            ajack22.setImageResource(R.drawable.checkok);
        }
        else{
            ajack22.setImageResource(R.drawable.checknope);
        }
        databaseAccess.close();
    }

    private void aloadLTE(int id,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        int showed = databaseAccess.getLTE(id);
        if(showed==1){
            alte21.setImageResource(R.drawable.checkok);
        }
        else{
            alte21.setImageResource(R.drawable.checknope);
        }
        int showed2 = databaseAccess.getLTE(id2);
        if(showed2==1){
            alte22.setImageResource(R.drawable.checkok);
        }
        else{
            alte22.setImageResource(R.drawable.checknope);
        }
        databaseAccess.close();
    }

    private void aloadLED(int id,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        int showed = databaseAccess.getLED(id);
        if(showed==1){
            aled21.setImageResource(R.drawable.checkok);
        }
        else{
            aled21.setImageResource(R.drawable.checknope);
        }
        int showed2 = databaseAccess.getLED(id2);
        if(showed2==1){
            aled22.setImageResource(R.drawable.checkok);
        }
        else{
            aled22.setImageResource(R.drawable.checknope);
        }
        databaseAccess.close();
    }

    private void aloadPrice(int id,int id2){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        double dwnld = databaseAccess.getPrice(id);
        String showed = Double.toString(dwnld)+"0zł";
        double dwnld2 = databaseAccess.getPrice(id2);
        String showed2 = Double.toString(dwnld2)+"0zł";
        databaseAccess.close();
        aprice21.setText(showed);
        aprice22.setText(showed2);
    }

    private void aloadProc(int id,int id2){
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
        aproc21.setText(showos);
        aproc22.setText(showos2);
    }

    private void aloadRAM(int id,int id2){
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
        aram21.setText(showed);
        aram22.setText(showed2);
    }

    private void aloadMemory(int id,int id2){
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
        amem21.setText(showed);
        amem22.setText(showed2);
    }




}
