package com.agobikk.cleanarchitecture.domain.usecase

import com.agobikk.cleanarchitecture.domain.models.UserName
import com.agobikk.cleanarchitecture.domain.repository.UserRepository


class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}