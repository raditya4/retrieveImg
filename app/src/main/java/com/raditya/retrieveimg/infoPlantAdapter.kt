package com.raditya.retrieveimg

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.raditya.retrieveimg.databinding.ItemListBinding
import com.raditya.retrieveimg.model.InfoPlantData

class infoPlantAdapter(var c : Context, var plantList:ArrayList<InfoPlantData>):RecyclerView.Adapter<infoPlantAdapter.PlantViewHolder>() {
    inner class PlantViewHolder(var v:ItemListBinding):RecyclerView.ViewHolder(v.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<ItemListBinding>(inflater,R.layout.item_list,parent,false)
        return PlantViewHolder(v)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val newList = plantList[position]
        holder.v.isPlant = plantList[position]
        holder.v.root.setOnClickListener {
            val img = newList.img
            val name = newList.name
            val info = newList.info

            val mIntent = Intent(c,NewActivity::class.java)
            mIntent.putExtra("img",img)
            mIntent.putExtra("name",name)
            mIntent.putExtra("info",info)
            c.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int {
        return plantList.size
    }
}