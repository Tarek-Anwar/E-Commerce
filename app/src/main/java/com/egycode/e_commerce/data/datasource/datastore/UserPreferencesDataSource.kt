package com.egycode.e_commerce.data.datasource.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferencesDataSource(private val context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_preferences")
    private val dataStore = context.dataStore
    suspend fun saveUserLoginState(isUserLogin: Boolean) {
        dataStore.edit { preferences ->
            preferences[DataStoreKey.IS_USER_LOGIN] = isUserLogin
        }
    }

    suspend fun saveUserId(userId: String) {
        dataStore.edit { preferences ->
            preferences[DataStoreKey.USER_ID] = userId
        }
    }

    val  isUserLoginIn: Flow<Boolean>  = dataStore.data.map { preferences ->
        preferences[DataStoreKey.IS_USER_LOGIN] ?: false
    }

    val getUserId: Flow<String?>  = dataStore.data.map { preferences ->
        preferences[DataStoreKey.USER_ID]
    }
}