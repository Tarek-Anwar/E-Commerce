package com.egycode.e_commerce.data.datasource.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.egycode.e_commerce.data.datasource.datastore.DataStoreKey.E_COMMERCE_PREFERENCES

object DataStoreKey {
    const val E_COMMERCE_PREFERENCES = "e_commerce_preferences"
    val IS_USER_LOGIN = booleanPreferencesKey("is_user_login")
    val USER_ID = stringPreferencesKey("user_id")
}

val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = E_COMMERCE_PREFERENCES)
