package com.example.pawanputra.helloworld;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>  {
    Object[] a;
    TreeSet<String> s=new TreeSet<String>();// to set all the keys from hashmap
    private HashMap<String, String> wordList2=new HashMap<String,String>();//to get data from db

    private LayoutInflater mInflater;
    public WordListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        ObjData o=new ObjData();
        this.wordList2=o.hm;//it returns db data through hashmap
            s.addAll(wordList2.keySet());
            this.a= (Object[]) s.toArray();
       for (int x=0;x<=a.length-1;x++)
       {
           System.out.println(a[x]);// to check keys are correct or not
       }


    }
    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.individual2, parent, false);

        return new WordViewHolder(mItemView, this);

    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {

        System.out.println("position ==="+position);
        holder.wordItemView.setText(a[position]+"");
        holder.wordItemView.setId(position);
        holder.wordItemView2.setId(position);
        holder.wordItemView2.setText(wordList2.get(a[position].toString()));
        holder.call.setId(position);
        Object o=a[position];
        System.out.println("wordlist data getting"+wordList2.get(o));
        holder.call.setTag(wordList2.get(o));
        holder.message.setId(position);
        holder.message.setTag(wordList2.get(o));

    }

    @Override
    public int getItemCount() {
        return a.length;
    }


    class WordViewHolder extends RecyclerView.ViewHolder {
        public final TextView wordItemView;
        public final TextView wordItemView2;
        public final ImageView call,message;

        final WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = (TextView) itemView.findViewById(R.id.idName);
            wordItemView2 = (TextView) itemView.findViewById(R.id.idAddress);
            call=(ImageView)itemView.findViewById(R.id.id_cal);
            message=(ImageView)itemView.findViewById(R.id.id_Message);
            this.mAdapter = adapter;
        }
    }

}