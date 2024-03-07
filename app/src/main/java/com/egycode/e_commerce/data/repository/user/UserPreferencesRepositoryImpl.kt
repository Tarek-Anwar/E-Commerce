package com.egycode.e_commerce.data.repository.user

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.egycode.e_commerce.data.datasource.datastore.DataStoreKey.IS_USER_LOGIN
import com.egycode.e_commerce.data.datasource.datastore.DataStoreKey.USER_ID
import com.egycode.e_commerce.data.datasource.datastore.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferencesRepositoryImp(
    private val context: Context
) : UserPreferencesRepository {
    override suspend fun isUserLoggedIn(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[IS_USER_LOGIN] ?: false
        }
    }

    override suspend fun saveLoginState(isUserLoggedIn: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_USER_LOGIN] = isUserLoggedIn
        }
    }

    override suspend fun saveUserID(userID: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_ID] = userID}
    }


}


