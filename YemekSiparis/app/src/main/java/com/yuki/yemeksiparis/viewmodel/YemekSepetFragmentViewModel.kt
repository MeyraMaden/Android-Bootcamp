package com.yuki.yemeksiparis.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yuki.yemeksiparis.databinding.FragmentYemekSepetBinding
import com.yuki.yemeksiparis.entity.YemekSepet
import com.yuki.yemeksiparis.repo.YemeklerDaoRepository

class YemekSepetFragmentViewModel : ViewModel() {
    var sepetYemeklerListesi : MutableLiveData<List<YemekSepet>>
    private val ydaor = YemeklerDaoRepository()

    init {
        sepetYemekleriYukle()
        sepetYemeklerListesi = ydaor.sepetYemekleriGetir()
    }

    fun sepetYemekleriYukle() {
        ydaor.tumSepetYemekleriAl()
    }

    fun yemekSil(sepet_yemek_id : Int, kullanici_adi : String){
        ydaor.sepettenYemekSilme(sepet_yemek_id, kullanici_adi)
    }

    fun sepetYemekRvAnim(tasarim : FragmentYemekSepetBinding){
        ydaor.yemekSepetRvAnim(tasarim)
    }
}