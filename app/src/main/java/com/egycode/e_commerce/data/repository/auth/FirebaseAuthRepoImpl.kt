package com.egycode.e_commerce.data.repository.auth

import com.egycode.e_commerce.data.model.Resource
import com.egycode.e_commerce.ui.common.views.ProgressDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class FirebaseAuthRepoImpl(
    private val auth : FirebaseAuth = FirebaseAuth.getInstance()
) : FirebaseAuhRepo {
    override suspend fun loginWithEmailAndPassword(
        email: String, 
        password: String
    ): Flow<Resource<String>>  = flow {
        try {
            emit(Resource.Loading())
            val result = auth.signInWithEmailAndPassword(email, password).await()
            result.user?.let {
                emit(Resource.Success(it.uid))
            } ?: run {
                emit(Resource.Error(Exception("User not found")))
            }

        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }
}