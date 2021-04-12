package GJ_CSE_subjectlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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
import HS_CSE_subjectlists.Cse_fifthsem_subjectlist;
import utils.GlobalClass;
import utils.Listdata;

public class Cse_firstsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int papercount1;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_firstsem_subjectlist3);
        listView=findViewById(R.id.list);
        downloadall=findViewById(R.id.download_btn);
        subjectname=findViewById(R.id.subjectname);
        papercount=findViewById(R.id.papercount);
        textView=findViewById(R.id.textView);
        subjectlist = new ArrayList<>();

        Intent intent=getIntent();
        key=intent.getStringExtra("key");
        textView.setText(key);

        GlobalClass globalClass=(GlobalClass)getApplicationContext();
        globalClass.setBoard("GJ");
        globalClass.setBranch("CS");
        globalClass.setSemester("01");

        Log.e("Bord",globalClass.getBoard());

        ref= FirebaseDatabase.getInstance().getReference("IN/GJ/CS/01");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("CH")) {
                    papercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Chemistry", papercount1+""));

                }
                if(dataSnapshot.getKey().equals("PP")) {
                   papercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Programming for problem solving", papercount1+""));

                }
                if(dataSnapshot.getKey().equals("X7")) {
                    papercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Mathematics-1", papercount1+""));
                }

                Listadapter adapter = new Listadapter(Cse_firstsem_subjectlist.this, R.layout.row, subjectlist);
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

        listView.setOnItemClickListener((parent, view, position, id) -> {

            if(position==0) {
                Intent intent1 =new Intent(Cse_firstsem_subjectlist.this, Pdflist.class);
                intent1.putExtra("subject","IN/GJ/CS/01/CH");
                startActivity(intent1);
            }
            if(position==1) {
                Intent intent1 =new Intent(Cse_firstsem_subjectlist.this, Pdflist.class);
                intent1.putExtra("subject","IN/GJ/CS/01/PP");
                startActivity(intent1);
            }
            if(position==2) {
                Intent intent1 =new Intent(Cse_firstsem_subjectlist.this, Pdflist.class);
                intent1.putExtra("subject","IN/GJ/CS/01/X7");
                startActivity(intent1);
            }


        });
    }
}