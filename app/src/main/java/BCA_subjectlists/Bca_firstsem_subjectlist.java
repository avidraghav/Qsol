package BCA_subjectlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.application.kurukshetrauniversitypapers.GlobalClass;
import com.application.kurukshetrauniversitypapers.Listdata;
import com.application.kurukshetrauniversitypapers.Pdflist;
import com.application.kurukshetrauniversitypapers.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import Adapters.Mylistadapter;


public class Bca_firstsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int bc_onepapercount1,bc_onepapercount2,bc_onepapercount3,bc_onepapercount4,bc_onepapercount5,bc_onepapercount6,bc_onepapercount7,bc_onepapercount8,bc_onepapercount9,bc_onepapercount10;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bca_firstsem_subjectlist);
        listView=findViewById(R.id.list);
        downloadall=findViewById(R.id.download_btn);
        subjectname=findViewById(R.id.subjectname);
        papercount=findViewById(R.id.papercount);
        textView=findViewById(R.id.textView);
        Intent intent=getIntent();
        key=intent.getStringExtra("key");
        textView.setText(key);

        GlobalClass globalClass=(GlobalClass)getApplicationContext();
        globalClass.setBranch("BCA");
        globalClass.setSemester(1);

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/BC/01");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("AG")) {
                    bc_onepapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Advanced programming in c", bc_onepapercount1+""));

                }
                if(dataSnapshot.getKey().equals("EH")) {
                    bc_onepapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("English", bc_onepapercount2+""));

                }
                if(dataSnapshot.getKey().equals("LR")) {
                    bc_onepapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Logical organization of computer", bc_onepapercount3+""));

                }
                if(dataSnapshot.getKey().equals("MA")) {
                    bc_onepapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Mathematics", bc_onepapercount4+""));

                }
                if(dataSnapshot.getKey().equals("OA")) {
                    bc_onepapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Office automation tools", bc_onepapercount5+""));
                }
                if(dataSnapshot.getKey().equals("PC")) {
                    bc_onepapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Programming in c", bc_onepapercount6+""));
                }
                if(dataSnapshot.getKey().equals("PY")) {
                    bc_onepapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Personality development", bc_onepapercount7+""));
                }
                if(dataSnapshot.getKey().equals("SX")) {
                    bc_onepapercount8 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Structured system analysis and design", bc_onepapercount8+""));
                }
                if(dataSnapshot.getKey().equals("WR")) {
                    bc_onepapercount9 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Windows and pc software", bc_onepapercount9+""));
                }
                

                Mylistadapter adapter = new Mylistadapter(getBaseContext(), R.layout.row, subjectlist);
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
                    Intent intent=new Intent(Bca_firstsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/BC/01/AG");
                    startActivity(intent);
                    Toast.makeText(Bca_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Bca_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BC/01/EH");
                    startActivity(intent);
                    Toast.makeText(Bca_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Bca_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BC/01/LR");
                    startActivity(intent);
                    Toast.makeText(Bca_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Bca_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BC/01/MA");
                    startActivity(intent);
                    Toast.makeText(Bca_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Bca_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BC/01/OA");
                    startActivity(intent);
                    Toast.makeText(Bca_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(Bca_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BC/01/PC");
                    startActivity(intent);
                    Toast.makeText(Bca_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }


                if(position==6) {
                    Intent intent=new Intent(Bca_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BC/01/PY");
                    startActivity(intent);
                    Toast.makeText(Bca_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==7) {
                    Intent intent=new Intent(Bca_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BC/01/SX");
                    startActivity(intent);
                    Toast.makeText(Bca_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==8) {
                    Intent intent=new Intent(Bca_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/BC/01/WR");
                    startActivity(intent);
                    Toast.makeText(Bca_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }


            }
        });



    }
}
