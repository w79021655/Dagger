package com.dagger.sample.api

import com.dagger.sample.model.Users
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiConfig {
    @GET("users")
    fun getUsers(
        @Query("per_page") perPage: Int,
        @Query("since") since: Int
    ): Single<Response<Users>>

}