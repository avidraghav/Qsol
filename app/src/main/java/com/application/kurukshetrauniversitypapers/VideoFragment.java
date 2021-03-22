package com.application.kurukshetrauniversitypapers;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class VideoFragment extends Fragment {
    Button cse,first,second,third,fourth,fifth,sixth,session;
    Button ku;
    String selected_branch = "null",selected_semester = "null",semester_number="null",branch_for_intent="null";
    String board="null";
    RelativeLayout ku_courses,ku_semesters,dp_courses,dp_semesters;

    Button search;
    TextView betafetaure;

  public VideoFragment(){
      //empty constructor
  }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        
        View v= inflater.inflate(R.layout.fragment_videos, container, false);
        cse=v.findViewById(R.id.cse);
        first=v.findViewById(R.id.first);
        third=v.findViewById(R.id.third);
        sixth=v.findViewById(R.id.sixth);
        search=v.findViewById(R.id.search);
        ku_courses=v.findViewById(R.id.ku_courses);
        ku_semesters=v.findViewById(R.id.ku_semesters);
        ku=v.findViewById(R.id.ku);
        session=v.findViewById(R.id.session_20_21);
        betafetaure=v.findViewById(R.id.textview_betafeature);

        setDefaultList();
        cse.setOnClickListener(v1 -> {
            selected_branch="CS";
            cse.setBackgroundResource(R.drawable.button_pressed);
            third.setEnabled(true);
            sixth.setEnabled(true);
            Log.e("branch",selected_branch);
        });
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="01";
                first.setBackgroundResource(R.drawable.button_pressed);
                third.setBackgroundResource(R.drawable.button_default);
                sixth.setBackgroundResource(R.drawable.button_default);
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="03";
                first.setBackgroundResource(R.drawable.button_default);
                third.setBackgroundResource(R.drawable.button_pressed);
                sixth.setBackgroundResource(R.drawable.button_default);
            }
        });
        sixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_semester="06";
                first.setBackgroundResource(R.drawable.button_default);
                third.setBackgroundResource(R.drawable.button_default);
                sixth.setBackgroundResource(R.drawable.button_pressed);
            }
        });

        ku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board="KU";
                selected_semester="null";
                selected_branch="null";
                ku_courses.setVisibility(View.VISIBLE);
                ku_semesters.setVisibility(View.VISIBLE);
                first.setBackgroundResource(R.drawable.button_default);
                third.setBackgroundResource(R.drawable.button_default);
                sixth.setBackgroundResource(R.drawable.button_default);
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
                    Intent intent = new Intent(getActivity(), PlaylistsAvailableActivity.class);
                    intent.putExtra("video_loc", "IN/"+board+"/"+selected_branch+"/"+selected_semester+"/Videos");
                    Log.e("info","IN/"+board+"/"+selected_branch+"/"+selected_semester);
                    startActivity(intent);
                }
            }
        });
        betafetaure.setOnClickListener(view -> {
            androidx.appcompat.app.AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
            dialog.setMessage("This feature will currently work for some courses only. If the testing is successful and feedback is positive, it will be extended further to know more contact at qsol.info@gmail.com");
            dialog.setTitle("Information");
            dialog.setPositiveButton("OK", null);
            dialog.setCancelable(true);
            dialog.setPositiveButton("OK",
                    (dialog1, which) -> {
                        //dismiss the dialog
                    });
            dialog.create().show();

        });
        return v;


    }

    public void setDefaultList()
    {
        ku_courses.setVisibility(View.VISIBLE);
        ku_semesters.setVisibility(View.VISIBLE);
        session.setBackgroundResource(R.drawable.button_pressed);
    }



}