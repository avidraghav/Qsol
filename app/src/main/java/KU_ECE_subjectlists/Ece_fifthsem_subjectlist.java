package KU_ECE_subjectlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import utils.GlobalClass;
import utils.Listdata;
import com.application.kurukshetrauniversitypapers.Pdflist;
import com.application.kurukshetrauniversitypapers.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import Adapters.Listadapter;

public class Ece_fifthsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int el_eightpapercount1;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ece_fifthsem_subjectlist);
        listView = findViewById(R.id.list);
        downloadall = findViewById(R.id.download_btn);
        subjectname = findViewById(R.id.subjectname);
        papercount = findViewById(R.id.papercount);
        textView = findViewById(R.id.textView);
        subjectlist = new ArrayList<>();

        Intent intent = getIntent();
        key = intent.getStringExtra("key");
        textView.setText(key);

        GlobalClass globalClass = (GlobalClass) getApplicationContext();
        globalClass.setBoard("KU");
        globalClass.setBranch("EC");
        globalClass.setSemester("05");

        ref = FirebaseDatabase.getInstance().getReference("IN/KU/EC/05");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if (dataSnapshot.getKey().equals("EW")) {
                    el_eightpapercount1 = (int) dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Electromagnetic waves", el_eightpapercount1 + ""));
                }
                if (dataSnapshot.getKey().equals("II")) {
                    el_eightpapercount1 = (int) dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Information theory and coding", el_eightpapercount1 + ""));
                }
                if (dataSnapshot.getKey().equals("CO")) {
                    el_eightpapercount1 = (int) dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer organisation and architecture", el_eightpapercount1 + ""));
                }
                if (dataSnapshot.getKey().equals("DP")) {
                    el_eightpapercount1 = (int) dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Digital signal processing", el_eightpapercount1 + ""));
                }
                if (dataSnapshot.getKey().equals("CS")) {
                    el_eightpapercount1 = (int) dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Control system engineering", el_eightpapercount1 + ""));
                }
                if (dataSnapshot.getKey().equals("SZ")) {
                    el_eightpapercount1 = (int) dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Soft skills and interpersonal skills", el_eightpapercount1 + ""));
                }
                if (dataSnapshot.getKey().equals("VL")) {
                    el_eightpapercount1 = (int) dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("VLSI design", el_eightpapercount1 + ""));
                }

                Listadapter adapter = new Listadapter(Ece_fifthsem_subjectlist.this, R.layout.row, subjectlist);
                listView.setAdapter(adapter);

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(Ece_fifthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject", "IN/KU/EC/05/CO");
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(Ece_fifthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject", "IN/KU/EC/05/DP");
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(Ece_fifthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject", "IN/KU/EC/05/CS");
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(Ece_fifthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject", "IN/KU/EC/05/EW");
                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(Ece_fifthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject", "IN/KU/EC/05/II");
                    startActivity(intent);
                }
                if (position == 5) {
                    Intent intent = new Intent(Ece_fifthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject", "IN/KU/EC/05/SZ");
                    startActivity(intent);
                }
                if (position == 6) {
                    Intent intent = new Intent(Ece_fifthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject", "IN/KU/EC/05/VL");
                    startActivity(intent);
                }


            }
        });
    }
}
