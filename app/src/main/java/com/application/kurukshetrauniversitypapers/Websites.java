package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Websites extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites);
        listView=findViewById(R.id.websites_list);

        final ArrayList<String> list=new ArrayList<String >();
        list.add("http://hsbte.org.in/");
        list.add("https://www.kuk.ac.in/");

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://hsbte.org.in/"));
                    startActivity(Browserintent);
                }
                if(position==1){
                    Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kuk.ac.in/"));
                    startActivity(Browserintent);
                }

            }
        });


    }
}