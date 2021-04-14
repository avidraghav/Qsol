package YM_CO_subjectlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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

public class Co_secondsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    Button downloadall;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;
    static int ymca_papercount;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_secondsem_subjectlist_ymca);
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
        globalClass.setBoard("YM");
        globalClass.setBranch("CO");
        globalClass.setSemester("02");

        ref= FirebaseDatabase.getInstance().getReference("IN/YM/CO/02");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("B9")) {
                    ymca_papercount=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Basics electrical engineering", ymca_papercount+""));
                }
                if(dataSnapshot.getKey().equals("CH")) {
                    ymca_papercount=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Chemistry", ymca_papercount+""));
                }
                if(dataSnapshot.getKey().equals("EH")) {
                    ymca_papercount=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("English", ymca_papercount+""));
                }
                if(dataSnapshot.getKey().equals("X5")) {
                    ymca_papercount=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Mathematics-2", ymca_papercount+""));
                }

                Listadapter adapter = new Listadapter(Co_secondsem_subjectlist.this, R.layout.row, subjectlist);
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
                    Intent intent=new Intent(Co_secondsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/YM/CO/02/B9");
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent=new Intent(Co_secondsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/YM/CO/02/CH");
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent=new Intent(Co_secondsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/YM/CO/02/EH");
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent=new Intent(Co_secondsem_subjectlist.this, Pdflist.class);
                    intent.putExtra("subject","IN/YM/CO/02/X5");
                    startActivity(intent);
                }


            }
        });
    }

}