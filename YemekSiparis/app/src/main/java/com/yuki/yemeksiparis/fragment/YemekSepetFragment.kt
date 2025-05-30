package com.yuki.yemeksiparis.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.yuki.yemeksiparis.R
import com.yuki.yemeksiparis.adapter.YemekSepetAdapter
import com.yuki.yemeksiparis.databinding.FragmentYemekSepetBinding
import com.yuki.yemeksiparis.viewmodel.YemekSepetFragmentViewModel

class YemekSepetFragment : Fragment() {

    private lateinit var tasarim : FragmentYemekSepetBinding
    private lateinit var viewModel : YemekSepetFragmentViewModel
    private lateinit var adapter : YemekSepetAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_yemek_sepet, container, false)
        tasarim.fragmentYemekSepet = this

        viewModel.sepetYemekRvAnim(tasarim)

        tasarim.textViewSepetToplamFiyat.visibility = View.INVISIBLE

        viewModel.sepetYemeklerListesi.observe(viewLifecycleOwner, { sepetYemeklerListesi ->
            var sonuc = 0
            sepetYemeklerListesi.map {
                sonuc += it.yemek_fiyat * it.yemek_siparis_adet
            }
            if (sepetYemeklerListesi.size > 0){
                tasarim.textViewSepetBos.visibility = View.INVISIBLE
                tasarim.textViewSepetToplamFiyat.visibility = View.VISIBLE
            }
            tasarim.textViewSepetToplamFiyat.text = "Sepet Tutarı: ${sonuc.toString()} ₺"
            adapter = YemekSepetAdapter(requireContext(),sepetYemeklerListesi, viewModel,tasarim)
            tasarim.yemekSepetAdapter = adapter
        })

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : YemekSepetFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

}