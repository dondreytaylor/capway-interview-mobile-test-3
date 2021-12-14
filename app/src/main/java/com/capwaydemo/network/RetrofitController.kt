package com.capwaydemo.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitController {
    private val ACCEPT: String = "*/*"
    private val API_KEY: String = "7733c58b6b9c4d85ba637459a1217245"
    private val BASE_URL: String = "https://newsapi.org/v2/"

    fun getRetrofitInstance(): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpBuilder = OkHttpClient.Builder()
        okHttpBuilder.readTimeout(10, TimeUnit.SECONDS)
        okHttpBuilder.writeTimeout(10, TimeUnit.SECONDS)
        okHttpBuilder.callTimeout(10, TimeUnit.SECONDS)
        okHttpBuilder.connectTimeout(10, TimeUnit.SECONDS)
        okHttpBuilder.addInterceptor(loggingInterceptor)
        okHttpBuilder.addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("x-api-key", API_KEY)
                .addHeader("accept", ACCEPT)
                .build()
            chain.proceed(request)
        }

        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpBuilder.build())
            .build()
    }
}
