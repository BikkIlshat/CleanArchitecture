package com.agobikk.cleanarchitecture.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.agobikk.cleanarchitecture.domain.models.SaveUserNameParam
import com.agobikk.cleanarchitecture.domain.models.UserName
import com.agobikk.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.agobikk.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val resultLiveDataMutable = MutableLiveData<String>()
    val resultLiveData : LiveData<String> = resultLiveDataMutable


    init {
        Log.e("AAA", "VM created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM created")
        super.onCleared()
    }

    fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(param = params)
        resultLiveDataMutable.postValue("Save result = $resultData")

    }

    fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        resultLiveDataMutable.postValue("${userName.firstName} ${userName.lastName}")
    }
}