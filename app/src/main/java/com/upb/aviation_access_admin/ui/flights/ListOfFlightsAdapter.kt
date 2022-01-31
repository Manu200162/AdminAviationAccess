package com.upb.aviation_access_admin.ui.flights

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upb.aviation_access_admin.Flight
import com.upb.aviation_access_admin.databinding.FlightItemBinding

class ListOfFlightsAdapter: RecyclerView.Adapter<ListOfFlightViewHolder>() {

    private val flightList: MutableList<Flight> = mutableListOf()
    private var onFlightItemClickListener:((flight: Flight)->Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun addAll(newElementList:List<Flight>){
        flightList.clear()
        flightList.addAll(newElementList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListOfFlightViewHolder {
        val binding = FlightItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListOfFlightViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListOfFlightViewHolder, position: Int) {
        holder.bind(flightList[position])
        holder.binding.root.setOnClickListener{
            onFlightItemClickListener?.invoke(flightList[position])
        }
    }

    override fun getItemCount(): Int {
        return flightList.size
    }

    fun setOnFlightClickListener(onFlightItemClickListener:((flight: Flight)->Unit)?){
        this.onFlightItemClickListener=onFlightItemClickListener
    }

}

class ListOfFlightViewHolder(val binding: FlightItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(flight:Flight){
        binding.flightInfo=flight
    }
}