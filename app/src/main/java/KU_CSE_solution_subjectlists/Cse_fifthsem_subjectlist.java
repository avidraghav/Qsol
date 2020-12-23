package KU_CSE_solution_subjectlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.application.kurukshetrauniversitypapers.R;
import com.application.kurukshetrauniversitypapers.SolutionDisplayActivity;

import java.util.ArrayList;
import java.util.List;

import Adapters.SolutionSubjectsAdapter;
import utils.Listdata;

public class Cse_fifthsem_subjectlist extends AppCompatActivity {
    ListView listView;
    List<Listdata> subjectlist;
    TextView subjectname;
    TextView papercount;
    TextView textView;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_fifthsem_subjectlist3);
        listView=findViewById(R.id.list);
        subjectname=findViewById(R.id.subjectname);
        papercount=findViewById(R.id.papercount);
        textView=findViewById(R.id.textView);
        Intent intent=getIntent();
        key=intent.getStringExtra("key");
        textView.setText(key);

        subjectlist = new ArrayList<>();
        subjectlist.add(new Listdata("Automata theory", "3"));
        subjectlist.add(new Listdata("Computer organisation and architecture", "3"));
        subjectlist.add(new Listdata("Essentials of information technology", "3"));
        subjectlist.add(new Listdata("Microprocessors and Interfacing", "1"));
        SolutionSubjectsAdapter adapter = new SolutionSubjectsAdapter(getBaseContext(), R.layout.solution_subjects_row, subjectlist);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener((parent, view, position, id) -> {
            if(position==0) {
                Intent intent1 =new Intent(Cse_fifthsem_subjectlist.this, SolutionDisplayActivity.class);
                intent1.putExtra("subject","IN/KU/CS/05/AT");
                startActivity(intent1);
                Toast.makeText(Cse_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
            }
            if(position==1) {
                Intent intent1 =new Intent(Cse_fifthsem_subjectlist.this, SolutionDisplayActivity.class);
                intent1.putExtra("subject","IN/KU/CS/05/CO");
                startActivity(intent1);
                Toast.makeText(Cse_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
            }
            if(position==2) {
                Intent intent1 =new Intent(Cse_fifthsem_subjectlist.this, SolutionDisplayActivity.class);
                intent1.putExtra("subject","IN/KU/CS/05/EO");
                startActivity(intent1);
                Toast.makeText(Cse_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
            }
            if(position==3) {
                Intent intent1 =new Intent(Cse_fifthsem_subjectlist.this, SolutionDisplayActivity.class);
                intent1.putExtra("subject","IN/KU/CS/05/MS");
                startActivity(intent1);
                Toast.makeText(Cse_fifthsem_subjectlist.this, "loading", Toast.LENGTH_SHORT).show();
            }

        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
