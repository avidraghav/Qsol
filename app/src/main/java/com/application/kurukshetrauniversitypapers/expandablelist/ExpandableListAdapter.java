package com.application.kurukshetrauniversitypapers.expandablelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.kurukshetrauniversitypapers.R;

import java.util.List;
import java.util.Locale;

import model.Branch;

public class ExpandableListAdapter extends RecyclerView.Adapter<ExpandableListAdapter.BranchViewHolder> {

    private Context context;
    private List<Branch> branches;
    private int expandedItemPosition = -1;
    private BranchViewHolder expandedHolder;

    public ExpandableListAdapter(Context context, List<Branch> branches) {
        this.context = context;
        this.branches = branches;
    }

    @NonNull
    @Override
    public BranchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_expandable_branch, parent, false);
        return new BranchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BranchViewHolder holder, int position) {
        Branch branch = branches.get(position);
        holder.titleTextView.setText(branch.getName());
        holder.paperCountTextView.setText(String.format(Locale.getDefault(), "%d", branch.getPapersCount()));
        holder.semestersRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.semestersRecyclerView.setAdapter(new ExpandableItemAdapter(context, branch.getSemesters()));
        // TODO Optimize the adapter instantiation
        if (expandedItemPosition == position) {
            holder.semestersRecyclerView.setVisibility(View.VISIBLE);
        } else {
            holder.semestersRecyclerView.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandedItemPosition == position) {
                    collapseItem();
                } else {
                    if (expandedItemPosition != -1) {
                        collapseItem();
                    }
                    expandItem(holder, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return branches.size();
    }

    private void expandItem(BranchViewHolder holder, int position) {
        // TODO Flip arrow
        expandedItemPosition = position;
        expandedHolder = holder;
        holder.semestersRecyclerView.setVisibility(View.VISIBLE);
    }

    private void collapseItem() {
        expandedItemPosition = -1;
        if (expandedHolder == null) return;
        expandedHolder.semestersRecyclerView.setVisibility(View.GONE);
        // TODO Flip arrow
    }

    interface OnExpandableItemClickListener {

        void onCollapse(Branch branch);

        void onExpand(Branch branch);
    }

    public static class BranchViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        TextView paperCountTextView;
        RecyclerView semestersRecyclerView;

        public BranchViewHolder(@NonNull View itemView) {
            super(itemView);
            this.titleTextView = itemView.findViewById(R.id.tv_branch_name);
            this.paperCountTextView = itemView.findViewById(R.id.tv_paper_count);
            this.semestersRecyclerView = itemView.findViewById(R.id.rv_semesters);
        }
    }
}
