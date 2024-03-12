package com.egycode.e_commerce.data.repository.user

import kotlinx.coroutines.flow.Flow

interface UserPreferencesRepository {
    suspend fun saveLoginState(isUserLoggedIn: Boolean)
    suspend fun isUserLoggedIn(): Flow<Boolean>
    suspend fun saveUserID(userID: String)
    fun getUserID(): Flow<String?>



}