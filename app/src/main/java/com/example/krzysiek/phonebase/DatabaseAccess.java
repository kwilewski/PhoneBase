package com.example.krzysiek.phonebase;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.provider.ContactsContract;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.support.v4.content.ContextCompat.getDrawable;


public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;
    private int selectedID,selectedID1,selectedID2,selectedID3,selectedID4;
    private int id;
    private int perfprog,camprog;
    private double dispmin,dispmax,pricemin,pricemax,memmin,memmax;
    private int antutumin=0,dxomin=0;



    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open() {
        this.db = openHelper.getWritableDatabase();
    }


    public void close() {
        if (db != null) {
            this.db.close();
        }
    }

    public void setSelectedID(int id){
        this.selectedID=id;
    }

    public int getSelectedID(){
        return this.selectedID;
    }

    public void setSelectedID1(int id){
        this.selectedID1=id;
    }

    public int getSelectedID1(){
        return this.selectedID1;
    }

    public void setSelectedID2(int id){
        this.selectedID2=id;
    }

    public int getSelectedID2(){
        return this.selectedID2;
    }

    public void setSelectedID3(int id){
        this.selectedID3=id;
    }

    public int getSelectedID3(){
        return this.selectedID3;
    }

    public void setSelectedID4(int id){
        this.selectedID4=id;
    }

    public int getSelectedID4(){
        return this.selectedID4;
    }

    public void setAssist(int a,int b,double c,double d,double e,double f,double g,double h){
        this.perfprog=a;
        this.camprog=b;
        this.dispmin=c;
        this.dispmax=d;
        this.pricemin=e;
        this.pricemax=f;
        this.memmin=g;
        this.memmax=h;
        switch(a){
            case 1:
                antutumin=0;
                break;
            case 2:
                antutumin=25000;
                break;
            case 3:
                antutumin=80000;
                break;
            case 4:
                antutumin=150000;
                break;
            case 5:
                antutumin=210000;
                break;
        }
        switch(b){
            case 1:
                dxomin=0;
                break;
            case 2:
                dxomin=30;
                break;
            case 3:
                dxomin=50;
                break;
            case 4:
                dxomin=80;
                break;
            case 5:
                dxomin=95;
                break;
        }
    }


    public List<Integer> getAssID() {
        List<Integer> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT id FROM phone WHERE type='Smartphone' AND antutu > "+antutumin+" AND dxo > "+dxomin+" AND price BETWEEN "+pricemin+" AND "+pricemax+" AND dispsize BETWEEN "+dispmin+" AND "+dispmax+" AND memory BETWEEN "+memmin+" AND "+memmax+" ORDER BY antutu DESC", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getInt(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }


    public List<String> getBrands() {
        List<String> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT phbrand FROM phone ORDER BY phbrand ASC", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getModels(String brand) {
        List<String> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT phmodel FROM phone WHERE phbrand = '"+brand+"' ORDER BY phmodel ASC", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public int getID(String brand,String model){
        int returnVal=0;
        Cursor cursor = db.rawQuery("SELECT id FROM phone WHERE phbrand = '"+brand+"' AND phmodel = '"+model+"'",null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getInt(0);
        }
        return returnVal;
    }

    public String getBrand(int id) {
        String returnVal = "";
        Cursor cursor = db.rawQuery("SELECT phbrand FROM phone WHERE id = '"+id+"'", null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getString(0);
        }
        return returnVal;
    }

    public String getModel(int id) {
        String returnVal = "";
        Cursor cursor = db.rawQuery("SELECT phmodel FROM phone WHERE id = '"+id+"'", null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getString(0);
        }
        return returnVal;
    }

    public String getType(int id) {
        String returnVal = "";
        Cursor cursor = db.rawQuery("SELECT type FROM phone WHERE id = '"+id+"'", null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getString(0);
        }
        return returnVal;
    }

    public String getOS(int id){
        String returnVal = "";
        Cursor cursor = db.rawQuery("SELECT os FROM phone WHERE id = '"+id+"'", null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getString(0);
        }
        return returnVal;
    }

    public String getOSVers(int id){
        String returnVal = " ";
        Cursor cursor = db.rawQuery("SELECT osvers FROM phone WHERE id = '"+id+"'",null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getString(0);
        }
        return returnVal;
    }


    public String getCPU(int id){
        String returnVal = "";
        Cursor cursor = db.rawQuery("SELECT cpu FROM phone WHERE id = '"+id+"'", null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getString(0);
        }
        return returnVal;
    }

    public int getCPUcores(int id){
        int returnVal=101;
        Cursor cursor = db.rawQuery("SELECT cpucores FROM phone WHERE id = '"+id+"'",null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getInt(0);
        }
        return returnVal;
    }

    public double getCPUfreq(int id){
        double returnVal=1;
        Cursor cursor = db.rawQuery("SELECT cpufreq FROM phone WHERE id = '"+id+"'",null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getDouble(0);
        }
        return returnVal;
    }

    public double getDispSize(int id){
        double returnVal=101;
        Cursor cursor = db.rawQuery("SELECT dispsize FROM phone WHERE id = '"+id+"'",null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getDouble(0);
        }
        return returnVal;
    }

    public String getDispRes(int id){
        String returnVal = "";
        Cursor cursor = db.rawQuery("SELECT dispres FROM phone WHERE id = '"+id+"'", null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getString(0);
        }
        return returnVal;
    }

    public int getCam(int id){
        int returnVal = 0;
        Cursor cursor = db.rawQuery("SELECT cam FROM phone WHERE id = '"+id+"'", null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getInt(0);
        }
        return returnVal;
    }

    public double getCamRes(int id){
        double returnVal=101;
        Cursor cursor = db.rawQuery("SELECT camres FROM phone WHERE id = '"+id+"'",null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getDouble(0);
        }
        return returnVal;
    }

    public int getCam2(int id){
        int returnVal = 0;
        Cursor cursor = db.rawQuery("SELECT cam2 FROM phone WHERE id = '"+id+"'", null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getInt(0);
        }
        return returnVal;
    }

    public double getCam2Res(int id){
        double returnVal=101;
        Cursor cursor = db.rawQuery("SELECT cam2res FROM phone WHERE id = '"+id+"'",null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getDouble(0);
        }
        return returnVal;
    }

    public int getJack(int id){
        int returnVal = 0;
        Cursor cursor = db.rawQuery("SELECT jack FROM phone WHERE id = '"+id+"'", null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getInt(0);
        }
        return returnVal;
    }

    public int getPrice(int id){
        int returnVal=101;
        Cursor cursor = db.rawQuery("SELECT price FROM phone WHERE id = '"+id+"'",null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getInt(0);
        }
        return returnVal;
    }

    public double getRAM(int id){
        double returnVal=0;
        Cursor cursor = db.rawQuery("SELECT ram FROM phone WHERE id = '"+id+"'",null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getDouble(0);
        }
        return returnVal;
    }

    public double getMemory(int id){
        double returnVal=101;
        Cursor cursor = db.rawQuery("SELECT memory FROM phone WHERE id = '"+id+"'",null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getDouble(0);
        }
        return returnVal;
    }

    public int getLTE(int id){
        int returnVal = 0;
        Cursor cursor = db.rawQuery("SELECT lte FROM phone WHERE id = '"+id+"'", null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getInt(0);
        }
        return returnVal;
    }

    public int getLED(int id){
        int returnVal = 0;
        Cursor cursor = db.rawQuery("SELECT led FROM phone WHERE id = '"+id+"'", null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            returnVal = cursor.getInt(0);
        }
        return returnVal;
    }



    public Bitmap getImage(int id){
        Bitmap bt = null;
        Cursor cursor = db.rawQuery("SELECT photo1 FROM phone WHERE id = '"+id+"'",null);
        if(cursor.moveToNext()){
            byte[] imag = cursor.getBlob(0);
            bt = BitmapFactory.decodeByteArray(imag,0,imag.length);
        }
        return bt;
    }

    public Bitmap getImage2(int id){
        Bitmap bt = null;
        Cursor cursor = db.rawQuery("SELECT photo2 FROM phone WHERE id = '"+id+"'",null);
        if(cursor.moveToNext()){
            byte[] imag = cursor.getBlob(0);
            bt = BitmapFactory.decodeByteArray(imag,0,imag.length);
        }
        return bt;
    }

    public Bitmap getImage3(int id){
        Bitmap bt = null;
        Cursor cursor = db.rawQuery("SELECT photo3 FROM phone WHERE id = '"+id+"'",null);
        if(cursor.moveToNext()){
            byte[] imag = cursor.getBlob(0);
            bt = BitmapFactory.decodeByteArray(imag,0,imag.length);
        }
        return bt;
    }



}