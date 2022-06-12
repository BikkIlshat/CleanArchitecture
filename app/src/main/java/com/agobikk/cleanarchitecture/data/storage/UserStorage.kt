package com.agobikk.cleanarchitecture.data.storage

import com.agobikk.cleanarchitecture.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}