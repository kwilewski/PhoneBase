package com.example.krzysiek.phonebase;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ShowPhone extends AppCompatActivity {

    private ImageView photo1,photo2,photo3,camCheckImage,cam2CheckImage,jackImage,lteImage,ledImage;
    private TextView brandmodel,onlymodel,typeText,osText,dispsizeText,dispresText,camResText,cam2ResText,priceText,procesorText,ramText,memText;
    private int selectedID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_phone);

        photo1 = (ImageView) findViewById(R.id.phonephoto1);
        photo2 = (ImageView) findViewById(R.id.phonephoto2);
        photo3 = (ImageView) findViewById(R.id.phonephoto3);
        camCheckImage = (ImageView) findViewById(R.id.camCheckImage);
        cam2CheckImage = (ImageView) findViewById(R.id.cam2CheckImage);
        lteImage = (ImageView) findViewById(R.id.lteImage);
        ledImage = (ImageView) findViewById(R.id.ledImage);
        jackImage = (ImageView) findViewById(R.id.jackImage);
        photo1.setImageResource(R.drawable.scr);
        photo2.setImageResource(R.drawable.scr);
        photo3.setImageResource(R.drawable.scr);

        brandmodel = (TextView) findViewById(R.id.brandmodeltext);
        onlymodel = (TextView) findViewById(R.id.onlymodeltext);
        typeText = (TextView) findViewById(R.id.typeText);
        osText = (TextView) findViewById(R.id.osText);
        dispsizeText = (TextView) findViewById(R.id.dispsizeText);
        dispresText = (TextView) findViewById(R.id.dispresText);
        camResText = (TextView) findViewById(R.id.camResText);
        cam2ResText = (TextView) findViewById(R.id.cam2ResText);
        priceText = (TextView) findViewById(R.id.priceText);
        procesorText = (TextView) findViewById(R.id.procesorText);
        ramText = (TextView) findViewById(R.id.ramText);
        memText = (TextView) findViewById(R.id.memText);

        setID();

        loadBrand(selectedID);
        loadModel(selectedID);
        loadType(selectedID);
        loadOS(selectedID);
        loadDispSize(selectedID);
        loadDispRes(selectedID);
        loadCamCheck(selectedID);
        loadCam2Check(selectedID);
        loadCamRes(selectedID);
        loadCam2Res(selectedID);
        loadJack(selectedID);
        loadPrice(selectedID);
        loadProc(selectedID);
        loadLED(selectedID);
        loadLTE(selectedID);
        loadRAM(selectedID);
        loadMemory(selectedID);
        loadPhoto1(selectedID);
        loadPhoto2(selectedID);
        loadPhoto3(selectedID);





        }



      private void setID(){
          DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
          this.selectedID=databaseAccess.getSelectedID();
      }

    private String loadBrand(int id){

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        String branddwn = databaseAccess.getBrand(id);
        databaseAccess.close();
        brandmodel.setText(branddwn);
        return branddwn;


    }

    private String loadModel(int id){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        String modeldwn = databaseAccess.getModel(id);
        databaseAccess.close();
        onlymodel.setText(modeldwn);
        return modeldwn;
    }


    private String loadType(int id){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        String ReturnVal = databaseAccess.getType(id);
        databaseAccess.close();
        typeText.setText(ReturnVal);
        return ReturnVal;
    }

    private void loadOS(int id){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        String part1 = databaseAccess.getOS(id);
        String part2 = databaseAccess.getOSVers(id);
        String showos = " ";
        if(part2!=" "){
            showos = part1 + " " + part2;

        }
        else{
            showos = part1;
        }
        databaseAccess.close();
        osText.setText(showos);
    }

    private void loadDispSize(int id){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        double size = databaseAccess.getDispSize(id);
        String dsize = Double.toString(size)+"\"";
        databaseAccess.close();
        dispsizeText.setText(dsize);
    }

    private void loadDispRes(int id){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        String showed = databaseAccess.getDispRes(id);
        databaseAccess.close();
        dispresText.setText(showed);
    }

    private void loadCamCheck(int id){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        int showed = databaseAccess.getCam(id);
        if(showed==1){
            camCheckImage.setImageResource(R.drawable.checkok);
        }
        else{
            camCheckImage.setImageResource(R.drawable.checknope);
        }
        databaseAccess.close();
    }

    private void loadCamRes(int id){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        String showed = "-";
        databaseAccess.open();
        double dwnld = databaseAccess.getCamRes(id);
        if(dwnld!=0){
            showed = Double.toString(dwnld)+"MPix";
        }
        databaseAccess.close();
        camResText.setText(showed);
    }

    private void loadCam2Check(int id){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        int showed = databaseAccess.getCam2(id);
        if(showed==1){
            cam2CheckImage.setImageResource(R.drawable.checkok);
        }
        else{
            cam2CheckImage.setImageResource(R.drawable.checknope);
        }
        databaseAccess.close();
    }

    private void loadCam2Res(int id){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        String showed = "-";
        databaseAccess.open();
        double dwnld = databaseAccess.getCam2Res(id);
        if(dwnld!=0){
            showed = Double.toString(dwnld)+"MPix";
        }
        databaseAccess.close();
        cam2ResText.setText(showed);
    }

    private void loadJack(int id){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        int showed = databaseAccess.getJack(id);
        if(showed==1){
            jackImage.setImageResource(R.drawable.checkok);
        }
        else{
            jackImage.setImageResource(R.drawable.checknope);
        }
        databaseAccess.close();
    }

    private void loadLTE(int id){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        int showed = databaseAccess.getLTE(id);
        if(showed==1){
            lteImage.setImageResource(R.drawable.checkok);
        }
        else{
            lteImage.setImageResource(R.drawable.checknope);
        }
        databaseAccess.close();
    }

    private void loadLED(int id){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        int showed = databaseAccess.getLED(id);
        if(showed==1){
            ledImage.setImageResource(R.drawable.checkok);
        }
        else{
            ledImage.setImageResource(R.drawable.checknope);
        }
        databaseAccess.close();
    }

    private void loadPrice(int id){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        double dwnld = databaseAccess.getPrice(id);
        String showed = Double.toString(dwnld)+"0zł";
        databaseAccess.close();
        priceText.setText(showed);
    }

    private void loadProc(int id){
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
        databaseAccess.close();
        procesorText.setText(showos);
    }

    private void loadRAM(int id){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        String showed = "-";
        databaseAccess.open();
        double dwnld = databaseAccess.getRAM(id);
        if(dwnld!=0){
            showed = Double.toString(dwnld)+"GB";
        }
        databaseAccess.close();
        ramText.setText(showed);
    }

    private void loadMemory(int id){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        String showed = "-";
        databaseAccess.open();
        double dwnld = databaseAccess.getMemory(id);
        if(dwnld!=0){
            showed = Double.toString(dwnld)+"GB";
        }
        databaseAccess.close();
        memText.setText(showed);
    }


    private void loadPhoto1(int id){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        //photo1.setImageBitmap(databaseAccess.getImage(id));
        Bitmap photo = databaseAccess.getImage(id);
        databaseAccess.close();
        photo1.setImageBitmap(photo);

    }

    private void loadPhoto2(int id){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        Bitmap photo = databaseAccess.getImage2(id);
        databaseAccess.close();
        photo2.setImageBitmap(photo);

    }

    private void loadPhoto3(int id){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        Bitmap photo = databaseAccess.getImage3(id);
        databaseAccess.close();
        photo3.setImageBitmap(photo);

    }




    }
