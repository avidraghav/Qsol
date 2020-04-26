package com.example.kurukshetrauniversitypapers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Pdflist extends AppCompatActivity {
     ListView listView;
     DatabaseReference databaseReference;
     List<uploadPDF> uploadPDFS;
     PDFView pdfView;
     String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdflist);
        listView=findViewById(R.id.btechfirst2019);
        uploadPDFS= new ArrayList<>();
        //pdfView=findViewById(R.id.pdfView);

        Intent intent=getIntent();
        key=intent.getStringExtra("key");
        if(key.equals("first19")) {
            viewAllFiles1();
        }
        if(key.equals("first18")) {
            viewAllFiles2();
        }
        if(key.equals("first17")) {
            viewAllFiles3();
        }
        if(key.equals("1")) {
            viewAllFiles4();
        }
        if(key.equals("2")) {
            viewAllFiles5();
        }
        if(key.equals("3")) {
            viewAllFiles6();
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                uploadPDF uploadPDF=uploadPDFS.get(position);
               // pdfView.fromUri(Uri.parse(uploadPDF.getUrl()));
               // Intent intent=new Intent(getBaseContext(),Pdfviewer.class);
                Intent intent=new Intent();
                intent.setType(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(uploadPDF.getUrl()));
                startActivity(intent);
//

            }
        });
    }

    private void viewAllFiles1() {
        databaseReference= FirebaseDatabase.getInstance().getReference("btech_first_sem_2019");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                 uploadPDF uploadPDF=postSnapshot.getValue(com.example.kurukshetrauniversitypapers.uploadPDF.class);
                 uploadPDFS.add(uploadPDF);


             }
             String[] uploads=new String[uploadPDFS.size()];
             for(int i=0; i<uploads.length;i++){
                 uploads[i]=uploadPDFS.get(i).getName();
             }
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploads){
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view=super.getView(position, convertView, parent);
                        TextView myText=(TextView) view.findViewById(android.R.id.text1);
                        myText.setTextColor(Color.BLACK);
                        return view;
                    }
                };
             listView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void viewAllFiles2() {
        databaseReference= FirebaseDatabase.getInstance().getReference("btech_first_sem_2018");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    uploadPDF uploadPDF=postSnapshot.getValue(com.example.kurukshetrauniversitypapers.uploadPDF.class);
                    uploadPDFS.add(uploadPDF);


                }
                String[] uploads=new String[uploadPDFS.size()];
                for(int i=0; i<uploads.length;i++){
                    uploads[i]=uploadPDFS.get(i).getName();
                }
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploads){
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view=super.getView(position, convertView, parent);
                        TextView myText=(TextView) view.findViewById(android.R.id.text1);
                        myText.setTextColor(Color.BLACK);
                        return view;
                    }
                };
                listView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void viewAllFiles3() {
        databaseReference= FirebaseDatabase.getInstance().getReference("btech_first_sem_2017");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    uploadPDF uploadPDF=postSnapshot.getValue(com.example.kurukshetrauniversitypapers.uploadPDF.class);
                    uploadPDFS.add(uploadPDF);


                }
                String[] uploads=new String[uploadPDFS.size()];
                for(int i=0; i<uploads.length;i++){
                    uploads[i]=uploadPDFS.get(i).getName();
                }
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploads){
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view=super.getView(position, convertView, parent);
                        TextView myText=(TextView) view.findViewById(android.R.id.text1);
                        myText.setTextColor(Color.BLACK);
                        return view;
                    }
                };
                listView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void viewAllFiles4() {
        databaseReference= FirebaseDatabase.getInstance().getReference("btech_second_sem_2019");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    uploadPDF uploadPDF=postSnapshot.getValue(com.example.kurukshetrauniversitypapers.uploadPDF.class);
                    uploadPDFS.add(uploadPDF);


                }
                String[] uploads=new String[uploadPDFS.size()];
                for(int i=0; i<uploads.length;i++){
                    uploads[i]=uploadPDFS.get(i).getName();
                }
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploads){
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view=super.getView(position, convertView, parent);
                        TextView myText=(TextView) view.findViewById(android.R.id.text1);
                        myText.setTextColor(Color.BLACK);
                        return view;
                    }
                };
                listView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void viewAllFiles5() {
        databaseReference= FirebaseDatabase.getInstance().getReference("btech_second_sem_2018");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    uploadPDF uploadPDF=postSnapshot.getValue(com.example.kurukshetrauniversitypapers.uploadPDF.class);
                    uploadPDFS.add(uploadPDF);


                }
                String[] uploads=new String[uploadPDFS.size()];
                for(int i=0; i<uploads.length;i++){
                    uploads[i]=uploadPDFS.get(i).getName();
                }
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploads){
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view=super.getView(position, convertView, parent);
                        TextView myText=(TextView) view.findViewById(android.R.id.text1);
                        myText.setTextColor(Color.BLACK);
                        return view;
                    }
                };
                listView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void viewAllFiles6() {
        databaseReference= FirebaseDatabase.getInstance().getReference("btech_second_sem_2017");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    uploadPDF uploadPDF=postSnapshot.getValue(com.example.kurukshetrauniversitypapers.uploadPDF.class);
                    uploadPDFS.add(uploadPDF);


                }
                String[] uploads=new String[uploadPDFS.size()];
                for(int i=0; i<uploads.length;i++){
                    uploads[i]=uploadPDFS.get(i).getName();
                }
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploads){
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view=super.getView(position, convertView, parent);
                        TextView myText=(TextView) view.findViewById(android.R.id.text1);
                        myText.setTextColor(Color.BLACK);
                        return view;
                    }
                };
                listView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
