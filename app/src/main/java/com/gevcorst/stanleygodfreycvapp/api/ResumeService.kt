package com.gevcorst.stanleygodfreycvapp.api

import com.gevcorst.stanleygodfreycvapp.model.Resume
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://api.myjson.com/"
//Sett up Moshi to be used by retrofit
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    //Set up retrofit with the Base URL
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .build()
 interface ResumeApiService{
     @GET("bins/mlb6e")
     fun getResumes():Deferred<Resume>
 }
object resumeApi{
    val retrofitService:ResumeApiService by lazy {
        retrofit.create(ResumeApiService::class.java)
    }
}
