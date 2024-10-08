package com.example.wavesoffood.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.wavesoffood.MenuBottomSheetFragment
import com.example.wavesoffood.R
import com.example.wavesoffood.adapter.PopularAdapter
import com.example.wavesoffood.databinding.FragmentHomeBinding


class  HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater,container,false)
        binding.ViewAllMenu.setOnClickListener {
            val bottomSheetDialog = MenuBottomSheetFragment()
                bottomSheetDialog.show(parentFragmentManager,"Test")

        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3, ScaleTypes.FIT))

        val imageSlider  = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)
    imageSlider.setItemClickListener(object : ItemClickListener{
        override fun doubleClick(position: Int) {
            TODO("Not yet implemented")
        }

        override fun onItemSelected(position: Int) {
                val itemPostion = imageList[position]
            val itemMessage = "Selected Image $position"
            Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_SHORT).show()
        }
    })

        val foodName = listOf("Herbal Pancake","Fruit Salad", "Green Noodles","Chicken Biryani","Burger", "Pizza")
        val foodPrices = listOf("$5", "$10", "$20","$5", "$10", "$20")
        val popularFoodImages = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu1,R.drawable.menu2,R.drawable.menu3)

        val adapter = PopularAdapter(foodName,foodPrices,popularFoodImages,requireContext())
        binding.PopularRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.PopularRecyclerView.adapter = adapter

    }

}