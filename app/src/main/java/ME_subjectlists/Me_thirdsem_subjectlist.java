package ME_subjectlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
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

public class Me_thirdsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int me_fourpapercount1, me_fourpapercount2, me_fourpapercount3, me_fourpapercount4, me_fourpapercount5, me_fourpapercount7;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_thirdsem_subjectlist);
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
        globalClass.setBranch("ME");
        globalClass.setSemester(3);

        ref= FirebaseDatabase.getInstance().getReference("IN/KU/ME/03");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("TD")) {
                    me_fourpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Thermodynamics", me_fourpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("M3")) {
                    me_fourpapercount5=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Mathematics 3", me_fourpapercount5+""));

                }
                if(dataSnapshot.getKey().equals("TM")) {
                    me_fourpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Theory of machines", me_fourpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("OW")) {
                    me_fourpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Optics and waves", me_fourpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("BF")) {
                    me_fourpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Basic electronics engineering", me_fourpapercount4+""));

                }
                if(dataSnapshot.getKey().equals("MO")) {
                    me_fourpapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Mechanics of solids", me_fourpapercount7+""));
                }
//


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
                    Intent intent=new Intent(Me_thirdsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/03/BF");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Me_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/03/M3");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Me_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/03/MO");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Me_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/03/OW");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Me_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/03/TD");
                    startActivity(intent);
                }
                if(position==5) {
                    Intent intent=new Intent(Me_thirdsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/03/TM");
                    startActivity(intent);
                }


            }
        });

    }
}