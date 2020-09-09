package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

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
import HS_ME_subjectlists.Me_thirdsem_subjectlist;
import KU_CSE_subjectlists.Cse_fifthsem_subjectlist;
import KU_CSE_subjectlists.Cse_firstsem_subjectlist;
import KU_CSE_subjectlists.Cse_fourthsem_subjectlist;
import KU_CSE_subjectlists.Cse_secondsem_subjectlist;
import KU_CSE_subjectlists.Cse_sixthsem_subjectlist;
import KU_CSE_subjectlists.Cse_thirdsem_subjectlist;
import KU_ECE_subjectlists.Ece_fifthsem_subjectlist;
import KU_ECE_subjectlists.Ece_fourthsem_subjectlist;
import KU_ECE_subjectlists.Ece_sixthsem_subjectlist;
import KU_ECE_subjectlists.Ece_thirdsem_subjectlist;
import KU_ELE_subjectlists.Ele_fifthsem_subjectlist;
import KU_ELE_subjectlists.Ele_fourthsem_subjectlist;
import KU_ELE_subjectlists.Ele_sixthsem_subjectlist;
import KU_ELE_subjectlists.Ele_thirdsem_subjectlist;
import KU_IT_subjectlists.It_fifthsem_subjectlist;
import KU_IT_subjectlists.It_fourthsem_subjectlist;
import KU_IT_subjectlists.It_sixthsem_subjectlist;
import KU_IT_subjectlists.It_thirdsem_subjectlist;
import KU_ME_subjectlists.Me_fifthsem_subjectlist;
import KU_ME_subjectlists.Me_fourthsem_subjectlist;
import KU_ME_subjectlists.Me_sixthsem_subjectlist;

