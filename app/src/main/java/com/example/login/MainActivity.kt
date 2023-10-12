package com.example.login

import android.app.Activity
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.login.databinding.ActivityMainBinding
import com.example.login.model.Login
import com.example.login.model.Product
import com.example.login.model.User
import com.example.login.networking.APIClient
import com.example.login.networking.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    private lateinit var username : String
    private lateinit var password : String
    val binding = ActivityMainBinding.inflate(layoutInflater)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val api = APIClient.getInstance().create(APIService::class.java)


        val l = Login("atuny0", "9uQFF1Lh", "Terry", 1, "https://robohash.org/hicveldicta.png?size=50x50&set=set1", "Medhurst")
            api.login(l).enqueue(object : Callback<User>{
                override fun onResponse(call: Call<User>, response: Response<User>) {
                   Log.d(TAG, "onResponse: ${response.body()?.username}")


                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t}")
                }

            })

      





    }
}