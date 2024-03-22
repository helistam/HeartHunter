package com.example.herathunter.services

import android.util.Log
import androidx.work.Logger.LogcatLogger
import com.example.herathunter.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.json.JSONObject
import org.springframework.stereotype.Service
import java.io.ByteArrayInputStream
import java.sql.Connection
import kotlin.math.log


@Service
object AppService {
    private lateinit var user: User

    private lateinit var connection: Connection



    fun getUser(id: Int){
        val request = Request.Builder()
            .url("http://192.168.182.87:8080/user")
            .build()
        Log.e("info","done")
       /* val response: Response = client.newCall(request).execute()

        if (response.isSuccessful) {
            val responseBody = response.body?.string()
//            TODO()Process the response data
        } else {
//            TODO() Handle the error
        }*/
    }


        val client = OkHttpClient()
    suspend fun postUser(user:User) {

            Log.e("my", "json")
            withContext(Dispatchers.IO) {

                //val json = Json.encodeToString(user)
                val json = JSONObject().apply {
                    put("email", user.email)
                    put("password", user.password)
                    put("name", user.name)
                    put("dateOfBirth", user.dateOfBirth)
                    put("about", user.about)
                    put("gender", user.gender)
                    put("city", user.city)
                }

                val jsonString = json.toString()
                Log.e("my", jsonString)
                Log.e("my", "2")

                val body =
                    jsonString.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())

                Log.e("my", body.toString())
                val request = Request.Builder()
                    .url("http://192.168.182.87:8080/user1")
                    .post(body)
                    .build()

                Log.e("my", request.toString())
                val response: Response = client.newCall(request).execute()

                Log.e("my", "response")
                if (response.isSuccessful) {

                    Log.e("my", "success")
                    val responseBody = response.body?.string()

                    Log.e("my", responseBody.toString())
//            TODO()Process the response data

                } else {

                    Log.e("my", "else")
//            TODO() Handle the error
                }
            }
        }
}