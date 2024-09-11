package com.example.wavesoffood.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.DetailsActivity
import com.example.wavesoffood.StartActivity
import com.example.wavesoffood.databinding.MenuItemBinding

class MenuAdapter(
    private val menuItemsName: List<String>,
    private val menuItemPrice: List<String>,
    private val menuImage: List<Int>,
    private val requireContext: Context
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private val itemClickListener :OnClickListener ?= null

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
    val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return MenuViewHolder(binding)
    }

    override fun getItemCount(): Int = menuItemsName.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }
    inner class MenuViewHolder(private val binding : MenuItemBinding) :RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener{
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                        itemClickListener?.onItemClick(position)
                }
                //SetOnClickListener to open Item Details
                val intent = Intent(requireContext,DetailsActivity::class.java)
                intent.putExtra("MenuItems", menuItemsName.get(position))
                intent.putExtra("MenuItemImage", menuImage.get(position))
                requireContext.startActivity(intent)
            }
        }


        fun bind(position: Int) {
        binding.apply {
            menuFoodName.text = menuItemsName[position]
            menuPrice.text = menuItemPrice[position]
            menuImages.setImageResource(menuImage[position])

        }

        }

    }
    interface OnClickListener {
        fun onItemClick(position: Int)
    }
}


