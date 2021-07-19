package com.dagger.sample.repository

import com.dagger.sample.api.IApiConfig
import com.dagger.sample.model.Users
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(_apiConfig: IApiConfig) {
    private val apiConfig: IApiConfig = _apiConfig

    fun getUsers(perPage: Int, since: Int): Single<Response<Users>> {
        return apiConfig.getUsers(perPage, since)
    }
}