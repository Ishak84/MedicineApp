package com.geeks.medicineapp.ui.adapteres

import android.view.Display.Mode
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geeks.medicineapp.data.local.entity.model.Model

import com.geeks.medicineapp.databinding.ItemPillsBinding

class PillsGreenAdapter () :
    ListAdapter<Model, PillsGreenAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPillsBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    class ViewHolder(private val binding: ItemPillsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(noteModel: Model?) {
            binding.apply {
                tvTime.text = noteModel?.time
                tvTitle.text = noteModel?.title
                tvDescription.text = noteModel?.description
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Model>() {
        override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem.id == newItem.id
        }
    }
}