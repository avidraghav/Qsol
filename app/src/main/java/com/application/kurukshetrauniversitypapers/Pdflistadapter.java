package com.application.kurukshetrauniversitypapers;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.application.kurukshetrauniversitypapers.LoginActivity;
import com.application.kurukshetrauniversitypapers.R;
import com.application.kurukshetrauniversitypapers.uploadPDF;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class Pdflistadapter extends ArrayAdapter<uploadPDF> {
    private Activity context;
    List<uploadPDF> pdflist;
    FirebaseAuth mAuth;


    public Pdflistadapter(Activity context, List<uploadPDF> pdflist) {
        super(context, R.layout.pdflist_row, pdflist);
        this.context = context;
        this.pdflist = pdflist;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.pdflist_row, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.pdfname);
        TextView textViewSol = (TextView) listViewItem.findViewById(R.id.solution);

        uploadPDF uploadPDF = pdflist.get(position);
        textViewName.setText(uploadPDF.getName());
        // textViewGenre.setText(artist.getArtistGenre());
        mAuth=FirebaseAuth.getInstance();
        textViewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFiles(position);

            }
        });
        textViewSol.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if (mAuth.getCurrentUser() != null) {
                    //Toast.makeText(context, "The user is already logged in", Toast.LENGTH_SHORT).show();
                    Toast.makeText(context, "solution", Toast.LENGTH_SHORT).show();
                }
                else{
                String[] items = {"Yes", "No"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("To get the solution login first");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                            Intent intent = new Intent(context, LoginActivity.class);
                            context.startActivity(intent);
                        }
                        if (which == 1) {

                        }
                    }
                });
                dialog.create().show();
            }
            }
        });
        return listViewItem;
    }

    public void viewFiles(int position){
        uploadPDF uploadPDF = pdflist.get(position);
        Intent intent = new Intent();
        intent.setType(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(uploadPDF.getUrl());
        if (uri.toString().contains(".pdf")) {
            intent.setDataAndType(uri, "application/pdf");
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }


}


