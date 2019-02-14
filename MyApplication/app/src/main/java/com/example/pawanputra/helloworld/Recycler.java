package com.example.pawanputra.helloworld;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
public class Recycler extends AppCompatActivity {
    private final HashMap<String,String> mWordList2=new HashMap<String, String>();
    private final HashMap<String,String> ooot = new HashMap();
    private int mCount = 0;
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    ObjData o=new ObjData();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        // Get a handle to the RecyclerView.
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
// Create an adapter and supply the data to be displayed.
        mAdapter = new WordListAdapter(this);
// Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
// Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void message(View v)
    {

        System.out.println("u clicked message "+v.getTag());
       /* SmsManager smsManager=SmsManager.getDefault();
       smsManager.sendTextMessage("8886528765",null,"hi",null,null);*/

        /*startActivityForResult(new Intent(Intent.ACTION_VIEW,Uri.parse("sms:"+"8886528765")),1);*/
        Intent ccc=new Intent();
        ccc.setAction(Intent.ACTION_VIEW);
        ccc.setData(Uri.parse("sms:"+v.getTag()));
       startActivityForResult(ccc,1);
    }
    public void calling(View v)

    {

        System.out.println("u clicked calling "+v.getTag());
        Intent cal = new Intent();
        cal.setAction(Intent.ACTION_DIAL);
        cal.setData(Uri.parse("tel:" +v.getTag()));

     startActivityForResult(cal,1);


    }
    public void onBackPressed()
    {

        Toast.makeText(getApplicationContext(),"please press back in top left",Toast.LENGTH_SHORT).show();
    }
}