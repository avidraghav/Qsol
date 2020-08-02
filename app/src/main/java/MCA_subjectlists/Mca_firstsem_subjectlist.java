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
public class Mca_firstsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int mc_onepapercount1,mc_onepapercount2,mc_onepapercount3,mc_onepapercount4,mc_onepapercount5,mc_onepapercount6,mc_onepapercount7,mc_onepapercount8,mc_onepapercount9,mc_onepapercount10;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mca_firstsem_subjectlist);
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
        globalClass.setSemester(1);

        subjectlist = new ArrayList<>();
        ref= FirebaseDatabase.getInstance().getReference("IN/KU/MC/01");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("CZ")) {
                    mc_onepapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Computer organization", mc_onepapercount1+""));

                }
                if(dataSnapshot.getKey().equals("DU")) {
                    mc_onepapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Discrete mathematical structures", mc_onepapercount2+""));

                }
                if(dataSnapshot.getKey().equals("NS")) {
                    mc_onepapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Numerical and statistical methods", mc_onepapercount3+""));

                }
                if(dataSnapshot.getKey().equals("PC")) {
                    mc_onepapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Programming in c", mc_onepapercount4+""));

                }
                if(dataSnapshot.getKey().equals("SE")) {
                    mc_onepapercount5 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Software engineering", mc_onepapercount5+""));
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
                    Intent intent=new Intent(Mca_firstsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/01/CZ");
                    startActivity(intent);
                    Toast.makeText(Mca_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(Mca_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/01/DU");
                    startActivity(intent);
                    Toast.makeText(Mca_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==2) {
                    Intent intent=new Intent(Mca_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/01/NS");
                    startActivity(intent);
                    Toast.makeText(Mca_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Intent intent=new Intent(Mca_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/01/PC");
                    startActivity(intent);
                    Toast.makeText(Mca_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==4) {
                    Intent intent=new Intent(Mca_firstsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/MC/01/SE");
                    startActivity(intent);
                    Toast.makeText(Mca_firstsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
