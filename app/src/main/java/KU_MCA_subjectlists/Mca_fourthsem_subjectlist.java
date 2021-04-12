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

public class Mca_fourthsem_subjectlist extends AppCompatActivity {
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
        setContentView(R.layout.activity_mca_fourthsem_subjectlist);
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
        globalClass.setSemester("04");

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/MC/04");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("AH")) {
                    mc_twopapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Advanced computer architecture", mc_twopapercount1+""));

                }
                if(dataSnapshot.getKey().equals("AL")) {
                    mc_twopapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Artificial intelligence", mc_twopapercount2+""));

                }
                if(dataSnapshot.getKey().equals("CM")) {
                    mc_twopapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer graphics", mc_twopapercount3+""));

                }
                if(dataSnapshot.getKey().equals("DW")) {
                    mc_twopapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Data warehouse and data mining", mc_twopapercount4+""));

                }
                if(dataSnapshot.getKey().equals("PV")) {
                    mc_twopapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Programming in java", mc_twopapercount5+""));
                }



                Listadapter adapter = new Listadapter(Mca_fourthsem_subjectlist.this, R.layout.row, subjectlist);
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
                    Intent intent=new Intent(Mca_fourthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/04/AH");
                    startActivity(intent);
                    Toast.makeText(Mca_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Mca_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/04/AL");
                    startActivity(intent);
                    Toast.makeText(Mca_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Mca_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/04/CM");
                    startActivity(intent);
                    Toast.makeText(Mca_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Mca_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/04/DW");
                    startActivity(intent);
                    Toast.makeText(Mca_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Mca_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/04/PV");
                    startActivity(intent);
                    Toast.makeText(Mca_fourthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
