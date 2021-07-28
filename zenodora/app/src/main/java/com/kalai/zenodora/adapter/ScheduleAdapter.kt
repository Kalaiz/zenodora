package com.kalai.zenodora.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kalai.zenodora.R
import com.kalai.zenodora.adapter.ScheduleAdapter.ViewHolder
import com.kalai.zenodora.data.Session
import com.kalai.zenodora.databinding.ItemScheduleRecyclerViewBinding
import timber.log.Timber

class ScheduleAdapter( private val sessionClickCallback: ((Int) -> Unit)): RecyclerView.Adapter<ViewHolder>() {

    var data = listOf<Session>()
        set(value){
            field = value
            notifyDataSetChanged()
        }


    inner class ViewHolder constructor(view: View):RecyclerView.ViewHolder(view),View.OnClickListener{
        private val binding =  ItemScheduleRecyclerViewBinding.bind(view)

init{
    view.setOnClickListener(this)
}
        fun bind(session: Session){
            Timber.d("Test")
            binding.sessionTitleTextView.text = session.title


        }

        override fun onClick(view: View) {
            Timber.d("On clicked ")
         sessionClickCallback( absoluteAdapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_schedule_recycler_view, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int  = data.size
}