public class Diploma_expendable_list extends AppCompatActivity {
    ExpandableListView expandableListView;
    List<String> branch;
    Map<String, List<String>> semester;
    ExpandableListAdapter listAdapter;
    int common01,common02,cs03,cs04,cs05,cs06,ec03,ec04,ec05,ec06,cv03,cv04,cv05,cv06,el03,el05,el04,el06,me03,me04,me05,me06,ml01,ml04,ml02,ml03;
    int total_cse,total_ece,total_ml,total_el,total_me,total_cv;
    DatabaseReference ref1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btech_expendable_list);
        textView=findViewById(R.id.refresh);
        expandableListView=findViewById(R.id.btechexpendablelist);
        ref1= FirebaseDatabase.getInstance().getReference("IN/HS/CO/01");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                if(dataSnapshot.getKey().equals("S1")) {
                    common01=common01+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("M1")) {
                    common01=common01+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("P1")) {
                    common01=common01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("C1")) {
                    common01=common01+(int)dataSnapshot.getChildrenCount();

                }

                if(dataSnapshot.getKey().equals("D1")) {
                    common01=common01+(int)dataSnapshot.getChildrenCount();

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
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/CO/02");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                if(dataSnapshot.getKey().equals("S2")) {
                    common02=common02+(int)dataSnapshot.getChildrenCount();

                }

                if(dataSnapshot.getKey().equals("M2")) {
                    common02=common02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("P2")) {
                    common02=common02+(int)dataSnapshot.getChildrenCount();

                }

                if(dataSnapshot.getKey().equals("C2")) {
                    common02=common02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("AM")) {
                    common02=common02+(int)dataSnapshot.getChildrenCount();

                }

                if(dataSnapshot.getKey().equals("D2")) {
                    common02=common02+(int)dataSnapshot.getChildrenCount();

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
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/CS/03");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("BG")) {
                    cs03=cs03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("DS")) {
                    cs03=cs03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("DE")) {
                    cs03=cs03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("M3")) {
                    cs03=cs03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("OP")) {
                    cs03=cs03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("PL")) {
                    cs03=cs03+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/CS/04");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("CA")) {
                    cs04=cs04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("IF")) {
                    cs04=cs04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("MI")) {
                    cs04=cs04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("OP")) {
                    cs04=cs04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("OS")) {
                    cs04=cs04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("PL")) {
                    cs04=cs04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("DD")) {
                    cs04=cs04+(int)dataSnapshot.getChildrenCount();
                }

                // total_cse=total_cse+cs06;
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/CS/05");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("MS")) {
                    cs05=cs05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("AT")) {
                    cs05=cs05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EO")) {
                    cs06=cs06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("CO")) {
                    cs05=cs05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("DM")) {
                    cs05=cs05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("SS")) {
                    cs05=cs05+(int)dataSnapshot.getChildrenCount();
                }

                // total_cse=total_cse+cs06;
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/CS/06");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("AD")) {
                    cs06=cs06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("CD")) {
                    cs06=cs06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("CT")) {
                    cs06=cs06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EO")) {
                    cs06=cs06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("MC")) {
                    cs06=cs06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("NM")) {
                    cs06=cs06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("SE")) {
                    cs06=cs06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("WE")) {
                    cs06=cs06+(int)dataSnapshot.getChildrenCount();
                }

                total_cse=common01+common02+cs03+cs04+cs05+cs06;
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

        // ece paper counts
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/EC/03");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("OW")) {
                    ec03=ec03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("ER")) {
                    ec03=ec03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("DE")) {
                    ec03=ec03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("SS")) {
                    ec03=ec03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EO")) {
                    ec03=ec03+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/EC/04");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("AN")) {
                    ec04=ec04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("CA")) {
                    ec04=ec04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("DE")) {
                    ec04=ec04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("DT")) {
                    ec04=ec04+(int)dataSnapshot.getChildrenCount();
                }

                if(dataSnapshot.getKey().equals("EM")) {
                    ec04=ec04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EY")) {
                    ec04=ec04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("FW")) {
                    ec04=ec04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("MS")) {
                    ec04=ec04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("TA")) {
                    ec04=ec04+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/EC/05");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("CO")) {
                    ec05=ec05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("II")) {
                    ec05=ec05+(int)dataSnapshot.getChildrenCount();
                }

                if(dataSnapshot.getKey().equals("EW")) {
                    ec05=ec05+(int)dataSnapshot.getChildrenCount();
                }

                if(dataSnapshot.getKey().equals("DP")) {
                    ec05=ec05+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/EC/06");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("CE")) {
                    ec06=ec06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("CS")) {
                    ec06=ec06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("DO")) {
                    ec06=ec06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("DI")) {
                    ec06=ec06+(int)dataSnapshot.getChildrenCount();
                }

                if(dataSnapshot.getKey().equals("DP")) {
                    ec06=ec06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("VD")) {
                    ec06=ec06+(int)dataSnapshot.getChildrenCount();
                }
                total_ece=common01+common02+ec03+ec04+ec05+ec06;
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
        // Civil paper count
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/CV/03");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("FM")) {
                    cv03=cv03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("Y1")) {
                    cv03=cv03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("CM")) {
                    cv03=cv03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("BC")) {
                    cv03=cv03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("G1")) {
                    cv03=cv03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("SS")) {
                    cv03=cv03+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/CV/04");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("CT")) {
                    cv04=cv04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("WM")) {
                    cv04=cv04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("IG")) {
                    cv04=cv04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("Y2")) {
                    cv04=cv04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("RD")) {
                    cv04=cv04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("SS")) {
                    cv04=cv04+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/CV/05");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                if(dataSnapshot.getKey().equals("SD")) {
                    cv05=cv05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("HE")) {
                    cv05=cv05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("SE")) {
                    cv05=cv05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("IG")) {
                    cv05=cv05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("RD")) {
                    cv05=cv05+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/CV/06");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("EC")) {
                    cv06=cv06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("RT")) {
                    cv06=cv06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("QV")) {
                    cv06=cv06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("CD")) {
                    cv06=cv06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("CB")) {
                    cv06=cv06+(int)dataSnapshot.getChildrenCount();
                }

                if(dataSnapshot.getKey().equals("PC")) {
                    cv06=cv06+(int)dataSnapshot.getChildrenCount();
                }
                total_cv=common01+common02+cv03+cv04+cv05+cv06;
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
        
        // ELE paper count
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/EL/03");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("EM")) {
                    el03=el03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EI")) {
                    el03=el03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("E1")) {
                    el03=el03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("H1")) {
                    el03=el03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("N1")) {
                    el03=el03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("FE")) {
                    el03=el03+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/EL/04");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("B1")) {
                    el04=el04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("ES")) {
                    el04=el04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("E2")) {
                    el04=el04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("H2")) {
                    el04=el04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("IN")) {
                    el04=el04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("K1")) {
                    el04=el04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("U1")) {
                    el04=el04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("N2")) {
                    el04=el04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("DE")) {
                    el04=el04+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/EL/05");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("B2")) {
                    el05=el05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("L1")) {
                    el05=el05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EN")) {
                    el05=el05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("DM")) {
                    el05=el05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("K2")) {
                    el05=el05+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/EL/06");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("U2")) {
                    el06=el06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("L2")) {
                    el06=el06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("PL")) {
                    el06=el06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EY")) {
                    el06=el06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("OC")) {
                    el06=el06+(int)dataSnapshot.getChildrenCount();
                }
                total_el=common01+common02+el03+el04+el05+el06;
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
        // ME paper count
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/ME/03");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("SM")) {
                    me03=me03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("TS")) {
                    me03=me03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("BE")) {
                    me03=me03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("W1")) {
                    me03=me03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("MD")) {
                    me03=me03+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/ME/04");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("MM")) {
                    me04=me04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("IS")) {
                    me04=me04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("MG")) {
                    me04=me04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("W2")) {
                    me04=me04+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/ME/05");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//
                if(dataSnapshot.getKey().equals("TM")) {
                    me05=me05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("RC")) {
                    me05=me05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("CN")) {
                    me05=me05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("W3")) {
                    me05=me05+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/ME/06");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("AE")) {
                    me06=me06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("IC")) {
                    me06=me06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("IE")) {
                    me06=me06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("ED")) {
                    me06=me06+(int)dataSnapshot.getChildrenCount();
                }

                total_me=common01+common02+me03+me04+me05+me06;
                Log.e("total_me",total_me+"");
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

        // MLT paper count
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/ML/01");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("BY")) {
                    ml01=ml01+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("O1")) {
                    ml01=ml01+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("R1")) {
                    ml01=ml01+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("Z1")) {
                    ml01=ml01+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/ML/02");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//
                if(dataSnapshot.getKey().equals("A2")) {
                    ml02=ml02+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("O2")) {
                    ml02=ml02+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("OY")) {
                    ml02=ml02+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("R2")) {
                    ml02=ml02+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("Z2")) {
                    ml02=ml02+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/ML/03");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("O3")) {
                    ml03=ml03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("TN")) {
                    ml03=ml03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("X1")) {
                    ml03=ml03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("Z3")) {
                    ml03=ml03+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/HS/ML/04");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("EV")) {
                    ml04=ml04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("MN")) {
                    ml04=ml04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("O4")) {
                    ml04=ml04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("R4")) {
                    ml04=ml04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("X2")) {
                    ml04=ml04+(int)dataSnapshot.getChildrenCount();
                }
                filldata();
                total_ml=ml01+ml02+ml03+ml04;
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

       
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Diploma_expendable_list.this,Expendable_loader.class);
                intent.putExtra("reference","diploma");
                startActivity(intent);

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition).equals("First semester " +"("+common01+")")) {
                    Intent i=new Intent(getBaseContext(),HS_CO_subjectlists.Co_firstsem_subjectlist.class);
                    i.putExtra("key", "Computer science 1st semester");
                    startActivity(i);
                    Toast.makeText(Diploma_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
                }
                if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition).equals("Second semester " +"("+common02+")")) {
                    Intent i=new Intent(getBaseContext(),HS_CO_subjectlists.Co_secondsem_subjectlist.class);
                    i.putExtra("key", "Computer science 2nd semester");
                    startActivity(i);
                    Toast.makeText(Diploma_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
                }
                if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition).equals("Third semester " +"("+cs03+")")) {
                    Intent i=new Intent(getBaseContext(), Cse_thirdsem_subjectlist.class);
                    i.putExtra("key", "Computer science 3rd semester");
                    startActivity(i);
                    Toast.makeText(Diploma_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
                }
                if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition).equals("Fourth semester " +"("+cs04+")")) {
                    Intent i=new Intent(getBaseContext(), Cse_fourthsem_subjectlist.class);
                    i.putExtra("key", "Computer science 4th semester");
                    startActivity(i);
                    Toast.makeText(Diploma_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
                }
                if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition).equals("Fifth semester " +"("+cs05+")")) {
                    Intent i=new Intent(getBaseContext(), Cse_fifthsem_subjectlist.class);
                    i.putExtra("key", "Computer science 5th semester");
                    startActivity(i);
                    Toast.makeText(Diploma_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
                }
                if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition).equals("Sixth semester " +"("+cs06+")")) {
                    Intent i=new Intent(getBaseContext(), Cse_sixthsem_subjectlist.class);
                    i.putExtra("key", "Computer science 6th semester");
                    startActivity(i);
                    Toast.makeText(Diploma_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
                }
                
                if((groupPosition)==1 && listAdapter.getChild(groupPosition,childPosition).equals("First semester " +"("+common01+")")) {
                    Intent i=new Intent(getBaseContext(),HS_CO_subjectlists.Co_firstsem_subjectlist.class);
                    i.putExtra("key", "Civil 1st semester");
                    startActivity(i);
                }
                if((groupPosition)==1 && listAdapter.getChild(groupPosition,childPosition).equals("Second semester " +"("+common02+")")) {
                    Intent i=new Intent(getBaseContext(),HS_CO_subjectlists.Co_secondsem_subjectlist.class);
                    i.putExtra("key", "Civil 2nd semester");
                    startActivity(i);
                }
                if((groupPosition)==1 && listAdapter.getChild(groupPosition,childPosition).equals("Third semester "+"("+cv03+")")) {
                    Intent i=new Intent(getBaseContext(), HS_CV_subjectlists.Cv_thirdsem_subjectlist.class);
                    i.putExtra("key", "Civil 3rd semester");
                    startActivity(i);
                }
                if((groupPosition)==1 && listAdapter.getChild(groupPosition,childPosition).equals("Fourth semester "+"("+cv04+")")) {
                    Intent i=new Intent(getBaseContext(), HS_CV_subjectlists.Cv_fourthsem_subjectlist.class);
                    i.putExtra("key", "Civil 4th semester");
                    startActivity(i);

                }
                if((groupPosition)==1 && listAdapter.getChild(groupPosition,childPosition).equals("Fifth semester "+"("+cv05+")")) {
                    Intent i=new Intent(getBaseContext(), HS_CV_subjectlists.Cv_fifthsem_subjectlist.class);
                    i.putExtra("key", "Civil 5th semester");
                    startActivity(i);
                }
                if((groupPosition)==1 && listAdapter.getChild(groupPosition,childPosition).equals("Sixth semester "+"("+cv06+")")) {
                    Intent i=new Intent(getBaseContext(), HS_CV_subjectlists.Cv_sixthsem_subjectlist.class);
                    i.putExtra("key", "Civil 6th semester");
                    startActivity(i);
                }
                
                if((groupPosition)==2  && listAdapter.getChild(groupPosition,childPosition).equals("First semester " +"("+common01+")")) {
                    Intent i=new Intent(getBaseContext(),HS_CO_subjectlists.Co_firstsem_subjectlist.class);
                    i.putExtra("key", "Mechanical 1st semester");
                    startActivity(i);

                }
                if((groupPosition)==2  && listAdapter.getChild(groupPosition,childPosition).equals("Second semester " +"("+common02+")")) {
                    Intent i=new Intent(getBaseContext(),HS_CO_subjectlists.Co_secondsem_subjectlist.class);
                    i.putExtra("key", "Mechanical 2nd semester");
                    startActivity(i);
                }
                if((groupPosition)==2 && listAdapter.getChild(groupPosition,childPosition).equals("Third semester "+"("+me03+")")) {
                    Intent i=new Intent(getBaseContext(), HS_ME_subjectlists.Me_thirdsem_subjectlist.class);
                    i.putExtra("key", "Mechanical 3rd semester");
                    startActivity(i);
                }
                if((groupPosition)==2 && listAdapter.getChild(groupPosition,childPosition).equals("Fourth semester "+"("+me04+")")) {
                    Intent i=new Intent(getBaseContext(), HS_ME_subjectlists.Me_fourthsem_subjectlist.class);
                    i.putExtra("key", "Mechanical 4th semester");
                    startActivity(i);
                }
                if((groupPosition)==2 && listAdapter.getChild(groupPosition,childPosition).equals("Fifth semester "+"("+me05+")")) {
                    Intent i=new Intent(getBaseContext(), HS_ME_subjectlists.Me_fifthsem_subjectlist.class);
                    i.putExtra("key", "Mechanical 5th semester");
                    startActivity(i);
                }
                if((groupPosition)==2 && listAdapter.getChild(groupPosition,childPosition).equals("Sixth semester "+"("+me06+")")) {
                    Intent i=new Intent(getBaseContext(), HS_ME_subjectlists.Me_sixthsem_subjectlist.class);
                    i.putExtra("key", "Mechanical 6th semester");
                    startActivity(i);
                }
              

                if((groupPosition)==3  && listAdapter.getChild(groupPosition,childPosition).equals("First semester " +"("+common01+")")) {
                    Intent i=new Intent(getBaseContext(),HS_CO_subjectlists.Co_firstsem_subjectlist.class);
                    i.putExtra("key", "Electronics and comm. 1st semester");
                    startActivity(i);
                }
                if((groupPosition)==3  && listAdapter.getChild(groupPosition,childPosition).equals("Second semester " +"("+common02+")")) {
                    Intent i=new Intent(getBaseContext(),HS_CO_subjectlists.Co_secondsem_subjectlist.class);
                    i.putExtra("key", "Electronics and comm. 2nd semester");
                    startActivity(i);
                }
                if((groupPosition)==3 && listAdapter.getChild(groupPosition,childPosition).equals("Third semester "+"("+ec03+")")) {
                    Intent i=new Intent(getBaseContext(), Ece_thirdsem_subjectlist.class);
                    i.putExtra("key", "Electronics and comm. 3rd semester");
                    startActivity(i);
                }
                if((groupPosition)==3 && listAdapter.getChild(groupPosition,childPosition).equals("Fourth semester "+"("+ec04+")")) {
                    Intent i=new Intent(getBaseContext(), Ece_fourthsem_subjectlist.class);
                    i.putExtra("key", "Electronics and comm. 4th semester");
                    startActivity(i);

                }
                if((groupPosition)==3 && listAdapter.getChild(groupPosition,childPosition).equals("Fifth semester "+"("+ec05+")")) {
                    Intent i=new Intent(getBaseContext(), Ece_fifthsem_subjectlist.class);
                    i.putExtra("key", "Electronics and comm. 5th semester");
                    startActivity(i);
                }
                if((groupPosition)==3 && listAdapter.getChild(groupPosition,childPosition).equals("Sixth semester "+"("+ec06+")")) {
                    Intent i=new Intent(getBaseContext(), Ece_sixthsem_subjectlist.class);
                    i.putExtra("key", "Electronics and comm. 6th semester");
                    startActivity(i);

                }


                if((groupPosition)==4  && listAdapter.getChild(groupPosition,childPosition).equals("First semester " +"("+common01+")")) {
                    Intent i=new Intent(getBaseContext(),HS_CO_subjectlists.Co_firstsem_subjectlist.class);
                    i.putExtra("key", "Electrical 1st semester");
                    startActivity(i);
                }
                if((groupPosition)==4  && listAdapter.getChild(groupPosition,childPosition).equals("Second semester " +"("+common02+")")) {
                    Intent i=new Intent(getBaseContext(),HS_CO_subjectlists.Co_secondsem_subjectlist.class);
                    i.putExtra("key", "Electrical 2nd semester");
                    startActivity(i);
                }
                if((groupPosition)==4 && listAdapter.getChild(groupPosition,childPosition).equals("Third semester "+"("+el03+")")) {
                    Intent i=new Intent(getBaseContext(), HS_ELE_subjectlists.Ele_thirdsem_subjectlist.class);
                    i.putExtra("key", "Electrical 3rd semester");
                    startActivity(i);
                }
                if((groupPosition)==4 && listAdapter.getChild(groupPosition,childPosition).equals("Fourth semester "+"("+el04+")")) {
                    Intent i=new Intent(getBaseContext(),HS_ELE_subjectlists.Ele_fourthsem_subjectlist.class);
                    i.putExtra("key", "Electrical 4th semester");
                    startActivity(i);
                }
                if((groupPosition)==4 && listAdapter.getChild(groupPosition,childPosition).equals("Fifth semester "+"("+el05+")")) {
                    Intent i=new Intent(getBaseContext(), HS_ELE_subjectlists.Ele_fifthsem_subjectlist.class);
                    i.putExtra("key", "Electrical 5th semester");
                    startActivity(i);
                }
                if((groupPosition)==4 && listAdapter.getChild(groupPosition,childPosition).equals("Sixth semester "+"("+el06+")")) {
                    Intent i=new Intent(getBaseContext(), HS_ELE_subjectlists.Ele_sixthsem_subjectlist.class);
                    i.putExtra("key", "Electrical 6th semester");
                    startActivity(i);
                }

                if((groupPosition)==5  && listAdapter.getChild(groupPosition,childPosition).equals("First semester " +"("+ml01+")")) {
                    Intent i=new Intent(getBaseContext(),HS_ML_subjectlists.Ml_firstsem_subjectlist.class);
                    i.putExtra("key", "MLT 1st semester");
                    startActivity(i);
                }
                if((groupPosition)==5  && listAdapter.getChild(groupPosition,childPosition).equals("Second semester " +"("+ml02+")")) {
                    Intent i=new Intent(getBaseContext(),HS_ML_subjectlists.Ml_secondsem_subjectlist.class);
                    i.putExtra("key", "MLT 2nd semester");
                    startActivity(i);
                }
                if((groupPosition)==5 && listAdapter.getChild(groupPosition,childPosition).equals("Third semester "+"("+ml03+")")) {
                    Intent i=new Intent(getBaseContext(), HS_ML_subjectlists.Ml_thirdsem_subjectlist.class);
                    i.putExtra("key", "MLT 3rd semester");
                    startActivity(i);
                }
                if((groupPosition)==5 && listAdapter.getChild(groupPosition,childPosition).equals("Fourth semester "+"("+ml04+")")) {
                    Intent i=new Intent(getBaseContext(),HS_ML_subjectlists.Ml_fourthsem_subjectlist.class);
                    i.putExtra("key", "MLT 4th semester");
                    startActivity(i);
                }



                return false;
            }
        });
    }
    public void filldata(){
        branch=new ArrayList<>();
        semester=new HashMap<>();

        branch.add("Computer Science Engineering " +"("+total_cse+")");
        branch.add("Civil Engineering "+"("+total_cv+")");
        branch.add("Mechanical Engineering "+"("+total_me+")");
        branch.add("Electronics and Communication Engg. "+"("+total_ece+")");
        branch.add("Electrical Engineering "+"("+total_el+")");
        branch.add("Medical Lab Technology"+"("+total_ml+")");

        List<String> first=new ArrayList<>();
        List<String> second=new ArrayList<>();
        List<String> third=new ArrayList<>();
        List<String> fourth=new ArrayList<>();
        List<String> fifth=new ArrayList<>();
        List<String> sixth=new ArrayList<>();

        first.add("First semester " +"("+common01+")");
        first.add("Second semester "+"("+common02+")");
        first.add("Third semester "+"("+cs03+")");
        first.add("Fourth semester "+"("+cs04+")");
        first.add("Fifth semester "+"("+cs05+")");
        first.add("Sixth semester "+"("+cs06+")");

        second.add("First semester "+"("+common01+")");
        second.add("Second semester "+"("+common02+")");
        second.add("Third semester "+"("+cv03+")");
        second.add("Fourth semester "+"("+cv04+")");
        second.add("Fifth semester "+"("+cv05+")");
        second.add("Sixth semester "+"("+cv06+")");

        third.add("First semester "+"("+common01+")");
        third.add("Second semester "+"("+common02+")");
        third.add("Third semester "+"("+me03+")");
        third.add("Fourth semester "+"("+me04+")");
        third.add("Fifth semester "+"("+me05+")");
        third.add("Sixth semester "+"("+me06+")");

        fourth.add("First semester "+"("+common01+")");
        fourth.add("Second semester "+"("+common02+")");
        fourth.add("Third semester "+"("+ec03+")");
        fourth.add("Fourth semester "+"("+ec04+")");
        fourth.add("Fifth semester "+"("+ec05+")");
        fourth.add("Sixth semester "+"("+ec06+")");

        fifth.add("First semester "+"("+common01+")");
        fifth.add("Second semester "+"("+common02+")");
        fifth.add("Third semester "+"("+el03+")");
        fifth.add("Fourth semester "+"("+el04+")");
        fifth.add("Fifth semester "+"("+el05+")");
        fifth.add("Sixth semester "+"("+el06+")");

        sixth.add("First semester "+"("+ml01+")");
        sixth.add("Second semester "+"("+ml02+")");
        sixth.add("Third semester "+"("+ml03+")");
        sixth.add("Fourth semester "+"("+ml04+")");

        semester.put(branch.get(0),first);
        semester.put(branch.get(1),second);
        semester.put(branch.get(2),third);
        semester.put(branch.get(3),fourth);
        semester.put(branch.get(4),fifth);
        semester.put(branch.get(5),sixth);

    }
    @Override
    public void onBackPressed()
    {
        Intent intent=new Intent(Diploma_expendable_list.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("run counter","no");
        intent.putExtra("EXIT", true);
        startActivity(intent);
        finish();

    }
}