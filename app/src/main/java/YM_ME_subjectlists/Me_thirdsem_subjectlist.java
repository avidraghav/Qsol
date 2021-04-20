package YM_ME_subjectlists;

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

public class Me_thirdsem_subjectlist extends AppCompatActivity {
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
        setContentView(R.layout.activity_me_thirdsem_subjectlist_ymca);
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
        globalClass.setBranch("ME");
        globalClass.setSemester("03");

        ref= FirebaseDatabase.getInstance().getReference("IN/YM/ME/03");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                if(dataSnapshot.getKey().equals("FM")) {
                    ymca_papercount=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Fluid mechanics", ymca_papercount+""));
                }
                if(dataSnapshot.getKey().equals("M0")) {
                    ymca_papercount=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Mechanics", ymca_papercount+""));
                }
                if(dataSnapshot.getKey().equals("M3")) {
                    ymca_papercount=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Mathematics 3", ymca_papercount+""));
                }
                if(dataSnapshot.getKey().equals("SL")) {
                    ymca_papercount=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Strength of materials", ymca_papercount+""));
                }
                if(dataSnapshot.getKey().equals("TD")) {
                    ymca_papercount=(int)dataSnapshot.getChildrenCount();
                    subjectlist.add(new Listdata("Thermodynamics", ymca_papercount+""));
                }

                Listadapter adapter = new Listadapter(Me_thirdsem_subjectlist.this, R.layout.row, subjectlist);
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

        listView.setOnItemClickListener((parent, view, position, id) -> {

            if(position==0) {
                Intent intent1 =new Intent(Me_thirdsem_subjectlist.this, Pdflist.class);
                intent1.putExtra("subject","IN/YM/ME/03/FM");
                startActivity(intent1);
            }
            if(position==1) {
                Intent intent1 =new Intent(Me_thirdsem_subjectlist.this, Pdflist.class);
                intent1.putExtra("subject","IN/YM/ME/03/M0");
                startActivity(intent1);
            }
            if(position==2) {
                Intent intent1 =new Intent(Me_thirdsem_subjectlist.this, Pdflist.class);
                intent1.putExtra("subject","IN/YM/ME/03/M3");
                startActivity(intent1);
            }
            if(position==3) {
                Intent intent1 =new Intent(Me_thirdsem_subjectlist.this, Pdflist.class);
                intent1.putExtra("subject","IN/YM/ME/03/SL");
                startActivity(intent1);
            }
            if(position==4) {
                Intent intent1 =new Intent(Me_thirdsem_subjectlist.this, Pdflist.class);
                intent1.putExtra("subject","IN/YM/ME/03/TD");
                startActivity(intent1);
            }


        });
    }

}