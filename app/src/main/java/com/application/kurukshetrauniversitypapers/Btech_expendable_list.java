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
import KU_CSE_subjectlists.Cse_eightsem_subjectlist;
import KU_CSE_subjectlists.Cse_fifthsem_subjectlist;
import KU_CSE_subjectlists.Cse_firstsem_subjectlist;
import KU_CSE_subjectlists.Cse_fourthsem_subjectlist;
import KU_CSE_subjectlists.Cse_secondsem_subjectlist;
import KU_CSE_subjectlists.Cse_seventhsem_subjectlist;
import KU_CSE_subjectlists.Cse_sixthsem_subjectlist;
import KU_CSE_subjectlists.Cse_thirdsem_subjectlist;
import KU_ECE_subjectlists.Ece_eightsem_subjectlist;
import KU_ECE_subjectlists.Ece_fifthsem_subjectlist;
import KU_ECE_subjectlists.Ece_fourthsem_subjectlist;
import KU_ECE_subjectlists.Ece_sixthsem_subjectlist;
import KU_ECE_subjectlists.Ece_seventhsem_subjectlist;
import KU_ECE_subjectlists.Ece_thirdsem_subjectlist;
import KU_ELE_subjectlists.Ele_eightsem_subjectlist;
import KU_ELE_subjectlists.Ele_fifthsem_subjectlist;
import KU_ELE_subjectlists.Ele_fourthsem_subjectlist;
import KU_ELE_subjectlists.Ele_seventhsem_subjectlist;
import KU_ELE_subjectlists.Ele_sixthsem_subjectlist;
import KU_ELE_subjectlists.Ele_thirdsem_subjectlist;
import KU_IT_subjectlists.It_eightsem_subjectlist;
import KU_IT_subjectlists.It_fifthsem_subjectlist;
import KU_IT_subjectlists.It_fourthsem_subjectlist;
import KU_IT_subjectlists.It_seventhsem_subjectlist;
import KU_IT_subjectlists.It_sixthsem_subjectlist;
import KU_IT_subjectlists.It_thirdsem_subjectlist;
import KU_ME_subjectlists.Me_eightsem_subjectlist;
import KU_ME_subjectlists.Me_fifthsem_subjectlist;
import KU_ME_subjectlists.Me_fourthsem_subjectlist;
import KU_ME_subjectlists.Me_seventhsem_subjectlist;
import KU_ME_subjectlists.Me_sixthsem_subjectlist;
import KU_ME_subjectlists.Me_thirdsem_subjectlist;

