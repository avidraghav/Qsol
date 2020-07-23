package ME_subjectlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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

public class Me_fifthsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int me_fourpapercount1, me_fourpapercount2, me_fourpapercount3, me_fourpapercount4, me_fourpapercount5, me_fourpapercount6, me_fourpapercount7;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_fifthsem_subjectlist);
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
        globalClass.setSemester(5);

        ref= FirebaseDatabase.getInstance().getReference("IN/KU/ME/05");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("GE")) {
                    me_fourpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("IC engine and gas turbine", me_fourpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("FM")) {
                    me_fourpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Fluid mechanics", me_fourpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("HT")) {
                    me_fourpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Heat transfer", me_fourpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("IE")) {
                    me_fourpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Industrial engineering", me_fourpapercount4+""));

                }
                if(dataSnapshot.getKey().equals("MN")) {
                    me_fourpapercount5=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Machine design", me_fourpapercount5+""));

                }
                if(dataSnapshot.getKey().equals("SG")) {
                    me_fourpapercount6=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Steam generator and power", me_fourpapercount6+""));

                }
                if(dataSnapshot.getKey().equals("PT")) {
                    me_fourpapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Production technology", me_fourpapercount7+""));
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
                    Intent intent=new Intent(Me_fifthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/05/FM");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Me_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/05/GE");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Me_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/05/HT");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Me_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/05/IE");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Me_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/05/MN");
                    startActivity(intent);
                }
                if(position==5) {
                    Intent intent=new Intent(Me_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/05/PT");
                    startActivity(intent);
                }
                if(position==6) {
                    Intent intent=new Intent(Me_fifthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/05/SG");
                    startActivity(intent);
                }

            }
        });

    }
}