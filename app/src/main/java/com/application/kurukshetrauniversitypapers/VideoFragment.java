package com.application.kurukshetrauniversitypapers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import utils.Videoinfo;

public class VideoFragment extends Fragment {
    List<Videoinfo> video_info;
    ImageView image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        
        View v= inflater.inflate(R.layout.fragment_videos, container, false);
        image=v.findViewById(R.id.teacher_image);
        video_info = new ArrayList<>();

        return v;
    }
}
