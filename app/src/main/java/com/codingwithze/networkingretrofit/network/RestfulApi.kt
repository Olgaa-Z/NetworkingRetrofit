package com.codingwithze.networkingretrofit.network

import com.codingwithze.networkingretrofit.model.DataNews
import com.codingwithze.networkingretrofit.model.ResponseAddNews
import com.codingwithze.networkingretrofit.model.ResponseDataNewsItem
import com.codingwithze.networkingretrofit.model.ResponseUpdateNews
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface RestfulApi {

    @GET("news")
    fun getAllNews(): Call<List<ResponseDataNewsItem>>

    @POST("news")
    fun postDataNews(@Body request : DataNews) : Call<ResponseAddNews>

    @PUT("news/{id}")
    fun updateDataNews(
        @Path("id") id :Int,
        @Body request: DataNews
    ) : Call<List<ResponseUpdateNews>>

    @DELETE("news/{id}")
    fun deleteNews(@Path("id") id :Int) : Call<Int>
}