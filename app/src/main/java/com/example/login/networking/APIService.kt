package com.example.login.networking

import com.example.login.model.Login
import com.example.login.model.Product
import com.example.login.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService {

    @GET("/products")
    fun getAllProduct(): Call<Product>

    @POST("/auth/login")
    fun login(@Body login: Login) : Call<User>
}