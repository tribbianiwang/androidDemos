package com.wl.androiddemos.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wl.androiddemos.R
import com.wl.androiddemos.bean.RvDataBean
import kotlinx.android.synthetic.main.rv_demo_item.view.*

class RvDemoAdapter(datalist: ArrayList<RvDataBean>) :RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var datalist: ArrayList<RvDataBean>
    init {
        this.datalist = datalist
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("rvDemoAdapter","oncreateviewholder")

      return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_demo_item,parent,false))

    }

    override fun getItemCount(): Int {

        return datalist.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.tv_name.text = datalist.get(position).name
        holder.itemView.tv_gender.text = datalist.get(position).gender
        holder.itemView.tv_age.text = datalist.get(position).age.toString()
        holder.itemView.tv_telephone.text = datalist.get(position).telephoneNum
        holder.itemView.tv_address.text = datalist.get(position).address
        holder.itemView.tv_birthday.text = datalist.get(position).birthday
        holder.itemView.tv_hobby.text = datalist.get(position).hobby
        holder.itemView.tv_job.text = datalist.get(position).jog
        holder.itemView.tv_jobage.text = datalist.get(position).jobage



    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}