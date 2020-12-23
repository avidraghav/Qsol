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

import utils.uploadPDF;

public class SolutionsFragment extends Fragment {

    Button cse,it,me,ee,ec,mb,bb,bc,mc,first,second,third,fourth,fifth,sixth,seventh,eight,session;
    Button dp_cse,dp_cv,dp_ee,dp_ec,dp_me,dp_dmlt,dp_first,dp_second,dp_third,dp_fourth,dp_fifth,dp_sixth;
    Button ku,dp;
    String selected_branch = "null",selected_semester = "null",semester_number="null",branch_for_intent="null";
    String board="null";
    RelativeLayout ku_courses,ku_semesters,dp_courses,dp_semesters;

    ArrayList<String> subjects;
    List<uploadPDF> uploadPDFS;
    Button search;

    public SolutionsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_solutions, container, false);
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
                // overriden to Cse
                cse.setBackgroundResource(R.drawable.button_pressed);
            }
        });

        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="third";
                semester_number="3";
                third.setBackgroundResource(R.drawable.button_pressed);
                fifth.setBackgroundResource(R.drawable.button_default);
            }
        });
        fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected_semester="fifth";
                semester_number="5";
                fifth.setBackgroundResource(R.drawable.button_pressed);
                third.setBackgroundResource(R.drawable.button_default);
            }
        });


        ku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board="KU_";
                ku_courses.setVisibility(View.VISIBLE);
                ku_semesters.setVisibility(View.VISIBLE);
                dp_courses.setVisibility(View.GONE);
                dp_semesters.setVisibility(View.GONE);
                ku.setBackgroundResource(R.drawable.button_pressed);

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selected_branch.equals("null") || selected_semester.equals("null") || board.equals("null"))
                {
                    Toast.makeText(getActivity(), "Choose Board, Course and semester", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent();
                    intent.putExtra("key", "Solutions");
                    intent.setClassName(getActivity(), board + selected_branch.toUpperCase() + "_solution_subjectlists." + selected_branch + "_" + selected_semester + "sem_subjectlist");
                    startActivity(intent);
                }

            }
        });
        return v;
    }
    public void setDefaultList()
    {
        ku_courses.setVisibility(View.VISIBLE);
        ku_semesters.setVisibility(View.VISIBLE);
        dp_courses.setVisibility(View.GONE);
        dp_semesters.setVisibility(View.GONE);
        selected_branch="null";
        selected_semester="null";
        board="null";
        session.setBackgroundResource(R.drawable.button_pressed);

    }
}