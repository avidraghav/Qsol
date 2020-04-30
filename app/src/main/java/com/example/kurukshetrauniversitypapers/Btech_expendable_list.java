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
    List<String> branch;
    Map<String, List<String>> semester;
    ExpandableListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btech_expendable_list);
        expandableListView=findViewById(R.id.btechexpendablelist);          // expListAdapter.getChild(
                                                                               // groupPosition, childPosition);
        filldata();

        listAdapter=new MyExListAdapter(this,branch,semester);
        expandableListView.setAdapter(listAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
               if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition)=="First semester") {
                   Intent i=new Intent(getBaseContext(),Cse_firstsem_subjectlist.class);
                   //i.putExtra("key", "first");
                   startActivity(i);
                   Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
               }
//                if(groupPosition==0 && semester.get(branch.get(groupPosition)).get(childPosition)=="Seond semster") {
//                    Intent i=new Intent(getBaseContext(),Pdflist.class);
//                    i.putExtra("key", "second");
//                    startActivity(i);
//                    Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
//                }
//                if(groupPosition==0 && semester.get(branch.get(groupPosition)).get(childPosition)=="Third semester") {
//                    Intent i=new Intent(getBaseContext(),Pdflist.class);
//                    i.putExtra("key", "third");
//                    startActivity(i);
//                    Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
//                }
//                if(groupPosition==0 && semester.get(branch.get(groupPosition)).get(childPosition)=="Fourth semester") {
//                    Intent i=new Intent(getBaseContext(),Pdflist.class);
//                    i.putExtra("key", "fourth");
//                    startActivity(i);
//                    Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
//                }
//                if(groupPosition==0 && semester.get(branch.get(groupPosition)).get(childPosition)=="Fifth semester") {
//                    Intent i=new Intent(getBaseContext(),Pdflist.class);
//                    i.putExtra("key", "fifth");
//                    startActivity(i);
//                    Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
//                }
//                if(groupPosition==0 && semester.get(branch.get(groupPosition)).get(childPosition)=="Sixth semester") {
//                    Intent i=new Intent(getBaseContext(),Pdflist.class);
//                    i.putExtra("key", "sixth");
//                    startActivity(i);
//                    Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
//                }
//                if(groupPosition==0 && semester.get(branch.get(groupPosition)).get(childPosition)=="Seventh semester") {
//                    Intent i=new Intent(getBaseContext(),Pdflist.class);
//                    i.putExtra("key", "seventh");
//                    startActivity(i);
//                    Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
//                }
//                if(groupPosition==0 && semester.get(branch.get(groupPosition)).get(childPosition)=="Eight semester") {
//                    Intent i=new Intent(getBaseContext(),Pdflist.class);
//                    i.putExtra("key", "eigth");
//                    startActivity(i);
//                    Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
//                }
                //Toast.makeText(Btech_expendable_list.this, branch.get(groupPosition)+ ":"+ semester.get(branch.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();

                return false;
            }
        });

    }
    public void filldata(){
        branch=new ArrayList<>();
        semester=new HashMap<>();

        branch.add("Computer Science Engineering");
        branch.add("Information Technology");
        branch.add("Mechanical Engineering");
        branch.add("Electronics and Communication Engg.");
        branch.add("Electrical Engineering");

        List<String> first=new ArrayList<>();
        List<String> second=new ArrayList<>();
        List<String> third=new ArrayList<>();
        List<String> fourth=new ArrayList<>();
        List<String> fifth=new ArrayList<>();
//        List<String> sixth=new ArrayList<>();
//        List<String> seventh=new ArrayList<>();
//        List<String> eigth=new ArrayList<>();

//        first.add("2019");
//        first.add("2018");
//        first.add("2017");
//
//        second.add("2019");
//        second.add("2018");
//        second.add("2017");

        first.add("First semester");
        first.add("Second semester");
        first.add("Third semester");
        first.add("Fourth semester");
        first.add("Fifth semester");
        first.add("Sixth semester");
        first.add("Seventh semester");
        first.add("Eight semester");

        second.add("First semester");
        second.add("Second semester");
        second.add("Third semester");
        second.add("Fourth semester");
        second.add("Fifth semester");
        second.add("Sixth semester");
        second.add("Seventh semester");
        second.add("Eight semester");

        third.add("First semester");
        third.add("Second semester");
        third.add("Third semester");
        third.add("Fourth semester");
        third.add("Fifth semester");
        third.add("Sixth semester");
        third.add("Seventh semester");
        third.add("Eight semester");

        fourth.add("First semester");
        fourth.add("Second semester");
        fourth.add("Third semester");
        fourth.add("Fourth semester");
        fourth.add("Fifth semester");
        fourth.add("Sixth semester");
        fourth.add("Seventh semester");
        fourth.add("Eight semester");

        fifth.add("First semester");
        fifth.add("Second semester");
        fifth.add("Third semester");
        fifth.add("Fourth semester");
        fifth.add("Fifth semester");
        fifth.add("Sixth semester");
        fifth.add("Seventh semester");
        fifth.add("Eight semester");

//        third.add("Computer science engineering");
//        third.add("Information technology");
//        third.add("Mechanical engineering");
//        third.add("Electronics and communication engg.");
//        third.add("Electrical engineering");
//
//        fourth.add("Computer science engineering");
//        fourth.add("Information technology");
//        fourth.add("Mechanical engineering");
//        fourth.add("Electronics and communication engg.");
//        fourth.add("Electrical engineering");
//
//        fifth.add("Computer science engineering");
//        fifth.add("Information technology");
//        fifth.add("Mechanical engineering");
//        fifth.add("Electronics and communication engg.");
//        fifth.add("Electrical engineering");
//
//        sixth.add("Computer science engineering");
//        sixth.add("Information technology");
//        sixth.add("Mechanical engineering");
//        sixth.add("Electronics and communication engg.");
//        sixth.add("Electrical engineering");
//
//        seventh.add("Computer science engineering");
//        seventh.add("Information technology");
//        seventh.add("Mechanical engineering");
//        seventh.add("Electronics and communication engg.");
//        seventh.add("Electrical engineering");
//
//        eigth.add("Computer science engineering");
//        eigth.add("Information technology");
//        eigth.add("Mechanical engineering");
//        eigth.add("Electronics and communication engg.");
//        eigth.add("Electrical engineering");


        semester.put(branch.get(0),first);
        semester.put(branch.get(1),second);
        semester.put(branch.get(2),third);
        semester.put(branch.get(3),fourth);
        semester.put(branch.get(4),fifth);
//        semester.put(branch.get(5),sixth);
//        semester.put(branch.get(6),seventh);
//        semester.put(branch.get(7),eigth);

    }
}
