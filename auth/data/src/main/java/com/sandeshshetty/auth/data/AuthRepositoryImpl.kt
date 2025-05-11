package com.sandeshshetty.auth.data

import android.util.Log
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.sandeshshetty.auth.domain.AuthRepository
import com.sandeshshetty.core.data.safeCall
import com.sandeshshetty.core.domain.util.DataError
import com.sandeshshetty.core.domain.util.EmptyResult
import com.sandeshshetty.core.domain.util.Result
import com.sandeshshetty.core.domain.util.asEmptyDataResult
import kotlinx.coroutines.tasks.await

/**
 * @author sandeshshetty
 * Created 5/6/25 at {TIME}
 */
class AuthRepositoryImpl : AuthRepository {

    override suspend fun login(email: String, password: String): EmptyResult<DataError.Network> {
        return  safeCall {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).await()
        }
    }

    override suspend fun register(
        email: String,
        password: String
    ): EmptyResult<DataError.Network> {
//        try {
//            Log.d("Register", email+" "+password)
//            val result = FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).await()
//        } catch (e: Exception) {
//            Log.e("Register", e.message.toString())
//        }
        return safeCall {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).await()
        }
    }
}