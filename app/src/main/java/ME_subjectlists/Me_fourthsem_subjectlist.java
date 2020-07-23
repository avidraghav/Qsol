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

public class Me_fourthsem_subjectlist extends AppCompatActivity {
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
        setContentView(R.layout.activity_me_fourthsem_subjectlist);
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
        globalClass.setSemester(4);

        ref= FirebaseDatabase.getInstance().getReference("IN/KU/ME/04");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("DY")) {
                    me_fourpapercount1=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Dynamics of machine", me_fourpapercount1+""));

                }
                if(dataSnapshot.getKey().equals("FM")) {
                    me_fourpapercount2=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Fluid mechanics", me_fourpapercount2+""));

                }
                if(dataSnapshot.getKey().equals("MT")) {
                    me_fourpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Material science", me_fourpapercount3+""));

                }
                if(dataSnapshot.getKey().equals("MO")) {
                    me_fourpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Mechanics of solids", me_fourpapercount4+""));

                }
                if(dataSnapshot.getKey().equals("PT")) {
                    me_fourpapercount5=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Production technology", me_fourpapercount5+""));

                }
                if(dataSnapshot.getKey().equals("SL")) {
                    me_fourpapercount6=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Strength of materials", me_fourpapercount6+""));

                }
                if(dataSnapshot.getKey().equals("SG")) {
                    me_fourpapercount7 =(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Steam generator and power", me_fourpapercount7+""));
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
                    Intent intent=new Intent(Me_fourthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/04/DY");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Me_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/04/FM");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Me_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/04/MT");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Me_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/04/MO");
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent=new Intent(Me_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/04/PT");
                    startActivity(intent);
                }
                if(position==5) {
                    Intent intent=new Intent(Me_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/04/SL");
                    startActivity(intent);
                }
                if(position==6) {
                    Intent intent=new Intent(Me_fourthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/04/SG");
                    startActivity(intent);
                }

            }
        });

    }
}
