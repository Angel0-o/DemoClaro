package com.moragar.democlaro.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moragar.democlaro.R
import com.moragar.democlaro.databinding.ItemDemoBinding
import com.moragar.democlaro.model.data.Demo

class DemoAdapter(
    val demoList:List<Demo> = emptyList()
): RecyclerView.Adapter<DemoAdapter.ViewHolder>() {
    lateinit var dListener:OnDemoListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_demo,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindDemo(demoList[position], position, dListener)
    }

    override fun getItemCount(): Int =demoList.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        lateinit var binding: ItemDemoBinding

        fun bindDemo(demo: Demo, position: Int,listener: OnDemoListener){
            binding = ItemDemoBinding.bind(itemView)
            binding.itemTitle.text = demo.title
            binding.itemDescription.text = demo.description
            itemView.setOnClickListener {
                listener.OnDemoClickListener(position)
            }
            itemView.setOnLongClickListener {
                listener.OnDemoLongClickListener(position)
                true
            }
        }
    }

    interface OnDemoListener{
        fun OnDemoClickListener(position: Int)
        fun OnDemoLongClickListener(position: Int)
    }

    fun setDemoListener(listener: OnDemoListener){dListener=listener}
}