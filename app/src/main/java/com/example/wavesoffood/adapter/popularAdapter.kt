package com.example.wavesoffood.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.databinding.PopularItemBinding

class popularAdapter(private val items: List<String>, private val image: List<String>, private val price: List<Int>) : RecyclerView.Adapter<popularAdapter.PopularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))

    }


    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        val price = price[position]
        holder.bind(item, images,price)
    }
    override fun getItemCount(): Int {
            return items.size
    }

    class PopularViewHolder (private  val binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imagesView = binding.imageView7
        fun bind(item: String, images: Int, price: String) {
        binding.foodnamepopular.text = item
            binding.price.text = price
            imagesView.setImageResource(images)


        }

    }
}