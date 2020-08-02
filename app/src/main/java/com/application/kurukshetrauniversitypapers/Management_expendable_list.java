package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Adapters.MyExListAdapter;
import BBA_subjectlists.Bba_firstsem_subjectlist;
import BBA_subjectlists.Bba_secondsem_subjectlist;
import BBA_subjectlists.Bba_thirdsem_subjectlist;
import MBA_subjectlist.Mba_firstsem_subjectlist;
import MBA_subjectlist.Mba_fourthsem_subjectlist;
import MBA_subjectlist.Mba_secondsem_subjectlist;
import MBA_subjectlist.Mba_thirdsem_subjectlist;

public class Management_expendable_list extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> branch;
    Map<String, List<String>> semester;
    ExpandableListAdapter listAdapter;
    int total_bba,total_mba;
    int bb01,bb02,bb03,mb01,mb02,mb03,mb04;
    DatabaseReference ref1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_expendable_list);
        textView=findViewById(R.id.refresh);
        expandableListView=findViewById(R.id.managementexpendablelist);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Management_expendable_list.this,Expendable_loader.class);
                intent.putExtra("reference","management");
                startActivity(intent);
            }
        });

        ref1= FirebaseDatabase.getInstance().getReference("IN/KU/BB/01");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("AY")) {
                    bb01=bb01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("BA")) {
                    bb01=bb01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("BM")) {
                    bb01=bb01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("BO")) {
                    bb01=bb01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("BU")) {
                    bb01=bb01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("CF")) {
                    bb01=bb01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("HI")) {
                    bb01=bb01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("MN")) {
                    bb01=bb01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("PM")) {
                    bb01=bb01+(int)dataSnapshot.getChildrenCount();

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
        ref1= FirebaseDatabase.getInstance().getReference("IN/KU/BB/02");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("BS")) {
                    bb02=bb02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("FD")) {
                    bb02=bb02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("FM")) {
                    bb02=bb02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("HB")) {
                    bb02=bb02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("MG")) {
                    bb02=bb02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("MK")) {
                    bb02=bb02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("MT")) {
                    bb02=bb02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("UH")) {
                    bb02=bb02+(int)dataSnapshot.getChildrenCount();

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
        ref1= FirebaseDatabase.getInstance().getReference("IN/KU/BB/03");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("US")) {
                    bb03=bb03+(int)dataSnapshot.getChildrenCount();
                }

                total_bba=bb01+bb02+bb03;
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

        ref1= FirebaseDatabase.getInstance().getReference("IN/KU/MB/01");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("BE")) {
                    mb01=mb01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("BN")) {
                    mb01=mb01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("BS")) {
                    mb01=mb01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("CB")) {
                    mb01=mb01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("FA")) {
                    mb01=mb01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("FS")) {
                    mb01=mb01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("MN")) {
                    mb01=mb01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("MQ")) {
                    mb01=mb01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("PD")) {
                    mb01=mb01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("SY")) {
                    mb01=mb01+(int)dataSnapshot.getChildrenCount();

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
        ref1= FirebaseDatabase.getInstance().getReference("IN/KU/MB/02");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("BE")) {
                    mb02=mb02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("BR")) {
                    mb02=mb02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("CR")) {
                    mb02=mb02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("FM")) {
                    mb02=mb02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("FX")) {
                    mb02=mb02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("HR")) {
                    mb02=mb02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("LE")) {
                    mb02=mb02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("MH")) {
                    mb02=mb02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("MK")) {
                    mb02=mb02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("OB")) {
                    mb02=mb02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("PI")) {
                    mb02=mb02+(int)dataSnapshot.getChildrenCount();

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
        ref1= FirebaseDatabase.getInstance().getReference("IN/KU/MB/03");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("BL")) {
                    mb03=mb03+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("LF")) {
                    mb03=mb03+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("MJ")) {
                    mb03=mb03+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("OI")) {
                    mb03=mb03+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("SD")) {
                    mb03=mb03+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("SR")) {
                    mb03=mb03+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("WC")) {
                    mb03=mb03+(int)dataSnapshot.getChildrenCount();

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
        ref1= FirebaseDatabase.getInstance().getReference("IN/KU/MB/04");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("CV")) {
                    mb04=mb04+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("EL")) {
                    mb04=mb04+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("FT")) {
                    mb04=mb04+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("IA")) {
                    mb04=mb04+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("IL")) {
                    mb04=mb04+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("IT")) {
                    mb04=mb04+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("MF")) {
                    mb04=mb04+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("MO")) {
                    mb04=mb04+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("MR")) {
                    mb04=mb04+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("MX")) {
                    mb04=mb04+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("PB")) {
                    mb04=mb04+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("PJ")) {
                    mb04=mb04+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("PT")) {
                    mb04=mb04+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("SG")) {
                    mb04=mb04+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("SI")) {
                    mb04=mb04+(int)dataSnapshot.getChildrenCount();

                }

                filldata();
                total_mba=mb01+mb02+mb03+mb04;
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
                if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition).equals("First semester " +"("+bb01+")")){
                    Intent i=new Intent(getBaseContext(), Bba_firstsem_subjectlist.class);
                    i.putExtra("key", "1");
                    startActivity(i);
                }
                if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition).equals("Second semester " +"("+bb02+")")){
                    Intent i=new Intent(getBaseContext(), Bba_secondsem_subjectlist.class);
                    i.putExtra("key", "2");
                    startActivity(i);
                }
                if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition).equals("Third semester " +"("+bb03+")")){
                    Intent i=new Intent(getBaseContext(), Bba_thirdsem_subjectlist.class);
                    i.putExtra("key", "3");
                    startActivity(i);
                }


                if((groupPosition)==1  && listAdapter.getChild(groupPosition,childPosition).equals("First semester " +"("+mb01+")")) {
                    Intent i=new Intent(getBaseContext(), Mba_firstsem_subjectlist.class);
                    i.putExtra("key", "1");
                    startActivity(i);
                }
                if((groupPosition)==1  && listAdapter.getChild(groupPosition,childPosition).equals("Second semester " +"("+mb02+")")) {
                    Intent i=new Intent(getBaseContext(), Mba_secondsem_subjectlist.class);
                    i.putExtra("key", "2");
                    startActivity(i);

                }
                if((groupPosition)==1 && listAdapter.getChild(groupPosition,childPosition).equals("Third semester "+"("+mb03+")")) {
                    Intent i=new Intent(getBaseContext(), Mba_thirdsem_subjectlist.class);
                    i.putExtra("key", "3");
                    startActivity(i);

                }
                if((groupPosition)==1 && listAdapter.getChild(groupPosition,childPosition).equals("Fourth semester "+"("+mb04+")")) {
                    Intent i=new Intent(getBaseContext(), Mba_fourthsem_subjectlist.class);
                    i.putExtra("key", "4");
                    startActivity(i);
                }
                return false;
            }
        });
    }

    public void filldata(){
        branch=new ArrayList<>();
        semester=new HashMap<>();

        branch.add("BBA " +"("+total_bba+")");
        branch.add("MBA "+"("+total_mba+")");
        
        List<String> first=new ArrayList<>();
        List<String> second=new ArrayList<>();
        
        first.add("First semester " +"("+bb01+")");
        first.add("Second semester "+"("+bb02+")");
        first.add("Third semester "+"("+bb03+")");

        second.add("First semester "+"("+mb01+")");
        second.add("Second semester "+"("+mb02+")");
        second.add("Third semester "+"("+mb03+")");
        second.add("Fourth semester "+"("+mb04+")");
        
        semester.put(branch.get(0),first);
        semester.put(branch.get(1),second);
        
    }
    @Override
    public void onBackPressed()
    {
        Intent intent=new Intent(Management_expendable_list.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("run counter","no");
        intent.putExtra("EXIT", true);
        startActivity(intent);
        finish();
    }
}