public class Btech_expendable_list extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> branch;
    Map<String, List<String>> semester;
    ExpandableListAdapter listAdapter;
    int cs01,cs02,cs03,cs04,cs05,cs06,cs07,cs08,ec03,ec04,ec05,ec06,ec07,ec08,it03,it04,it05,it06,it07,it08,el03,el05,el04,el06,el07,el08,me03,me04,me05,me06,me07,me08;
    int total_cse,total_ece,total_it,total_el,total_me;
    DatabaseReference ref1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btech_expendable_list);
        textView=findViewById(R.id.refresh);
        expandableListView=findViewById(R.id.btechexpendablelist);
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/CS/01");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                if(dataSnapshot.getKey().equals("EE")) {
                    cs01=cs01+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("BI")) {
                    cs01=cs01+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("CU")) {
                    cs01=cs01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("CH")) {
                    cs01=cs01+(int)dataSnapshot.getChildrenCount();

                }

                if(dataSnapshot.getKey().equals("ED")) {
                    cs01=cs01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("EH")) {
                    cs01=cs01+(int)dataSnapshot.getChildrenCount();

                }

                if(dataSnapshot.getKey().equals("PP")) {
                    cs01=cs01+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("SH")) {
                    cs01=cs01+(int)dataSnapshot.getChildrenCount();

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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/CS/02");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                if(dataSnapshot.getKey().equals("BI")) {
                    cs02=cs02+(int)dataSnapshot.getChildrenCount();

                }

                if(dataSnapshot.getKey().equals("CH")) {
                    cs02=cs02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("EE")) {
                    cs02=cs02+(int)dataSnapshot.getChildrenCount();

                }

                if(dataSnapshot.getKey().equals("ED")) {
                    cs02=cs02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("EH")) {
                    cs02=cs02+(int)dataSnapshot.getChildrenCount();

                }

                if(dataSnapshot.getKey().equals("PS")) {
                    cs02=cs02+(int)dataSnapshot.getChildrenCount();

                }
                if(dataSnapshot.getKey().equals("PP")) {
                    cs02=cs02+(int)dataSnapshot.getChildrenCount();

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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/CS/03");
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/CS/04");
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/CS/05");
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/CS/06");
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/CS/07");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                if(dataSnapshot.getKey().equals("CG")) {
                    cs07=cs07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("CI")) {
                    cs07=cs07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("ES")) {
                    cs07=cs07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("UL")) {
                    cs07=cs07+(int)dataSnapshot.getChildrenCount();
                }

                Log.e("7 sem",cs07+"");
                // total_cse=total_cse+cs07;
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/CS/08");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("CC")) {
                    cs08=cs08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("DW")) {
                    cs08=cs08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("IC")) {
                    cs08=cs08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("MD")) {
                    cs08=cs08+(int)dataSnapshot.getChildrenCount();
                }

                if(dataSnapshot.getKey().equals("NL")) {
                    cs08=cs08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("NO")) {
                    cs08=cs08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("ST")) {
                    cs08=cs08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("SV")) {
                    cs08=cs08+(int)dataSnapshot.getChildrenCount();
                }
                Log.e("total_cse",total_cse+"");
                total_cse=cs01+cs02+cs03+cs04+cs05+cs06+cs07+cs08;
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/EC/03");
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/EC/04");
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/EC/05");
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/EC/06");
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/EC/07");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                if(dataSnapshot.getKey().equals("RE")) {
                    ec07=ec07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("TE")) {
                    ec07=ec07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("AI")) {
                    ec07=ec07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("ME")) {
                    ec07=ec07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("MP")) {
                    ec07=ec07+(int)dataSnapshot.getChildrenCount();
                }

                if(dataSnapshot.getKey().equals("OC")) {
                    ec07=ec07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("VL")) {
                    ec07=ec07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("FW")) {
                    ec07=ec07+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/EC/08");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("EI")) {
                    ec08=ec08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("MU")) {
                    ec08=ec08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("RA")) {
                    cs08=cs08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("TA")) {
                    ec08=ec08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("WI")) {
                    ec08=ec08+(int)dataSnapshot.getChildrenCount();
                }

                Log.e("total_ece",total_ece+"");
                total_ece=cs01+cs02+ec03+ec04+ec05+ec06+ec07+ec08;
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
        // IT paper count
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/IT/03");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("M3")) {
                    it03=it03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("DS")) {
                    it03=it03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("DE")) {
                    it03=it03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("FN")) {
                    it03=it03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("OP")) {
                    it03=it03+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/IT/04");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("CO")) {
                    it04=it04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("OP")) {
                    it04=it04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("OS")) {
                    it04=it04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("PL")) {
                    it04=it04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("FI")) {
                    it04=it04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EY")) {
                    it04=it04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("FR")) {
                    it04=it04+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/IT/05");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                if(dataSnapshot.getKey().equals("IU")) {
                    it05=it05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("CO")) {
                    it05=it05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("CM")) {
                    it05=it05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("JP")) {
                    it05=it05+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/IT/06");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("CM")) {
                    it06=it06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("CN")) {
                    it06=it06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("DA")) {
                    it06=it06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("MM")) {
                    it06=it06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("SE")) {
                    it06=it06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("IM")) {
                    it06=it04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("DW")) {
                    it06=it04+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/IT/07");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("AL")) {
                    it07=it07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("BC")) {
                    it07=it07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("CD")) {
                    it07=it07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EC")) {
                    it07=it07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("LS")) {
                    it07=it07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("FE")) {
                    it07=it07+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/IT/08");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("AA")) {
                    it08=it08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("CI")) {
                    it08=it08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("DW")) {
                    it08=it08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("MB")) {
                    it08=it08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EI")) {
                    it08=it08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("IO")) {
                    it08=it08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("ES")) {
                    it08=it08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("AV")) {
                    it08=it08+(int)dataSnapshot.getChildrenCount();
                }
                total_it=cs01+cs02+it03+it04+it05+it06+it07+it08;
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/EL/03");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("AN")) {
                    el03=el03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("CY")) {
                    el03=el03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EA")) {
                    el03=el03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EJ")) {
                    el03=el03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EK")) {
                    el03=el03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("ER")) {
                    el03=el03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EX")) {
                    el03=el03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("NA")) {
                    el03=el03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("PO")) {
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/EL/04");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("CY")) {
                    el04=el04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("DE")) {
                    el04=el04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EA")) {
                    el04=el04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EG")) {
                    el04=el04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EM")) {
                    el04=el04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("PG")) {
                    el04=el04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("SS")) {
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/EL/05");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("AN")) {
                    el05=el05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("CS")) {
                    el05=el05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("CY")) {
                    el05=el05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EJ")) {
                    el05=el05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("FW")) {
                    el05=el05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("NC")) {
                    el05=el05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("PE")) {
                    el05=el05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("PO")) {
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/EL/06");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("AE")) {
                    el06=el06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("DP")) {
                    el06=el06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EN")) {
                    el06=el06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EZ")) {
                    el06=el06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("MP")) {
                    el06=el06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("MS")) {
                    el06=el06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("PE")) {
                    el06=el06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("PN")) {
                    el06=el06+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/EL/07");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("DN")) {
                    el07=el07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EZ")) {
                    el07=el07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("HV")) {
                    el07=el07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("NC")) {
                    el07=el07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("TA")) {
                    el07=el07+(int)dataSnapshot.getChildrenCount();
                }
                 total_el=cs01+cs02+el04+el06+el07+el08;
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/EL/08");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("CP")) {
                    el08=el08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EG")) {
                    el08=el08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("IF")) {
                    el08=el08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("OR")) {
                    el08=el08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("UT")) {
                    el08=el08+(int)dataSnapshot.getChildrenCount();
                }
                total_el=cs01+cs02+el03+el04+el05+el06+el07+el08;
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/ME/03");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("TD")) {
                    me03=me03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("M3")) {
                    me03=me03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("TM")) {
                    me03=me03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("OW")) {
                    me03=me03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("BF")) {
                    me03=me03+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("MO")) {
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/ME/04");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("DY")) {
                    me04=me04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("FM")) {
                    me04=me04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("MO")) {
                    me04=me04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("MT")) {
                    me04=me04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("PT")) {
                    me04=me04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("SG")) {
                    me04=me04+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("SL")) {
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/ME/05");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                if(dataSnapshot.getKey().equals("GE")) {
//                    me05=me05+(int)dataSnapshot.getChildrenCount();
//                }
//                if(dataSnapshot.getKey().equals("FM")) {
//                    me05=me05+(int)dataSnapshot.getChildrenCount();
//                }
                if(dataSnapshot.getKey().equals("HT")) {
                    me05=me05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("EP")) {
                    me05=me05+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("TV")) {
                    me05=me05+(int)dataSnapshot.getChildrenCount();
                }
//                if(dataSnapshot.getKey().equals("SG")) {
//                    me05=me05+(int)dataSnapshot.getChildrenCount();
//                }
                if(dataSnapshot.getKey().equals("PT")) {
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/ME/06");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("CF")) {
                    me06=me06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("MN")) {
                    me06=me06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("MV")) {
                    me06=me06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("OR")) {
                    me06=me06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("RC")) {
                    me06=me06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("TV")) {
                    me06=me06+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("TY")) {
                    me06=me06+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/ME/07");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("AF")) {
                    me07=me07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("CF")) {
                    me07=me07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("PI")) {
                    me07=me07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("MR")) {
                    me07=me07+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("SQ")) {
                    me07=me07+(int)dataSnapshot.getChildrenCount();
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
        ref1=FirebaseDatabase.getInstance().getReference("IN/KU/ME/08");
        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals("EP")) {
                    me08=me08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("MM")) {
                    me08=me08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("NG")) {
                    me08=me08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("OR")) {
                    me08=me08+(int)dataSnapshot.getChildrenCount();
                }
                if(dataSnapshot.getKey().equals("PI")) {
                    me08=me08+(int)dataSnapshot.getChildrenCount();
                }
                total_me=cs01+cs02+me03+me04+me05+me06+me07+me08;
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



        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Btech_expendable_list.this,Expendable_loader.class);
                intent.putExtra("reference","btech");
                startActivity(intent);

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition).equals("First semester " +"("+cs01+")")) {
                    Intent i=new Intent(getBaseContext(), Cse_firstsem_subjectlist.class);
                    i.putExtra("key", "Computer science 1st semester");
                    startActivity(i);
                    Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
                }
                if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition).equals("Second semester " +"("+cs02+")")) {
                    Intent i=new Intent(getBaseContext(), Cse_secondsem_subjectlist.class);
                    i.putExtra("key", "Computer science 2nd semester");
                    startActivity(i);
                    Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
                }
                if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition).equals("Third semester " +"("+cs03+")")) {
                    Intent i=new Intent(getBaseContext(), Cse_thirdsem_subjectlist.class);
                    i.putExtra("key", "Computer science 3rd semester");
                    startActivity(i);
                    Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
                }
                if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition).equals("Fourth semester " +"("+cs04+")")) {
                    Intent i=new Intent(getBaseContext(), Cse_fourthsem_subjectlist.class);
                    i.putExtra("key", "Computer science 4th semester");
                    startActivity(i);
                    Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
                }
                if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition).equals("Fifth semester " +"("+cs05+")")) {
                    Intent i=new Intent(getBaseContext(), Cse_fifthsem_subjectlist.class);
                    i.putExtra("key", "Computer science 5th semester");
                    startActivity(i);
                    Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
                }
                if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition).equals("Sixth semester " +"("+cs06+")")) {
                    Intent i=new Intent(getBaseContext(), Cse_sixthsem_subjectlist.class);
                    i.putExtra("key", "Computer science 6th semester");
                    startActivity(i);
                    Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
                }
                if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition).equals("Seventh semester " +"("+cs07+")")) {
                    Intent i=new Intent(getBaseContext(), Cse_seventhsem_subjectlist.class);
                    i.putExtra("key", "Computer science 7th semester");
                    startActivity(i);
                    Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
                }
                if((groupPosition)==0 && listAdapter.getChild(groupPosition,childPosition).equals("Eight semester " +"("+cs08+")")) {
                    Intent i=new Intent(getBaseContext(), Cse_eightsem_subjectlist.class);
                    i.putExtra("key", "Computer science 8th semester");
                    startActivity(i);
                    Toast.makeText(Btech_expendable_list.this, "Loading", Toast.LENGTH_SHORT).show();
                }

                if((groupPosition)==1 && listAdapter.getChild(groupPosition,childPosition).equals("First semester " +"("+cs01+")")) {
                    Intent i=new Intent(getBaseContext(),Cse_firstsem_subjectlist.class);
                    i.putExtra("key", "Information technology 1st semester");
                    startActivity(i);

//
                }
                if((groupPosition)==1 && listAdapter.getChild(groupPosition,childPosition).equals("Second semester " +"("+cs02+")")) {
                    Intent i=new Intent(getBaseContext(),Cse_secondsem_subjectlist.class);
                    i.putExtra("key", "Information technology 2nd semester");
                    startActivity(i);
                }
                if((groupPosition)==1 && listAdapter.getChild(groupPosition,childPosition).equals("Third semester "+"("+it03+")")) {
                    Intent i=new Intent(getBaseContext(), It_thirdsem_subjectlist.class);
                    i.putExtra("key", "Information technology 3rd semester");
                    startActivity(i);
                }
                if((groupPosition)==1 && listAdapter.getChild(groupPosition,childPosition).equals("Fourth semester "+"("+it04+")")) {
                    Intent i=new Intent(getBaseContext(), It_fourthsem_subjectlist.class);
                    i.putExtra("key", "Information technology 4th semester");
                    startActivity(i);

                }
                if((groupPosition)==1 && listAdapter.getChild(groupPosition,childPosition).equals("Fifth semester "+"("+it05+")")) {
                    Intent i=new Intent(getBaseContext(), It_fifthsem_subjectlist.class);
                    i.putExtra("key", "Information technology 5th semester");
                    startActivity(i);
                }
                if((groupPosition)==1 && listAdapter.getChild(groupPosition,childPosition).equals("Sixth semester "+"("+it06+")")) {
                    Intent i=new Intent(getBaseContext(), It_sixthsem_subjectlist.class);
                    i.putExtra("key", "Information technology 6th semester");
                    startActivity(i);
                }
                if((groupPosition)==1 && listAdapter.getChild(groupPosition,childPosition).equals("Seventh semester "+"("+it07+")")) {
                    Intent i=new Intent(getBaseContext(), It_seventhsem_subjectlist.class);
                    i.putExtra("key", "Information technology 7th semester");
                    startActivity(i);
                }
                if((groupPosition)==1 && listAdapter.getChild(groupPosition,childPosition).equals("Eight semester "+"("+it08+")")) {
                    Intent i=new Intent(getBaseContext(), It_eightsem_subjectlist.class);
                    i.putExtra("key", "Information technology 8th semester");
                    startActivity(i);
                }

                if((groupPosition)==2  && listAdapter.getChild(groupPosition,childPosition).equals("First semester " +"("+cs01+")")) {
                    Intent i=new Intent(getBaseContext(),Cse_firstsem_subjectlist.class);
                    i.putExtra("key", "Mechanical 1st semester");
                    startActivity(i);

                }
                if((groupPosition)==2  && listAdapter.getChild(groupPosition,childPosition).equals("Second semester " +"("+cs02+")")) {
                    Intent i=new Intent(getBaseContext(),Cse_secondsem_subjectlist.class);
                    i.putExtra("key", "Mechanical 2nd semester");
                    startActivity(i);
                }
                if((groupPosition)==2 && listAdapter.getChild(groupPosition,childPosition).equals("Third semester "+"("+me03+")")) {
                    Intent i=new Intent(getBaseContext(),Me_thirdsem_subjectlist.class);
                    i.putExtra("key", "Mechanical 3rd semester");
                    startActivity(i);
                }
                if((groupPosition)==2 && listAdapter.getChild(groupPosition,childPosition).equals("Fourth semester "+"("+me04+")")) {
                    Intent i=new Intent(getBaseContext(),Me_fourthsem_subjectlist.class);
                    i.putExtra("key", "Mechanical 4th semester");
                    startActivity(i);
                }
                if((groupPosition)==2 && listAdapter.getChild(groupPosition,childPosition).equals("Fifth semester "+"("+me05+")")) {
                    Intent i=new Intent(getBaseContext(),Me_fifthsem_subjectlist.class);
                    i.putExtra("key", "Mechanical 5th semester");
                    startActivity(i);
                }
                if((groupPosition)==2 && listAdapter.getChild(groupPosition,childPosition).equals("Sixth semester "+"("+me06+")")) {
                    Intent i=new Intent(getBaseContext(),Me_sixthsem_subjectlist.class);
                    i.putExtra("key", "Mechanical 6th semester");
                    startActivity(i);
                }
                if((groupPosition)==2 && listAdapter.getChild(groupPosition,childPosition).equals("Seventh semester "+"("+me07+")")) {
                    Intent i=new Intent(getBaseContext(),Me_seventhsem_subjectlist.class);
                    i.putExtra("key", "Mechanical 7th semester");
                    startActivity(i);
                }
                if((groupPosition)==2 && listAdapter.getChild(groupPosition,childPosition).equals("Eight semester "+"("+me08+")")) {
                    Intent i=new Intent(getBaseContext(),Me_eightsem_subjectlist.class);
                    i.putExtra("key", "Mechanical 8th semester");
                    startActivity(i);
                }

                if((groupPosition)==3  && listAdapter.getChild(groupPosition,childPosition).equals("First semester " +"("+cs01+")")) {
                    Intent i=new Intent(getBaseContext(),Cse_firstsem_subjectlist.class);
                    i.putExtra("key", "Electronics and comm. 1st semester");
                    startActivity(i);
                }
                if((groupPosition)==3  && listAdapter.getChild(groupPosition,childPosition).equals("Second semester " +"("+cs02+")")) {
                    Intent i=new Intent(getBaseContext(),Cse_secondsem_subjectlist.class);
                    i.putExtra("key", "Electronics and comm. 2nd semester");
                    startActivity(i);
                }
                if((groupPosition)==3 && listAdapter.getChild(groupPosition,childPosition).equals("Third semester "+"("+ec03+")")) {
                    Intent i=new Intent(getBaseContext(),Ece_thirdsem_subjectlist.class);
                    i.putExtra("key", "Electronics and comm. 3rd semester");
                    startActivity(i);
                }
                if((groupPosition)==3 && listAdapter.getChild(groupPosition,childPosition).equals("Fourth semester "+"("+ec04+")")) {
                    Intent i=new Intent(getBaseContext(),Ece_fourthsem_subjectlist.class);
                    i.putExtra("key", "Electronics and comm. 4th semester");
                    startActivity(i);

                }
                if((groupPosition)==3 && listAdapter.getChild(groupPosition,childPosition).equals("Fifth semester "+"("+ec05+")")) {
                    Intent i=new Intent(getBaseContext(),Ece_fifthsem_subjectlist.class);
                    i.putExtra("key", "Electronics and comm. 5th semester");
                    startActivity(i);
                }
                if((groupPosition)==3 && listAdapter.getChild(groupPosition,childPosition).equals("Sixth semester "+"("+ec06+")")) {
                    Intent i=new Intent(getBaseContext(),Ece_sixthsem_subjectlist.class);
                    i.putExtra("key", "Electronics and comm. 6th semester");
                    startActivity(i);

                }
                if((groupPosition)==3 && listAdapter.getChild(groupPosition,childPosition).equals("Seventh semester "+"("+ec07+")")) {
                    Intent i=new Intent(getBaseContext(),Ece_seventhsem_subjectlist.class);
                    i.putExtra("key", "Electronics and comm. 7th semester");
                    startActivity(i);

                }
                if((groupPosition)==3 && listAdapter.getChild(groupPosition,childPosition).equals("Eight semester "+"("+ec08+")")) {
                    Intent i=new Intent(getBaseContext(),Ece_eightsem_subjectlist.class);
                    i.putExtra("key", "Electronics and comm. 8th semester");
                    startActivity(i);
                }



                if((groupPosition)==4  && listAdapter.getChild(groupPosition,childPosition).equals("First semester " +"("+cs01+")")) {
                    Intent i=new Intent(getBaseContext(),Cse_firstsem_subjectlist.class);
                    i.putExtra("key", "Electrical 1st semester");
                    startActivity(i);
                }
                if((groupPosition)==4  && listAdapter.getChild(groupPosition,childPosition).equals("Second semester " +"("+cs02+")")) {
                    Intent i=new Intent(getBaseContext(),Cse_secondsem_subjectlist.class);
                    i.putExtra("key", "Electrical 2nd semester");
                    startActivity(i);
                }
                if((groupPosition)==4 && listAdapter.getChild(groupPosition,childPosition).equals("Third semester "+"("+el03+")")) {
                    Intent i=new Intent(getBaseContext(),Ele_thirdsem_subjectlist.class);
                    i.putExtra("key", "Electrical 3rd semester");
                    startActivity(i);
                }
                if((groupPosition)==4 && listAdapter.getChild(groupPosition,childPosition).equals("Fourth semester "+"("+el04+")")) {
                    Intent i=new Intent(getBaseContext(),Ele_fourthsem_subjectlist.class);
                    i.putExtra("key", "Electrical 4th semester");
                    startActivity(i);
                }
                if((groupPosition)==4 && listAdapter.getChild(groupPosition,childPosition).equals("Fifth semester "+"("+el05+")")) {
                    Intent i=new Intent(getBaseContext(),Ele_fifthsem_subjectlist.class);
                    i.putExtra("key", "Electrical 5th semester");
                    startActivity(i);
                }
                if((groupPosition)==4 && listAdapter.getChild(groupPosition,childPosition).equals("Sixth semester "+"("+el06+")")) {
                    Intent i=new Intent(getBaseContext(),Ele_sixthsem_subjectlist.class);
                    i.putExtra("key", "Electrical 6th semester");
                    startActivity(i);
                }
                if((groupPosition)==4 && listAdapter.getChild(groupPosition,childPosition).equals("Seventh semester "+"("+el07+")")) {
                    Intent i=new Intent(getBaseContext(),Ele_seventhsem_subjectlist.class);
                    i.putExtra("key", "Electrical 7th semester");
                    startActivity(i);
                }
                if((groupPosition)==4 && listAdapter.getChild(groupPosition,childPosition).equals("Eight semester "+"("+el08+")")) {
                    Intent i=new Intent(getBaseContext(),Ele_eightsem_subjectlist.class);
                    i.putExtra("key", "Electrical 8th semester");
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
        branch.add("Information Technology "+"("+total_it+")");
        branch.add("Mechanical Engineering "+"("+total_me+")");
        branch.add("Electronics and Communication Engg. "+"("+total_ece+")");
        branch.add("Electrical Engineering "+"("+total_el+")");

        List<String> first=new ArrayList<>();
        List<String> second=new ArrayList<>();
        List<String> third=new ArrayList<>();
        List<String> fourth=new ArrayList<>();
        List<String> fifth=new ArrayList<>();

        first.add("First semester " +"("+cs01+")");
        first.add("Second semester "+"("+cs02+")");
        first.add("Third semester "+"("+cs03+")");
        first.add("Fourth semester "+"("+cs04+")");
        first.add("Fifth semester "+"("+cs05+")");
        first.add("Sixth semester "+"("+cs06+")");
        first.add("Seventh semester "+"("+cs07+")");
        first.add("Eight semester "+"("+cs08+")");

        second.add("First semester "+"("+cs01+")");
        second.add("Second semester "+"("+cs02+")");
        second.add("Third semester "+"("+it03+")");
        second.add("Fourth semester "+"("+it04+")");
        second.add("Fifth semester "+"("+it05+")");
        second.add("Sixth semester "+"("+it06+")");
        second.add("Seventh semester "+"("+it07+")");
        second.add("Eight semester "+"("+it08+")");

        third.add("First semester "+"("+cs01+")");
        third.add("Second semester "+"("+cs02+")");
        third.add("Third semester "+"("+me03+")");
        third.add("Fourth semester "+"("+me04+")");
        third.add("Fifth semester "+"("+me05+")");
        third.add("Sixth semester "+"("+me06+")");
        third.add("Seventh semester "+"("+me07+")");
        third.add("Eight semester "+"("+me08+")");

        fourth.add("First semester "+"("+cs01+")");
        fourth.add("Second semester "+"("+cs02+")");
        fourth.add("Third semester "+"("+ec03+")");
        fourth.add("Fourth semester "+"("+ec04+")");
        fourth.add("Fifth semester "+"("+ec05+")");
        fourth.add("Sixth semester "+"("+ec06+")");
        fourth.add("Seventh semester "+"("+ec07+")");
        fourth.add("Eight semester "+"("+ec08+")");

        fifth.add("First semester "+"("+cs01+")");
        fifth.add("Second semester "+"("+cs02+")");
        fifth.add("Third semester "+"("+el03+")");
        fifth.add("Fourth semester "+"("+el04+")");
        fifth.add("Fifth semester "+"("+el05+")");
        fifth.add("Sixth semester "+"("+el06+")");
        fifth.add("Seventh semester "+"("+el07+")");
        fifth.add("Eight semester "+"("+el08+")");

        semester.put(branch.get(0),first);
        semester.put(branch.get(1),second);
        semester.put(branch.get(2),third);
        semester.put(branch.get(3),fourth);
        semester.put(branch.get(4),fifth);

    }
    @Override
    public void onBackPressed()
    {
        Intent intent=new Intent(Btech_expendable_list.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("run counter","no");
        intent.putExtra("EXIT", true);
        startActivity(intent);
        finish();

    }

}
