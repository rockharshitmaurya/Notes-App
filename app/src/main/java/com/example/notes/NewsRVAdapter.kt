package com.example.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsRVAdapter(private val context: Context, private val listener: INOtesRVAdapter): RecyclerView.Adapter<NewsRVAdapter.NoteViwHolder>() {
   private val allNotes=ArrayList<Note>()
    inner class NoteViwHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textView: TextView =itemView.findViewById<TextView>(R.id.text)
        val deleteButton: ImageView =itemView.findViewById<ImageView>(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViwHolder {
      val viewHolder= NoteViwHolder( LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
        viewHolder.deleteButton.setOnClickListener{
       listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return  viewHolder
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    override fun onBindViewHolder(holder: NoteViwHolder, position: Int) {
        val currentNote=allNotes[position]
        holder.textView.text=currentNote.text
    }
    fun updateList(newList: List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }
}

interface  INOtesRVAdapter{
    fun onItemClicked(note: Note)
}