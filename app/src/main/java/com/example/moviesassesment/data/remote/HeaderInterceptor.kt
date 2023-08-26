package com.example.moviesassesment.data.remote

import okhttp3.Interceptor
import okhttp3.Response
import com.example.moviesassesment.BuildConfig

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader("Authorization", "Bearer ${BuildConfig.Token}")
                .build()
        )
    }
}