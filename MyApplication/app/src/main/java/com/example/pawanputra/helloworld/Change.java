package com.example.pawanputra.helloworld;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.HashMap;
public class Change extends AppCompatActivity {
    private Uri image_uri=null;
    HashMap<String,String> hm;
    EditText key,value;
    ImageView imageView;
    Button button;
    String keyButton1;
    SQLiteDatabase dbVariable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changedata2);
        hm=new HashMap<String, String>();
        this.keyButton1=getIntent().getStringExtra("keyButton");
        key=(EditText)findViewById(R.id.editKey);
        value=(EditText)findViewById(R.id.editValue);
        imageView=(ImageView)findViewById(R.id.idImage);
        button=(Button)findViewById(R.id.idsubmitButton);
        dbVariable=openOrCreateDatabase("App22", Context.MODE_PRIVATE,null);
        dbVariable.execSQL("create table if not exists Contactss(ID number,MOBILE varchar(10));");

        System.out.println("databasepath= "+dbVariable.getPath());
       try
       {
           File f=new File("/data/user/0/com.example.pawanputra.helloworld/files");
           String[] aa=f.list();
           for (String aaa:aa)
               System.out.println(aaa);
       }catch (Exception e)
       {
           System.out.println("errror");
       }

         if (Integer.parseInt(keyButton1)==4)
         {
             key.setVisibility(View.INVISIBLE);
             value.setVisibility(View.INVISIBLE);
             imageView.setVisibility(View.INVISIBLE);
             button.setText("please press back key back");
             submit();
         }
    }
    protected void submit(View v){
        String keyEdit=key.getText().toString();
        String valueEdit=value.getText().toString();

        switch (Integer.parseInt(keyButton1)) {
            case 1: {
                if (!keyEdit.isEmpty()&&!valueEdit.isEmpty()) {
                    if (enquiry()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("ID", keyEdit);
                        contentValues.put("MOBILE", valueEdit);

                        dbVariable.insert("Contactss", null, contentValues);
                        Toast.makeText(getApplicationContext(), "success insertion", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getApplicationContext(), "already key available", Toast.LENGTH_SHORT).show();

                    }
                }
                else Toast.makeText(getApplicationContext(),"please give correct values",Toast.LENGTH_SHORT).show();
                    }
            break;

            case 2:{
                if (!enquiry()) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("MOBILE", valueEdit);
                    dbVariable.update("Contactss", contentValues, "ID=?", new String[]{key.getText().toString()});
                    Toast.makeText(getApplicationContext(), keyEdit + " " + valueEdit, Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "success update", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(),"there is no such key to update",Toast.LENGTH_SHORT).show();
                break;
            }
            case 3:
            {
                if (!enquiry()) {
                    dbVariable.delete("Contactss","ID=?",new String[]{key.getText().toString()});
                    Toast.makeText(getApplicationContext(), "success Deletion", Toast.LENGTH_SHORT).show();
                    break;
                }
                else Toast.makeText(getApplicationContext(),"There is no such key to delete",Toast.LENGTH_SHORT).show();
                break;
                }

        }
        value.setText("");
        key.setText("");

    }
    void submit()
    {


            ReadQuery();

        }
    protected void ReadQuery()
    {


        String s="SELECT * FROM "+ "Contactss";
        Cursor c= dbVariable.rawQuery(s,null);


        while (c.moveToNext()) {
            hm.put(c.getString(0),c.getString(1));
                String result = c.getString(0) + " " + c.getString(1);
            System.out.println("data to hashMap=  "+result);
        }
        System.out.println("hashMap data before sending hm to objdata= "+hm);

        ObjData od=new ObjData(hm);

        Intent ii=new Intent(this,Recycler.class);
        startActivity(ii);


    }
    protected boolean enquiry()
    {
        Cursor c=dbVariable.query("Contactss",new String[]{"ID","MOBILE"},"ID=?",new String[]{key.getText().toString()},null,null,null);
            if (c.moveToNext())return false;
            else return true;

    }
    String ppath()
    {
     return dbVariable.getPath();
    }


}


