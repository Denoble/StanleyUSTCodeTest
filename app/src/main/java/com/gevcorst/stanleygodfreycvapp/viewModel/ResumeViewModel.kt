package com.gevcorst.stanleygodfreycvapp.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.gevcorst.stanleygodfreycvapp.api.resumeApi
import com.gevcorst.stanleygodfreycvapp.model.Resume
import com.gevcorst.stanleygodfreycvapp.utility.ReadLocallyJsonFile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class ResumeViewModel(application:Application) :AndroidViewModel(application){
    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status
    private val _resume = MutableLiveData<Resume>()
    val Stanresume:LiveData<Resume>
        get() = _resume
    // Create Coroutine job which run using the Main (UI) dispatcher
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )
    init {
        getResumeProperties()
    }
    private fun getResumeProperties(){
        coroutineScope.launch {
            val jsonString = ReadLocallyJsonFile.readJsonLocally(getApplication(),"stanResume.json")
           // var resumePropertyDeferred = resumeApi.retrofitService.getResumes()
            val res = ReadLocallyJsonFile.parseJson(jsonString)
            try {
                val resume = res
                if(resume.name.length > 0){
                    _resume.value = resume
                }
                _status.value = "Success: ${resume.name.length} Resume properties retrieved"
            }
            catch (e:Exception){
                _status.value = "Failure: ${e.message}"
            }
        }
    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ResumeViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ResumeViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}