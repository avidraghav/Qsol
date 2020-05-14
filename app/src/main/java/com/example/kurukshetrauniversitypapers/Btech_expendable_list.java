package com.example.kurukshetrauniversitypapers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.kurukshetrauniversitypapers.Cse_firstsem_subjectlist.papercount5;

public class Btech_expendable_list extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> branch;
    Map<String, List<String>> semester;
    ExpandableListAdapter listAdapter;
     int cs01;
    DatabaseReference ref ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btech_expendable_list);
        expandableListView=findViewById(R.id.btechexpendablelist);


        ref=FirebaseDatabase.getInstance().getReference("IN/KU/CS/01");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("BI")) {
                    cs01=cs01+(int)dataSnapshot.getChildrenCount();
                    Log.e(dataSnapshot.getKey(), cs01 + "");
                }
                if(dataSnapshot.getKey().equals("MA")) {
                    cs01=cs01+(int)dataSnapshot.getChildrenCount();
                    Log.e(dataSnapshot.getKey(), cs01 + "");
                }
                if(dataSnapshot.getKey().equals("PH")) {
                    cs01=cs01+(int)dataSnapshot.getChildrenCount();
                    Log.e(dataSnapshot.getKey(), cs01 + "");
                }
                filldata();

                listAdapter=new MyExListAdapter(getBaseContext(),branch,semester);
                expandableListView.setAdapter(listAdapter);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition).equals("First semester "+cs01+" papers")) {
                    Intent i=new Intent(getBaseContext(),Cse_firstsem_subjectlist.class);
                    //i.putExtra("key", "first");
                    startActivity(i);
                    Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
                }

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

        first.add("First semester "+cs01+" papers");
        Log.e("value",cs01+"");
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
