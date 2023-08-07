package com.example.jadwalshalat_uasakb.model

data class ScheduleMonthlyResponse(
    val `data`: Data,
    val status: Boolean
){
    data class Data(
        val daerah: String,
        val id: String,
        val jadwal: List<Jadwal>,
        val koordinat: Koordinat,
        val lokasi: String
    ){
        data class Jadwal(
            val ashar: String,
            val date: String,
            val dhuha: String,
            val dzuhur: String,
            val imsak: String,
            val isya: String,
            val maghrib: String,
            val subuh: String,
            val tanggal: String,
            val terbit: String
        )
        data class Koordinat(
            val bujur: String,
            val lat: Double,
            val lintang: String,
            val lon: Double
        )
    }
}