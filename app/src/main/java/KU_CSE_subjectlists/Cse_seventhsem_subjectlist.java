package KU_CSE_subjectlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

public class Cse_seventhsem_subjectlist extends AppCompatActivity {

    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;

    static int sevenpapercount1,sevenpapercount2,sevenpapercount3,sevenpapercount4,sevenpapercount5,sevenpapercount6,sevenpapercount7,sevenpapercount8;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_seventhsem_subjectlist);

        listView=findViewById(R.id.list);
        downloadall=findViewById(R.id.download_btn);
        subjectname=findViewById(R.id.subjectname);
        papercount=findViewById(R.id.papercount);
        textView=findViewById(R.id.textView);
        Intent intent=getIntent();
        key=intent.getStringExtra("key");
        textView.setText(key);
        GlobalClass globalClass=(GlobalClass)getApplicationContext();
        globalClass.setBoard("KU");
        globalClass.setBranch("CS");
        globalClass.setSemester("07");

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/CS/07");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
//                if(dataSnapshot.getKey().equals("CD")) {
//                    sevenpapercount1=(int)dataSnapshot.getChildrenCount();
//                    subjectlist.add(new Listdata("Compiler design", sevenpapercount1+""));
//                }
                if(dataSnapshot.getKey().equals("CG")) {
                    sevenpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer graphics and animation", sevenpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("CI")) {
                    sevenpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Cryptography and information security", sevenpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("ES")) {
                    sevenpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Expert systems", sevenpapercount4+""));

                }
//                if(dataSnapshot.getKey().equals("SC")) {
//                    sevenpapercount5 =(int)dataSnapshot.getChildrenCount();
//                    subjectlist.add(new Listdata("Security and cryptography", sevenpapercount5+""));
//                }
//                if(dataSnapshot.getKey().equals("SP")) {
//                    sevenpapercount6 =(int)dataSnapshot.getChildrenCount();
//                    subjectlist.add(new Listdata("Software project management", sevenpapercount6+""));
//                }
//                if(dataSnapshot.getKey().equals("SM")) {
//                    sevenpapercount7 =(int)dataSnapshot.getChildrenCount();
//                    subjectlist.add(new Listdata("Statistical models for computer science", sevenpapercount7+""));
//                }
                if(dataSnapshot.getKey().equals("UL")) {
                    sevenpapercount8 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Unix and Linux prog", sevenpapercount8+""));
                }
//                if(dataSnapshot.getKey().equals("WE")) {
//                    sevenpapercount8 =(int)dataSnapshot.getChildrenCount();
//                    subjectlist.add(new Listdata("Web engineering", sevenpapercount8+""));
//                }

                Listadapter adapter = new Listadapter(getBaseContext(), R.layout.row, subjectlist);
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
                if(position==0) {
                    Intent intent=new Intent(Cse_seventhsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/07/CG");
                    startActivity(intent);
                    Toast.makeText(Cse_seventhsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Cse_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/07/CI");
                    startActivity(intent);
                    Toast.makeText(Cse_seventhsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Cse_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/07/ES");
                    startActivity(intent);
                    Toast.makeText(Cse_seventhsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Cse_seventhsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CS/07/UL");
                    startActivity(intent);
                    Toast.makeText(Cse_seventhsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
//                if(position==4) {
//                    Intent intent=new Intent(Cse_seventhsem_subjectlist.this,Pdflist.class);
//                    intent.putExtra("subject","IN/KU/CS/07/SC");
//                    startActivity(intent);
//                    Toast.makeText(Cse_seventhsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
//                }
//                if(position==5) {
//                    Intent intent=new Intent(Cse_seventhsem_subjectlist.this,Pdflist.class);
//                    intent.putExtra("subject","IN/KU/CS/07/SP");
//                    startActivity(intent);
//                    Toast.makeText(Cse_seventhsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
//                }
//                if(position==6) {
//                    Intent intent=new Intent(Cse_seventhsem_subjectlist.this,Pdflist.class);
//                    intent.putExtra("subject","IN/KU/CS/07/SM");
//                    startActivity(intent);
//                    Toast.makeText(Cse_seventhsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
//                }
//                if(position==7) {
//                    Intent intent=new Intent(Cse_seventhsem_subjectlist.this,Pdflist.class);
//                    intent.putExtra("subject","IN/KU/CS/07/UL");
//                    startActivity(intent);
//                    Toast.makeText(Cse_seventhsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
//                }
//                if(position==8) {
//                    Intent intent=new Intent(Cse_seventhsem_subjectlist.this,Pdflist.class);
//                    intent.putExtra("subject","IN/KU/CS/07/WE");
//                    startActivity(intent);
//                    Toast.makeText(Cse_seventhsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
//                }
            }
        });



    }
}
