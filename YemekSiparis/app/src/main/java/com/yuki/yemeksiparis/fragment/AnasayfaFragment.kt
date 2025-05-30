package com.yuki.yemeksiparis.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.yuki.yemeksiparis.R
import com.yuki.yemeksiparis.adapter.YemeklerAdapter
import com.yuki.yemeksiparis.databinding.FragmentAnasayfaBinding
import com.yuki.yemeksiparis.viewmodel.AnasayfaFragmentViewModel

class AnasayfaFragment : Fragment() {
    private lateinit var tasarim : FragmentAnasayfaBinding
    private lateinit var adapter : YemeklerAdapter
    private lateinit var viewModel : AnasayfaFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)

        viewModel.homePageRvAnim(tasarim)


        viewModel.yemeklerListesi.observe(viewLifecycleOwner,{ yemeklerListesi ->
            adapter = YemeklerAdapter(requireContext(),yemeklerListesi)
            tasarim.yemeklerAdapter = adapter
        })

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:AnasayfaFragmentViewModel by viewModels()
        this.viewModel = tempViewModel
    }

}