package com.agobikk.cleanarchitecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.agobikk.cleanarchitecture.data.repository.UserRepositoryImpl
import com.agobikk.cleanarchitecture.data.storage.sharedprefs.SharedPrefUserStorage
import com.agobikk.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.agobikk.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context))
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository = userRepository)
    }

    private val saveUserNameUserCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository = userRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase, saveUserNameUseCase = saveUserNameUserCase
        ) as T
    }
}