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

import BCA_subjectlists.Bca_firstsem_subjectlist;
import BCA_subjectlists.Bca_secondsem_subjectlist;
import BCA_subjectlists.Bca_thirdsem_subjectlist;
import MCA_subjectlists.Mca_fifthsem_subjectlist;
import MCA_subjectlists.Mca_firstsem_subjectlist;
import MCA_subjectlists.Mca_fourthsem_subjectlist;
import MCA_subjectlists.Mca_secondsem_subjectlist;
import MCA_subjectlists.Mca_thirdsem_subjectlist;

public class ComputerApplications_expendable_list extends AppCompatActivity {
    ExpandableListView expandableListView;
    List<String> branch;
    Map<String, List<String>> semester;
    ExpandableListAdapter listAdapter;
    int total_bca,total_mca;
    int bc01,bc02,bc03,mc01,mc02,mc03,mc04,mc05;
    DatabaseReference ref1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_applications_expendable_list);
        textView=findViewById(R.id.refresh);
        expandableListView=findViewById(R.id.computerapplications_expendable_list);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ComputerApplications_expendable_list.this,Expendable_loader.class);
                intent.putExtra("reference","computer_applications");
                startActivity(intent);
            }
        });

        ref1= FirebaseDatabase.getInstance().getReference("IN/KU/BC/01");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("EH")) {
                    bc01=bc01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("LR")) {
                    bc01=bc01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("MA")) {
                    bc01=bc01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("PC")) {
                    bc01=bc01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("WR")) {
                    bc01=bc01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("AG")) {
                    bc01=bc01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("OA")) {
                    bc01=bc01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("PY")) {
                    bc01=bc01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("SX")) {
                    bc01=bc01+(int)dataSnapshot.getChildrenCount();

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
        ref1= FirebaseDatabase.getInstance().getReference("IN/KU/BC/02");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("RD")) {
                    bc02=bc02+(int)dataSnapshot.getChildrenCount();

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
        ref1= FirebaseDatabase.getInstance().getReference("IN/KU/BC/03");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("CX")) {
                    bc03=bc03+(int)dataSnapshot.getChildrenCount();
                }

                total_bca=bc01+bc02+bc03;
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

        ref1= FirebaseDatabase.getInstance().getReference("IN/KU/MC/01");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("CZ")) {
                    mc01=mc01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("DU")) {
                    mc01=mc01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("NS")) {
                    mc01=mc01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("PC")) {
                    mc01=mc01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("SE")) {
                    mc01=mc01+(int)dataSnapshot.getChildrenCount();

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
        ref1= FirebaseDatabase.getInstance().getReference("IN/KU/MC/02");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("DS")) {
                    mc02=mc02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("OP")) {
                    mc02=mc02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("PF")) {
                    mc02=mc02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("SO")) {
                    mc02=mc02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("WT")) {
                    mc02=mc02+(int)dataSnapshot.getChildrenCount();
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
        ref1= FirebaseDatabase.getInstance().getReference("IN/KU/MC/03");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("CW")) {
                    mc03=mc03+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("DA")) {
                    mc03=mc03+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("DM")) {
                    mc03=mc03+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("OS")) {
                    mc03=mc03+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("OU")) {
                    mc03=mc03+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("VP")) {
                    mc03=mc03+(int)dataSnapshot.getChildrenCount();

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
        ref1= FirebaseDatabase.getInstance().getReference("IN/KU/MC/04");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("AH")) {
                    mc04=mc04+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("AL")) {
                    mc04=mc04+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("CM")) {
                    mc04=mc04+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("DW")) {
                    mc04=mc04+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("PV")) {
                    mc04=mc04+(int)dataSnapshot.getChildrenCount();

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
        ref1= FirebaseDatabase.getInstance().getReference("IN/KU/MC/05");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("AW")) {
                    mc05=mc05+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("CC")) {
                    mc05=mc05+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("CD")) {
                    mc05=mc05+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("CM")) {
                    mc05=mc05+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("LP")) {
                    mc05=mc05+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("MD")) {
                    mc05=mc05+(int)dataSnapshot.getChildrenCount();

                }

                filldata();
                    total_mca=mc01+mc02+mc03+mc04+mc05;
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
                if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition).equals("First semester " +"("+bc01+")")){
                    Intent i=new Intent(getBaseContext(), Bca_firstsem_subjectlist.class);
                    i.putExtra("key", "1");
                    startActivity(i);
                }
                if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition).equals("Second semester " +"("+bc02+")")){
                    Intent i=new Intent(getBaseContext(), Bca_secondsem_subjectlist.class);
                    i.putExtra("key", "2");
                    startActivity(i);
                }
                if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition).equals("Third semester " +"("+bc03+")")){
                    Intent i=new Intent(getBaseContext(), Bca_thirdsem_subjectlist.class);
                    i.putExtra("key", "3");
                    startActivity(i);
                }


                if((groupPosition)==1  && listAdapter.getChild(groupPosition,childPosition).equals("First semester " +"("+mc01+")")) {
                    Intent i=new Intent(getBaseContext(), Mca_firstsem_subjectlist.class);
                    i.putExtra("key", "1");
                    startActivity(i);
                }
                if((groupPosition)==1  && listAdapter.getChild(groupPosition,childPosition).equals("Second semester " +"("+mc02+")")) {
                    Intent i=new Intent(getBaseContext(), Mca_secondsem_subjectlist.class);
                    i.putExtra("key", "2");
                    startActivity(i);

                }
                if((groupPosition)==1 && listAdapter.getChild(groupPosition,childPosition).equals("Third semester "+"("+mc03+")")) {
                    Intent i=new Intent(getBaseContext(), Mca_thirdsem_subjectlist.class);
                    i.putExtra("key", "3");
                    startActivity(i);

                }
                if((groupPosition)==1 && listAdapter.getChild(groupPosition,childPosition).equals("Fourth semester "+"("+mc04+")")) {
                    Intent i=new Intent(getBaseContext(), Mca_fourthsem_subjectlist.class);
                    i.putExtra("key", "4");
                    startActivity(i);
                }
                if((groupPosition)==1 && listAdapter.getChild(groupPosition,childPosition).equals("Fifth semester "+"("+mc05+")")) {
                    Intent i=new Intent(getBaseContext(), Mca_fifthsem_subjectlist.class);
                    i.putExtra("key", "5");
                    startActivity(i);
                }
                return false;
            }
        });
    }

    public void filldata(){
        branch=new ArrayList<>();
        semester=new HashMap<>();

        branch.add("BCA" +"("+total_bca+")");
        branch.add("MCA"+"("+total_mca+")");

        List<String> first=new ArrayList<>();
        List<String> second=new ArrayList<>();

        first.add("First semester " +"("+bc01+")");
        first.add("Second semester "+"("+bc02+")");
        first.add("Third semester "+"("+bc03+")");

        second.add("First semester "+"("+mc01+")");
        second.add("Second semester "+"("+mc02+")");
        second.add("Third semester "+"("+mc03+")");
        second.add("Fourth semester "+"("+mc04+")");
        second.add("Fifth semester "+"("+mc05+")");

        semester.put(branch.get(0),first);
        semester.put(branch.get(1),second);

    }
    @Override
    public void onBackPressed()
    {
        Intent intent=new Intent(ComputerApplications_expendable_list.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("run counter","no");
        intent.putExtra("EXIT", true);
        startActivity(intent);
        finish();
    }
}
