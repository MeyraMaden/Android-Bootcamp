package com.yuki.odevler

class Odev2 {

    // 1) Celsius -> Fahrenheit
    fun dereceToFahrenheit(celsius: Double): Double {
        return celsius * 1.8 + 32
    }

    // 2) Dikdörtgen çevresi
    fun dikdortgenCevresi(kenar1: Int, kenar2: Int): Int {
        return 2 * (kenar1 + kenar2)
    }

    // 3) Faktöriyel hesaplama
    fun faktoriyel(sayi: Int): Int {
        var sonuc = 1
        for (i in 1..sayi) {
            sonuc *= i
        }
        return sonuc
    }

    // 4) Kelimedeki 'a' harf sayısı
    fun aHarfiSayisi(kelime: String): Int {
        var sayac = 0
        for (i in kelime.indices) {
            if (kelime[i] == 'a' || kelime[i] == 'A') {
                sayac++
            }
        }
        return sayac
    }

    // 5) İç açılar toplamı
    fun icAcilarToplami(kenarSayisi: Int): Int {
        return (kenarSayisi - 2) * 180
    }


    // 6) Gün sayısına göre maaş hesabı
    fun maasHesapla(gunSayisi: Int): Int {
        val toplamSaat = gunSayisi * 8
        var maas = 0
        if (toplamSaat <= 160) {
            maas = toplamSaat * 10
        } else {
            val mesaiSaat = toplamSaat - 160
            maas = (160 * 10) + (mesaiSaat * 20)
        }
        return maas
    }


    // 7) Kota miktarına göre ücret
    fun kotaUcretiHesapla(gb: Int): Int {
        return if (gb <= 50) {
            100
        } else {
            val asim = gb - 50
            100 + (asim * 4)
        }
    }
}

fun main() {
    val odev = Odev2()

    println(
        "25.5 Celsius = ${odev.dereceToFahrenheit(25.5)} Fahrenheit\n" +
                "kenarları 5 ve 10 olan dikdörtgenin çevresi: ${odev.dikdortgenCevresi(5, 10)}\n" +
                "5! = ${odev.faktoriyel(5)}\n" +
                "a sayısı: ${odev.aHarfiSayisi("Kotlini kolayca öğreniyorum")}\n" +
                "altıgenin iç açılar toplamı : ${odev.icAcilarToplami(6)}\n" +
                "200 gün çalışan biri ${odev.maasHesapla(200)} tl kazanır\n" +
                "64GB harcayan biri ${odev.kotaUcretiHesapla(64)} tl öder\n"
    )
}