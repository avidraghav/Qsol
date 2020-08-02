package MCA_subjectlists;

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

import Adapters.Mylistadapter;

public class Mca_fifthsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int mc_twopapercount1,mc_twopapercount2,mc_twopapercount3,mc_twopapercount4,mc_twopapercount5,mc_twopapercount6,mc_twopapercount7;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mca_fifthsem_subjectlist);
        listView=findViewById(R.id.list);
        downloadall=findViewById(R.id.download_btn);
        subjectname=findViewById(R.id.subjectname);
        papercount=findViewById(R.id.papercount);
        textView=findViewById(R.id.textView);
        Intent intent=getIntent();
        key=intent.getStringExtra("key");
        textView.setText(key);

        GlobalClass globalClass=(GlobalClass)getApplicationContext();
        globalClass.setBranch("MCA");
        globalClass.setSemester(5);

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/MC/05");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("AW")) {
                    mc_twopapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Advanced web technology ", mc_twopapercount1+""));

                }
                if(dataSnapshot.getKey().equals("CC")) {
                    mc_twopapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Cloud computing", mc_twopapercount2+""));

                }
                if(dataSnapshot.getKey().equals("CD")) {
                    mc_twopapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Compiler design", mc_twopapercount3+""));

                }
                if(dataSnapshot.getKey().equals("CQ")) {
                    mc_twopapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer architecture and parallel processing", mc_twopapercount4+""));

                }
                if(dataSnapshot.getKey().equals("CM")) {
                    mc_twopapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer graphics", mc_twopapercount5+""));
                }
                if(dataSnapshot.getKey().equals("LP")) {
                    mc_twopapercount6 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Linux and shell programming", mc_twopapercount6+""));
                }
                if(dataSnapshot.getKey().equals("MD")) {
                    mc_twopapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Mobile apps development", mc_twopapercount7+""));
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
                    Intent intent=new Intent(Mca_fifthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/05/AW");
                    startActivity(intent);
                    Toast.makeText(Mca_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Mca_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/05/CC");
                    startActivity(intent);
                    Toast.makeText(Mca_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Mca_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/05/CD");
                    startActivity(intent);
                    Toast.makeText(Mca_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Mca_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/05/CM");
                    startActivity(intent);
                    Toast.makeText(Mca_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Mca_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/05/CQ");
                    startActivity(intent);
                    Toast.makeText(Mca_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Intent intent=new Intent(Mca_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/05/LP");
                    startActivity(intent);
                    Toast.makeText(Mca_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==6) {
                    Intent intent=new Intent(Mca_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/05/MD");
                    startActivity(intent);
                    Toast.makeText(Mca_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
