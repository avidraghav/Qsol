package com.example.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Cse_firstsem_subjectlist extends AppCompatActivity {
 ListView listView;
 int papercount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_firstsem_subjectlist);
        listView=findViewById(R.id.list);
        final ArrayList<String> subjects=new ArrayList<String >();
        subjects.add("Physics");
        subjects.add("Mathematics");
        subjects.add("Foundation of computer programming");
        subjects.add("Engineering drawing and graphics");
        subjects.add("Biotechnology");
//        subjects.add("Business Intelligence and entrepreneurship");
//        subjects.add("Organistional behaviour");
//        subjects.add("Operating systems");
//        subjects.add("Programming for problem solving");
//        subjects.add("Discrete");
//        subjects.add("Database management");
//        subjects.add("Internet fundamentals and management");

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,subjects);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(subjects.get(position).equals("Physics")) {
                    Intent intent1 = new Intent(getBaseContext(), Pdflist.class);
                    intent1.putExtra("subject", "cse-firstsem-Physics");
                    startActivity(intent1);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(subjects.get(position).equals("Mathematics")) {
                    Intent intent1 = new Intent(getBaseContext(), Pdflist.class);
                    intent1.putExtra("subject", "cse-firstsem-Mathematics");
                    startActivity(intent1);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(subjects.get(position).equals("Foundation of computer programming")) {
                    Intent intent1 = new Intent(getBaseContext(), Pdflist.class);
                    intent1.putExtra("subject", "cse-firstsem-Foundation of computer programming");
                    startActivity(intent1);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(subjects.get(position).equals("Engineering drawing and graphics")) {
                    Intent intent1 = new Intent(getBaseContext(), Pdflist.class);
                    intent1.putExtra("subject", "cse-firstsem-Engineering drawing and graphics");
                    startActivity(intent1);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(subjects.get(position).equals("Biotechnology")) {
                    Intent intent1 = new Intent(getBaseContext(), Pdflist.class);
                    intent1.putExtra("subject", "cse-firstsem-Biotechnology");
                    startActivity(intent1);
                    Toast.makeText(Cse_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
