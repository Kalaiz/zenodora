package com.kalai.zenodora

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.kalai.zenodora.ScheduleAdapter.ViewHolder
import com.kalai.zenodora.databinding.ItemScheduleRecyclerViewBinding
import timber.log.Timber

class ScheduleAdapter: RecyclerView.Adapter<ViewHolder>() {

    var data = listOf<Session>()
        set(value){
            field = value
            notifyDataSetChanged()
        }


    class ViewHolder constructor(view: View):RecyclerView.ViewHolder(view){
        private val binding =  ItemScheduleRecyclerViewBinding.bind(view)

        fun bind(session:Session){
            binding.sessionTitleTextView.text = session.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_schedule_recycler_view, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int  = data.size
}