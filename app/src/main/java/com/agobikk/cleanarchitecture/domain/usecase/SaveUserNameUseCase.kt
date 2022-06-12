package com.agobikk.cleanarchitecture.domain.usecase

import com.agobikk.cleanarchitecture.domain.models.SaveUserNameParam
import com.agobikk.cleanarchitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        val oldUserName = userRepository.getName()

        if (oldUserName.firstName == param.name) {
            return true

        }
        val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }



}
