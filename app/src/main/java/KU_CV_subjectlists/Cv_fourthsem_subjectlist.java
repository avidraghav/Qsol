package KU_CV_subjectlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
import KU_BCA_subjectlists.Bca_firstsem_subjectlist;
import utils.GlobalClass;
import utils.Listdata;

public class Cv_fourthsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int bc_onepapercount1,bc_onepapercount2,bc_onepapercount3,bc_onepapercount4,bc_onepapercount5;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_fourthsem_subjectlist2);
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
        globalClass.setBranch("CV");
        globalClass.setSemester("04");

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/CV/04");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("Z1")) {
                    bc_onepapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Structural analysis 2", bc_onepapercount1+""));

                }
                if(dataSnapshot.getKey().equals("Z2")) {
                    bc_onepapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Design of steel structure 1", bc_onepapercount2+""));

                }
                if(dataSnapshot.getKey().equals("Z3")) {
                    bc_onepapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Fluid mechanics 2", bc_onepapercount3+""));

                }
                if(dataSnapshot.getKey().equals("Z4")) {
                    bc_onepapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Soil mechanics", bc_onepapercount4+""));

                }
                if(dataSnapshot.getKey().equals("Z5")) {
                    bc_onepapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Surveying 2", bc_onepapercount5+""));
                }

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
                    Intent intent=new Intent(Cv_fourthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/CV/04/Z1");
                    startActivity(intent);
                    Toast.makeText(Cv_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Cv_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CV/04/Z2");
                    startActivity(intent);
                    Toast.makeText(Cv_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Cv_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CV/04/Z3");
                    startActivity(intent);
                    Toast.makeText(Cv_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Cv_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CV/04/Z4");
                    startActivity(intent);
                    Toast.makeText(Cv_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Cv_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CV/04/Z5");
                    startActivity(intent);
                    Toast.makeText(Cv_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
