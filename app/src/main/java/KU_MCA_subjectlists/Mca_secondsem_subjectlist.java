package KU_MCA_subjectlists;

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
import com.application.kurukshetrauniversitypapers.GlobalClass;
import com.application.kurukshetrauniversitypapers.Listdata;
import com.application.kurukshetrauniversitypapers.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import Adapters.Listadapter;

public class Mca_secondsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int mc_twopapercount1,mc_twopapercount2,mc_twopapercount3,mc_twopapercount4,mc_twopapercount5;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mca_secondsem_subjectlist);
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
        globalClass.setBranch("MC");
        globalClass.setSemester("02");

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/MC/02");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("WT")) {
                    mc_twopapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Web technology", mc_twopapercount1+""));

                }
                if(dataSnapshot.getKey().equals("SO")) {
                    mc_twopapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("System programming", mc_twopapercount2+""));

                }
                if(dataSnapshot.getKey().equals("PF")) {
                    mc_twopapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Principles of programming language", mc_twopapercount3+""));

                }
                if(dataSnapshot.getKey().equals("OP")) {
                    mc_twopapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Object oriented programming", mc_twopapercount4+""));

                }
                if(dataSnapshot.getKey().equals("DS")) {
                    mc_twopapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Data structures", mc_twopapercount5+""));
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
                    Intent intent=new Intent(Mca_secondsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/02/DS");
                    startActivity(intent);
                    Toast.makeText(Mca_secondsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Mca_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/02/OP");
                    startActivity(intent);
                    Toast.makeText(Mca_secondsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Mca_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/02/PF");
                    startActivity(intent);
                    Toast.makeText(Mca_secondsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Mca_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/02/SO");
                    startActivity(intent);
                    Toast.makeText(Mca_secondsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Mca_secondsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/02/WT");
                    startActivity(intent);
                    Toast.makeText(Mca_secondsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
