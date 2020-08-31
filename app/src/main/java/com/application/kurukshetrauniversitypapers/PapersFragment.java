package com.application.kurukshetrauniversitypapers;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class PapersFragment extends Fragment {
    Button cse,it,me,ee,ec,mb,bb,bc,mc,first,second,third,fourth,fifth,sixth,seventh,eight,session;
    Button dp_cse,dp_cv,dp_ee,dp_ec,dp_me,dp_dmlt,dp_first,dp_second,dp_third,dp_fourth,dp_fifth,dp_sixth;
    Button ku,dp;
    String selected_branch = "null",selected_semester = "null",semester_number="null",branch_for_intent="null";
    String board="KU_";
    RelativeLayout ku_courses,ku_semesters,dp_courses,dp_semesters;

//    ArrayAdapter<String> adapter;
//    DatabaseReference db,databaseReference;
    ArrayList<String> subjects;
    List<uploadPDF> uploadPDFS;
  //  ListView listView;
    Button search;
  //  ValueEventListener listener;

    public PapersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_papers, container, false);
        cse=v.findViewById(R.id.cse);
        it=v.findViewById(R.id.it);
        me=v.findViewById(R.id.me);
        ee=v.findViewById(R.id.ee);
        ec=v.findViewById(R.id.ec);
        mb=v.findViewById(R.id.mb);
        bb=v.findViewById(R.id.bb);
        bc=v.findViewById(R.id.bc);
        mc=v.findViewById(R.id.mc);
        first=v.findViewById(R.id.first);
        second=v.findViewById(R.id.second);
        third=v.findViewById(R.id.third);
        fourth=v.findViewById(R.id.fourth);
        fifth=v.findViewById(R.id.fifth);
        sixth=v.findViewById(R.id.sixth);
        seventh=v.findViewById(R.id.seventh);
        eight=v.findViewById(R.id.eight);
        uploadPDFS= new ArrayList<>();
        subjects=new ArrayList<>();
        search=v.findViewById(R.id.search);
        session=v.findViewById(R.id.session_20_21);
        ku_courses=v.findViewById(R.id.ku_courses);
        ku_semesters=v.findViewById(R.id.ku_semesters);
        dp_courses=v.findViewById(R.id.dp_courses);
        dp_semesters=v.findViewById(R.id.dp_semesters);
        ku=v.findViewById(R.id.ku);
        dp=v.findViewById(R.id.dp);
        dp_cse=v.findViewById(R.id.dp_cse);
        dp_cv=v.findViewById(R.id.dp_cv);
        dp_me=v.findViewById(R.id.dp_me);
        dp_ee=v.findViewById(R.id.dp_ee);
        dp_ec=v.findViewById(R.id.dp_ec);
        dp_dmlt=v.findViewById(R.id.dp_dmlt);
        dp_first=v.findViewById(R.id.dp_first);
        dp_second=v.findViewById(R.id.dp_second);
        dp_third=v.findViewById(R.id.dp_third);
        dp_fourth=v.findViewById(R.id.dp_fourth);
        dp_fifth=v.findViewById(R.id.dp_fifth);
        dp_sixth=v.findViewById(R.id.dp_sixth);

       setDefaultList();
        cse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selected_branch="Cse";
                branch_for_intent="Computer science"; // for branches other than Cse when first or second sem is selected selected branch is
                //setList();             // overriden to Cse
                cse.setBackgroundResource(R.drawable.button_pressed);
                it.setBackgroundResource(R.drawable.button_default);
                me.setBackgroundResource(R.drawable.button_default);
                ec.setBackgroundResource(R.drawable.button_default);
                ee.setBackgroundResource(R.drawable.button_default);
                mb.setBackgroundResource(R.drawable.button_default);
                bb.setBackgroundResource(R.drawable.button_default);
                bc.setBackgroundResource(R.drawable.button_default);
                mc.setBackgroundResource(R.drawable.button_default);
                third.setEnabled(true);
                fourth.setEnabled(true);
                fifth.setEnabled(true);
                sixth.setEnabled(true);
                seventh.setEnabled(true);
                eight.setEnabled(true);
                Log.e("branch",selected_branch);

            }
        });

        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch="It";
                branch_for_intent="Information technology";
                //setList();
                cse.setBackgroundResource(R.drawable.button_default);
                it.setBackgroundResource(R.drawable.button_pressed);
                me.setBackgroundResource(R.drawable.button_default);
                ec.setBackgroundResource(R.drawable.button_default);
                ee.setBackgroundResource(R.drawable.button_default);
                mb.setBackgroundResource(R.drawable.button_default);
                bb.setBackgroundResource(R.drawable.button_default);
                bc.setBackgroundResource(R.drawable.button_default);
                mc.setBackgroundResource(R.drawable.button_default);
                third.setEnabled(true);
                fifth.setEnabled(true);
                fourth.setEnabled(true);
                sixth.setEnabled(true);
                seventh.setEnabled(true);
                eight.setEnabled(true);
                Log.e("branch",selected_branch);
            }
        });
        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch="Me";
                branch_for_intent="Mechanical";
                //setList();
                cse.setBackgroundResource(R.drawable.button_default);
                it.setBackgroundResource(R.drawable.button_default);
                me.setBackgroundResource(R.drawable.button_pressed);
                ec.setBackgroundResource(R.drawable.button_default);
                ee.setBackgroundResource(R.drawable.button_default);
                mb.setBackgroundResource(R.drawable.button_default);
                bb.setBackgroundResource(R.drawable.button_default);
                bc.setBackgroundResource(R.drawable.button_default);
                mc.setBackgroundResource(R.drawable.button_default);
                third.setEnabled(true);
                fifth.setEnabled(true);
                fourth.setEnabled(true);
                sixth.setEnabled(true);
                seventh.setEnabled(true);
                eight.setEnabled(true);
                Log.e("branch",selected_branch);
            }
        });
        ec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch="Ece";
                branch_for_intent="Electronics and communication";
                //setList();
                cse.setBackgroundResource(R.drawable.button_default);
                it.setBackgroundResource(R.drawable.button_default);
                me.setBackgroundResource(R.drawable.button_default);
                ec.setBackgroundResource(R.drawable.button_pressed);
                ee.setBackgroundResource(R.drawable.button_default);
                mb.setBackgroundResource(R.drawable.button_default);
                bb.setBackgroundResource(R.drawable.button_default);
                bc.setBackgroundResource(R.drawable.button_default);
                mc.setBackgroundResource(R.drawable.button_default);
                third.setEnabled(true);
                fifth.setEnabled(true);
                fourth.setEnabled(true);
                sixth.setEnabled(true);
                seventh.setEnabled(true);
                eight.setEnabled(true);
                Log.e("branch",selected_branch);
            }
        });
        ee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch="Ele";
                branch_for_intent="Electrical";
                //setList();
                cse.setBackgroundResource(R.drawable.button_default);
                it.setBackgroundResource(R.drawable.button_default);
                me.setBackgroundResource(R.drawable.button_default);
                ec.setBackgroundResource(R.drawable.button_default);
                ee.setBackgroundResource(R.drawable.button_pressed);
                mb.setBackgroundResource(R.drawable.button_default);
                bb.setBackgroundResource(R.drawable.button_default);
                bc.setBackgroundResource(R.drawable.button_default);
                mc.setBackgroundResource(R.drawable.button_default);
                third.setEnabled(true);
                fifth.setEnabled(true);
                fourth.setEnabled(true);
                sixth.setEnabled(true);
                seventh.setEnabled(true);
                eight.setEnabled(true);
                Log.e("branch",selected_branch);
            }
        });
        mb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch="Mba";
                branch_for_intent="MBA";
                //setList();
                cse.setBackgroundResource(R.drawable.button_default);
                it.setBackgroundResource(R.drawable.button_default);
                me.setBackgroundResource(R.drawable.button_default);
                ec.setBackgroundResource(R.drawable.button_default);
                ee.setBackgroundResource(R.drawable.button_default);
                mb.setBackgroundResource(R.drawable.button_pressed);
                bb.setBackgroundResource(R.drawable.button_default);
                bc.setBackgroundResource(R.drawable.button_default);
                mc.setBackgroundResource(R.drawable.button_default);
                third.setEnabled(true);
                fourth.setEnabled(true);
                fifth.setEnabled(false);
                sixth.setEnabled(false);
                seventh.setEnabled(false);
                eight.setEnabled(false);
                Log.e("branch",selected_branch);
            }
        });
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch="Bba";
                branch_for_intent="BBA";
                //setList();
                cse.setBackgroundResource(R.drawable.button_default);
                it.setBackgroundResource(R.drawable.button_default);
                me.setBackgroundResource(R.drawable.button_default);
                ec.setBackgroundResource(R.drawable.button_default);
                ee.setBackgroundResource(R.drawable.button_default);
                mb.setBackgroundResource(R.drawable.button_default);
                bb.setBackgroundResource(R.drawable.button_pressed);
                bc.setBackgroundResource(R.drawable.button_default);
                mc.setBackgroundResource(R.drawable.button_default);
                third.setEnabled(true);
                fourth.setEnabled(true);
                fifth.setEnabled(false);
                sixth.setEnabled(false);
                seventh.setEnabled(false);
                eight.setEnabled(false);
                Log.e("branch",selected_branch);
            }
        });
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch="Bca";
                branch_for_intent="BCA";
                //setList();
                cse.setBackgroundResource(R.drawable.button_default);
                it.setBackgroundResource(R.drawable.button_default);
                me.setBackgroundResource(R.drawable.button_default);
                ec.setBackgroundResource(R.drawable.button_default);
                ee.setBackgroundResource(R.drawable.button_default);
                mb.setBackgroundResource(R.drawable.button_default);
                bb.setBackgroundResource(R.drawable.button_default);
                bc.setBackgroundResource(R.drawable.button_pressed);
                mc.setBackgroundResource(R.drawable.button_default);
                third.setEnabled(true);
                fourth.setEnabled(false);
                fifth.setEnabled(false);
                sixth.setEnabled(false);
                seventh.setEnabled(false);
                eight.setEnabled(false);
                Log.e("branch",selected_branch);
            }
        });
        mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch="Mca";
                branch_for_intent="MCA";
                //setList();
                cse.setBackgroundResource(R.drawable.button_default);
                it.setBackgroundResource(R.drawable.button_default);
                me.setBackgroundResource(R.drawable.button_default);
                ec.setBackgroundResource(R.drawable.button_default);
                ee.setBackgroundResource(R.drawable.button_default);
                mb.setBackgroundResource(R.drawable.button_default);
                bb.setBackgroundResource(R.drawable.button_default);
                bc.setBackgroundResource(R.drawable.button_default);
                mc.setBackgroundResource(R.drawable.button_pressed);
                third.setEnabled(true);
                fourth.setEnabled(true);
                fifth.setEnabled(true);
                sixth.setEnabled(false);
                seventh.setEnabled(false);
                eight.setEnabled(false);
                Log.e("branch",selected_branch);
            }
        });

        dp_cse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selected_branch="Cse";
                branch_for_intent="Computer science"; // for branches other than Cse when first or second sem is selected selected branch is
                // overriden to Cse
                dp_cse.setBackgroundResource(R.drawable.button_pressed);
                dp_dmlt.setBackgroundResource(R.drawable.button_default);
                dp_me.setBackgroundResource(R.drawable.button_default);
                dp_ec.setBackgroundResource(R.drawable.button_default);
                dp_ee.setBackgroundResource(R.drawable.button_default);
                dp_cv.setBackgroundResource(R.drawable.button_default);
                Log.e("branch",selected_branch);

            }
        });
        dp_cv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selected_branch="Cv";
                branch_for_intent="Civil"; // for branches other than Cse when first or second sem is selected selected branch is
                   // overriden to Cse
                dp_cse.setBackgroundResource(R.drawable.button_default);
                dp_dmlt.setBackgroundResource(R.drawable.button_default);
                dp_me.setBackgroundResource(R.drawable.button_default);
                dp_ec.setBackgroundResource(R.drawable.button_default);
                dp_ee.setBackgroundResource(R.drawable.button_default);
                dp_cv.setBackgroundResource(R.drawable.button_pressed);
                Log.e("branch",selected_branch);

            }
        });
        dp_me.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selected_branch="Me";
                branch_for_intent="Mechanical"; // for branches other than Cse when first or second sem is selected selected branch is
                                                // overriden to Cse
                dp_cse.setBackgroundResource(R.drawable.button_default);
                dp_dmlt.setBackgroundResource(R.drawable.button_default);
                dp_me.setBackgroundResource(R.drawable.button_pressed);
                dp_ec.setBackgroundResource(R.drawable.button_default);
                dp_ee.setBackgroundResource(R.drawable.button_default);
                dp_cv.setBackgroundResource(R.drawable.button_default);
                Log.e("branch",selected_branch);

            }
        });
        dp_ee.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selected_branch="Ele";
                branch_for_intent="Electrical"; // for branches other than Cse when first or second sem is selected selected branch is
                //setList();             // overriden to Cse
                dp_cse.setBackgroundResource(R.drawable.button_default);
                dp_dmlt.setBackgroundResource(R.drawable.button_default);
                dp_me.setBackgroundResource(R.drawable.button_default);
                dp_ec.setBackgroundResource(R.drawable.button_default);
                dp_ee.setBackgroundResource(R.drawable.button_pressed);
                dp_cv.setBackgroundResource(R.drawable.button_default);
                Log.e("branch",selected_branch);

            }
        });
        dp_ec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selected_branch="Ece";
                branch_for_intent="Electronics and communication"; // for branches other than Cse when first or second sem is selected selected branch is
                //setList();             // overriden to Cse
                dp_cse.setBackgroundResource(R.drawable.button_default);
                dp_dmlt.setBackgroundResource(R.drawable.button_default);
                dp_me.setBackgroundResource(R.drawable.button_default);
                dp_ec.setBackgroundResource(R.drawable.button_pressed);
                dp_ee.setBackgroundResource(R.drawable.button_default);
                dp_cv.setBackgroundResource(R.drawable.button_default);
                Log.e("branch",selected_branch);

            }
        });
        dp_dmlt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selected_branch="Dmlt";
                branch_for_intent="DMLT"; // for branches other than Cse when first or second sem is selected selected branch is
                //setList();             // overriden to Cse
                dp_cse.setBackgroundResource(R.drawable.button_default);
                dp_dmlt.setBackgroundResource(R.drawable.button_pressed);
                dp_me.setBackgroundResource(R.drawable.button_default);
                dp_ec.setBackgroundResource(R.drawable.button_default);
                dp_ee.setBackgroundResource(R.drawable.button_default);
                dp_cv.setBackgroundResource(R.drawable.button_default);
                Log.e("branch",selected_branch);

            }
        });
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="first";
                semester_number="1";
                //setList();
                first.setBackgroundResource(R.drawable.button_pressed);
                second.setBackgroundResource(R.drawable.button_default);
                third.setBackgroundResource(R.drawable.button_default);
                fourth.setBackgroundResource(R.drawable.button_default);
                fifth.setBackgroundResource(R.drawable.button_default);
                sixth.setBackgroundResource(R.drawable.button_default);
                seventh.setBackgroundResource(R.drawable.button_default);
                eight.setBackgroundResource(R.drawable.button_default);
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="second";
                semester_number="2";
                //setList();
                first.setBackgroundResource(R.drawable.button_default);
                second.setBackgroundResource(R.drawable.button_pressed);
                third.setBackgroundResource(R.drawable.button_default);
                fourth.setBackgroundResource(R.drawable.button_default);
                fifth.setBackgroundResource(R.drawable.button_default);
                sixth.setBackgroundResource(R.drawable.button_default);
                seventh.setBackgroundResource(R.drawable.button_default);
                eight.setBackgroundResource(R.drawable.button_default);
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="third";
                semester_number="3";
                //setList();
                first.setBackgroundResource(R.drawable.button_default);
                second.setBackgroundResource(R.drawable.button_default);
                third.setBackgroundResource(R.drawable.button_pressed);
                fourth.setBackgroundResource(R.drawable.button_default);
                fifth.setBackgroundResource(R.drawable.button_default);
                sixth.setBackgroundResource(R.drawable.button_default);
                seventh.setBackgroundResource(R.drawable.button_default);
                eight.setBackgroundResource(R.drawable.button_default);
            }
        });
        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="fourth";
                semester_number="4";
                //setList();
                first.setBackgroundResource(R.drawable.button_default);
                second.setBackgroundResource(R.drawable.button_default);
                third.setBackgroundResource(R.drawable.button_default);
                fourth.setBackgroundResource(R.drawable.button_pressed);
                fifth.setBackgroundResource(R.drawable.button_default);
                sixth.setBackgroundResource(R.drawable.button_default);
                seventh.setBackgroundResource(R.drawable.button_default);
                eight.setBackgroundResource(R.drawable.button_default);

            }
        });
        fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="fifth";
                semester_number="5";
                //setList();
                first.setBackgroundResource(R.drawable.button_default);
                second.setBackgroundResource(R.drawable.button_default);
                third.setBackgroundResource(R.drawable.button_default);
                fourth.setBackgroundResource(R.drawable.button_default);
                fifth.setBackgroundResource(R.drawable.button_pressed);
                sixth.setBackgroundResource(R.drawable.button_default);
                seventh.setBackgroundResource(R.drawable.button_default);
                eight.setBackgroundResource(R.drawable.button_default);
            }
        });
        sixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="sixth";
                semester_number="6";
                //setList();
                first.setBackgroundResource(R.drawable.button_default);
                second.setBackgroundResource(R.drawable.button_default);
                third.setBackgroundResource(R.drawable.button_default);
                fourth.setBackgroundResource(R.drawable.button_default);
                fifth.setBackgroundResource(R.drawable.button_default);
                sixth.setBackgroundResource(R.drawable.button_pressed);
                seventh.setBackgroundResource(R.drawable.button_default);
                eight.setBackgroundResource(R.drawable.button_default);
            }
        });
        seventh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="seventh";
                semester_number="7";
                //setList();
                first.setBackgroundResource(R.drawable.button_default);
                second.setBackgroundResource(R.drawable.button_default);
                third.setBackgroundResource(R.drawable.button_default);
                fourth.setBackgroundResource(R.drawable.button_default);
                fifth.setBackgroundResource(R.drawable.button_default);
                sixth.setBackgroundResource(R.drawable.button_default);
                seventh.setBackgroundResource(R.drawable.button_pressed);
                eight.setBackgroundResource(R.drawable.button_default);

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="eight";
                semester_number="8";
                //setList();
                first.setBackgroundResource(R.drawable.button_default);
                second.setBackgroundResource(R.drawable.button_default);
                third.setBackgroundResource(R.drawable.button_default);
                fourth.setBackgroundResource(R.drawable.button_default);
                fifth.setBackgroundResource(R.drawable.button_default);
                sixth.setBackgroundResource(R.drawable.button_default);
                seventh.setBackgroundResource(R.drawable.button_default);
                eight.setBackgroundResource(R.drawable.button_pressed);
            }
        });
        dp_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="first";
                semester_number="1";
                //setList();
                dp_first.setBackgroundResource(R.drawable.button_pressed);
                dp_second.setBackgroundResource(R.drawable.button_default);
                dp_third.setBackgroundResource(R.drawable.button_default);
                dp_fourth.setBackgroundResource(R.drawable.button_default);
                dp_fifth.setBackgroundResource(R.drawable.button_default);
                dp_sixth.setBackgroundResource(R.drawable.button_default);
            }
        });
        dp_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="second";
                semester_number="2";
                //setList();
                dp_first.setBackgroundResource(R.drawable.button_default);
                dp_second.setBackgroundResource(R.drawable.button_pressed);
                dp_third.setBackgroundResource(R.drawable.button_default);
                dp_fourth.setBackgroundResource(R.drawable.button_default);
                dp_fifth.setBackgroundResource(R.drawable.button_default);
                dp_sixth.setBackgroundResource(R.drawable.button_default);
            }
        });
        dp_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="third";
                semester_number="3";
                //setList();
                dp_first.setBackgroundResource(R.drawable.button_default);
                dp_second.setBackgroundResource(R.drawable.button_default);
                dp_third.setBackgroundResource(R.drawable.button_pressed);
                dp_fourth.setBackgroundResource(R.drawable.button_default);
                dp_fifth.setBackgroundResource(R.drawable.button_default);
                dp_sixth.setBackgroundResource(R.drawable.button_default);
            }
        });
        dp_fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="fourth";
                semester_number="4";
                //setList();
                dp_first.setBackgroundResource(R.drawable.button_default);
                dp_second.setBackgroundResource(R.drawable.button_default);
                dp_third.setBackgroundResource(R.drawable.button_default);
                dp_fourth.setBackgroundResource(R.drawable.button_pressed);
                dp_fifth.setBackgroundResource(R.drawable.button_default);
                dp_sixth.setBackgroundResource(R.drawable.button_default);
            }
        });
        dp_fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="fifth";
                semester_number="5";
                //setList();
                dp_first.setBackgroundResource(R.drawable.button_default);
                dp_second.setBackgroundResource(R.drawable.button_default);
                dp_third.setBackgroundResource(R.drawable.button_default);
                dp_fourth.setBackgroundResource(R.drawable.button_default);
                dp_fifth.setBackgroundResource(R.drawable.button_pressed);
                dp_sixth.setBackgroundResource(R.drawable.button_default);
            }
        });
        dp_sixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="sixth";
                semester_number="6";
                //setList();
                dp_first.setBackgroundResource(R.drawable.button_default);
                dp_second.setBackgroundResource(R.drawable.button_default);
                dp_third.setBackgroundResource(R.drawable.button_default);
                dp_fourth.setBackgroundResource(R.drawable.button_default);
                dp_fifth.setBackgroundResource(R.drawable.button_default);
                dp_sixth.setBackgroundResource(R.drawable.button_pressed);
            }
        });

        ku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ku_courses.setVisibility(View.VISIBLE);
                ku_semesters.setVisibility(View.VISIBLE);
                dp_courses.setVisibility(View.GONE);
                dp_semesters.setVisibility(View.GONE);
                ku.setBackgroundResource(R.drawable.button_pressed);
                dp.setBackgroundResource(R.drawable.button_default);
                board="KU_";
            }
        });
        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ku_courses.setVisibility(View.GONE);
                ku_semesters.setVisibility(View.GONE);
                dp_courses.setVisibility(View.VISIBLE);
                dp_semesters.setVisibility(View.VISIBLE);
                ku.setBackgroundResource(R.drawable.button_default);
                dp.setBackgroundResource(R.drawable.button_pressed);
                board="HS_";
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selected_branch.equals("null") || selected_semester.equals("null"))
                {
                    Toast.makeText(getActivity(), "Choose Course and semester", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(selected_branch.equals("It")|| selected_branch.equals("Me")|| selected_branch.equals("Ece")|| selected_branch.equals("Ele"))
                    {
                        if (selected_semester.equals("first") || selected_semester.equals("second"))
                        {
                            selected_branch="Cse";
                            Log.e("Selected branch",selected_branch);
                            Intent intent = new Intent();
                            intent.putExtra("key", branch_for_intent+" "+semester_number+"semester");
                            intent.setClassName(getActivity(), board+selected_branch.toUpperCase() + "_subjectlists." + selected_branch + "_" + selected_semester + "sem_subjectlist");
                            startActivity(intent);
                        }
                        else
                        {
                            Log.e("Selected branch",selected_branch);
                                Intent intent = new Intent();
                                intent.putExtra("key", branch_for_intent + " " + semester_number + "semester");
                                intent.setClassName(getActivity(), board+selected_branch.toUpperCase() + "_subjectlists." + selected_branch + "_" + selected_semester + "sem_subjectlist");
                                startActivity(intent);

                        }
                    }
                    else
                    {
                            Log.e("Selected branch",selected_branch);
                            //classname = selected_branch.toUpperCase() + "_subjectlists." + selected_branch + "_" + selected_semester + "sem_subjectlist";
                            Intent intent = new Intent();
                            intent.putExtra("key", branch_for_intent + " " + semester_number + "semester");
                            intent.setClassName(getActivity(), board+selected_branch.toUpperCase() + "_subjectlists." + selected_branch + "_" + selected_semester + "sem_subjectlist");
                            startActivity(intent);

                    }
                }
               //startActivity(new Intent(getActivity(),selected_branch+selected_semester.class));

//                Subjectcode subjectcode = new Subjectcode();
//                subjectcode.setSubjectname(spinner.getSelectedItem().toString());
//                if(selected_branch.equals("IT")|| selected_branch.equals("ME")|| selected_branch.equals("EC")|| selected_branch.equals("EL")){
//                    if(selected_semester.equals("01") || selected_semester.equals("02")){
//                        selected_branch = "CS";
//                        Intent intent=new Intent(getActivity(), Pdflist.class);
//                        intent.putExtra("subject","IN/KU/"+selected_branch+"/"+selected_semester+"/"+subjectcode.getcode());
//                        startActivity(intent);
//                    }
//                    else {
//                        Intent intent=new Intent(getActivity(), Pdflist.class);
//                        intent.putExtra("subject","IN/KU/"+selected_branch+"/"+selected_semester+"/"+subjectcode.getcode());
//                        startActivity(intent);
//                    }
//
//                }
//                else {
//                    Intent intent=new Intent(getActivity(), Pdflist.class);
//                    intent.putExtra("subject","IN/KU/"+selected_branch+"/"+selected_semester+"/"+subjectcode.getcode());
//                    startActivity(intent);
//                }
            }
        });
        return v;
                }

