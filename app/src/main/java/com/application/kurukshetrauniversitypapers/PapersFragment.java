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


public class PapersFragment extends Fragment {
    Button cse,it,me,ee,ec,mb,bb,bc,mc,cv,first,second,third,fourth,fifth,sixth,seventh,eight,session;
    Button dp_cse,dp_cv,dp_ee,dp_ec,dp_me,dp_dmlt,dp_first,dp_second,dp_third,dp_fourth,dp_fifth,dp_sixth;
    Button gju_cse,gju_first;
    Button ymca_cse,ymca_it,ymca_ee,ymca_ec,ymca_me,ymca_cv,ymca_first,ymca_second;
    Button ku,dp,gju,ymca;
    String selected_branch = "null",selected_semester = "null",semester_number="null",branch_for_intent="null";
    String board="null";
    RelativeLayout ku_courses,ku_semesters,dp_courses,dp_semesters,gju_courses,gju_semesters,ymca_courses,ymca_semesters;

    ArrayList<String> subjects;
    List<uploadPDF> uploadPDFS;
    Button search;

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
        cv=v.findViewById(R.id.cv);
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
        gju_courses=v.findViewById(R.id.gju_courses);
        gju_semesters=v.findViewById(R.id.gju_semesters);
        ymca_courses=v.findViewById(R.id.ymca_courses);
        ymca_semesters=v.findViewById(R.id.ymca_semesters);
        ku=v.findViewById(R.id.sy_ku);
        dp=v.findViewById(R.id.sy_dp);
        gju=v.findViewById(R.id.gju);
        ymca=v.findViewById(R.id.ymca);
        gju_cse=v.findViewById(R.id.gju_cse);
        gju_first=v.findViewById(R.id.gju_first);
        ymca_cse=v.findViewById(R.id.ymca_cse);
        ymca_cv=v.findViewById(R.id.ymca_cv);
        ymca_me=v.findViewById(R.id.ymca_me);
        ymca_ee=v.findViewById(R.id.ymca_ee);
        ymca_ec=v.findViewById(R.id.ymca_ec);
        ymca_it=v.findViewById(R.id.ymca_it);
        ymca_first=v.findViewById(R.id.ymca_first);
        ymca_second=v.findViewById(R.id.ymca_second);
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

