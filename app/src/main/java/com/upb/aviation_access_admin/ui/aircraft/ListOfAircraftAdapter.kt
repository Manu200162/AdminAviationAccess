package com.upb.aviation_access_admin.ui.aircraft

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upb.aviation_access_admin.Aircraft
import com.upb.aviation_access_admin.databinding.AircraftItemBinding

class ListOfAircraftAdapter:RecyclerView.Adapter<ListOfAircraftViewHolder>() {

    private val aircraftList: MutableList<Aircraft> = mutableListOf()
    private var onAircraftItemClickListener:((aircraft:Aircraft)->Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun addAll(newElementList:List<Aircraft>){
        aircraftList.clear()
        aircraftList.addAll(newElementList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListOfAircraftViewHolder {
        val binding = AircraftItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListOfAircraftViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListOfAircraftViewHolder, position: Int) {
        holder.bind(aircraftList[position])
        holder.binding.root.setOnClickListener{
            onAircraftItemClickListener?.invoke(aircraftList[position])
        }
    }

    override fun getItemCount(): Int {
        return aircraftList.size
    }

    fun setOnAircratClickListener(onAircraftItemClickListener:((aircraft:Aircraft)->Unit)?){
        this.onAircraftItemClickListener=onAircraftItemClickListener
    }

}

class ListOfAircraftViewHolder(val binding: AircraftItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(aircraft: Aircraft){
        binding.airplaneDes=aircraft
    }
}