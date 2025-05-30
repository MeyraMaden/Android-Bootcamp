package com.yuki.yemeksiparis.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yuki.yemeksiparis.databinding.FragmentAnasayfaBinding
import com.yuki.yemeksiparis.entity.Yemekler
import com.yuki.yemeksiparis.repo.YemeklerDaoRepository

class AnasayfaFragmentViewModel : ViewModel() {
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()
    private val ydaor = YemeklerDaoRepository()

    init {
        yemekleriYukle()
        yemeklerListesi = ydaor.yemekleriGetir()
    }

    fun yemekleriYukle(){
        ydaor.tumYemekleriAl()
    }

    fun homePageRvAnim(tasarim : FragmentAnasayfaBinding){
        ydaor.homePageRvAnim(tasarim)
    }
}