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
import utils.GlobalClass;
import utils.Listdata;
import com.application.kurukshetrauniversitypapers.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import Adapters.Listadapter;

public class Mca_thirdsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int mc_twopapercount1,mc_twopapercount2,mc_twopapercount3,mc_twopapercount4,mc_twopapercount6,mc_twopapercount5;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mca_thirdsem_subjectlist);
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
        globalClass.setSemester("03");

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/MC/03");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("CW")) {
                    mc_twopapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer networks and data communication", mc_twopapercount1+""));

                }
                if(dataSnapshot.getKey().equals("DM")) {
                    mc_twopapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Database management system", mc_twopapercount2+""));

                }
                if(dataSnapshot.getKey().equals("DA")) {
                    mc_twopapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Design and analysis of algorithm", mc_twopapercount3+""));

                }
                if(dataSnapshot.getKey().equals("OU")) {
                    mc_twopapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Object oriented design using uml", mc_twopapercount4+""));

                }
                if(dataSnapshot.getKey().equals("OS")) {
                    mc_twopapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Operating systems", mc_twopapercount5+""));
                }
                if(dataSnapshot.getKey().equals("VP")) {
                    mc_twopapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Visual programming", mc_twopapercount6+""));
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
                    Intent intent=new Intent(Mca_thirdsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/03/CW");
                    startActivity(intent);
                    Toast.makeText(Mca_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Mca_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/03/DA");
                    startActivity(intent);
                    Toast.makeText(Mca_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Mca_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/03/DM");
                    startActivity(intent);
                    Toast.makeText(Mca_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Mca_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/03/OU");
                    startActivity(intent);
                    Toast.makeText(Mca_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Mca_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/03/OS");
                    startActivity(intent);
                    Toast.makeText(Mca_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Mca_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/03/OU");
                    startActivity(intent);
                    Toast.makeText(Mca_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(Mca_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/03/VP");
                    startActivity(intent);
                    Toast.makeText(Mca_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
