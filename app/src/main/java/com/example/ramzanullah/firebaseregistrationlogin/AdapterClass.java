package com.example.ramzanullah.firebaseregistrationlogin;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by RamzanUllah on 23-Apr-17.
 */

public class AdapterClass extends ArrayAdapter {

    private Activity context;
    List<Authors>authors;


    public AdapterClass(Activity context,List<Authors>authors ){
        super(context, R.layout.activity_retreiving_data,authors);
        this.context = context;
        this.authors = authors;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = context.getLayoutInflater();
         View listitemView =inflater.inflate(R.layout.activity_retreiving_data,parent,false);

        TextView listName = (TextView)listitemView.findViewById(R.id.id_listName);
        TextView listQuote = (TextView)listitemView.findViewById(R.id.id_lisQuote);

        Authors author = authors.get(position);
        listName.setText(author.getmName());
        listQuote.setText(author.getmQuote());



        return listitemView;
    }


}
