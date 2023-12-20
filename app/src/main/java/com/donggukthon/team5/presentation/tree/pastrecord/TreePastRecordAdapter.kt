package com.donggukthon.team5.presentation.tree.pastrecord

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.donggukthon.team5.databinding.ActivityTreePastRecordBinding
import com.donggukthon.team5.databinding.ItemTreePastRecordBinding
import com.donggukthon.team5.domain.model.GoodMemory
import com.donggukthon.team5.util.ItemDiffCallback

class TreePastRecordAdapter(context: Context): ListAdapter<GoodMemory, TreePastRecordAdapter.TreePastRecordViewHolder>(
    ItemDiffCallback<GoodMemory>(
        onItemsTheSame = { old, new -> old == new },
        onContentsTheSame = { old, new -> old == new }
    )
) {

    private val inflater by lazy { LayoutInflater.from(context) }
    inner class TreePastRecordViewHolder(private val binding: ItemTreePastRecordBinding) : RecyclerView.ViewHolder(binding.root){

        //var carouselImageView : ImageView
        var carouselLayout : LinearLayout


        init {
            //carouselImageView = binding.carouselImageView
            carouselLayout = binding.carouselLayoutView

            binding.root.setOnClickListener {
                onBind(currentList[adapterPosition])
            }

            fun onBind(data: GoodMemory) {
                binding.tvTreePastRecordContent.text = data.memory
            }
        }

        fun onBind(data: GoodMemory) {
            binding.tvTreePastRecordContent.text = data.memory
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreePastRecordViewHolder {
        val binding = ItemTreePastRecordBinding.inflate(inflater, parent, false)
        val viewHolder = TreePastRecordViewHolder(binding)

        return viewHolder
    }

//    override fun getItemCount(): Int {
//        return imageRes.size
//    }

    override fun onBindViewHolder(holder: TreePastRecordViewHolder, position: Int) {
        //holder.carouselImageView.setImageResource(imageRes[position])

        val item = currentList[position]
        holder.onBind(item as GoodMemory)
    }
}