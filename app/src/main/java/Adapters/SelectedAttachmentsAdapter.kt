package Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.application.kurukshetrauniversitypapers.R
import kotlinx.android.synthetic.main.selected_attachments_row.view.*
import utils.AttachedFile

class SelectedAttachmentsAdapter(private val files: List<AttachedFile>) :
    RecyclerView.Adapter<SelectedAttachmentsAdapter.ExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.selected_attachments_row,
            parent, false)
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = files[position]
        holder.textView1.text = currentItem.name
        holder.textView2.text = currentItem.uri.toString()
    }
   override fun getItemCount() = files.size

    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.attachment_name
        val textView2: TextView = itemView.attachment_uri
    }
}