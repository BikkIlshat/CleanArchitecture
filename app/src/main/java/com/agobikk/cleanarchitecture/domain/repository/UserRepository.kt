package com.agobikk.cleanarchitecture.domain.repository

import com.agobikk.cleanarchitecture.domain.models.SaveUserNameParam
import com.agobikk.cleanarchitecture.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}