//    public void setList()
//    {
//        db = FirebaseDatabase.getInstance().getReference().child(selected_branch + selected_semester);
//        listener=db.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                subjects.clear();
//                for(DataSnapshot item: dataSnapshot.getChildren())
//                {
//                    subjects.add(item.getValue().toString());
//                }
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, subjects);
//        spinner.setAdapter(adapter);
//        inflate();
//
//    }
//
    public void setDefaultList()
    {
        ku_courses.setVisibility(View.VISIBLE);
        ku_semesters.setVisibility(View.VISIBLE);
        dp_courses.setVisibility(View.GONE);
        dp_semesters.setVisibility(View.GONE);
        board="KU_";
        selected_branch="Cse";
        branch_for_intent="Computer science";
        selected_semester="first";
        semester_number="1";
        ku.setBackgroundResource(R.drawable.button_pressed);
        cse.setBackgroundResource(R.drawable.button_pressed);
        first.setBackgroundResource(R.drawable.button_pressed);
        session.setBackgroundResource(R.drawable.button_pressed);

    }
//
//    public void inflate()
//    { spinner.performClick();}
//    public void inflate()
//    {
//        findViewById(android.R.id.content).post(new Runnable() {
//        @Override
//        public void run() {
//            spinner.performClick();
//        }
//    });
//    }

