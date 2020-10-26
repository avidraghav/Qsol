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

import model.Branch;
import model.Semester;

public class ExpandableItemAdapter extends RecyclerView.Adapter<ExpandableItemAdapter.SemesterViewHolder> {

    private Context context;
    private Branch branch;
    private List<Semester> semesters;
    private List<Object> listItems;
    private int expandedItemPosition = -1;
    private SemesterViewHolder expandedHolder;

    public ExpandableItemAdapter(Context context, Branch branch) {
        this.context = context;
        this.branch = branch;
        this.semesters = branch.getSemesters();
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
        holder.titleTextView.setText(semester.getId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Handle click event
                Intent i = new Intent(context, SubjectListActivity.class);
                i.putExtra("key", branch.getId() + semester.getId());
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
