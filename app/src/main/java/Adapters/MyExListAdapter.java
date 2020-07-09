package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.application.kurukshetrauniversitypapers.R;

import java.util.List;
import java.util.Map;

public class MyExListAdapter extends BaseExpandableListAdapter {
    Context context;
    List<String> semester;
    Map<String, List<String>> year;

    public MyExListAdapter(Context context, List<String> semester, Map<String, List<String>> year) {
        this.context = context;
        this.semester = semester;
        this.year = year;
    }

    @Override
    public int getGroupCount() {
       return semester.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return year.get(semester.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return semester.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return year.get(semester.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String sem=(String) getGroup(groupPosition);
        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.list_parent,null);
        }
        TextView txtparent=(TextView) convertView.findViewById(R.id.txtparent);
        txtparent.setText(sem);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String year=(String) getChild(groupPosition,childPosition);
        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.list_child,null);
        }
        TextView txtchild=(TextView) convertView.findViewById(R.id.txtchild);
        txtchild.setText(year);



        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