//    public void displayResults()
//    {
//        if(selected_branch.equals("IT")|| selected_branch.equals("ME")|| selected_branch.equals("EC")|| selected_branch.equals("EL"))
//        {
//            if(selected_semester.equals("01") || selected_semester.equals("02"))
//            {
//                selected_branch = "CS";
//                Subjectcode subjectcode = new Subjectcode();
//                SingleDownloadClass singleDownloadClass = new SingleDownloadClass();
//                singleDownloadClass.setBranch(selected_branch);
//                singleDownloadClass.setSemester(selected_semester);
//                singleDownloadClass.setCode(subjectcode.getcode());
//                databaseReference = FirebaseDatabase.getInstance().getReference("IN/KU/" + selected_branch + "/" + selected_semester + "/" + subjectcode.getcode());
//                databaseReference.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        uploadPDFS.clear();
//                        for (DataSnapshot pdfSnapshot : dataSnapshot.getChildren()) {
//                            uploadPDF uploadPDF = pdfSnapshot.getValue(uploadPDF.class);
//                            uploadPDFS.add(uploadPDF);
//                        }
//
//                        Pdflistadapter adapter = new Pdflistadapter(getActivity(), uploadPDFS);
//                        listView.setAdapter(adapter);
//                    }
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });
//            }
//            else {
//                Subjectcode subjectcode = new Subjectcode();
//                SingleDownloadClass singleDownloadClass = new SingleDownloadClass();
//                singleDownloadClass.setBranch(selected_branch);
//                singleDownloadClass.setSemester(selected_semester);
//                singleDownloadClass.setCode(subjectcode.getcode());
//                databaseReference = FirebaseDatabase.getInstance().getReference("IN/KU/" + selected_branch + "/" + selected_semester + "/" + subjectcode.getcode());
//                databaseReference.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        uploadPDFS.clear();
//                        for (DataSnapshot pdfSnapshot : dataSnapshot.getChildren()) {
//                            uploadPDF uploadPDF = pdfSnapshot.getValue(uploadPDF.class);
//                            uploadPDFS.add(uploadPDF);
//                        }
//
//                        Pdflistadapter adapter = new Pdflistadapter(getActivity(), uploadPDFS);
//                        listView.setAdapter(adapter);
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });
//            }
//
//        }
//        else {
//            Subjectcode subjectcode = new Subjectcode();
//            SingleDownloadClass singleDownloadClass = new SingleDownloadClass();
//            singleDownloadClass.setBranch(selected_branch);
//            singleDownloadClass.setSemester(selected_semester);
//            singleDownloadClass.setCode(subjectcode.getcode());
//            databaseReference = FirebaseDatabase.getInstance().getReference("IN/KU/" + selected_branch + "/" + selected_semester + "/" + subjectcode.getcode());
//            databaseReference.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    uploadPDFS.clear();
//                    for (DataSnapshot pdfSnapshot : dataSnapshot.getChildren()) {
//                        uploadPDF uploadPDF = pdfSnapshot.getValue(uploadPDF.class);
//                        uploadPDFS.add(uploadPDF);
//                    }
//
//                    Pdflistadapter adapter = new Pdflistadapter(getActivity(), uploadPDFS);
//                    listView.setAdapter(adapter);
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//        }
//    }
}