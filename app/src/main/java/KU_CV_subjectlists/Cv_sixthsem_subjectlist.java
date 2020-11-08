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
import utils.GlobalClass;
import utils.Listdata;

public class Cv_sixthsem_subjectlist extends AppCompatActivity {
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
        setContentView(R.layout.activity_cv_sixthsem_subjectlist);
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
        globalClass.setSemester("06");

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/CV/06");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("X0")) {
                    bc_onepapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Water supply and treatment", bc_onepapercount1+""));

                }
                if(dataSnapshot.getKey().equals("Z0")) {
                    bc_onepapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Transportation engineering 1", bc_onepapercount2+""));

                }
                if(dataSnapshot.getKey().equals("Z6")) {
                    bc_onepapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Design of steel structure 2", bc_onepapercount3+""));

                }
                if(dataSnapshot.getKey().equals("Z7")) {
                    bc_onepapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Irrigation engineering 1", bc_onepapercount4+""));

                }
                if(dataSnapshot.getKey().equals("Z8")) {
                    bc_onepapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Water resources and system engineering", bc_onepapercount5+""));
                }
                if(dataSnapshot.getKey().equals("Z9")) {
                    bc_onepapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Geotechnology 2", bc_onepapercount5+""));
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
                    Intent intent=new Intent(Cv_sixthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/CV/06/X0");
                    startActivity(intent);
                    Toast.makeText(Cv_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Cv_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CV/06/Z0");
                    startActivity(intent);
                    Toast.makeText(Cv_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Cv_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CV/06/Z6");
                    startActivity(intent);
                    Toast.makeText(Cv_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Cv_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CV/06/Z7");
                    startActivity(intent);
                    Toast.makeText(Cv_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Cv_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CV/06/Z8");
                    startActivity(intent);
                    Toast.makeText(Cv_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(Cv_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/CV/06/Z9");
                    startActivity(intent);
                    Toast.makeText(Cv_sixthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                
            }
        });



    }
}
