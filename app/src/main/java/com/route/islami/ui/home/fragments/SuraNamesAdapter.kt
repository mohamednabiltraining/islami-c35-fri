package com.route.islami.ui.home.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.Sura

class SuraNamesAdapter(val suraList: List<Sura>) :
    RecyclerView.Adapter<SuraNamesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sura_name, parent, false);
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = suraList.get(position);
        holder.name.setText(item.name)
//        onItemClickListener?.let { clickListener->
//            holder.itemView.setOnClickListener{
//                clickListener.onItemClick(position,item)
//            }
//        }
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(position, item)
            }
        }
    }

    override fun getItemCount(): Int = suraList.size

    var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(position: Int, item: Sura)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name);
    }
}