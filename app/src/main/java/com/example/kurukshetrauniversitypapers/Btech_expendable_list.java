package com.example.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Btech_expendable_list extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> semester;
    Map<String, List<String>> year;
    ExpandableListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btech_expendable_list);
        expandableListView=findViewById(R.id.btechexpendablelist);          // expListAdapter.getChild(
                                                                               // groupPosition, childPosition);
        filldata();

        listAdapter=new MyExListAdapter(this,semester,year);
        expandableListView.setAdapter(listAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
               if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition)=="2019") {
                   Intent i=new Intent(getBaseContext(),Pdflist.class);
                   i.putExtra("key", "first19");
                   startActivity(i);
                   Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
               }
                if(groupPosition==0 && year.get(semester.get(groupPosition)).get(childPosition)=="2018") {
                    Intent i=new Intent(getBaseContext(),Pdflist.class);
                    i.putExtra("key", "first18");
                    startActivity(i);
                    Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
                }
                if(groupPosition==0 && year.get(semester.get(groupPosition)).get(childPosition)=="2017") {
                    Intent i=new Intent(getBaseContext(),Pdflist.class);
                    i.putExtra("key", "first17");
                    startActivity(i);
                    Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
                }
                if(groupPosition==1 && year.get(semester.get(groupPosition)).get(childPosition)=="2019") {
                    Intent i=new Intent(getBaseContext(),Pdflist.class);
                    i.putExtra("key", "1");
                    startActivity(i);
                    Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
                }
                if(groupPosition==1 && year.get(semester.get(groupPosition)).get(childPosition)=="2018") {
                    Intent i=new Intent(getBaseContext(),Pdflist.class);
                    i.putExtra("key", "2");
                    startActivity(i);
                    Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
                }
                if(groupPosition==1 && year.get(semester.get(groupPosition)).get(childPosition)=="2017") {
                    Intent i=new Intent(getBaseContext(),Pdflist.class);
                    i.putExtra("key", "3");
                    startActivity(i);
                    Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(Btech_expendable_list.this, semester.get(groupPosition)+ ":"+ year.get(semester.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();

                return false;
            }
        });

    }
    public void filldata(){
        semester=new ArrayList<>();
        year=new HashMap<>();

        semester.add("First semester");
        semester.add("Second semester");
        semester.add("Third semester");
        semester.add("Fourth semester");
        semester.add("Fifth semester");
        semester.add("Sixth semester");
        semester.add("Seventh semester");
        semester.add("eigth semester");

        List<String> first=new ArrayList<>();
        List<String> second=new ArrayList<>();
        List<String> third=new ArrayList<>();
        List<String> fourth=new ArrayList<>();
        List<String> fifth=new ArrayList<>();
        List<String> sixth=new ArrayList<>();
        List<String> seventh=new ArrayList<>();
        List<String> eigth=new ArrayList<>();

        first.add("2019");
        first.add("2018");
        first.add("2017");

        second.add("2019");
        second.add("2018");
        second.add("2017");

        third.add("Computer science engineering");
        third.add("Information technology");
        third.add("Mechanical engineering");
        third.add("Electronics and communication engg.");
        third.add("Electrical engineering");

        fourth.add("Computer science engineering");
        fourth.add("Information technology");
        fourth.add("Mechanical engineering");
        fourth.add("Electronics and communication engg.");
        fourth.add("Electrical engineering");

        fifth.add("Computer science engineering");
        fifth.add("Information technology");
        fifth.add("Mechanical engineering");
        fifth.add("Electronics and communication engg.");
        fifth.add("Electrical engineering");

        sixth.add("Computer science engineering");
        sixth.add("Information technology");
        sixth.add("Mechanical engineering");
        sixth.add("Electronics and communication engg.");
        sixth.add("Electrical engineering");

        seventh.add("Computer science engineering");
        seventh.add("Information technology");
        seventh.add("Mechanical engineering");
        seventh.add("Electronics and communication engg.");
        seventh.add("Electrical engineering");

        eigth.add("Computer science engineering");
        eigth.add("Information technology");
        eigth.add("Mechanical engineering");
        eigth.add("Electronics and communication engg.");
        eigth.add("Electrical engineering");


        year.put(semester.get(0),first);
        year.put(semester.get(1),second);
        year.put(semester.get(2),third);
        year.put(semester.get(3),fourth);
        year.put(semester.get(4),fifth);
        year.put(semester.get(5),sixth);
        year.put(semester.get(6),seventh);
        year.put(semester.get(7),eigth);

    }
}
