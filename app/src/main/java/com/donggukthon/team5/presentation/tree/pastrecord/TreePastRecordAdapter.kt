package com.donggukthon.team5.presentation.tree.pastrecord

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.donggukthon.team5.databinding.ItemTreePastRecordBinding
import com.donggukthon.team5.domain.model.OrnamentList
import com.donggukthon.team5.util.ItemDiffCallback

class TreePastRecordAdapter(context: Context): ListAdapter<OrnamentList.OrnamentListData, TreePastRecordAdapter.TreePastRecordViewHolder>(
    ItemDiffCallback<OrnamentList.OrnamentListData>(
        onItemsTheSame = { old, new -> old == new },
        onContentsTheSame = { old, new -> old == new }
    )
) {

    private val inflater by lazy { LayoutInflater.from(context) }
    inner class TreePastRecordViewHolder(private val binding: ItemTreePastRecordBinding) : RecyclerView.ViewHolder(binding.root){

        private var carouselLayout : LinearLayout = binding.carouselLayoutView


        init {
            carouselLayout.dividerPadding = 30
        }

        fun onBind(data: OrnamentList.OrnamentListData) {
            binding.tvTreePastRecordContent.text = data.memory
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreePastRecordViewHolder {
        val binding = ItemTreePastRecordBinding.inflate(inflater, parent, false)
        val viewHolder = TreePastRecordViewHolder(binding)

        return viewHolder
    }

    override fun onBindViewHolder(holder: TreePastRecordViewHolder, position: Int) {
        val item = currentList[position]
        holder.onBind(item as OrnamentList.OrnamentListData)
    }
}