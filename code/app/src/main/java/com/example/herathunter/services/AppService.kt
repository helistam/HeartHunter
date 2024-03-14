package com.example.herathunter.services

import com.example.herathunter.models.User
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.springframework.stereotype.Service
import java.io.ByteArrayInputStream
import java.sql.Connection


@Service
class AppService {
    private lateinit var user: User

    private lateinit var connection: Connection
    private val client = OkHttpClient()

    fun postUser(user:User) {
//        TODO() connect to app interface
//        example
//        var user = User(
//            email = "abc@gmail.com",
//            password = "qwerty123",
//            name = "Jane",
//            dateOfBirth = "01.01.2001",
//            photo = BLOB,
//            city = "Minsk"
//        )

        val json = Json.encodeToString(user)

        val body = json.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())

        val request = Request.Builder()
            .url("jdbc:mysql://192.168.56.1:3306/user")
            .post(body)
            .build()

        val response: Response = client.newCall(request).execute()

        if (response.isSuccessful) {
            val responseBody = response.body?.string()
            print(responseBody)
//            TODO()Process the response data

        } else {
//            TODO() Handle the error
        }
    }
    fun getUser(id: Int){
        val request = Request.Builder()
            .url("jdbc:mysql://192.168.56.1:3306/user")
            .build()

        val response: Response = client.newCall(request).execute()

        if (response.isSuccessful) {
            val responseBody = response.body?.string()
//            TODO()Process the response data
        } else {
//            TODO() Handle the error
        }
    }
}