        cse.setOnClickListener(v124 -> {
            selected_branch="Cse";
            branch_for_intent="Computer science"; // for branches other than Cse when first or second sem is selected selected branch is
                         // overriden to Cse
            cv.setBackgroundResource(R.drawable.button_default);
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

        });
        it.setOnClickListener(v125 -> {
            selected_branch="It";
            branch_for_intent="Information technology";
            cv.setBackgroundResource(R.drawable.button_default);
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
        });
        me.setOnClickListener(v126 -> {
            selected_branch="Me";
            branch_for_intent="Mechanical";
            cv.setBackgroundResource(R.drawable.button_default);
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
        });
        ec.setOnClickListener(v127 -> {
            selected_branch="Ece";
            branch_for_intent="Electronics and communication";
            cv.setBackgroundResource(R.drawable.button_default);
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
        });
        cv.setOnClickListener(v128 -> {
            selected_branch="Cv";
            branch_for_intent="Civil Engineering";
            cv.setBackgroundResource(R.drawable.button_pressed);
            cse.setBackgroundResource(R.drawable.button_default);
            it.setBackgroundResource(R.drawable.button_default);
            me.setBackgroundResource(R.drawable.button_default);
            ec.setBackgroundResource(R.drawable.button_default);
            ee.setBackgroundResource(R.drawable.button_default);
            mb.setBackgroundResource(R.drawable.button_default);
            bb.setBackgroundResource(R.drawable.button_default);
            bc.setBackgroundResource(R.drawable.button_default);
            mc.setBackgroundResource(R.drawable.button_default);
            third.setEnabled(false);
            fifth.setEnabled(false);
            fourth.setEnabled(true);
            sixth.setEnabled(true);
            seventh.setEnabled(false);
            eight.setEnabled(false);
            Log.e("branch",selected_branch);
        });
        ee.setOnClickListener(v129 -> {
            selected_branch="Ele";
            branch_for_intent="Electrical";
            cv.setBackgroundResource(R.drawable.button_default);
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
        });
        mb.setOnClickListener(v130 -> {
            selected_branch="Mba";
            branch_for_intent="MBA";
            cv.setBackgroundResource(R.drawable.button_default);
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
        });
        bb.setOnClickListener(v121 -> {
            selected_branch="Bba";
            branch_for_intent="BBA";
            cv.setBackgroundResource(R.drawable.button_default);
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
        });
        bc.setOnClickListener(v122 -> {
            selected_branch="Bca";
            branch_for_intent="BCA";
            cv.setBackgroundResource(R.drawable.button_default);
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
        });
        mc.setOnClickListener(v123 -> {
            selected_branch="Mca";
            branch_for_intent="MCA";
            cv.setBackgroundResource(R.drawable.button_default);
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
        });
        dp_cse.setOnClickListener(v120 -> {
            selected_branch="Cse";
            branch_for_intent="Computer science"; // for branches other than Cse when first or second sem is selected selected branch is
            // overriden to Cse
            dp_cse.setBackgroundResource(R.drawable.button_pressed);
            dp_dmlt.setBackgroundResource(R.drawable.button_default);
            dp_me.setBackgroundResource(R.drawable.button_default);
            dp_ec.setBackgroundResource(R.drawable.button_default);
            dp_ee.setBackgroundResource(R.drawable.button_default);
            dp_cv.setBackgroundResource(R.drawable.button_default);
            dp_fifth.setVisibility(View.VISIBLE);
            dp_sixth.setVisibility(View.VISIBLE);
            Log.e("branch",selected_branch);

        });
        dp_cv.setOnClickListener(v119 -> {
            selected_branch="Cv";
            branch_for_intent="Civil"; // for branches other than Cse when first or second sem is selected selected branch is
               // overriden to Cse
            dp_cse.setBackgroundResource(R.drawable.button_default);
            dp_dmlt.setBackgroundResource(R.drawable.button_default);
            dp_me.setBackgroundResource(R.drawable.button_default);
            dp_ec.setBackgroundResource(R.drawable.button_default);
            dp_ee.setBackgroundResource(R.drawable.button_default);
            dp_cv.setBackgroundResource(R.drawable.button_pressed);
            dp_fifth.setVisibility(View.VISIBLE);
            dp_sixth.setVisibility(View.VISIBLE);
            Log.e("branch",selected_branch);

        });
        dp_me.setOnClickListener(v118 -> {
            selected_branch="Me";
            branch_for_intent="Mechanical"; // for branches other than Cse when first or second sem is selected selected branch is
                                            // overriden to Cse
            dp_cse.setBackgroundResource(R.drawable.button_default);
            dp_dmlt.setBackgroundResource(R.drawable.button_default);
            dp_me.setBackgroundResource(R.drawable.button_pressed);
            dp_ec.setBackgroundResource(R.drawable.button_default);
            dp_ee.setBackgroundResource(R.drawable.button_default);
            dp_cv.setBackgroundResource(R.drawable.button_default);
            dp_fifth.setVisibility(View.VISIBLE);
            dp_sixth.setVisibility(View.VISIBLE);
            Log.e("branch",selected_branch);

        });
        dp_ee.setOnClickListener(v117 -> {
            selected_branch="Ele";
            branch_for_intent="Electrical"; // for branches other than Cse when first or second sem is selected selected branch is
                         // overriden to Cse
            dp_cse.setBackgroundResource(R.drawable.button_default);
            dp_dmlt.setBackgroundResource(R.drawable.button_default);
            dp_me.setBackgroundResource(R.drawable.button_default);
            dp_ec.setBackgroundResource(R.drawable.button_default);
            dp_ee.setBackgroundResource(R.drawable.button_pressed);
            dp_cv.setBackgroundResource(R.drawable.button_default);
            dp_fifth.setVisibility(View.VISIBLE);
            dp_sixth.setVisibility(View.VISIBLE);
            Log.e("branch",selected_branch);

        });
        dp_ec.setOnClickListener(v115 -> {
            selected_branch="Ece";
            branch_for_intent="Electronics and communication"; // for branches other than Cse when first or second sem is selected selected branch is
                         // overriden to Cse
            dp_cse.setBackgroundResource(R.drawable.button_default);
            dp_dmlt.setBackgroundResource(R.drawable.button_default);
            dp_me.setBackgroundResource(R.drawable.button_default);
            dp_ec.setBackgroundResource(R.drawable.button_pressed);
            dp_ee.setBackgroundResource(R.drawable.button_default);
            dp_cv.setBackgroundResource(R.drawable.button_default);
            dp_fifth.setVisibility(View.VISIBLE);
            dp_sixth.setVisibility(View.VISIBLE);
            Log.e("branch",selected_branch);

        });
        dp_dmlt.setOnClickListener(v116 -> {
            selected_branch="Ml";
            branch_for_intent="MLT"; // for branches other than Cse when first or second sem is selected selected branch is
                         // overriden to Cse
            dp_cse.setBackgroundResource(R.drawable.button_default);
            dp_dmlt.setBackgroundResource(R.drawable.button_pressed);
            dp_me.setBackgroundResource(R.drawable.button_default);
            dp_ec.setBackgroundResource(R.drawable.button_default);
            dp_ee.setBackgroundResource(R.drawable.button_default);
            dp_cv.setBackgroundResource(R.drawable.button_default);
            dp_fifth.setVisibility(View.GONE);
            dp_sixth.setVisibility(View.GONE);
            Log.e("branch",selected_branch);

        });
        first.setOnClickListener(v114 -> {
            selected_semester="first";
            semester_number="1";

            first.setBackgroundResource(R.drawable.button_pressed);
            second.setBackgroundResource(R.drawable.button_default);
            third.setBackgroundResource(R.drawable.button_default);
            fourth.setBackgroundResource(R.drawable.button_default);
            fifth.setBackgroundResource(R.drawable.button_default);
            sixth.setBackgroundResource(R.drawable.button_default);
            seventh.setBackgroundResource(R.drawable.button_default);
            eight.setBackgroundResource(R.drawable.button_default);
        });
        second.setOnClickListener(v113 -> {
            selected_semester="second";
            semester_number="2";
            first.setBackgroundResource(R.drawable.button_default);
            second.setBackgroundResource(R.drawable.button_pressed);
            third.setBackgroundResource(R.drawable.button_default);
            fourth.setBackgroundResource(R.drawable.button_default);
            fifth.setBackgroundResource(R.drawable.button_default);
            sixth.setBackgroundResource(R.drawable.button_default);
            seventh.setBackgroundResource(R.drawable.button_default);
            eight.setBackgroundResource(R.drawable.button_default);
        });
        third.setOnClickListener(v112 -> {
            selected_semester="third";
            semester_number="3";
            first.setBackgroundResource(R.drawable.button_default);
            second.setBackgroundResource(R.drawable.button_default);
            third.setBackgroundResource(R.drawable.button_pressed);
            fourth.setBackgroundResource(R.drawable.button_default);
            fifth.setBackgroundResource(R.drawable.button_default);
            sixth.setBackgroundResource(R.drawable.button_default);
            seventh.setBackgroundResource(R.drawable.button_default);
            eight.setBackgroundResource(R.drawable.button_default);
        });
        fourth.setOnClickListener(v111 -> {
            selected_semester="fourth";
            semester_number="4";
            first.setBackgroundResource(R.drawable.button_default);
            second.setBackgroundResource(R.drawable.button_default);
            third.setBackgroundResource(R.drawable.button_default);
            fourth.setBackgroundResource(R.drawable.button_pressed);
            fifth.setBackgroundResource(R.drawable.button_default);
            sixth.setBackgroundResource(R.drawable.button_default);
            seventh.setBackgroundResource(R.drawable.button_default);
            eight.setBackgroundResource(R.drawable.button_default);

        });
        fifth.setOnClickListener(v110 -> {
            selected_semester="fifth";
            semester_number="5";
            first.setBackgroundResource(R.drawable.button_default);
            second.setBackgroundResource(R.drawable.button_default);
            third.setBackgroundResource(R.drawable.button_default);
            fourth.setBackgroundResource(R.drawable.button_default);
            fifth.setBackgroundResource(R.drawable.button_pressed);
            sixth.setBackgroundResource(R.drawable.button_default);
            seventh.setBackgroundResource(R.drawable.button_default);
            eight.setBackgroundResource(R.drawable.button_default);
        });
        sixth.setOnClickListener(v19 -> {
            selected_semester="sixth";
            semester_number="6";
            first.setBackgroundResource(R.drawable.button_default);
            second.setBackgroundResource(R.drawable.button_default);
            third.setBackgroundResource(R.drawable.button_default);
            fourth.setBackgroundResource(R.drawable.button_default);
            fifth.setBackgroundResource(R.drawable.button_default);
            sixth.setBackgroundResource(R.drawable.button_pressed);
            seventh.setBackgroundResource(R.drawable.button_default);
            eight.setBackgroundResource(R.drawable.button_default);
        });
        seventh.setOnClickListener(v18 -> {
            selected_semester="seventh";
            semester_number="7";
            first.setBackgroundResource(R.drawable.button_default);
            second.setBackgroundResource(R.drawable.button_default);
            third.setBackgroundResource(R.drawable.button_default);
            fourth.setBackgroundResource(R.drawable.button_default);
            fifth.setBackgroundResource(R.drawable.button_default);
            sixth.setBackgroundResource(R.drawable.button_default);
            seventh.setBackgroundResource(R.drawable.button_pressed);
            eight.setBackgroundResource(R.drawable.button_default);

        });
        eight.setOnClickListener(v17 -> {
            selected_semester="eight";
            semester_number="8";
            first.setBackgroundResource(R.drawable.button_default);
            second.setBackgroundResource(R.drawable.button_default);
            third.setBackgroundResource(R.drawable.button_default);
            fourth.setBackgroundResource(R.drawable.button_default);
            fifth.setBackgroundResource(R.drawable.button_default);
            sixth.setBackgroundResource(R.drawable.button_default);
            seventh.setBackgroundResource(R.drawable.button_default);
            eight.setBackgroundResource(R.drawable.button_pressed);
        });
        ymca_first.setOnClickListener(view -> {
            selected_semester="first";
            semester_number="1";
            ymca_first.setBackgroundResource(R.drawable.button_pressed);
            ymca_second.setBackgroundResource(R.drawable.button_default);
        });
        ymca_second.setOnClickListener(view -> {
            selected_semester="second";
            semester_number="2";
            ymca_first.setBackgroundResource(R.drawable.button_default);
            ymca_second.setBackgroundResource(R.drawable.button_pressed);
        });
        ymca_cse.setOnClickListener(view -> {
            selected_branch="Cse";
            branch_for_intent="Computer science";
           ymca_cse.setBackgroundResource(R.drawable.button_pressed);
           ymca_cv.setBackgroundResource(R.drawable.button_default);
           ymca_it.setBackgroundResource(R.drawable.button_default);
           ymca_me.setBackgroundResource(R.drawable.button_default);
           ymca_ec.setBackgroundResource(R.drawable.button_default);
           ymca_ee.setBackgroundResource(R.drawable.button_default);
            Log.e("branch",selected_branch);
        });
        ymca_it.setOnClickListener(view -> {
            selected_branch="It";
            branch_for_intent="Information technology";
            ymca_cse.setBackgroundResource(R.drawable.button_default);
            ymca_cv.setBackgroundResource(R.drawable.button_default);
            ymca_it.setBackgroundResource(R.drawable.button_pressed);
            ymca_me.setBackgroundResource(R.drawable.button_default);
            ymca_ec.setBackgroundResource(R.drawable.button_default);
            ymca_ee.setBackgroundResource(R.drawable.button_default);
            Log.e("branch",selected_branch);
        });
        ymca_cv.setOnClickListener(view -> {
            selected_branch="Cv";
            branch_for_intent="Civil";
            ymca_cse.setBackgroundResource(R.drawable.button_default);
            ymca_cv.setBackgroundResource(R.drawable.button_pressed);
            ymca_it.setBackgroundResource(R.drawable.button_default);
            ymca_me.setBackgroundResource(R.drawable.button_default);
            ymca_ec.setBackgroundResource(R.drawable.button_default);
            ymca_ee.setBackgroundResource(R.drawable.button_default);
            Log.e("branch",selected_branch);
        });
        ymca_me.setOnClickListener(view -> {
            selected_branch="Me";
            branch_for_intent="Mechanical";
            ymca_cse.setBackgroundResource(R.drawable.button_default);
            ymca_cv.setBackgroundResource(R.drawable.button_default);
            ymca_it.setBackgroundResource(R.drawable.button_default);
            ymca_me.setBackgroundResource(R.drawable.button_pressed);
            ymca_ec.setBackgroundResource(R.drawable.button_default);
            ymca_ee.setBackgroundResource(R.drawable.button_default);
            Log.e("branch",selected_branch);
        });
        ymca_ec.setOnClickListener(view -> {
            selected_branch="Ece";
            branch_for_intent="Electronics and communication";
            ymca_cse.setBackgroundResource(R.drawable.button_default);
            ymca_cv.setBackgroundResource(R.drawable.button_default);
            ymca_it.setBackgroundResource(R.drawable.button_default);
            ymca_me.setBackgroundResource(R.drawable.button_default);
            ymca_ec.setBackgroundResource(R.drawable.button_pressed);
            ymca_ee.setBackgroundResource(R.drawable.button_default);
            Log.e("branch",selected_branch);
        });
        ymca_ee.setOnClickListener(view -> {
            selected_branch="Ele";
            branch_for_intent="Electrical";
            ymca_cse.setBackgroundResource(R.drawable.button_default);
            ymca_cv.setBackgroundResource(R.drawable.button_default);
            ymca_it.setBackgroundResource(R.drawable.button_default);
            ymca_me.setBackgroundResource(R.drawable.button_default);
            ymca_ec.setBackgroundResource(R.drawable.button_default);
            ymca_ee.setBackgroundResource(R.drawable.button_pressed);
            Log.e("branch",selected_branch);
        });
        dp_first.setOnClickListener(v16 -> {
            selected_semester="first";
            semester_number="1";
            dp_first.setBackgroundResource(R.drawable.button_pressed);
            dp_second.setBackgroundResource(R.drawable.button_default);
            dp_third.setBackgroundResource(R.drawable.button_default);
            dp_fourth.setBackgroundResource(R.drawable.button_default);
            dp_fifth.setBackgroundResource(R.drawable.button_default);
            dp_sixth.setBackgroundResource(R.drawable.button_default);
        });
        dp_second.setOnClickListener(v15 -> {
            selected_semester="second";
            semester_number="2";
            dp_first.setBackgroundResource(R.drawable.button_default);
            dp_second.setBackgroundResource(R.drawable.button_pressed);
            dp_third.setBackgroundResource(R.drawable.button_default);
            dp_fourth.setBackgroundResource(R.drawable.button_default);
            dp_fifth.setBackgroundResource(R.drawable.button_default);
            dp_sixth.setBackgroundResource(R.drawable.button_default);
        });
        dp_third.setOnClickListener(v14 -> {
            selected_semester="third";
            semester_number="3";
            dp_first.setBackgroundResource(R.drawable.button_default);
            dp_second.setBackgroundResource(R.drawable.button_default);
            dp_third.setBackgroundResource(R.drawable.button_pressed);
            dp_fourth.setBackgroundResource(R.drawable.button_default);
            dp_fifth.setBackgroundResource(R.drawable.button_default);
            dp_sixth.setBackgroundResource(R.drawable.button_default);
        });
        dp_fourth.setOnClickListener(v13 -> {
            selected_semester="fourth";
            semester_number="4";
            dp_first.setBackgroundResource(R.drawable.button_default);
            dp_second.setBackgroundResource(R.drawable.button_default);
            dp_third.setBackgroundResource(R.drawable.button_default);
            dp_fourth.setBackgroundResource(R.drawable.button_pressed);
            dp_fifth.setBackgroundResource(R.drawable.button_default);
            dp_sixth.setBackgroundResource(R.drawable.button_default);
        });
        dp_fifth.setOnClickListener(v12 -> {
            selected_semester="fifth";
            semester_number="5";
            dp_first.setBackgroundResource(R.drawable.button_default);
            dp_second.setBackgroundResource(R.drawable.button_default);
            dp_third.setBackgroundResource(R.drawable.button_default);
            dp_fourth.setBackgroundResource(R.drawable.button_default);
            dp_fifth.setBackgroundResource(R.drawable.button_pressed);
            dp_sixth.setBackgroundResource(R.drawable.button_default);
        });
        dp_sixth.setOnClickListener(v1 -> {
            selected_semester="sixth";
            semester_number="6";
            dp_first.setBackgroundResource(R.drawable.button_default);
            dp_second.setBackgroundResource(R.drawable.button_default);
            dp_third.setBackgroundResource(R.drawable.button_default);
            dp_fourth.setBackgroundResource(R.drawable.button_default);
            dp_fifth.setBackgroundResource(R.drawable.button_default);
            dp_sixth.setBackgroundResource(R.drawable.button_pressed);
        });
        gju_cse.setOnClickListener(v120 -> {
            selected_branch="Cse";
            branch_for_intent="Computer science"; // for branches other than Cse when first or second sem is selected selected branch is
            // overriden to Cse
            gju_cse.setBackgroundResource(R.drawable.button_pressed);
            Log.e("branch",selected_branch);

        });
        gju_first.setOnClickListener(v16 -> {
            selected_semester="first";
            semester_number="1";
            gju_first.setBackgroundResource(R.drawable.button_pressed);
        });
        ku.setOnClickListener(view -> {
            board="KU_";
            selected_semester="null";
            selected_branch="null";
            ku_courses.setVisibility(View.VISIBLE);
            ku_semesters.setVisibility(View.VISIBLE);
            dp_courses.setVisibility(View.GONE);
            dp_semesters.setVisibility(View.GONE);
            gju_courses.setVisibility(View.GONE);
            gju_semesters.setVisibility(View.GONE);
            ymca_courses.setVisibility(View.GONE);
            ymca_semesters.setVisibility(View.GONE);
            first.setBackgroundResource(R.drawable.button_default);
            second.setBackgroundResource(R.drawable.button_default);
            third.setBackgroundResource(R.drawable.button_default);
            fourth.setBackgroundResource(R.drawable.button_default);
            fifth.setBackgroundResource(R.drawable.button_default);
            sixth.setBackgroundResource(R.drawable.button_default);
            seventh.setBackgroundResource(R.drawable.button_default);
            eight.setBackgroundResource(R.drawable.button_default);
            cse.setBackgroundResource(R.drawable.button_default);
            it.setBackgroundResource(R.drawable.button_default);
            me.setBackgroundResource(R.drawable.button_default);
            ec.setBackgroundResource(R.drawable.button_default);
            ee.setBackgroundResource(R.drawable.button_default);
            cv.setBackgroundResource(R.drawable.button_default);
            mb.setBackgroundResource(R.drawable.button_default);
            bb.setBackgroundResource(R.drawable.button_default);
            bc.setBackgroundResource(R.drawable.button_default);
            mc.setBackgroundResource(R.drawable.button_default);
            ku.setBackgroundResource(R.drawable.button_pressed);
            dp.setBackgroundResource(R.drawable.button_default);
            gju.setBackgroundResource(R.drawable.button_default);
            ymca.setBackgroundResource(R.drawable.button_default);

        });
        ymca.setOnClickListener(view -> {
            board="YM_";
            selected_semester="null";
            selected_branch="null";
            ymca_courses.setVisibility(View.VISIBLE);
            ymca_semesters.setVisibility(View.VISIBLE);
            dp_courses.setVisibility(View.GONE);
            dp_semesters.setVisibility(View.GONE);
            gju_courses.setVisibility(View.GONE);
            gju_semesters.setVisibility(View.GONE);
            ku_courses.setVisibility(View.GONE);
            ku_semesters.setVisibility(View.GONE);
            ymca_first.setBackgroundResource(R.drawable.button_default);
            ymca_second.setBackgroundResource(R.drawable.button_default);
            ymca_cse.setBackgroundResource(R.drawable.button_default);
            ymca_it.setBackgroundResource(R.drawable.button_default);
            ymca_me.setBackgroundResource(R.drawable.button_default);
            ymca_ec.setBackgroundResource(R.drawable.button_default);
            ymca_ee.setBackgroundResource(R.drawable.button_default);
            ymca_cv.setBackgroundResource(R.drawable.button_default);
            ymca.setBackgroundResource(R.drawable.button_pressed);
            ku.setBackgroundResource(R.drawable.button_default);
            dp.setBackgroundResource(R.drawable.button_default);
            gju.setBackgroundResource(R.drawable.button_default);

        });
        dp.setOnClickListener(view -> {
            board="HS_";
            selected_semester="null";
            selected_branch="null";
            ku_courses.setVisibility(View.GONE);
            ku_semesters.setVisibility(View.GONE);
            dp_courses.setVisibility(View.VISIBLE);
            dp_semesters.setVisibility(View.VISIBLE);
            gju_courses.setVisibility(View.GONE);
            gju_semesters.setVisibility(View.GONE);
            ymca_courses.setVisibility(View.GONE);
            ymca_semesters.setVisibility(View.GONE);
            dp_first.setBackgroundResource(R.drawable.button_default);
            dp_second.setBackgroundResource(R.drawable.button_default);
            dp_third.setBackgroundResource(R.drawable.button_default);
            dp_fourth.setBackgroundResource(R.drawable.button_default);
            dp_fifth.setBackgroundResource(R.drawable.button_default);
            dp_sixth.setBackgroundResource(R.drawable.button_default);
            dp_cse.setBackgroundResource(R.drawable.button_default);
            dp_dmlt.setBackgroundResource(R.drawable.button_default);
            dp_me.setBackgroundResource(R.drawable.button_default);
            dp_ec.setBackgroundResource(R.drawable.button_default);
            dp_ee.setBackgroundResource(R.drawable.button_default);
            dp_cv.setBackgroundResource(R.drawable.button_default);
            ku.setBackgroundResource(R.drawable.button_default);
            dp.setBackgroundResource(R.drawable.button_pressed);
            gju.setBackgroundResource(R.drawable.button_default);
            ymca.setBackgroundResource(R.drawable.button_default);

        });
        gju.setOnClickListener(view -> {
            board="GJ_";
            selected_semester="null";
            selected_branch="null";
            ku_courses.setVisibility(View.GONE);
            ku_semesters.setVisibility(View.GONE);
            dp_courses.setVisibility(View.GONE);
            dp_semesters.setVisibility(View.GONE);
            gju_courses.setVisibility(View.VISIBLE);
            gju_semesters.setVisibility(View.VISIBLE);
            ymca_courses.setVisibility(View.GONE);
            ymca_semesters.setVisibility(View.GONE);
            gju_first.setBackgroundResource(R.drawable.button_default);
            gju_cse.setBackgroundResource(R.drawable.button_default);
            ku.setBackgroundResource(R.drawable.button_default);
            dp.setBackgroundResource(R.drawable.button_default);
            ymca.setBackgroundResource(R.drawable.button_default);
            gju.setBackgroundResource(R.drawable.button_pressed);

        });
        search.setOnClickListener(view -> {
            if(selected_branch.equals("null") || selected_semester.equals("null") || board.equals("null"))
            {
                Toast.makeText(getActivity(), "Choose Board, Course and semester", Toast.LENGTH_SHORT).show();
            }
            else{
                if(board.equals("KU_")) {
                    if (selected_branch.equals("It") || selected_branch.equals("Me") || selected_branch.equals("Ece") || selected_branch.equals("Ele") || selected_branch.equals("Cv")) {
                        if (selected_semester.equals("first") || selected_semester.equals("second")) {
                            selected_branch = "Cse";
                            Log.e("Selected branch", selected_branch);
                            Intent intent = new Intent();
                            intent.putExtra("key", branch_for_intent + " " + semester_number + "semester");
                            intent.setClassName(getActivity(), board + selected_branch.toUpperCase() + "_subjectlists." + selected_branch + "_" + selected_semester + "sem_subjectlist");
                            startActivity(intent);
                        }
                        else {
                            Log.e("Selected branch", selected_branch);
                            Intent intent = new Intent();
                            intent.putExtra("key", branch_for_intent + " " + semester_number + "semester");
                            intent.setClassName(getActivity(), board + selected_branch.toUpperCase() + "_subjectlists." + selected_branch + "_" + selected_semester + "sem_subjectlist");
                            startActivity(intent);

                        }
                    }
                    else {
                        Log.e("Selected branch", selected_branch);
                        //classname = selected_branch.toUpperCase() + "_subjectlists." + selected_branch + "_" + selected_semester + "sem_subjectlist";
                        Intent intent = new Intent();
                        intent.putExtra("key", branch_for_intent + " " + semester_number + "semester");
                        intent.setClassName(getActivity(), board + selected_branch.toUpperCase() + "_subjectlists." + selected_branch + "_" + selected_semester + "sem_subjectlist");
                        startActivity(intent);

                    }
                }

                if(board.equals("HS_"))
                {
                    if(selected_branch.equals("Ml")){
                        if(selected_semester.equals("fifth") || selected_semester.equals("sixth"))
                        {
                            Toast.makeText(getActivity(), "Please select semester", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Log.e("Selected branch", selected_branch);
                            Intent intent = new Intent();
                            intent.putExtra("key", branch_for_intent + " " + semester_number + "semester");
                            intent.setClassName(getActivity(), board + selected_branch.toUpperCase() + "_subjectlists." + selected_branch + "_" + selected_semester + "sem_subjectlist");
                            startActivity(intent);
                        }
                    }
                    else {
                        if (selected_semester.equals("first") || selected_semester.equals("second")) {
                            selected_branch = "Co";
                            Log.e("Selected branch", selected_branch);
                            Intent intent = new Intent();
                            intent.putExtra("key", branch_for_intent + " " + semester_number + "semester");
                            intent.setClassName(getActivity(), board + selected_branch.toUpperCase() + "_subjectlists." + selected_branch + "_" + selected_semester + "sem_subjectlist");
                            startActivity(intent);
                        } else {
                            Log.e("Selected branch", selected_branch);
                            Intent intent = new Intent();
                            intent.putExtra("key", branch_for_intent + " " + semester_number + "semester");
                            intent.setClassName(getActivity(), board + selected_branch.toUpperCase() + "_subjectlists." + selected_branch + "_" + selected_semester + "sem_subjectlist");
                            startActivity(intent);

                        }
                    }
                }
                if(board.equals("GJ_")) {
                    Log.e("Selected branch", selected_branch);
                    Intent intent = new Intent();
                    intent.putExtra("key", branch_for_intent + " " + semester_number + "semester");
                    intent.setClassName(getActivity(), board + selected_branch.toUpperCase() + "_subjectlists." + selected_branch + "_" + selected_semester + "sem_subjectlist");
                    startActivity(intent);
                }
                if(board.equals("YM_")){
                    if (selected_branch.equals("Cse")|| selected_branch.equals("It") || selected_branch.equals("Me") || selected_branch.equals("Ece") || selected_branch.equals("Ele") || selected_branch.equals("Cv")) {
                        if (selected_semester.equals("first") || selected_semester.equals("second")) {
                            selected_branch = "Co";
                            Log.e("Selected branch", selected_branch);
                            Intent intent = new Intent();
                            intent.putExtra("key", branch_for_intent + " " + semester_number + "semester");
                            intent.setClassName(getActivity(), board + selected_branch.toUpperCase() + "_subjectlists." + selected_branch + "_" + selected_semester + "sem_subjectlist");
                            startActivity(intent);
                        }
                        else {
                            Log.e("Selected branch", selected_branch);
                            Intent intent = new Intent();
                            intent.putExtra("key", branch_for_intent + " " + semester_number + "semester");
                            intent.setClassName(getActivity(), board + selected_branch.toUpperCase() + "_subjectlists." + selected_branch + "_" + selected_semester + "sem_subjectlist");
                            startActivity(intent);

                        }
                    }
                    else {
                        Log.e("Selected branch", selected_branch);
                        //classname = selected_branch.toUpperCase() + "_subjectlists." + selected_branch + "_" + selected_semester + "sem_subjectlist";
                        Intent intent = new Intent();
                        intent.putExtra("key", branch_for_intent + " " + semester_number + "semester");
                        intent.setClassName(getActivity(), board + selected_branch.toUpperCase() + "_subjectlists." + selected_branch + "_" + selected_semester + "sem_subjectlist");
                        startActivity(intent);

                    }
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
        gju_courses.setVisibility(View.GONE);
        gju_semesters.setVisibility(View.GONE);
        ymca_courses.setVisibility(View.GONE);
        ymca_semesters.setVisibility(View.GONE);
        session.setBackgroundResource(R.drawable.button_pressed);

    }
}