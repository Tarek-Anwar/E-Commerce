package com.egycode.e_commerce.data.repository.user

import com.egycode.e_commerce.data.datasource.datastore.UserPreferencesDataSource
import kotlinx.coroutines.flow.Flow

class UserPreferencesRepositoryImp(
    private val userPreferencesDataSource: UserPreferencesDataSource
) : UserPreferencesRepository {
    override suspend fun saveLoginState(isUserLoggedIn: Boolean) {
        userPreferencesDataSource.saveUserLoginState(isUserLoggedIn)
    }
    override suspend fun isUserLoggedIn(): Flow<Boolean> {
        return userPreferencesDataSource.isUserLoginIn
    }
    override suspend fun saveUserID(userID: String) {
        userPreferencesDataSource.saveUserId(userID)
    }
    override fun getUserID(): Flow<String?> {
        return userPreferencesDataSource.getUserId
    }


}


