package Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.kurukshetrauniversitypapers.R;

import java.util.List;

import utils.DatesheetsInfo;

public class DatesheetAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<DatesheetsInfo> datesheetlist;

    public DatesheetAdapter(Context context, List<DatesheetsInfo> datesheetlist) {
        this.context = context;
        this.datesheetlist = datesheetlist;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.datesheet_row,parent,false);
        return  new Holder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        Log.e("info","info");
        DatesheetsInfo datesheetsInfo= datesheetlist.get(position);
        Log.e("position",position+"");
        Log.e(datesheetsInfo.getName(),datesheetsInfo.getId());
        Holder yth = (Holder) holder;
        yth.datesheetname.setText(datesheetsInfo.getName());

    }
    @NonNull
    @Override
    public int getItemCount() {
        return datesheetlist.size();
    }
    class Holder extends RecyclerView.ViewHolder{
        TextView datesheetname;
        public Holder(@NonNull View itemView) {
            super(itemView);
            datesheetname = itemView.findViewById(R.id.datesheetname);
        }

    }
}
