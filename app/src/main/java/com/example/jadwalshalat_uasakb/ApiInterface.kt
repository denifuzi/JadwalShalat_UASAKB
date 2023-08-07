package com.example.jadwalshalat_uasakb

import com.example.jadwalshalat_uasakb.model.ScheduleMonthlyResponse
import com.example.jadwalshalat_uasakb.model.ScheduleResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("jadwal/{id_kota}/{tahun}/{bulan}/{tanggal}")
    suspend fun getScheduleByDay(
        @Path("id_kota") idKota: String,
        @Path("tahun") tahun: String,
        @Path("bulan") bulan: String,
        @Path("tanggal") tanggal: String
    ): Response<ScheduleResponse>

    @GET("jadwal/{id_kota}/{tahun}/{bulan}")
    suspend fun getScheduleMonthly(
        @Path("id_kota") idKota: String,
        @Path("tahun") tahun: String,
        @Path("bulan") bulan: String
    ): Response<ScheduleMonthlyResponse>

}