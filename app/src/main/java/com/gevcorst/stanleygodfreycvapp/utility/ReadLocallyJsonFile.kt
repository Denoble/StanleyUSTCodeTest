package com.gevcorst.stanleygodfreycvapp.utility

import android.content.Context
import android.util.Log
import com.gevcorst.stanleygodfreycvapp.model.Resume
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.*
import java.io.IOException

object ReadLocallyJsonFile {
    fun readJsonLocally(context:Context, fileName:String):String {
        var jsonString:String
        try {
            jsonString  = context.assets.open(fileName).bufferedReader().use {
                it.readText()
            }
        }catch (e: IOException){
            jsonString = e.localizedMessage?:"Problem reading json file"
        }
        return jsonString
    }
     suspend fun parseJson(json:String): Resume {
            val gson = Gson()
            val _resume  = object : TypeToken<Resume>() {}.type
            val resume:Resume = gson.fromJson(json,_resume)
            //resume.education.forEachIndexed { idx, person -> Log.i("data", "> Item $idx:\n${person.schoolName}") }
           return resume
    }
}
