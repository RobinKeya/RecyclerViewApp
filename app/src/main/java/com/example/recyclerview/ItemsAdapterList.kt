package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import de.hdodenhof.circleimageview.CircleImageView

class ItemsAdapterList(private val context:Context,private val imageNames:List<String>,private val images:List<String>):
    RecyclerView.Adapter<ItemsAdapterList.ViewHolder>() {
    private  val layoutInflater = LayoutInflater.from(context)
   inner class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<CircleImageView>(R.id.image)
        val text = itemView.findViewById<TextView>(R.id.image_name)

//        init {
//            itemView.setOnClickListener {
//                Snackbar.make(context,"text",Snackbar.LENGTH_LONG).show()
//
//            }
        //}

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = layoutInflater.inflate(R.layout.layout_listitem,parent,false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
            .asBitmap()
            .load(images.get(position))
            .into(holder.image)
        holder.text.setText(imageNames.get(position))
    }

    override fun getItemCount(): Int {
        return imageNames.size
    }
}