package KU_ME_subjectlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
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

public class Me_sixthsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int me_sixpapercount1, me_sixpapercount2, me_sixpapercount3, me_sixpapercount4, me_sixpapercount5, me_sixpapercount6, me_sixpapercount7;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_sixthsem_subjectlist);
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
        globalClass.setBoard("KU");
        globalClass.setBranch("ME");
        globalClass.setSemester("06");

        ref= FirebaseDatabase.getInstance().getReference("IN/KU/ME/06");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("GE")) {
                    me_sixpapercount3=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("IC engine and gas turbine", me_sixpapercount3+""));
                }
                if(dataSnapshot.getKey().equals("RC")) {
                    me_sixpapercount4=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Refrigeration and air conditioning", me_sixpapercount4+""));

                }
                if(dataSnapshot.getKey().equals("AF")) {
                    me_sixpapercount5=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Advanced manufacturing tech", me_sixpapercount5+""));

                }
                if(dataSnapshot.getKey().equals("OB")) {
                    me_sixpapercount6=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Organisational behaviour", me_sixpapercount6+""));

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
                    Intent intent=new Intent(Me_sixthsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/06/AF");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Me_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/06/GE");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Me_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/06/OB");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Me_sixthsem_subjectlist.this,Pdflist.class);
                    intent.putExtra("subject","IN/KU/ME/06/RC");
                    startActivity(intent);
                }

            }
        });

    }
}
