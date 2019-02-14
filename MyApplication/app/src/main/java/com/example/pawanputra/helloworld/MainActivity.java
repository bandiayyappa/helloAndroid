package com.example.pawanputra.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {
 int ii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void open(View v)
    {
        Intent i=new Intent(this,Change.class);
       switch (v.getId())
       {
           case R.id.id1 : {this.ii=1;break;}
           case R.id.id2 : {this.ii=2;break;}
           case R.id.id3 : {this.ii=3;break;}


       }
        i.putExtra("keyButton",ii+"");
       startActivity(i);

    }
    public void openRecycler(View v)
    {
        Intent i=new Intent(this,Change.class);
        i.putExtra("keyButton",4+"");
        startActivity(i);
    }

}
