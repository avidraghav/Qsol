package com.application.kurukshetrauniversitypapers;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Adapters.SyllabusAdapter;
import utils.DynamicHeightForListViewHelper;
import utils.SingleDownloadClass;
import utils.uploadPDF;

public class SyllabusFragment extends Fragment {
    Button cse_syl,it_syl,me_syl,ee_syl,ec_syl,mb_syl,bb_syl,bc_syl,mc_syl,first_syl,second_syl,third_syl,fourth_syl,fifth_syl,sixth_syl,seventh_syl,eight_syl,session;
    Button dp_cse,dp_cv,dp_ee,dp_ec,dp_me,dp_dmlt,dp_first,dp_second,dp_third,dp_fourth,dp_fifth,dp_sixth;
    Button ku,dp;
    String board;
    String selected_branch_syllabus,selected_semester_syllabus;
    DatabaseReference databaseReference;
    ArrayList<String> subjects;
    List<uploadPDF> uploadPDFS;
    ListView listView;
    Button search_syl;
    RelativeLayout ku_courses,ku_semesters,dp_courses,dp_semesters;
    
    public SyllabusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_syllabus, container, false);
        cse_syl=v.findViewById(R.id.cse_syl);
        it_syl=v.findViewById(R.id.it_syl);
        me_syl=v.findViewById(R.id.me_syl);
        ee_syl=v.findViewById(R.id.ee_syl);
        ec_syl=v.findViewById(R.id.ec_syl);
        bb_syl=v.findViewById(R.id.bb_syl);
        mb_syl=v.findViewById(R.id.mb_syl);
        bc_syl=v.findViewById(R.id.bc_syl);
        mc_syl=v.findViewById(R.id.mc_syl);
        first_syl=v.findViewById(R.id.first_syl);
        second_syl=v.findViewById(R.id.second_syl);
        third_syl=v.findViewById(R.id.third_syl);
        fourth_syl=v.findViewById(R.id.fourth_syl);
        fifth_syl=v.findViewById(R.id.fifth_syl);
        sixth_syl=v.findViewById(R.id.sixth_syl);
        seventh_syl=v.findViewById(R.id.seventh_syl);
        eight_syl=v.findViewById(R.id.eight_syl);
        uploadPDFS= new ArrayList<>();
        subjects=new ArrayList<>();
        listView=v.findViewById(R.id.list_syllabus);
        search_syl=v.findViewById(R.id.sy_search);
        session=v.findViewById(R.id.session_20_21);
        ku_courses=v.findViewById(R.id.sy_ku_courses);
        ku_semesters=v.findViewById(R.id.sy_ku_semesters);
        dp_courses=v.findViewById(R.id.sy_dp_courses);
        dp_semesters=v.findViewById(R.id.sy_dp_semesters);
        ku=v.findViewById(R.id.sy_ku);
        dp=v.findViewById(R.id.sy_dp);
        dp_cse=v.findViewById(R.id.sy_dp_cse);
        dp_cv=v.findViewById(R.id.sy_dp_cv);
        dp_me=v.findViewById(R.id.sy_dp_me);
        dp_ee=v.findViewById(R.id.sy_dp_ee);
        dp_ec=v.findViewById(R.id.sy_dp_ec);
        dp_dmlt=v.findViewById(R.id.sy_dp_dmlt);
        dp_first=v.findViewById(R.id.sy_dp_first);
        dp_second=v.findViewById(R.id.sy_dp_second);
        dp_third=v.findViewById(R.id.sy_dp_third);
        dp_fourth=v.findViewById(R.id.sy_dp_fourth);
        dp_fifth=v.findViewById(R.id.sy_dp_fifth);
        dp_sixth=v.findViewById(R.id.sy_dp_sixth);

       displayDefaultResults();
        cse_syl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selected_branch_syllabus="CS";
                kuBoard();
                cse_syl.setBackgroundResource(R.drawable.button_pressed);
                it_syl.setBackgroundResource(R.drawable.button_default);
                me_syl.setBackgroundResource(R.drawable.button_default);
                ec_syl.setBackgroundResource(R.drawable.button_default);
                ee_syl.setBackgroundResource(R.drawable.button_default);
                mb_syl.setBackgroundResource(R.drawable.button_default);
                bb_syl.setBackgroundResource(R.drawable.button_default);
                bc_syl.setBackgroundResource(R.drawable.button_default);
                mc_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setEnabled(true);
                fourth_syl.setEnabled(true);
                fifth_syl.setEnabled(true);
                sixth_syl.setEnabled(true);
                seventh_syl.setEnabled(true);
                eight_syl.setEnabled(true);

            }
        });
        it_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kuBoard();
                selected_branch_syllabus="IT";

                cse_syl.setBackgroundResource(R.drawable.button_default);
                it_syl.setBackgroundResource(R.drawable.button_pressed);
                me_syl.setBackgroundResource(R.drawable.button_default);
                ec_syl.setBackgroundResource(R.drawable.button_default);
                ee_syl.setBackgroundResource(R.drawable.button_default);
                mb_syl.setBackgroundResource(R.drawable.button_default);
                bb_syl.setBackgroundResource(R.drawable.button_default);
                bc_syl.setBackgroundResource(R.drawable.button_default);
                mc_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setEnabled(true);
                fifth_syl.setEnabled(true);
                fourth_syl.setEnabled(true);
                sixth_syl.setEnabled(true);
                seventh_syl.setEnabled(true);
                eight_syl.setEnabled(true);
            }
        });
        me_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kuBoard();
                selected_branch_syllabus="ME";

                cse_syl.setBackgroundResource(R.drawable.button_default);
                it_syl.setBackgroundResource(R.drawable.button_default);
                me_syl.setBackgroundResource(R.drawable.button_pressed);
                ec_syl.setBackgroundResource(R.drawable.button_default);
                ee_syl.setBackgroundResource(R.drawable.button_default);
                mb_syl.setBackgroundResource(R.drawable.button_default);
                bb_syl.setBackgroundResource(R.drawable.button_default);
                bc_syl.setBackgroundResource(R.drawable.button_default);
                mc_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setEnabled(true);
                fifth_syl.setEnabled(true);
                fourth_syl.setEnabled(true);
                sixth_syl.setEnabled(true);
                seventh_syl.setEnabled(true);
                eight_syl.setEnabled(true);
            }
        });
        ec_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kuBoard();
                selected_branch_syllabus="EC";

                cse_syl.setBackgroundResource(R.drawable.button_default);
                it_syl.setBackgroundResource(R.drawable.button_default);
                me_syl.setBackgroundResource(R.drawable.button_default);
                ec_syl.setBackgroundResource(R.drawable.button_pressed);
                ee_syl.setBackgroundResource(R.drawable.button_default);
                mb_syl.setBackgroundResource(R.drawable.button_default);
                bb_syl.setBackgroundResource(R.drawable.button_default);
                bc_syl.setBackgroundResource(R.drawable.button_default);
                mc_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setEnabled(true);
                fifth_syl.setEnabled(true);
                fourth_syl.setEnabled(true);
                sixth_syl.setEnabled(true);
                seventh_syl.setEnabled(true);
                eight_syl.setEnabled(true);
            }
        });
        ee_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kuBoard();
                selected_branch_syllabus="EL";

                cse_syl.setBackgroundResource(R.drawable.button_default);
                it_syl.setBackgroundResource(R.drawable.button_default);
                me_syl.setBackgroundResource(R.drawable.button_default);
                ec_syl.setBackgroundResource(R.drawable.button_default);
                ee_syl.setBackgroundResource(R.drawable.button_pressed);
                mb_syl.setBackgroundResource(R.drawable.button_default);
                bb_syl.setBackgroundResource(R.drawable.button_default);
                bc_syl.setBackgroundResource(R.drawable.button_default);
                mc_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setEnabled(false);
                fifth_syl.setEnabled(false);
                fourth_syl.setEnabled(true);
                sixth_syl.setEnabled(true);
                seventh_syl.setEnabled(true);
                eight_syl.setEnabled(true);
            }
        });
        mb_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch_syllabus="MB";
                kuBoard();
                cse_syl.setBackgroundResource(R.drawable.button_default);
                it_syl.setBackgroundResource(R.drawable.button_default);
                me_syl.setBackgroundResource(R.drawable.button_default);
                ec_syl.setBackgroundResource(R.drawable.button_default);
                ee_syl.setBackgroundResource(R.drawable.button_default);
                mb_syl.setBackgroundResource(R.drawable.button_pressed);
                bb_syl.setBackgroundResource(R.drawable.button_default);
                bc_syl.setBackgroundResource(R.drawable.button_default);
                mc_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setEnabled(false);
                fourth_syl.setEnabled(false);
                fifth_syl.setEnabled(false);
                sixth_syl.setEnabled(false);
                seventh_syl.setEnabled(false);
                eight_syl.setEnabled(false);
                Log.e("branch",selected_branch_syllabus);
            }
        });
        bb_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_branch_syllabus="BB";
                kuBoard();
                cse_syl.setBackgroundResource(R.drawable.button_default);
                it_syl.setBackgroundResource(R.drawable.button_default);
                me_syl.setBackgroundResource(R.drawable.button_default);
                ec_syl.setBackgroundResource(R.drawable.button_default);
                ee_syl.setBackgroundResource(R.drawable.button_default);
                mb_syl.setBackgroundResource(R.drawable.button_default);
                bb_syl.setBackgroundResource(R.drawable.button_pressed);
                bc_syl.setBackgroundResource(R.drawable.button_default);
                mc_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setEnabled(true);
                fourth_syl.setEnabled(true);
                fifth_syl.setEnabled(true);
                sixth_syl.setEnabled(true);
                seventh_syl.setEnabled(false);
                eight_syl.setEnabled(false);
                Log.e("branch",selected_branch_syllabus);
            }
        });
        bc_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kuBoard();
                selected_branch_syllabus="BC";
                cse_syl.setBackgroundResource(R.drawable.button_default);
                it_syl.setBackgroundResource(R.drawable.button_default);
                me_syl.setBackgroundResource(R.drawable.button_default);
                ec_syl.setBackgroundResource(R.drawable.button_default);
                ee_syl.setBackgroundResource(R.drawable.button_default);
                mb_syl.setBackgroundResource(R.drawable.button_default);
                bb_syl.setBackgroundResource(R.drawable.button_default);
                bc_syl.setBackgroundResource(R.drawable.button_pressed);
                mc_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setEnabled(true);
                fourth_syl.setEnabled(true);
                fifth_syl.setEnabled(true);
                sixth_syl.setEnabled(true);
                seventh_syl.setEnabled(false);
                eight_syl.setEnabled(false);
                Log.e("branch",selected_branch_syllabus);
            }
        });
        mc_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kuBoard();
                selected_branch_syllabus="MC";
                cse_syl.setBackgroundResource(R.drawable.button_default);
                it_syl.setBackgroundResource(R.drawable.button_default);
                me_syl.setBackgroundResource(R.drawable.button_default);
                ec_syl.setBackgroundResource(R.drawable.button_default);
                ee_syl.setBackgroundResource(R.drawable.button_default);
                mb_syl.setBackgroundResource(R.drawable.button_default);
                bb_syl.setBackgroundResource(R.drawable.button_default);
                bc_syl.setBackgroundResource(R.drawable.button_default);
                mc_syl.setBackgroundResource(R.drawable.button_pressed);
                third_syl.setEnabled(false);
                fourth_syl.setEnabled(false);
                fifth_syl.setEnabled(false);
                sixth_syl.setEnabled(false);
                seventh_syl.setEnabled(false);
                eight_syl.setEnabled(false);
                Log.e("branch",selected_branch_syllabus);
            }
        });
        dp_cse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selected_branch_syllabus="CS";
                hsBoard();
                dp_cse.setBackgroundResource(R.drawable.button_pressed);
                dp_dmlt.setBackgroundResource(R.drawable.button_default);
                dp_me.setBackgroundResource(R.drawable.button_default);
                dp_ec.setBackgroundResource(R.drawable.button_default);
                dp_ee.setBackgroundResource(R.drawable.button_default);
                dp_cv.setBackgroundResource(R.drawable.button_default);
                dp_fifth.setVisibility(View.VISIBLE);
                dp_sixth.setVisibility(View.VISIBLE);


            }
        });
        dp_cv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hsBoard();
                selected_branch_syllabus="CV";
                dp_cse.setBackgroundResource(R.drawable.button_default);
                dp_dmlt.setBackgroundResource(R.drawable.button_default);
                dp_me.setBackgroundResource(R.drawable.button_default);
                dp_ec.setBackgroundResource(R.drawable.button_default);
                dp_ee.setBackgroundResource(R.drawable.button_default);
                dp_cv.setBackgroundResource(R.drawable.button_pressed);
                dp_fifth.setVisibility(View.VISIBLE);
                dp_sixth.setVisibility(View.VISIBLE);


            }
        });
        dp_me.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hsBoard();
                selected_branch_syllabus="ME";
                dp_cse.setBackgroundResource(R.drawable.button_default);
                dp_dmlt.setBackgroundResource(R.drawable.button_default);
                dp_me.setBackgroundResource(R.drawable.button_pressed);
                dp_ec.setBackgroundResource(R.drawable.button_default);
                dp_ee.setBackgroundResource(R.drawable.button_default);
                dp_cv.setBackgroundResource(R.drawable.button_default);
                dp_fifth.setVisibility(View.VISIBLE);
                dp_sixth.setVisibility(View.VISIBLE);
            }
        });
        dp_ee.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hsBoard();
                selected_branch_syllabus="EL";
                dp_cse.setBackgroundResource(R.drawable.button_default);
                dp_dmlt.setBackgroundResource(R.drawable.button_default);
                dp_me.setBackgroundResource(R.drawable.button_default);
                dp_ec.setBackgroundResource(R.drawable.button_default);
                dp_ee.setBackgroundResource(R.drawable.button_pressed);
                dp_cv.setBackgroundResource(R.drawable.button_default);
                dp_fifth.setVisibility(View.VISIBLE);
                dp_sixth.setVisibility(View.VISIBLE);
            }
        });
        dp_ec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hsBoard();
                selected_branch_syllabus="EC";
                dp_cse.setBackgroundResource(R.drawable.button_default);
                dp_dmlt.setBackgroundResource(R.drawable.button_default);
                dp_me.setBackgroundResource(R.drawable.button_default);
                dp_ec.setBackgroundResource(R.drawable.button_pressed);
                dp_ee.setBackgroundResource(R.drawable.button_default);
                dp_cv.setBackgroundResource(R.drawable.button_default);
                dp_fifth.setVisibility(View.VISIBLE);
                dp_sixth.setVisibility(View.VISIBLE);
            }
        });
        dp_dmlt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hsBoard();
                selected_branch_syllabus="ML";
                dp_cse.setBackgroundResource(R.drawable.button_default);
                dp_dmlt.setBackgroundResource(R.drawable.button_pressed);
                dp_me.setBackgroundResource(R.drawable.button_default);
                dp_ec.setBackgroundResource(R.drawable.button_default);
                dp_ee.setBackgroundResource(R.drawable.button_default);
                dp_cv.setBackgroundResource(R.drawable.button_default);
                dp_fifth.setVisibility(View.GONE);
                dp_sixth.setVisibility(View.GONE);
            }
        });

        first_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester_syllabus = "01";
                kuBoard();
                first_syl.setBackgroundResource(R.drawable.button_pressed);
                second_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setBackgroundResource(R.drawable.button_default);
                fourth_syl.setBackgroundResource(R.drawable.button_default);
                fifth_syl.setBackgroundResource(R.drawable.button_default);
                sixth_syl.setBackgroundResource(R.drawable.button_default);
                seventh_syl.setBackgroundResource(R.drawable.button_default);
                eight_syl.setBackgroundResource(R.drawable.button_default);
            }
        });
        second_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester_syllabus="02";
                kuBoard();
                first_syl.setBackgroundResource(R.drawable.button_default);
                second_syl.setBackgroundResource(R.drawable.button_pressed);
                third_syl.setBackgroundResource(R.drawable.button_default);
                fourth_syl.setBackgroundResource(R.drawable.button_default);
                fifth_syl.setBackgroundResource(R.drawable.button_default);
                sixth_syl.setBackgroundResource(R.drawable.button_default);
                seventh_syl.setBackgroundResource(R.drawable.button_default);
                eight_syl.setBackgroundResource(R.drawable.button_default);
            }
        });
        third_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester_syllabus="03";
                kuBoard();
                first_syl.setBackgroundResource(R.drawable.button_default);
                second_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setBackgroundResource(R.drawable.button_pressed);
                fourth_syl.setBackgroundResource(R.drawable.button_default);
                fifth_syl.setBackgroundResource(R.drawable.button_default);
                sixth_syl.setBackgroundResource(R.drawable.button_default);
                seventh_syl.setBackgroundResource(R.drawable.button_default);
                eight_syl.setBackgroundResource(R.drawable.button_default);
            }
        });
        fourth_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester_syllabus="04";
                kuBoard();
                first_syl.setBackgroundResource(R.drawable.button_default);
                second_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setBackgroundResource(R.drawable.button_default);
                fourth_syl.setBackgroundResource(R.drawable.button_pressed);
                fifth_syl.setBackgroundResource(R.drawable.button_default);
                sixth_syl.setBackgroundResource(R.drawable.button_default);
                seventh_syl.setBackgroundResource(R.drawable.button_default);
                eight_syl.setBackgroundResource(R.drawable.button_default);

            }
        });
        fifth_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester_syllabus="05";
                kuBoard();
                first_syl.setBackgroundResource(R.drawable.button_default);
                second_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setBackgroundResource(R.drawable.button_default);
                fourth_syl.setBackgroundResource(R.drawable.button_default);
                fifth_syl.setBackgroundResource(R.drawable.button_pressed);
                sixth_syl.setBackgroundResource(R.drawable.button_default);
                seventh_syl.setBackgroundResource(R.drawable.button_default);
                eight_syl.setBackgroundResource(R.drawable.button_default);
            }
        });
        sixth_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester_syllabus="06";
                kuBoard();
                first_syl.setBackgroundResource(R.drawable.button_default);
                second_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setBackgroundResource(R.drawable.button_default);
                fourth_syl.setBackgroundResource(R.drawable.button_default);
                fifth_syl.setBackgroundResource(R.drawable.button_default);
                sixth_syl.setBackgroundResource(R.drawable.button_pressed);
                seventh_syl.setBackgroundResource(R.drawable.button_default);
                eight_syl.setBackgroundResource(R.drawable.button_default);
            }
        });
        seventh_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester_syllabus="07";
                kuBoard();
                first_syl.setBackgroundResource(R.drawable.button_default);
                second_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setBackgroundResource(R.drawable.button_default);
                fourth_syl.setBackgroundResource(R.drawable.button_default);
                fifth_syl.setBackgroundResource(R.drawable.button_default);
                sixth_syl.setBackgroundResource(R.drawable.button_default);
                seventh_syl.setBackgroundResource(R.drawable.button_pressed);
                eight_syl.setBackgroundResource(R.drawable.button_default);

            }
        });
        eight_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester_syllabus="08";
                kuBoard();
                first_syl.setBackgroundResource(R.drawable.button_default);
                second_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setBackgroundResource(R.drawable.button_default);
                fourth_syl.setBackgroundResource(R.drawable.button_default);
                fifth_syl.setBackgroundResource(R.drawable.button_default);
                sixth_syl.setBackgroundResource(R.drawable.button_default);
                seventh_syl.setBackgroundResource(R.drawable.button_default);
                eight_syl.setBackgroundResource(R.drawable.button_pressed);
            }
        });
        dp_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester_syllabus="01";
                hsBoard();
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
                selected_semester_syllabus="02";
                hsBoard();
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
                selected_semester_syllabus="03";
                hsBoard();
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
                selected_semester_syllabus="04";
                hsBoard();
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
                selected_semester_syllabus="05";
                hsBoard();
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
                selected_semester_syllabus="06";
                hsBoard();
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
                board="KU_";
                selected_semester_syllabus="null";
                selected_branch_syllabus="null";
                ku_courses.setVisibility(View.VISIBLE);
                ku_semesters.setVisibility(View.VISIBLE);
                dp_courses.setVisibility(View.GONE);
                dp_semesters.setVisibility(View.GONE);
                first_syl.setBackgroundResource(R.drawable.button_default);
                second_syl.setBackgroundResource(R.drawable.button_default);
                third_syl.setBackgroundResource(R.drawable.button_default);
                fourth_syl.setBackgroundResource(R.drawable.button_default);
                fifth_syl.setBackgroundResource(R.drawable.button_default);
                sixth_syl.setBackgroundResource(R.drawable.button_default);
                seventh_syl.setBackgroundResource(R.drawable.button_default);
                eight_syl.setBackgroundResource(R.drawable.button_default);
                cse_syl.setBackgroundResource(R.drawable.button_default);
                it_syl.setBackgroundResource(R.drawable.button_default);
                me_syl.setBackgroundResource(R.drawable.button_default);
                ec_syl.setBackgroundResource(R.drawable.button_default);
                ee_syl.setBackgroundResource(R.drawable.button_default);
                mb_syl.setBackgroundResource(R.drawable.button_default);
                bb_syl.setBackgroundResource(R.drawable.button_default);
                bc_syl.setBackgroundResource(R.drawable.button_default);
                mc_syl.setBackgroundResource(R.drawable.button_default);
                ku.setBackgroundResource(R.drawable.button_pressed);
                dp.setBackgroundResource(R.drawable.button_default);

            }
        });
        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board="HS_";
                selected_semester_syllabus="null";
                selected_branch_syllabus="null";
                ku_courses.setVisibility(View.GONE);
                ku_semesters.setVisibility(View.GONE);
                dp_courses.setVisibility(View.VISIBLE);
                dp_semesters.setVisibility(View.VISIBLE);
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

            }
        });

        search_syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selected_semester_syllabus.equals("null") || selected_branch_syllabus.equals("null")) {
                    Toast.makeText(getActivity(), "Select branch and semester", Toast.LENGTH_SHORT).show();
                }
                else {
                    SingleDownloadClass singleDownloadClass = new SingleDownloadClass();
                    singleDownloadClass.setBranch(selected_branch_syllabus);
                    singleDownloadClass.setSemester(selected_semester_syllabus);
                    databaseReference = FirebaseDatabase.getInstance().getReference("IN/" + board + "/" + selected_branch_syllabus + "/" + selected_semester_syllabus + "/" + "Syllabus");
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            uploadPDFS.clear();
                            for (DataSnapshot pdfSnapshot : dataSnapshot.getChildren()) {
                                uploadPDF uploadPDF = pdfSnapshot.getValue(uploadPDF.class);
                                uploadPDFS.add(uploadPDF);
                            }
                            SyllabusAdapter adapter = new SyllabusAdapter(getActivity(), uploadPDFS);
                            listView.setAdapter(adapter);
                            DynamicHeightForListViewHelper.setListViewHeightBasedOnChildren(listView);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });
        
        return v;
    }

    public void displayDefaultResults()
    {
        selected_branch_syllabus="CS";
        selected_semester_syllabus="01";
        board="KU";
        cse_syl.setBackgroundResource(R.drawable.button_pressed);
        first_syl.setBackgroundResource(R.drawable.button_pressed);
        session.setBackgroundResource(R.drawable.button_pressed);
        ku.setBackgroundResource(R.drawable.button_pressed);
    }
    public void kuBoard(){
        board="KU";
    }
    public void hsBoard(){
        board="HS";
    }
}