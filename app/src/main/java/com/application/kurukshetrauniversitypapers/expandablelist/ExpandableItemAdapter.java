package com.application.kurukshetrauniversitypapers.expandablelist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.kurukshetrauniversitypapers.R;
import com.application.kurukshetrauniversitypapers.subjectlist.SubjectListActivity;

import java.util.List;
import java.util.Locale;

import model.Semester;

import static com.application.kurukshetrauniversitypapers.filelist.FileListActivity.KEY_SEMESTER;

public class ExpandableItemAdapter extends RecyclerView.Adapter<ExpandableItemAdapter.SemesterViewHolder> {

    private Context context;
    private List<Semester> semesters;

    public ExpandableItemAdapter(Context context, List<Semester> semesters) {
        this.context = context;
        this.semesters = semesters;
    }

    @NonNull
    @Override
    public SemesterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_expanded_semester, parent, false);
        return new SemesterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SemesterViewHolder holder, int position) {
        Semester semester = semesters.get(position);
        String semesterName = context.getString(R.string.semester) + " " + semester.getKey().replaceFirst("^0+(?!$)", "");
        holder.titleTextView.setText(semesterName);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Handle click event
                Intent i = new Intent(context, SubjectListActivity.class);
                i.putExtra(KEY_SEMESTER, semester.getId());
                context.startActivity(i);
            }
        });
        holder.paperCountTextView.setText(String.format(Locale.getDefault(), "%d", semester.getPapersCount()));
    }

    @Override
    public int getItemCount() {
        return semesters.size();
    }

    public static class SemesterViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        TextView paperCountTextView;

        public SemesterViewHolder(@NonNull View itemView) {
            super(itemView);
            this.titleTextView = itemView.findViewById(R.id.tv_semester_name);
            this.paperCountTextView = itemView.findViewById(R.id.tv_paper_count);
        }
    }
}
