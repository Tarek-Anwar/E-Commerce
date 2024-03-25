package com.egycode.e_commerce.data.repository.auth

import com.egycode.e_commerce.data.model.Resource
import kotlinx.coroutines.flow.Flow

interface FirebaseAuhRepo {
    suspend fun loginWithEmailAndPassword(
        email : String , password : String
    ) : Flow<Resource<String>>
}