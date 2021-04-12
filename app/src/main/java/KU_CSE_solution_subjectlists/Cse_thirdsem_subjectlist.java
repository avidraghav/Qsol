package KU_CSE_solution_subjectlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.application.kurukshetrauniversitypapers.Pdflist;
import com.application.kurukshetrauniversitypapers.R;
import com.application.kurukshetrauniversitypapers.SolutionDisplayActivity;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import Adapters.Listadapter;
import Adapters.SolutionSubjectsAdapter;
import utils.GlobalClass;
import utils.Listdata;

public class Cse_thirdsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_thirdsem_subjectlist2);
        listView=findViewById(R.id.list);
        subjectname=findViewById(R.id.subjectname);
        papercount=findViewById(R.id.papercount);
        textView=findViewById(R.id.textView);
        Intent intent=getIntent();
        key=intent.getStringExtra("key");
        textView.setText(key);

        subjectlist = new ArrayList<>();
        subjectlist.add(new Listdata("Mathematics 3", "1"));
        subjectlist.add(new Listdata("Programming Language", "3"));
        SolutionSubjectsAdapter adapter = new SolutionSubjectsAdapter(getBaseContext(), R.layout.solution_subjects_row, subjectlist);
        listView.setAdapter(adapter);





        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    Intent intent=new Intent(KU_CSE_solution_subjectlists.Cse_thirdsem_subjectlist.this, SolutionDisplayActivity.class);
                    intent.putExtra("subject","IN/KU/CS/03/M3");
                    startActivity(intent);
                    Toast.makeText(KU_CSE_solution_subjectlists.Cse_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }
                if(position==1) {
                    Intent intent=new Intent(KU_CSE_solution_subjectlists.Cse_thirdsem_subjectlist.this, SolutionDisplayActivity.class);
                    intent.putExtra("subject","IN/KU/CS/03/PL");
                    startActivity(intent);
                    Toast.makeText(Cse_thirdsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
