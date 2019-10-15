package com.gevcorst.stanleygodfreycvapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gevcorst.stanleygodfreycvapp.api.resumeApi
import com.gevcorst.stanleygodfreycvapp.model.Resume
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class ResumeViewModel :ViewModel(){
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
            var resumePropertyDeferred = resumeApi.retrofitService.getResumes()
            try {
                var resume = resumePropertyDeferred.await()
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
}